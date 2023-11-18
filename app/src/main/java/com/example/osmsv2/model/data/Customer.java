package com.example.osmsv2.model.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "Customers")
public class Customer {
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public void setCustomerDateOfBirth(String customerDateOfBirth) {
        this.customerDateOfBirth = customerDateOfBirth;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setCustomerSuburb(String customerSuburb) {
        this.customerSuburb = customerSuburb;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public void setCustomerZIP(String customerZIP) {
        this.customerZIP = customerZIP;
    }

    public void setCustomerRegistrationDate(String customerRegistrationDate) {
        this.customerRegistrationDate = customerRegistrationDate;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public String getCustomerDateOfBirth() {
        return customerDateOfBirth;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerSuburb() {
        return customerSuburb;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public String getCustomerZIP() {
        return customerZIP;
    }

    public String getCustomerRegistrationDate() {
        return customerRegistrationDate;
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "CustomerID")
    private int customerID;

    @ColumnInfo(name = "CustomerFirstName")
    private String customerFirstName;

    @ColumnInfo(name = "CustomerLastName")
    private String customerLastName;

    @ColumnInfo(name = "CustomerDateOfBirth")
    private String customerDateOfBirth;

    @ColumnInfo(name = "CustomerAddress")
    private String customerAddress;

    @ColumnInfo(name = "CustomerSuburb")
    private String customerSuburb;

    @ColumnInfo(name = "CustomerCity")
    private String customerCity;

    @ColumnInfo(name = "CustomerZIP")
    private String customerZIP;

    @ColumnInfo(name = "CustomerRegistrationDate")
    private String customerRegistrationDate;

    // Getters and Setters...
}
