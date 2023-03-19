package com.example.apporderfood;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class DetailFood extends AppCompatActivity {

    ImageView imageView, btnBack;
    TextView rateView, moneyFood, foodName, foodDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_food_page);

        imageView = findViewById(R.id.image);
        rateView = findViewById(R.id.rateView);
        moneyFood = findViewById(R.id.moneyFood);
        foodName = findViewById(R.id.foodName);
        foodDetail = findViewById(R.id.foodDetail);
        btnBack = findViewById(R.id.back);

        Intent intent = getIntent();
        int image = intent.getIntExtra("image", -1);
        String food_name = intent.getStringExtra("foodName");
        String rate = intent.getStringExtra("rate");
        String money = intent.getStringExtra("money");
        String food_detail = intent.getStringExtra("detail");

        imageView.setImageResource(image);
        foodName.setText(food_name);
        rateView.setText(rate);
        moneyFood.setText(money);
        foodDetail.setText(food_detail);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailFood.this, HomeFragmentActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
