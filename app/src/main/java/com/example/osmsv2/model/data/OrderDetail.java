package com.example.osmsv2.model.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "OrderDetails",
        primaryKeys = {"OrderDetailOrderID", "OrderDetailProductID"})
public class OrderDetail {
    @ColumnInfo(name = "OrderDetailOrderID")
    private int orderDetailOrderID;

    @ColumnInfo(name = "OrderDetailProductID")
    private int orderDetailProductID;

    public int getOrderDetailOrderID() {
        return orderDetailOrderID;
    }

    public int getOrderDetailProductID() {
        return orderDetailProductID;
    }

    public int getOrderDetailQuantity() {
        return orderDetailQuantity;
    }

    @ColumnInfo(name = "OrderDetailQuantity")
    private int orderDetailQuantity;

    // Foreign keys, if needed, can be added with @ForeignKey annotation.

    // Getters, Setters, and other methods...
}
