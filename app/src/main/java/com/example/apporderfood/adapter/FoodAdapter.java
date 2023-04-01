package com.example.apporderfood.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apporderfood.R;
import com.example.apporderfood.model.Food;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodViewHolder> {
    List<Food> foodList;

    public FoodAdapter(List<Food> foodList) {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.box_food_cart_fragment, parent, false);
        return new FoodViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.imageView.setImageResource(food.getImage());
        holder.foodName.setText(food.getFoodName());
        holder.money.setText("$"+food.getMoney());
        holder.quantity.setText(food.getQuantity());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

}
