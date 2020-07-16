package org.techtown.edc;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class subActivity_end<player> extends AppCompatActivity {

    final String TAG = "subActivity_end";

    TextView textView;
    Button exit;
    int i;
    String endStory;
    int cnt;

    private FirebaseDatabase cntDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        cntDatabase = FirebaseDatabase.getInstance();
        textView = findViewById(R.id.textView);
        exit = findViewById(R.id.exit);

        //외부에 파일 업로드 권한 요청
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
        }

        //ini_db(); //맨 처음 DB 구성하고 값 초기화하기 위해 사용

        i = 0; //엔딩 오기 전 무슨 엔딩으로 가야하는지 변수 받았다고 가정.
        endStory = "";

        if (i == 0) {
            //textView.setText(R.string.end00);
            endStory = getString(R.string.end00);
        }
        else if (i == 1) {
            //textView.setText(R.string.end01);
            endStory = getString(R.string.end01);
        }
        else if (i == 2) {
            //textView.setText(R.string.end02);
            endStory = getString(R.string.end02);
        }
        else if (i == 3) {
            //textView.setText(R.string.end03);
            endStory = getString(R.string.end03);
        }
        else if (i == 4) {
            //textView.setText(R.string.end04);
            endStory = getString(R.string.end04);
        }
        else if (i == 5) {
            //textView.setText(R.string.end05);
            endStory = getString(R.string.end05);
        }
        else if (i == 6) {
            //textView.setText(R.string.end06);
            endStory = getString(R.string.end06);
        }
        else if (i == 7) {
            //textView.setText(R.string.end07);
            endStory = getString(R.string.end07);
        }
        else if (i == 8) {
            //textView.setText(R.string.end08);
            endStory = getString(R.string.end08);
        }

        increase_cnt(cntDatabase.getReference().child("endingCnt").child(String.valueOf(i)));


        Button exit = findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
    }

    private void increase_cnt(DatabaseReference postRef) {
        postRef.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                EndingCount ec = mutableData.getValue(EndingCount.class);

                if(ec == null) {
                    return Transaction.success(mutableData);
                }

                ec.setCount(ec.getCount() + 1);
                mutableData.setValue(ec);


                return Transaction.success(mutableData);

            }

            @Override
            public void onComplete(@Nullable DatabaseError databaseError, boolean b, @Nullable DataSnapshot dataSnapshot) {
                EndingCount ec = dataSnapshot.getValue(EndingCount.class);
                endStory = endStory + "\n\n\n 해당 엔딩은 총" + (ec.getCount()) + "명이 본 엔딩입니다.\n";
                textView.setText(endStory);
            }
        });
    }

    private void ini_db() {
        EndingCount ec_initialize = new EndingCount();
        Map<String, Object> map = new HashMap<>();
        DatabaseReference databaseReference;

        for(int i = 0; i < 9; i++) {
            databaseReference = cntDatabase.getReference().child("endingCnt").child(String.valueOf(i));

            String t = "end" + String.valueOf(i);
            map.put("title", t);
            map.put("count", 0);
            databaseReference.setValue(map);
        }
    }
}
