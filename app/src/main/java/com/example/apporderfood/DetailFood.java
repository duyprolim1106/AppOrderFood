package com.example.apporderfood;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class DetailFood extends AppCompatActivity {
    private static final String TAG = "MyClass";

    ImageView imageView, btnBack;
    TextView rateView, moneyFood, foodName, foodDetail, txtQuantity;
    ImageButton btnAdd, btnMinus;
    Button btnAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_food_page);

        Context context = this;

        imageView = findViewById(R.id.image);
        rateView = findViewById(R.id.rateView);
        moneyFood = findViewById(R.id.moneyFood);
        foodName = findViewById(R.id.foodName);
        foodDetail = findViewById(R.id.foodDetail);
        btnBack = findViewById(R.id.back);
        btnAddToCart = findViewById(R.id.btnAddToCart);
        btnAdd = findViewById(R.id.add);
        btnMinus = findViewById(R.id.minus);
        txtQuantity = findViewById(R.id.txtQuantity);

        Intent intent = getIntent();
        int image = intent.getIntExtra("image", -1);
        String food_name = intent.getStringExtra("foodName");
        String rate = intent.getStringExtra("rate");
        String money = intent.getStringExtra("money");
        String food_detail = intent.getStringExtra("foodDetail");

        imageView.setImageResource(image);
        foodName.setText(food_name);
        rateView.setText(rate);
        moneyFood.setText(money);
        foodDetail.setText(food_detail);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = Integer.parseInt(txtQuantity.getText().toString());
                quantity+=1;
                txtQuantity.setText(Integer.toString(quantity));
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = Integer.parseInt(txtQuantity.getText().toString());
                quantity-=1;
                if (quantity >= 1) {
                    txtQuantity.setText(Integer.toString(quantity));
                } else {
                    txtQuantity.setText("1");
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailFood.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cart cart = new Cart(image, food_name, Integer.parseInt(money), Integer.parseInt(txtQuantity.getText().toString()));
                try {
                    DatabaseHandler db = new DatabaseHandler(context);
                    db.addCart(cart);
                    db.close();
                } catch (SQLiteException e) {
                    Log.e(TAG, "Error adding cart to database: " + e.getMessage());
                }
            }
        });
    }
}
