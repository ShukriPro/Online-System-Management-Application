package com.example.osmsv2.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.example.osmsv2.model.AppDatabase;
import com.example.osmsv2.model.CustomerDao;
import com.example.osmsv2.model.data.Customer;

import java.util.List;

public class CustomerRepository {
    private CustomerDao customerDao;
    private LiveData<List<Customer>> allCustomers;

    public CustomerRepository(Application application) {
        AppDatabase db = Room.databaseBuilder(application, AppDatabase.class, "mydb").build();
        customerDao = db.customerDao();
        allCustomers = customerDao.getAllCustomers();
    }

    public void insert(Customer customer) {
        new InsertCustomerAsyncTask(customerDao).execute(customer);
    }

    public LiveData<List<Customer>> getAllCustomers() {
        return allCustomers;
    }

    public LiveData<Customer> getCustomerById(int id) {
        return customerDao.getCustomerById(id);
    }

    public void updateCustomer(Customer customer) {
        new UpdateCustomerAsyncTask(customerDao).execute(customer);
    }

    private static class InsertCustomerAsyncTask extends AsyncTask<Customer, Void, Void> {
        private CustomerDao customerDao;

        private InsertCustomerAsyncTask(CustomerDao customerDao) {
            this.customerDao = customerDao;
        }

        @Override
        protected Void doInBackground(Customer... customers) {
            customerDao.insert(customers[0]);
            return null;
        }
    }

    private static class UpdateCustomerAsyncTask extends AsyncTask<Customer, Void, Void> {
        private CustomerDao customerDao;

        private UpdateCustomerAsyncTask(CustomerDao customerDao) {
            this.customerDao = customerDao;
        }

        @Override
        protected Void doInBackground(Customer... customers) {
            customerDao.update(customers[0]);
            return null;
        }
    }
    public void deleteCustomer(Customer customer) {
        new DeleteCustomerAsyncTask(customerDao).execute(customer);
    }

    private static class DeleteCustomerAsyncTask extends AsyncTask<Customer, Void, Void> {
        private CustomerDao customerDao;

        private DeleteCustomerAsyncTask(CustomerDao customerDao) {
            this.customerDao = customerDao;
        }

        @Override
        protected Void doInBackground(Customer... customers) {
            customerDao.delete(customers[0]);
            return null;
        }
    }

}
