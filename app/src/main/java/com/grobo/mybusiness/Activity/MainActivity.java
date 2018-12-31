package com.grobo.mybusiness.Activity;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.grobo.mybusiness.R;
import com.grobo.mybusiness.adapters.MainViewAdapter;
import com.grobo.mybusiness.models.Customer;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class MainActivity extends AppCompatActivity {

    private FirebaseFirestore mFirestore;
    private CollectionReference customersReference;
    private Query mQuery;

    private ListView mListView;
    private MainViewAdapter mAdapter;
    List<Customer> mainList;

    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkMessagePermission();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.grobo.mybusiness.Activity.NewSaleActivity.class);
                startActivity(intent);
            }
        });

        initFirestore();

        mListView = findViewById(R.id.sale_list_view);
        View emptyView = findViewById(R.id.empty_view);
        mListView.setEmptyView(emptyView);

        mainList = new ArrayList<Customer>();
        mAdapter = new MainViewAdapter(this, R.layout.list_item, mainList);
        mListView.setAdapter(mAdapter);

        populateData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.set_price_menu_item){
            startActivity(new Intent(this, SetPriceActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    private void initFirestore() {
        mFirestore = FirebaseFirestore.getInstance();

        mQuery = mFirestore.collection("customers")
                .orderBy("purchaseDate", Query.Direction.DESCENDING);
    }

    private void populateData(){
       mQuery.addSnapshotListener(new EventListener<QuerySnapshot>() {
           @Override
           public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
               if (e != null){
                   Log.d("MainActivity", "Error getting Snapshots");
                   return;
               }

               mAdapter.clear();
               mainList = queryDocumentSnapshots.toObjects(Customer.class);
               mAdapter.addAll(mainList);
           }
       });
    }

    @Override
    protected void onResume() {
        populateData();
        super.onResume();
    }

    private void checkMessagePermission(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 0);
            }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 0: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "SMS permission granted!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Permission not granted, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }
    }

}
