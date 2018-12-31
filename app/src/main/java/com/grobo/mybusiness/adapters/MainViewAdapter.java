package com.grobo.mybusiness.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.grobo.mybusiness.R;
import com.grobo.mybusiness.models.Customer;

import java.util.List;

public class MainViewAdapter extends ArrayAdapter<Customer> {

    public MainViewAdapter(Context context, int resource, List<Customer> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.list_item, parent, false);
        }

        Customer currentCustomer = getItem(position);

        TextView nameTextView = convertView.findViewById(R.id.name_display_view);
        TextView locationTextView = convertView.findViewById(R.id.location_display_view);
        TextView totalAmountTextView = convertView.findViewById(R.id.total_amount_display_view);
        TextView leftAmountTextView = convertView.findViewById(R.id.left_amount_display_view);
        TextView customerPhoneDisplayView = convertView.findViewById(R.id.customer_phone_display_view);
        TextView purchaseDateDisplayView = convertView.findViewById(R.id.purchase_date_display_view);

        nameTextView.setText(currentCustomer.getCustomerName());
        locationTextView.setText(currentCustomer.getPurchaseLocation());
        totalAmountTextView.setText(String.valueOf(currentCustomer.getTotalAmount()));
        leftAmountTextView.setText(String.valueOf(currentCustomer.getLeftAmount()));
        customerPhoneDisplayView.setText(currentCustomer.getCustomerPhone());
        purchaseDateDisplayView.setText(currentCustomer.getPurchaseDate());

        return convertView;
    }
}
