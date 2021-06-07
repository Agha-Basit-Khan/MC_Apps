package com.example.pos_version2.HelperItem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelperItem extends SQLiteOpenHelper {
    public static final String ITEM_ID = "itemId";
    public static final String ITEM_NAME = "itemName";
    public static final String ITEM_DESCRIPTion = "itemDes";
    public static final String ITEM_AMOUNT = "itemAmount";
    public static final String ITEM_QUANTITY = "itemQuantity";
    public static final String ITEM_TABLE = "itemTable";

    public DBHelperItem(@Nullable Context context) {
        super(context, "MyDBmy.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSTatement = "CREATE TABLE " + ITEM_TABLE  + " (" + ITEM_ID + " Integer PRIMARY KEY AUTOINCREMENT, " + ITEM_NAME + " Text, " + ITEM_DESCRIPTion + " Text, " + ITEM_AMOUNT + " Text, " + ITEM_QUANTITY + " Text)";
        db.execSQL(createTableSTatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addItem(itemModel itemObj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ITEM_NAME, itemObj.getName());
        cv.put(ITEM_DESCRIPTion, itemObj.getDescription());
        cv.put(ITEM_AMOUNT, itemObj.getAmount());
        cv.put(ITEM_QUANTITY, itemObj.getQuantity());
        db.insert(ITEM_TABLE, null, cv);
    }
    public List<itemModel> viewItem(){
        List<itemModel> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + ITEM_TABLE;
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String des = cursor.getString(2);
                String amount = cursor.getString(3);
                String quantity = cursor.getString(4);
                itemModel obj = new itemModel(id,name,des,amount,quantity);
                list.add(obj);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }
    public void updateItem(itemModel itemObj){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ITEM_NAME, itemObj.getName());
        cv.put(ITEM_DESCRIPTion, itemObj.getDescription());
        cv.put(ITEM_AMOUNT, itemObj.getAmount());
        cv.put(ITEM_QUANTITY, itemObj.getQuantity());
        String whereClause = "itemId=?";
        String whereArgs = String.valueOf(itemObj.getId());
        db.update("itemTable", cv, whereClause, new String[]{whereArgs});
        db.close();
    }
    public void deleteItem(itemModel itemObj) {
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = "itemId=?";
        String whereArgs[] = {String.valueOf(itemObj.getId())};
        db.delete("itemTable", whereClause, whereArgs);
        db.close();
    }
    public List<itemModel> viewFruit(){
        List<itemModel> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + ITEM_TABLE + " WHERE itemDes = 'Fruits'";
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String des = cursor.getString(2);
                String amount = cursor.getString(3);
                String quantity = cursor.getString(4);
                itemModel obj = new itemModel(id,name,des,amount,quantity);
                list.add(obj);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }
}
