package com.example.apporderfood;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        List<String> data = new ArrayList<>();
        data.add("Item 1");
        data.add("Item 2");
        data.add("Item 3");

        MyAdapter adapter = new MyAdapter(data);
//        recyclerView.setAdapter(adapter);

        return inflater.inflate(R.layout.shopping_cart_fragment, container, false);
    }

}
