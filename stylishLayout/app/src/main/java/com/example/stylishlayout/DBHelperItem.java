package com.example.stylishlayout;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
        super(context, "MyDB0.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSTatement = "CREATE TABLE " + ITEM_TABLE + "(" + ITEM_ID + " Integer PRIMARY KEY AUTOINCREMENT, " + ITEM_NAME + " Text, " + ITEM_DESCRIPTion + " Text, " + ITEM_AMOUNT + " INT, " + ITEM_QUANTITY + " INT)";
        db.execSQL(createTableSTatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addItem(itemModel itemObj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ITEM_NAME, itemObj.getName());
        cv.put(ITEM_DESCRIPTion, itemObj.getDescription());
        cv.put(ITEM_AMOUNT, itemObj.getAmount());
        cv.put(ITEM_QUANTITY, itemObj.getQuantity());
        long insert=db.insert(ITEM_TABLE, null, cv);
        if (insert == -1) { return false; }
        else{return true;}
    }
    public List<itemModel> viewItem(){
        List<itemModel> list = new ArrayList<itemModel>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + ITEM_TABLE;
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String des = cursor.getString(2);
                int amount = cursor.getInt(3);
                int quantity = cursor.getInt(4);
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
        String whereArgs[] = {String.valueOf(itemObj.getId())};
        db.update("Items", cv, whereClause, whereArgs);
    }
    public void deleteItem(itemModel itemObj) {
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = "id=?";
        String whereArgs[] = {String.valueOf(itemObj.getId())};
        db.delete("Items", whereClause, whereArgs);
    }
}
