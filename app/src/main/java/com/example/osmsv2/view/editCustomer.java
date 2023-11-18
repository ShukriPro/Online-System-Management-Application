package com.example.osmsv2.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.osmsv2.R;
import com.example.osmsv2.model.data.Customer;
import com.example.osmsv2.viewmodel.CustomerViewModel;

import java.util.Calendar;

public class editCustomer extends AppCompatActivity {

    private CustomerViewModel customerViewModel;

    // UI Elements
    private EditText editTextCustomerID;
    private EditText editTextCustomerFirstName;
    private EditText editTextCustomerLastName;
    private EditText editTextCustomerDateOfBirth;
    private EditText editTextCustomerAddress;
    private EditText editTextCustomerSuburb;
    private EditText editTextCustomerCity;
    private EditText editTextCustomerZIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_customer);

        // Initialize UI elements
        editTextCustomerID = findViewById(R.id.editTextCustomerID);
        editTextCustomerFirstName = findViewById(R.id.editTextCustomerFirstName);
        editTextCustomerLastName = findViewById(R.id.editTextCustomerLastName);
        editTextCustomerDateOfBirth = findViewById(R.id.editTextCustomerDateOfBirth);
        editTextCustomerAddress = findViewById(R.id.editTextCustomerAddress);
        editTextCustomerSuburb = findViewById(R.id.editTextCustomerSuburb);
        editTextCustomerCity = findViewById(R.id.editTextCustomerCity);
        editTextCustomerZIP = findViewById(R.id.editTextCustomerZIP);

        customerViewModel = new ViewModelProvider(this).get(CustomerViewModel.class);

        // Assuming you're passing the customer ID from the previous activity
        int customerId = getIntent().getIntExtra("CUSTOMER_ID", -1);

        if (customerId != -1) {
            customerViewModel.getCustomerById(customerId).observe(this, new Observer<Customer>() {
                @Override
                public void onChanged(Customer customer) {
                    populateFields(customer);
                }
            });
        } else {
            Toast.makeText(this, "Error: No Customer ID provided", Toast.LENGTH_SHORT).show();
        }

        //Birth date
        final EditText editTextCustomerDateOfBirth = findViewById(R.id.editTextCustomerDateOfBirth);

        editTextCustomerDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                // Using a spinner theme
                DatePickerDialog picker = new DatePickerDialog(editCustomer.this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                editTextCustomerDateOfBirth.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // Making the background transparent
                picker.show();
            }
        });
    }

    private void populateFields(Customer customer) {
        editTextCustomerID.setText(String.valueOf(customer.getCustomerID()));
        editTextCustomerFirstName.setText(customer.getCustomerFirstName());
        editTextCustomerLastName.setText(customer.getCustomerLastName());
        editTextCustomerDateOfBirth.setText(customer.getCustomerDateOfBirth());
        editTextCustomerAddress.setText(customer.getCustomerAddress());
        editTextCustomerSuburb.setText(customer.getCustomerSuburb());
        editTextCustomerCity.setText(customer.getCustomerCity());
        editTextCustomerZIP.setText(customer.getCustomerZIP());
    }

    public void btnUpdate(View view) {
        Customer updatedCustomer = new Customer();
        updatedCustomer.setCustomerID(Integer.parseInt(editTextCustomerID.getText().toString()));
        updatedCustomer.setCustomerFirstName(editTextCustomerFirstName.getText().toString());
        updatedCustomer.setCustomerLastName(editTextCustomerLastName.getText().toString());
        updatedCustomer.setCustomerDateOfBirth(editTextCustomerDateOfBirth.getText().toString());
        updatedCustomer.setCustomerAddress(editTextCustomerAddress.getText().toString());
        updatedCustomer.setCustomerSuburb(editTextCustomerSuburb.getText().toString());
        updatedCustomer.setCustomerCity(editTextCustomerCity.getText().toString());
        updatedCustomer.setCustomerZIP(editTextCustomerZIP.getText().toString());

        customerViewModel.updateCustomer(updatedCustomer);

        Toast.makeText(this, "Customer Updated", Toast.LENGTH_SHORT).show();
        finish();
    }
    public void btnDelete(View view) {
        int customerId = Integer.parseInt(editTextCustomerID.getText().toString());
        Customer customerToDelete = new Customer();
        customerToDelete.setCustomerID(customerId);
        customerViewModel.deleteCustomer(customerToDelete);
        Toast.makeText(this, "Customer Deleted", Toast.LENGTH_SHORT).show();
        finish(); // Return to the previous screen or wherever you'd like the user to go after deletion.
    }
    public void btnCancel(View view) {
        finish();
    }
}
