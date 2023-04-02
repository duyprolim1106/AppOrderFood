package com.example.apporderfood;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apporderfood.adapter.FoodAdapter;
import com.example.apporderfood.database.DatabaseHandler;
import com.example.apporderfood.model.Food;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartFragment extends Fragment implements FoodAdapter.OnItemClickListener {

    RecyclerView recyclerView;
    private static final String TAG = "MyClass";
    private Context context;
    TextView numberFoodInCart, totalMoney;

    FoodAdapter fAdapter;

    int total = 0;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onItemClick(int position) {
        // Perform any actions you need to update the data in your adapter
        // (e.g., update the list of items in your adapter and call notifyDataSetChanged)
        fAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shopping_cart_fragment, container, false);
        numberFoodInCart = view.findViewById(R.id.NumberFoodInCart);
        totalMoney = view.findViewById(R.id.TotalMoney);

        try {
            context = getContext();
            DatabaseHandler db = new DatabaseHandler(context);
            List<Food> foodList = db.getAllFoodItems(); // retrieve data from the database using a method that returns List<Food>
            numberFoodInCart.setText(String.valueOf(foodList.size()));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                foodList.forEach(v -> total += v.getMoney()*v.getQuantity());
            }
            totalMoney.setText("$" + total);
            FoodAdapter adapter = new FoodAdapter(foodList, totalMoney);
            recyclerView = view.findViewById(R.id.recycler_view);
            LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(adapter);
        } catch (SQLiteException e) {
            Log.e(TAG, "Error adding cart to database: " + e.getMessage());
        }

        return view;
    }

}
