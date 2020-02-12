package org.techtown.edc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class subActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //일단 임시로 setting 버튼 첫화면으로 가는 버튼으로 바꿈, 이후 팝업창 만들어서 저장등 메뉴 띄울 생각
        Button home = findViewById(R.id.b45);
        home.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
