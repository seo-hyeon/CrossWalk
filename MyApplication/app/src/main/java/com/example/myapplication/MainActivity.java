package com.example.myapplication;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Princess princess = new Princess();
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        TextView textView1 = (TextView) findViewById(R.id.heart);
        textView1.setText(String.format("생명력: %d",princess.getHeart()));

        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(String.format("인벤토리 수: %d", princess.getInvNum()));

        txtResult = (TextView)findViewById(R.id.txtResult);

        Button inventory = findViewById(R.id.button);


    }

    public void mOnPopupClick(View v) {
        final Dialog loginDialog = new Dialog(this);
        loginDialog.setContentView(R.layout.popup_activity);
        loginDialog.setTitle("로그인 화면");

        Button login = (Button) loginDialog.findViewById(R.id.login);
        Button cancel = (Button) loginDialog.findViewById(R.id.cancel);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginDialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginDialog.dismiss();
            }
        });

        loginDialog.show();
    }

    public void heal(View v) {
        princess.heal();
        TextView textView1 = (TextView) findViewById(R.id.heart);
        textView1.setText(String.format("생명력: %d",princess.getHeart()));
    }
    public void damage(View v) {
        princess.damage();
        TextView textView1 = (TextView) findViewById(R.id.heart);
        textView1.setText(String.format("생명력: %d",princess.getHeart()));
    }

    public void add1(View v) {
        princess.addInventory(1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(String.format("인벤토리 수: %d", princess.getInvNum()));
    }
    public void add2(View v) {
        princess.addInventory(2);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(String.format("인벤토리 수: %d", princess.getInvNum()));
    }
    public void add3(View v) {
        princess.addInventory(3);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(String.format("인벤토리 수: %d", princess.getInvNum()));
    }
    public void remove1(View v) {
        princess.removeInventory(1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(String.format("인벤토리 수: %d", princess.getInvNum()));
    }
    public void remove2(View v) {
        princess.removeInventory(2);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(String.format("인벤토리 수: %d", princess.getInvNum()));
    }
    public void remove3(View v) {
        princess.removeInventory(3);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(String.format("인벤토리 수: %d", princess.getInvNum()));
    }

    public void inventoryClick(View v) {
        final Dialog loginDialog = new Dialog(this);
        loginDialog.setContentView(R.layout.inventory);

        Button exit = (Button) loginDialog.findViewById(R.id.exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginDialog.dismiss();
            }
        });

        loginDialog.show();
    }
}
