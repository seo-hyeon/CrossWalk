package org.techtown.edc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class subActivity_end<player> extends AppCompatActivity {

    TextView textView;
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        textView = findViewById(R.id.textView);
        exit = findViewById(R.id.exit);

        int i = 0; //엔딩 오기 전 무슨 엔딩으로 가야하는지 변수 받았다고 가정.

        if (i == 0) {
            textView.setText(R.string.end00);
        }
        else if (i == 1) {
            textView.setText(R.string.end01);
        }
        else if (i == 2) {
            textView.setText(R.string.end02);
        }
        else if (i == 3) {
            textView.setText(R.string.end03);
        }
        else if (i == 4) {
            textView.setText(R.string.end04);
        }
        else if (i == 5) {
            textView.setText(R.string.end05);
        }
        else if (i == 6) {
            textView.setText(R.string.end06);
        }
        else if (i == 7) {
            textView.setText(R.string.end07);
        }
        else if (i == 8) {
            textView.setText(R.string.end08);
        }
    }
}
