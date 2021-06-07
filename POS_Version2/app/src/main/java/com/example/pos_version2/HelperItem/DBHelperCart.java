package com.example.pos_version2.HelperItem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelperCart extends SQLiteOpenHelper {
    public static final String CART_ID = "cartId";
    public static final String CART_NAME = "cartName";
    public static final String CART_DESCRIPTion = "cartDes";
    public static final String CART_AMOUNT = "cartAmount";
    //public static final String ITEM_QUANTITY = "itemQuantity";
    public static final String CART_TABLE = "cart1Table";

    public DBHelperCart(@Nullable Context context) {
        super(context, "MyDB.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSTatement = "CREATE TABLE cart1Table(" + CART_ID + " Integer PRIMARY KEY AUTOINCREMENT, " + CART_NAME + " Text, " + CART_DESCRIPTion + " Text, " + CART_AMOUNT + " Text)";
        db.execSQL(createTableSTatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addCart(itemModel itemObj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(CART_NAME, itemObj.getName());
        cv.put(CART_DESCRIPTion, itemObj.getDescription());
        cv.put(CART_AMOUNT, itemObj.getAmount());
        db.insert("cart1Table", null, cv);
    }
    public List<itemModel> viewCart(){
        List<itemModel> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM cart1Table";
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                String name = cursor.getString(1);
                String des = cursor.getString(2);
                String amount = cursor.getString(3);
                itemModel obj = new itemModel(name,des,amount);
                list.add(obj);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }
}
