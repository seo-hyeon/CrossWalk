package org.techtown.edc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class map extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_map);

        findViewById(R.id.map_c).setOnClickListener(this);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.map_c:
                this.finish();
                break;
        }
    }
}
