package com.example.osmsv2.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.osmsv2.model.data.Customer;

import java.util.List;

@Dao
public interface CustomerDao {
    @Insert
    void insert(Customer customer);
    @Query("UPDATE Customers SET CustomerFirstName = :firstName, CustomerLastName = :lastName, CustomerDateOfBirth = :dob, CustomerAddress = :address, CustomerSuburb = :suburb, CustomerCity = :city, CustomerZIP = :zip WHERE CustomerID = :customerId")
    void updateCustomer(int customerId, String firstName, String lastName, String dob, String address, String suburb, String city, String zip);
    @Delete
    void delete(Customer customer);

    @Query("SELECT * FROM Customers")
    LiveData<List<Customer>> getAllCustomers();

    @Query("DELETE FROM Customers") // Replace 'Customers' with the exact table name if it's different
    void deleteAll();
    //For repo
    @Query("SELECT * FROM Customers WHERE CustomerID = :customerId")
    LiveData<Customer> getCustomerById(int customerId);
    @Update
    void update(Customer customer);

}

