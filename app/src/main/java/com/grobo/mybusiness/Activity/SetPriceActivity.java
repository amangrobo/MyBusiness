package com.grobo.mybusiness.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.grobo.mybusiness.R;

import java.util.ArrayList;

public class SetPriceActivity extends AppCompatActivity {

    SharedPreferences prefs;
    private EditText inputKhapraPrice;
    private EditText inputMangraPrice;
    private EditText inputKoniaPrice;
    private EditText inputPillar12ftPrice;
    private EditText inputPillar10ftPrice;
    private EditText inputPillar8ftPrice;
    private EditText inputPillar3ftPrice;
    private EditText inputAsbestos10ftPrice;
    private EditText inputAsbestos8ftPrice;
    private EditText inputAsbestos6ftPrice;
    private int khapraPrice;
    private int mangraPrice;
    private int koniaPrice;
    private int pillar12ftPrice;
    private int pillar10ftPrice;
    private int pillar8ftPrice;
    private int pillar3ftPrice;
    private int asbestos10ftPrice;
    private int asbestos8ftPrice;
    private int asbestos6ftPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_price_new);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        inputKhapraPrice = (EditText) findViewById(R.id.input_khapra_price);
        inputMangraPrice = (EditText) findViewById(R.id.input_mangra_price);
        inputKoniaPrice = (EditText) findViewById(R.id.input_konia_price);
        inputPillar12ftPrice = (EditText) findViewById(R.id.input_pillar_12ft_price);
        inputPillar10ftPrice = (EditText) findViewById(R.id.input_pillar_10ft_price);
        inputPillar8ftPrice = (EditText) findViewById(R.id.input_pillar_8ft_price);
        inputPillar3ftPrice = (EditText) findViewById(R.id.input_pillar_3ft_price);
        inputAsbestos10ftPrice = (EditText) findViewById(R.id.input_asbestos_10ft_price);
        inputAsbestos8ftPrice = (EditText) findViewById(R.id.input_asbestos_8ft_price);
        inputAsbestos6ftPrice = (EditText) findViewById(R.id.input_asbestos_6ft_price);

        khapraPrice = prefs.getInt("khapraPrice", 0);
        inputKhapraPrice.setText(String.valueOf(khapraPrice));

        mangraPrice = prefs.getInt("mangraPrice", 0);
        inputMangraPrice.setText(String.valueOf(mangraPrice));

        koniaPrice = prefs.getInt("koniaPrice", 0);
        inputKoniaPrice.setText(String.valueOf(koniaPrice));

        pillar12ftPrice = prefs.getInt("pillar12ftPrice", 0);
        inputPillar12ftPrice.setText(String.valueOf(pillar12ftPrice));

        pillar10ftPrice = prefs.getInt("pillar10ftPrice", 0);
        inputPillar10ftPrice.setText(String.valueOf(pillar10ftPrice));

        pillar8ftPrice = prefs.getInt("pillar8ftPrice", 0);
        inputPillar8ftPrice.setText(String.valueOf(pillar8ftPrice));

        pillar3ftPrice = prefs.getInt("pillar3ftPrice", 0);
        inputPillar3ftPrice.setText(String.valueOf(pillar3ftPrice));

        asbestos10ftPrice = prefs.getInt("asbestos10ftPrice", 0);
        inputAsbestos10ftPrice.setText(String.valueOf(asbestos10ftPrice));

        asbestos8ftPrice = prefs.getInt("asbestos8ftPrice", 0);
        inputAsbestos8ftPrice.setText(String.valueOf(asbestos8ftPrice));

        asbestos6ftPrice = prefs.getInt("asbestos6ftPrice", 0);
        inputAsbestos6ftPrice.setText(String.valueOf(asbestos6ftPrice));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.set_price_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.save_price_menu_item){
            savePrice();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void savePrice(){

        khapraPrice = Integer.parseInt(inputKhapraPrice.getText().toString());
        prefs.edit().putInt("khapraPrice", khapraPrice).apply();

        mangraPrice = Integer.parseInt(inputMangraPrice.getText().toString());
        prefs.edit().putInt("mangraPrice", mangraPrice).apply();

        koniaPrice = Integer.parseInt(inputKoniaPrice.getText().toString());
        prefs.edit().putInt("koniaPrice", koniaPrice).apply();

        pillar12ftPrice = Integer.parseInt(inputPillar12ftPrice.getText().toString());
        prefs.edit().putInt("pillar12ftPrice", pillar12ftPrice).apply();

        pillar10ftPrice = Integer.parseInt(inputPillar10ftPrice.getText().toString());
        prefs.edit().putInt("pillar10ftPrice", pillar10ftPrice).apply();

        pillar8ftPrice = Integer.parseInt(inputPillar8ftPrice.getText().toString());
        prefs.edit().putInt("pillar8ftPrice", pillar8ftPrice).apply();

        pillar3ftPrice = Integer.parseInt(inputPillar3ftPrice.getText().toString());
        prefs.edit().putInt("pillar3ftPrice", pillar3ftPrice).apply();

        asbestos10ftPrice = Integer.parseInt(inputAsbestos10ftPrice.getText().toString());
        prefs.edit().putInt("asbestos10ftPrice", asbestos10ftPrice).apply();

        asbestos8ftPrice = Integer.parseInt(inputAsbestos8ftPrice.getText().toString());
        prefs.edit().putInt("asbestos8ftPrice", asbestos8ftPrice).apply();

        asbestos6ftPrice = Integer.parseInt(inputAsbestos6ftPrice.getText().toString());
        prefs.edit().putInt("asbestos6ftPrice", asbestos6ftPrice).apply();

    }
}
