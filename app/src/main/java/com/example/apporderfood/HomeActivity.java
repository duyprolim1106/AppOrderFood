package com.example.apporderfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

//    BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
//
//        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
////            @SuppressLint("NonConstantResourceId")
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Fragment selected_Fragment = null;
//
//                switch (item.getItemId()) {
//                    case R.id.navigation_home:
//                        selected_Fragment = new HomeFragment();
//                        break;
//                    case R.id.navigation_shopping_cart:
//                        selected_Fragment = new ShoppingCartFragment();
//                        break;
//                }
//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.frame_layout, selected_Fragment)
//                        .commit();
//                return false;
//            }
//        });

    }

}

