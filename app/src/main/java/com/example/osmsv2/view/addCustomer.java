package com.example.osmsv2.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.osmsv2.R;
import com.example.osmsv2.model.AppDatabase;
import com.example.osmsv2.model.data.Customer;
import com.example.osmsv2.model.CustomerDao;

import java.util.Calendar;

public class addCustomer extends AppCompatActivity {
    private EditText editTextCustomerFirstName, editTextCustomerLastName, editTextCustomerDOB,
            editTextCustomerAddress, editTextCustomerSuburb, editTextCustomerCity,
            editTextCustomerZIP;

    // Assuming you have a Database class named 'AppDatabase' and a Dao 'CustomerDao'
    private AppDatabase database;
    private CustomerDao customerDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        // Get references to EditText fields
        editTextCustomerFirstName = findViewById(R.id.editTextCustomerFirstName);
        editTextCustomerLastName = findViewById(R.id.editTextCustomerLastName);
        editTextCustomerDOB = findViewById(R.id.editTextCustomerDOB);
        editTextCustomerAddress = findViewById(R.id.editTextCustomerAddress);
        editTextCustomerSuburb = findViewById(R.id.editTextCustomerSuburb);
        editTextCustomerCity = findViewById(R.id.editTextCustomerCity);
        editTextCustomerZIP = findViewById(R.id.editTextCustomerZIP);

        // Initialize the database and DAO
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "mydb")
                .allowMainThreadQueries() // Not recommended for production apps
                .build();
        customerDao = database.customerDao();

        //Date
        final EditText editTextCustomerDOB = findViewById(R.id.editTextCustomerDOB);

        editTextCustomerDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                DatePickerDialog picker = new DatePickerDialog(addCustomer.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                editTextCustomerDOB.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
    }

    public void btnAdd(View view)
    {

        String firstName = editTextCustomerFirstName.getText().toString();
        String lastName = editTextCustomerLastName.getText().toString();
        String registerDate = editTextCustomerDOB.getText().toString();
        String address = editTextCustomerAddress.getText().toString();
        String suburb = editTextCustomerSuburb.getText().toString();
        String city = editTextCustomerCity.getText().toString();
        String zip = editTextCustomerZIP.getText().toString();


        Customer customer = new Customer();
        customer.setCustomerFirstName(firstName);
        customer.setCustomerLastName(lastName);
        customer.setCustomerRegistrationDate(registerDate);
        customer.setCustomerAddress(address);
        customer.setCustomerSuburb(suburb);
        customer.setCustomerCity(city);
        customer.setCustomerZIP(zip);

        customerDao.insert(customer);

        Toast.makeText(this, "Customer added successfully", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(addCustomer.this, manageCustomers.class);
        startActivity(intent);
        finish();  // to close the addCustomer activity

    }

    public void btnCancel(View view)
    {
        finish();
    }
}