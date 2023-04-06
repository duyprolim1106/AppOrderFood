package com.example.apporderfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class UserFragment extends Fragment {

    TextView txtView;
    String value;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_fragment, container, false);
        String TAG = null;

        txtView = view.findViewById(R.id.txtView);
        // Retrieve the value of the variable from the Bundle in the fragment's onCreate or onCreateView method

        return view;
    }

    public void setStringData(String data) {
        txtView.setText(data);
    }
}