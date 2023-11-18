package com.example.osmsv2.model.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Products")
public class Product {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ProductID")
    private int productID;

    @ColumnInfo(name = "ProductName")
    private String productName;

    @ColumnInfo(name = "ProductDescription")
    private String productDescription;

    @ColumnInfo(name = "ProductUnitPrice")
    private int productUnitPrice; // Note: This might better be represented as a float or double, but I'm keeping it as an integer based on your provided data type.

    // Getters, Setters, and other methods...
}
