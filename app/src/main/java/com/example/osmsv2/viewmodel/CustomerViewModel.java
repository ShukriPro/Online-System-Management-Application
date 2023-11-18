package com.example.osmsv2.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.osmsv2.repository.CustomerRepository;
import com.example.osmsv2.model.data.Customer;

import java.util.List;
public class CustomerViewModel extends AndroidViewModel {
    private CustomerRepository repository;
    private LiveData<List<Customer>> allCustomers;

    public CustomerViewModel(Application application) {
        super(application);
        repository = new CustomerRepository(application);
        allCustomers = repository.getAllCustomers();
    }

    public void insert(Customer customer) {
        repository.insert(customer);
    }

    public LiveData<List<Customer>> getAllCustomers() {
        return allCustomers;
    }

    // New methods
    public LiveData<Customer> getCustomerById(int id) {
        return repository.getCustomerById(id);
    }

    public void updateCustomer(Customer customer) {
        repository.updateCustomer(customer);
    }
    public void deleteCustomer(Customer customer) {
        repository.deleteCustomer(customer);
    }

}

