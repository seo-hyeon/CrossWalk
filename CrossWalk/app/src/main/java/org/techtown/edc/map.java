package org.techtown.edc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

public class map extends Activity implements View.OnClickListener {
    LinearLayout map;
    Button cage, table, stew, window, stair, gate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_map);
        map = findViewById(R.id.map);

        cage = findViewById(R.id.cage); cage.setVisibility(View.INVISIBLE);
        table = findViewById(R.id.table); table.setVisibility(View.INVISIBLE);
        stew = findViewById(R.id.stew); stew.setVisibility(View.INVISIBLE);
        window = findViewById(R.id.window); window.setVisibility(View.INVISIBLE);
        gate = findViewById(R.id.gate); gate.setVisibility(View.INVISIBLE);
        stair = findViewById(R.id.stair); stair.setVisibility(View.INVISIBLE);


        Intent intent = getIntent();
        Princess player = (Princess) intent.getSerializableExtra("player");

        if(intent.getIntExtra("floor", 0) == 1) {
            map.setBackgroundResource(R.drawable.s1f_map);
            /*
            assert player != null;
            int loation = player.getLocation();
            //1층 0 : 새장, 1 : 큰문, 2 : 조리대, 3: 창문, 4 : 식탁, 5 : 계단
            switch(loation){
                case 0 :
                    cage.setVisibility(View.VISIBLE);
                    break;
                case 1 :
                    gate.setVisibility(View.VISIBLE);
                    break;
                case 2 :
                    stew.setVisibility(View.VISIBLE);
                    break;
                case 3 :
                    window.setVisibility(View.VISIBLE);
                    break;
                case 4 :
                    table.setVisibility(View.VISIBLE);
                    break;
                case 5 :
                    stair.setVisibility(View.VISIBLE);
                    break;
            }
             */
        } else if(intent.getIntExtra("floor", 0) == 2){
            //
        }
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
