package com.example.osmsv2.view;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.osmsv2.viewmodel.CustomerViewModel;
import com.example.osmsv2.R;
import com.example.osmsv2.model.AppDatabase;
import com.example.osmsv2.model.data.Customer;
import com.example.osmsv2.model.CustomerDao;

import java.util.ArrayList;
import java.util.List;

public class manageCustomers extends AppCompatActivity {

    private CustomerViewModel customerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_customers);

        RecyclerView recyclerView = findViewById(R.id.customersRecyclerView);
        final CustomerAdapter adapter = new CustomerAdapter(this, new ArrayList<>());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // ViewModel
        customerViewModel = new ViewModelProvider(this).get(CustomerViewModel.class);
        customerViewModel.getAllCustomers().observe(this, new Observer<List<Customer>>() {
            @Override
            public void onChanged(List<Customer> customers) {
                adapter.setCustomers(customers);
            }
        });

        //ItemList onClick
        adapter.setOnItemClickListener(new CustomerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(manageCustomers.this, editCustomer.class);

                // Get clicked customer's details
                Customer clickedCustomer = adapter.getCustomerAtPosition(position);
                intent.putExtra("CUSTOMER_ID", clickedCustomer.getCustomerID());

                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);
    }

    public void btnClearList(View view)
    {
        AppDatabase database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "mydb")
                .allowMainThreadQueries()
                .build();
        CustomerDao customerDao = database.customerDao();

        // Delete all records
        customerDao.deleteAll();

        finish();
    }

    public void btnBack(View view)
    {
        finish();
    }
    public void btnEdit(View view)
    {
        Intent intent = new Intent(this, editCustomer.class);
        startActivity(intent);
    }

}
