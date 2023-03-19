package com.example.apporderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeFragmentActivity extends AppCompatActivity {

    ImageButton btnBurger, btnCheese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_fragment);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//            getWindow().setDecorFitsSystemWindows(false);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//            getWindow().setNavigationBarColor(Color.TRANSPARENT);
//            getWindow().getInsetsController().hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
//        } else {
//            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        }

        btnBurger = findViewById(R.id.btnBurger);
        btnCheese = findViewById(R.id.btnCheese);
        btnBurger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentValues(R.drawable.beef_burger_biggest, getString(R.string.s48), getString(R.string.BeefBurger), getString(R.string.s20), getString(R.string.BigJuicyBurger));
            }
        });

        btnCheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentValues(R.drawable.pizza_big, getString(R.string.s45), getString(R.string.CheesePizza), getString(R.string.s32), getString(R.string.PizzaDist));
            }
        });

    }

    public void IntentValues(int idImage, String rate, String title, String money, String detail) {
        Intent intent = new Intent(this, DetailFood.class);

        intent.putExtra("image", idImage);
        intent.putExtra("rate", rate);
        intent.putExtra("foodName", title);
        intent.putExtra("money", money);
        intent.putExtra("foodDetail", detail);
        startActivity(intent);
        finish();
    }
}