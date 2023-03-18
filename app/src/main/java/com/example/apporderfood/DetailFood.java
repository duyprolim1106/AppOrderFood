package com.example.apporderfood;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class DetailFood extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_food_page);

//        imageView = findViewById(R.id.image);
//        textView = findViewById(R.id.textView);
//
//        Intent intent = getIntent();
//        int image = intent.getIntExtra("image", -1);
//        String title = intent.getStringExtra("title");
//        String money = intent.getStringExtra("money");
//        String detail = intent.getStringExtra("detail");
//
//        Log.d("haha", image+" "+title+" "+money+" "+detail);
//
//        imageView.setImageResource(image);
//        textView.setText(title);
    }
}
