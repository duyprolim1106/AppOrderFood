package com.example.apporderfood;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "cartManager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "cart";

    private static final String KEY_IMAGE = "image";
    private static final String KEY_FOOD_NAME = "foodName";
    private static final String KEY_MONEY = "money";
    private static final String KEY_QUANTITY = "quantity";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_cart_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s INTEGER, %s INTEGER)", TABLE_NAME, KEY_IMAGE, KEY_FOOD_NAME, KEY_MONEY, KEY_QUANTITY);
        db.execSQL(create_cart_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_students_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_students_table);

        onCreate(db);
    }

    public void addCart(Cart cart) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(KEY_IMAGE, cart.getImage());
            values.put(KEY_FOOD_NAME, cart.getFoodName());
            values.put(KEY_MONEY, cart.getMoney());
            values.put(KEY_QUANTITY, cart.getQuantity());

            db.insert(TABLE_NAME, null, values);
            db.close();
        } catch (Exception e) {
            Log.e("DatabaseHandler", "Error adding cart item: " + e.getMessage());
        }

    }

    public void updateCart(Cart cart) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(KEY_IMAGE, cart.getImage());
            values.put(KEY_FOOD_NAME, cart.getFoodName());
            values.put(KEY_MONEY, cart.getMoney());
            values.put(KEY_QUANTITY, cart.getQuantity());

            db.update(TABLE_NAME, values, KEY_IMAGE + " = ?", new String[] { String.valueOf(cart.getImage()) });
            db.close();
        } catch (Exception e){
            Log.e("DatabaseHandler", "Error update cart items: " + e.getMessage());
        }

    }

    public void deleteCart(int image) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.delete(TABLE_NAME, KEY_IMAGE + " = ?", new String[] { String.valueOf(image) });
            db.close();
        } catch (Exception e){
            Log.e("DatabaseHandler", "Error delete cart items: " + e.getMessage());
        }

    }

    public List<Cart> getAllCarts() {
        List<Cart>  cartList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();

        try {

        } catch (Exception e){
            Log.e("DatabaseHandler", "Error query cart items: " + e.getMessage());
        }
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()) {
            Cart cart = new Cart(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3));
            cartList.add(cart);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return cartList;
    }
}
