package com.example.osmsv2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.osmsv2.R;
import com.example.osmsv2.view.addCustomer;
import com.example.osmsv2.view.manageCustomers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnAddCustomer(View view) {
        // Start the AddCustomerActivity
        Intent intent = new Intent(this, addCustomer.class);
        startActivity(intent);
    }

    public void btnManageCustomer(View view) {
        // Start the ManageCustomersActivity
        Intent intent = new Intent(this, manageCustomers.class);
        startActivity(intent);
    }
}