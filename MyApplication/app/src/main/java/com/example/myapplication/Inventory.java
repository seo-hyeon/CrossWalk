package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Inventory extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory);

        TextView textView1 = (TextView) findViewById(R.id.text);
        textView1.setText(String.format("아이템 설명설명"));

        Button b1 = (Button)findViewById(R.id.button0);
        b1.setBackgroundResource(R.drawable.star);
    }

}
