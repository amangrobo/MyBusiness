package com.grobo.mybusiness.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.grobo.mybusiness.R;
import com.grobo.mybusiness.models.Customer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NewSaleActivity extends AppCompatActivity {

    SharedPreferences prefs;

    private EditText inputKhapraAmount;
    private EditText inputMangraAmount;
    private EditText inputKoniaAmount;
    private EditText inputPillar12ftAmount;
    private EditText inputPillar10ftAmount;
    private EditText inputPillar8ftAmount;
    private EditText inputPillar3ftAmount;
    private EditText inputAsbestos10ftAmount;
    private EditText inputAsbestos8ftAmount;
    private EditText inputAsbestos6ftAmount;

    private EditText inputLabourAmount;
    private EditText inputTransportAmount;
    private EditText inputOtherAmount;
    private EditText inputDiscountAmount;
    private EditText inputPaidAmount;

    private EditText inputCustomerName;
    private EditText inputPurchaseDate;
    private EditText inputPurchasePlace;
    private EditText inputCustomerPhone;
    private EditText inputCustomerNotes;

    private TextView showAmountTextView;
    private TextView showLeftAmountTextView;

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

    private String customerName;
    private String purchaseDate;
    private String purchaseLocation;
    private String customerPhone;
    private String customerNotes;

    private int khapraAmount;
    private int mangraAmount;
    private int koniaAmount;
    private int pillar12ftAmount;
    private int pillar10ftAmount;
    private int pillar8ftAmount;
    private int pillar3ftAmount;
    private int asbestos10ftAmount;
    private int asbestos8ftAmount;
    private int asbestos6ftAmount;

    private int khapraTotal;
    private int mangraTotal;
    private int koniaTotal;
    private int pillar12ftTotal;
    private int pillar10ftTotal;
    private int pillar8ftTotal;
    private int pillar3ftTotal;
    private int asbestos10ftTotal;
    private int asbestos8ftTotal;
    private int asbestos6ftTotal;
    private int labourTotal;
    private int transportTotal;
    private int otherTotal;
    private int discountTotal;
    private int paidTotal;

    private int totalAmount = 0;
    private int leftAmount = 0;

    Button totalAmountButton;
    Button leftAmountButton;

    Date todayDate;

    private FirebaseFirestore mFirestore;
    private CollectionReference customersReference;
    Customer newCustomer;

    private String formattedPhoneNumber;
    private String formattedMessage;

    private final String textSeparator = ", ";
    private final String SENT = "SMS_SENT";
    private final String DELIVERED = "SMS_DELIVERED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_sale);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        showAmountTextView = findViewById(R.id.show_amount_text_view);
        showLeftAmountTextView = findViewById(R.id.left_amount_text_view);

        todayDate = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(todayDate);

        inputKhapraAmount = (EditText) findViewById(R.id.input_khapra_amount);
        inputMangraAmount = (EditText) findViewById(R.id.input_mangra_amount);
        inputKoniaAmount = (EditText) findViewById(R.id.input_konia_amount);
        inputPillar12ftAmount = (EditText) findViewById(R.id.input_pillar_12ft_amount);
        inputPillar10ftAmount = (EditText) findViewById(R.id.input_pillar_10ft_amount);
        inputPillar8ftAmount = (EditText) findViewById(R.id.input_pillar_8ft_amount);
        inputPillar3ftAmount = (EditText) findViewById(R.id.input_pillar_3ft_amount);
        inputAsbestos10ftAmount = (EditText) findViewById(R.id.input_asbestos_10ft_amount);
        inputAsbestos8ftAmount = (EditText) findViewById(R.id.input_asbestos_8ft_amount);
        inputAsbestos6ftAmount = (EditText) findViewById(R.id.input_asbestos_6ft_amount);

        inputLabourAmount = (EditText) findViewById(R.id.input_labour_amount);
        inputTransportAmount = (EditText) findViewById(R.id.input_transport_amount);
        inputOtherAmount = (EditText) findViewById(R.id.input_other_amount);
        inputDiscountAmount = (EditText) findViewById(R.id.input_discount_amount);
        inputPaidAmount = (EditText) findViewById(R.id.input_paid_amount);

        inputCustomerName = (EditText) findViewById(R.id.input_customer_name);
        inputPurchaseDate = (EditText) findViewById(R.id.input_purchase_date);
        inputPurchasePlace = (EditText) findViewById(R.id.input_purchase_location);
        inputCustomerPhone = (EditText) findViewById(R.id.input_customer_phone);
        inputCustomerNotes = (EditText) findViewById(R.id.input_customer_notes);

        inputPurchaseDate.setText(formattedDate);

        khapraPrice = prefs.getInt("khapraPrice", 0);
        mangraPrice = prefs.getInt("mangraPrice", 0);
        koniaPrice = prefs.getInt("koniaPrice", 0);
        pillar12ftPrice = prefs.getInt("pillar12ftPrice", 0);
        pillar10ftPrice = prefs.getInt("pillar10ftPrice", 0);
        pillar8ftPrice = prefs.getInt("pillar8ftPrice", 0);
        pillar3ftPrice = prefs.getInt("pillar3ftPrice", 0);
        asbestos10ftPrice = prefs.getInt("asbestos10ftPrice", 0);
        asbestos8ftPrice = prefs.getInt("asbestos8ftPrice", 0);
        asbestos6ftPrice = prefs.getInt("asbestos6ftPrice", 0);

        initFirestore();
        newCustomer = new Customer();

        totalAmountButton = (Button) findViewById(R.id.total_amount_button);
        totalAmountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAmount();
            }
        });

        leftAmountButton = (Button) findViewById(R.id.left_amount_button);
        leftAmountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAmount();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.new_sale_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.save_customer_menu_item){
            saveCustomer();
        } if (item.getItemId() == R.id.send_message_menu_item){
            sendMessage();
        } if (item.getItemId() == R.id.send_whatsapp_menu_item){
            sendOnWhatsApp();
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveCustomer(){

        if (customerName.isEmpty()){
            Toast.makeText(this, "Enter a valid Customer's name!", Toast.LENGTH_SHORT).show();
            return;
        } if (purchaseDate.isEmpty()){
            Toast.makeText(this, "Enter a valid Purchase Date!", Toast.LENGTH_SHORT).show();
            return;
        } if (purchaseLocation.isEmpty()){
            Toast.makeText(this, "Enter a valid place!", Toast.LENGTH_SHORT).show();
            return;
        } if (customerPhone.isEmpty()){
            Toast.makeText(this, "Enter a valid Phone Number!", Toast.LENGTH_SHORT).show();
            return;
        } if (leftAmount == 0){
            Toast.makeText(this, "Please Calculate Left Amount!!", Toast.LENGTH_SHORT).show();
        }

        saveToDatabase();

        Toast.makeText(this, customerName + " purchased goods!", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void calculateAmount(){

        customerName = inputCustomerName.getText().toString();
        customerPhone = inputCustomerPhone.getText().toString();
        purchaseDate = inputPurchaseDate.getText().toString();
        purchaseLocation = inputPurchasePlace.getText().toString();
        customerNotes = inputCustomerNotes.getText().toString();

        if (inputKhapraAmount.getText().toString().isEmpty()){
            inputKhapraAmount.setText("0");
        } if (inputMangraAmount.getText().toString().isEmpty()){
            inputMangraAmount.setText("0");
        } if (inputKoniaAmount.getText().toString().isEmpty()){
            inputKoniaAmount.setText("0");
        } if (inputPillar12ftAmount.getText().toString().isEmpty()){
            inputPillar12ftAmount.setText("0");
        } if (inputPillar10ftAmount.getText().toString().isEmpty()){
            inputPillar10ftAmount.setText("0");
        } if (inputPillar8ftAmount.getText().toString().isEmpty()){
            inputPillar8ftAmount.setText("0");
        } if (inputPillar3ftAmount.getText().toString().isEmpty()){
            inputPillar3ftAmount.setText("0");
        } if (inputAsbestos10ftAmount.getText().toString().isEmpty()){
            inputAsbestos10ftAmount.setText("0");
        } if (inputAsbestos8ftAmount.getText().toString().isEmpty()){
            inputAsbestos8ftAmount.setText("0");
        } if (inputAsbestos6ftAmount.getText().toString().isEmpty()){
            inputAsbestos6ftAmount.setText("0");
        } if (inputLabourAmount.getText().toString().isEmpty()){
            inputLabourAmount.setText("0");
        } if (inputTransportAmount.getText().toString().isEmpty()){
            inputTransportAmount.setText("0");
        } if (inputOtherAmount.getText().toString().isEmpty()){
            inputOtherAmount.setText("0");
        } if (inputDiscountAmount.getText().toString().isEmpty()){
            inputDiscountAmount.setText("0");
        } if (inputPaidAmount.getText().toString().isEmpty()){
            inputPaidAmount.setText("0");
        }

        khapraAmount = Integer.parseInt(inputKhapraAmount.getText().toString());
        mangraAmount = Integer.parseInt(inputMangraAmount.getText().toString());
        koniaAmount = Integer.parseInt(inputKoniaAmount.getText().toString());
        pillar12ftAmount = Integer.parseInt(inputPillar12ftAmount.getText().toString());
        pillar10ftAmount = Integer.parseInt(inputPillar10ftAmount.getText().toString());
        pillar8ftAmount = Integer.parseInt(inputPillar8ftAmount.getText().toString());
        pillar3ftAmount = Integer.parseInt(inputPillar3ftAmount.getText().toString());
        asbestos10ftAmount = Integer.parseInt(inputAsbestos10ftAmount.getText().toString());
        asbestos8ftAmount = Integer.parseInt(inputAsbestos8ftAmount.getText().toString());
        asbestos6ftAmount = Integer.parseInt(inputAsbestos6ftAmount.getText().toString());

        khapraTotal = khapraAmount * khapraPrice;
        mangraTotal = mangraAmount * mangraPrice;
        koniaTotal = koniaAmount * koniaPrice;
        pillar12ftTotal = pillar12ftAmount * pillar12ftPrice;
        pillar10ftTotal = pillar10ftAmount * pillar10ftPrice;
        pillar8ftTotal = pillar8ftAmount * pillar8ftPrice;
        pillar3ftTotal = pillar3ftAmount * pillar3ftPrice;
        asbestos10ftTotal = asbestos10ftAmount * asbestos10ftPrice;
        asbestos8ftTotal = asbestos8ftAmount * asbestos8ftPrice;
        asbestos6ftTotal = asbestos6ftAmount * asbestos6ftPrice;

        labourTotal = Integer.parseInt(inputLabourAmount.getText().toString());
        transportTotal = Integer.parseInt(inputTransportAmount.getText().toString());
        otherTotal = Integer.parseInt(inputOtherAmount.getText().toString());
        discountTotal = Integer.parseInt(inputDiscountAmount.getText().toString());
        paidTotal = Integer.parseInt(inputPaidAmount.getText().toString());

        totalAmount = khapraTotal + mangraTotal + koniaTotal + pillar12ftTotal + pillar10ftTotal + pillar8ftTotal + pillar3ftTotal + asbestos10ftTotal + asbestos8ftTotal + asbestos6ftTotal + labourTotal + transportTotal + otherTotal - discountTotal;
        showAmountTextView.setText(String.valueOf(totalAmount));
        showAmountTextView.setVisibility(View.VISIBLE);

        leftAmount = totalAmount - paidTotal;
        showLeftAmountTextView.setText(String.valueOf(leftAmount));
        showLeftAmountTextView.setVisibility(View.VISIBLE);
    }

    private void initFirestore(){
        mFirestore = FirebaseFirestore.getInstance();
    }

    private void saveToDatabase(){
        customersReference = mFirestore.collection("customers");

        newCustomer.setCustomerName(customerName);
        newCustomer.setPurchaseDate(purchaseDate);
        newCustomer.setPurchaseLocation(purchaseLocation);
        newCustomer.setCustomerPhone(customerPhone);
        newCustomer.setCustomerNotes(customerNotes);

        newCustomer.setKhapraAmount(khapraAmount);
        newCustomer.setKhapraPrice(khapraPrice);
        newCustomer.setMangraAmount(mangraAmount);
        newCustomer.setMangraPrice(mangraPrice);
        newCustomer.setKoniaAmount(koniaAmount);
        newCustomer.setKoniaPrice(koniaPrice);

        newCustomer.setPillar12ftAmount(pillar12ftAmount);
        newCustomer.setPillar12ftPrice(pillar12ftPrice);
        newCustomer.setPillar10ftAmount(pillar10ftAmount);
        newCustomer.setPillar10ftPrice(pillar10ftPrice);
        newCustomer.setPillar8ftAmount(pillar8ftAmount);
        newCustomer.setPillar8ftPrice(pillar8ftPrice);
        newCustomer.setPillar3ftAmount(pillar3ftAmount);
        newCustomer.setPillar3ftPrice(pillar3ftPrice);

        newCustomer.setAsbestos6ftAmount(asbestos6ftAmount);
        newCustomer.setAsbestos6ftPrice(asbestos6ftPrice);
        newCustomer.setAsbestos10ftAmount(asbestos10ftAmount);
        newCustomer.setAsbestos10ftPrice(asbestos10ftPrice);
        newCustomer.setAsbestos8ftAmount(asbestos8ftAmount);
        newCustomer.setAsbestos8ftPrice(asbestos8ftPrice);

        newCustomer.setLabourTotal(labourTotal);
        newCustomer.setTransportTotal(transportTotal);
        newCustomer.setOtherTotal(otherTotal);
        newCustomer.setDiscountTotal(discountTotal);
        newCustomer.setPaidTotal(paidTotal);
        newCustomer.setTotalAmount(totalAmount);
        newCustomer.setLeftAmount(leftAmount);

        customersReference.add(newCustomer);
    }

    private void createMessageBody() {

        calculateAmount();

        StringBuilder messageStringBuilder = new StringBuilder();
        messageStringBuilder.append("AM Enterprises invoice. ");
        messageStringBuilder.append("Name: ");
        messageStringBuilder.append(customerName);
        messageStringBuilder.append(", ");
        messageStringBuilder.append(purchaseDate);

        if (khapraAmount != 0){
            messageStringBuilder.append(textSeparator);
            messageStringBuilder.append("Khapra: ");
            messageStringBuilder.append(khapraAmount);
        }
        if (mangraAmount != 0){
            messageStringBuilder.append(textSeparator);
            messageStringBuilder.append("Mangra: ");
            messageStringBuilder.append(mangraAmount);
        }
        if (koniaAmount != 0){
            messageStringBuilder.append(textSeparator);
            messageStringBuilder.append("Konia: ");
            messageStringBuilder.append(koniaAmount);
        }
        if (pillar12ftAmount != 0){
            messageStringBuilder.append(textSeparator);
            messageStringBuilder.append("Pillar12': ");
            messageStringBuilder.append(pillar12ftAmount);
        }
        if (pillar10ftAmount != 0){
            messageStringBuilder.append(textSeparator);
            messageStringBuilder.append("Pillar10': ");
            messageStringBuilder.append(pillar10ftAmount);
        }
        if (pillar8ftAmount != 0){
            messageStringBuilder.append(textSeparator);
            messageStringBuilder.append("Pillar8': ");
            messageStringBuilder.append(pillar8ftAmount);
        }
        if (pillar3ftAmount != 0){
            messageStringBuilder.append(textSeparator);
            messageStringBuilder.append("Pillar3': ");
            messageStringBuilder.append(pillar3ftAmount);
        }
        if (asbestos10ftAmount != 0){
            messageStringBuilder.append(textSeparator);
            messageStringBuilder.append("Asbestos10': ");
            messageStringBuilder.append(asbestos10ftAmount);
        }
        if (asbestos8ftAmount != 0){
            messageStringBuilder.append(textSeparator);
            messageStringBuilder.append("Asbestos8': ");
            messageStringBuilder.append(asbestos10ftAmount);
        }
        if (asbestos6ftAmount != 0){
            messageStringBuilder.append(textSeparator);
            messageStringBuilder.append("Asbestos6': ");
            messageStringBuilder.append(asbestos6ftAmount);
        }
        messageStringBuilder.append(textSeparator);
        messageStringBuilder.append("Total: ₹");
        messageStringBuilder.append(totalAmount);
        messageStringBuilder.append(textSeparator);
        messageStringBuilder.append("Paid: ₹");
        messageStringBuilder.append(paidTotal);
        messageStringBuilder.append(". ");
        messageStringBuilder.append("*ThankYou*");

        formattedMessage = messageStringBuilder.toString();

        formattedPhoneNumber = "+91" + customerPhone;

    }

    private void sendOnWhatsApp() {

        createMessageBody();

        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+formattedPhoneNumber +"&text="+formattedMessage));
            startActivity(intent);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Toast.makeText(this, "WhatsApp opened!", Toast.LENGTH_SHORT).show();

    }

    private void sendMessage(){

        createMessageBody();

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(formattedPhoneNumber, null, formattedMessage, null, null);
        Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show();
    }

}