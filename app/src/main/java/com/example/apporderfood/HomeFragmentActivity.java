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

    ImageButton btnBurger;

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
        btnBurger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentValues(R.drawable.burger_all_big, getString(R.string.BeefBurger), getString(R.string.s20), "Big juicy burger with cheese lettuce tomato onions and special sauce");
            }
        });

    }

    public void IntentValues(int idImage, String title, String money, String detail) {
        Intent intent = new Intent(this, DetailFood.class);

        intent.putExtra("image", idImage);
        intent.putExtra("title", title);
        intent.putExtra("money", money);
        intent.putExtra("detail", detail);
        startActivity(intent);
    }
}