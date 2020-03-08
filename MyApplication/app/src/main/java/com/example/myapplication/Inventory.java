package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class Inventory extends AppCompatActivity {
    private Activity a;
    private Princess p;
    private int count = 0;
    private ArrayList<Integer> itemlist;

    Inventory(Activity activity, Princess player){
        this.a = activity;
        this.p = player;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory);

        setInventoty();
        TextView dec = (TextView) findViewById(R.id.text);
        //textView1.setText(String.format("아이템 설명설명"));

        //Button b1 = (Button)findViewById(R.id.button0);
        //b1.setBackgroundResource(R.drawable.star);



    }
    public void setInventoty(){
        for(int i : p.inventory){
            if(p.isInventory(i)){
                itemlist.add(i);
            }
        }
    }
    public Boolean getItem(int i){
        return true;
    }


}
