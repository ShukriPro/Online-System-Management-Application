package com.example.osmsv2.model.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

@Entity(tableName = "CustomerOrders")
public class CustomerOrder {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "OrderID")
    private int orderId;

    @ColumnInfo(name = "OrderDate")
    private String orderDate; // In SQLite, dates are often stored as TEXT in the format "YYYY-MM-DD"

    @ColumnInfo(name = "OrderCustomerID")
    private int orderCustomerId;

    // Getters and Setters

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderCustomerId() {
        return orderCustomerId;
    }

    public void setOrderCustomerId(int orderCustomerId) {
        this.orderCustomerId = orderCustomerId;
    }
}
