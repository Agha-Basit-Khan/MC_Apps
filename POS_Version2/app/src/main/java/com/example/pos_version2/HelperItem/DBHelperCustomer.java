package com.example.pos_version2.HelperItem;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperCustomer extends SQLiteOpenHelper {
    public static final String CUST_ID = "custID";
    public static final String CUST_NAME = "custName";
    public static final String CUST_ADDRESS = "custAddress";
    public static final String CUST_EMAIL = "custEmail";
    public static final String CUST_PHONE = "custPhone";
    public static final String CUST_TABLE = "custTable";

    public DBHelperCustomer(@Nullable Context context) {
        super(context, "MyDBmy.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSTatement = "CREATE TABLE " + CUST_TABLE  + " (" + CUST_ID + " Integer PRIMARY KEY AUTOINCREMENT, " + CUST_NAME + " Text, " + CUST_ADDRESS + " Text, " + CUST_EMAIL + " Text, " + CUST_PHONE + " Text)";
        db.execSQL(createTableSTatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addCustomer(customerModel custObj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(CUST_NAME, custObj.getName());
        cv.put(CUST_ADDRESS, custObj.getAddress());
        cv.put(CUST_EMAIL, custObj.getEmail());
        cv.put(CUST_PHONE, custObj.getPhone());
        db.insert(CUST_TABLE, null, cv);
    }
}
