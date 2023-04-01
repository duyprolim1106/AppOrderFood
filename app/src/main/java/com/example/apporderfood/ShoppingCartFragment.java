package com.example.apporderfood;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apporderfood.adapter.FoodAdapter;
import com.example.apporderfood.database.DatabaseHandler;
import com.example.apporderfood.model.Food;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartFragment extends Fragment {

    RecyclerView recyclerView;
    private static final String TAG = "MyClass";
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.shopping_cart_fragment, container, false);


        try {
            DatabaseHandler db = new DatabaseHandler(context);
            List<Food> foodList = db.getAllFoodItems(); // retrieve data from the database using a method that returns List<Food>

            FoodAdapter adapter = new FoodAdapter(foodList);
            recyclerView = view.findViewById(R.id.recycler_view);
            recyclerView.setAdapter(adapter);
        } catch (SQLiteException e) {
            Log.e(TAG, "Error adding cart to database: " + e.getMessage());
        }

        return view;
    }

}
