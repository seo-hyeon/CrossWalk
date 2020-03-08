package org.techtown.edc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Inventory_Activity extends Activity implements View.OnClickListener{
    private Princess player;
    Button i0, i1, i2,i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, ii4, i15, i16, i17, i18, i19;
    Button i20, i21, i22, i23, i24, i25, i26, i27,i28,i29,i30, i31, choice;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        Intent intent = getIntent();
        player = (Princess) intent.getSerializableExtra("player");
        findViewById(R.id.inventory_c).setOnClickListener(this);
        setInventory();
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.exit:
                this.finish();
                break;
        }
    }

    public void setInventory(){
        for(int i = 0; i < 32; i++){
            if(player.isInventory(i)){
                switch(i){
                    case 0 :
                        i0 = findViewById(R.id.i0);
                        i0.setBackgroundResource(R.drawable.crown);
                        break;
                    case 1 :
                        i1 = findViewById(R.id.i1);
                        i1.setBackgroundResource(R.drawable.star);
                        break;
                    case 2 :
                        i2 = findViewById(R.id.i2);
                        i2.setBackgroundResource(R.drawable.img_464209);
                }
            }
        }

    }
}