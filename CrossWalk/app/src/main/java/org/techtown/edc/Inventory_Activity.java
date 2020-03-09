package org.techtown.edc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Inventory_Activity extends Activity implements View.OnClickListener{
    private Princess player;
    Button i0, i1, i2,i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19;
    Button i20, i21, i22, i23, i24, i25, i26, i27,i28,i29, choice;
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
        for(int i = 0; i < 31; i++){
            if(player.isInventory(i)){
                switch(i){
                    case 0 :
                        i0 = findViewById(R.id.i0);
                        i0.setBackgroundResource(R.drawable.crown);
                        break;
                    case 1 :
                        i0 = findViewById(R.id.i0);
                        i0.setBackgroundResource(R.drawable.star);
                        break;
                    case 2 :
                        i0 = findViewById(R.id.i0);
                        i0.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 3 :
                        i1 = findViewById(R.id.i1);
                        i1.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 4 :
                        i2 = findViewById(R.id.i2);
                        i2.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 5 :
                        i3 = findViewById(R.id.i3);
                        i3.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 6 :
                        i4 = findViewById(R.id.i4);
                        i4.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 7 :
                        i5 = findViewById(R.id.i5);
                        i5.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 8 :
                        i6 = findViewById(R.id.i6);
                        i6.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 9 :
                        i7 = findViewById(R.id.i7);
                        i7.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 10 :
                        i8 = findViewById(R.id.i8);
                        i8.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 11 :
                        i9 = findViewById(R.id.i9);
                        i9.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 12 :
                        i10 = findViewById(R.id.i10);
                        i10.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 13 :
                        i11 = findViewById(R.id.i11);
                        i11.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 14 :
                        i12 = findViewById(R.id.i12);
                        i12.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 15 :
                        i13 = findViewById(R.id.i13);
                        i13.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 16 :
                        i14 = findViewById(R.id.i14);
                        i14.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 17 :
                        i15 = findViewById(R.id.i15);
                        i15.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 18 :
                        i16 = findViewById(R.id.i16);
                        i16.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 19 :
                        i17 = findViewById(R.id.i17);
                        i17.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 20 :
                        i18 = findViewById(R.id.i18);
                        i18.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 21 :
                        i19 = findViewById(R.id.i19);
                        i19.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 22 :
                        i20 = findViewById(R.id.i20);
                        i20.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 23 :
                        i21 = findViewById(R.id.i21);
                        i21.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 24 :
                        i22 = findViewById(R.id.i22);
                        i22.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 25 :
                        i23 = findViewById(R.id.i23);
                        i23.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 26 :
                        i24 = findViewById(R.id.i24);
                        i24.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 27 :
                        i25 = findViewById(R.id.i25);
                        i25.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 28 :
                        i26 = findViewById(R.id.i26);
                        i26.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 29 :
                        i27 = findViewById(R.id.i27);
                        i27.setBackgroundResource(R.drawable.img_464209);
                        break;
                    case 30 :
                        i28 = findViewById(R.id.i28);
                        i28.setBackgroundResource(R.drawable.img_464209);
                        break;
                }
            }
        }

    }

    public void explainI0(View v) {
        if (player.isInventory(0)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.crown);
            text = findViewById(R.id.item_text);
            text.setText(String.format("황금주머니"));
        }
        else if (player.isInventory(1)){
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.star);
            text = findViewById(R.id.item_text);
            text.setText(String.format("수정구슬"));
        }
        else if (player.isInventory(2)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("육감의 티아라"));
        }
    }

    public void explainT1(View v) {
        if (player.isInventory(3)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("새장열쇠"));
        }
    }

    public void explainT2(View v) {
        if (player.isInventory(4)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("하녀옷"));
        }
    }

    public void explainT3(View v) {
        if (player.isInventory(5)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("우유"));
        }
    }

    public void explainT4(View v) {
        if (player.isInventory(6)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("치즈"));
        }
    }

    public void explainT5(View v) {
        if (player.isInventory(7)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("후추"));
        }
    }

    public void explainT6(View v) {
        if (player.isInventory(8)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("지랫대"));
        }
    }

    public void explainT7(View v) {
        if (player.isInventory(9)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("바늘"));
        }
    }

    public void explainT8(View v) {
        if (player.isInventory(10)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("밧줄"));
        }
    }

    public void explainT9(View v) {
        if (player.isInventory(11)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("맛있는 스튜"));
        }
    }


    public void explainT10(View v) {
        if (player.isInventory(12)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("허가증"));
        }
    }

    public void explainT11(View v) {
        if (player.isInventory(13)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("수선된 드레스"));
        }
    }
    public void explainT12(View v) {
        if (player.isInventory(14)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("잠드는 약"));
        }
    }

    public void explainT13(View v) {
        if (player.isInventory(15)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("빵조각"));
        }
    }

    public void explainT14(View v) {
        if (player.isInventory(16)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("동물과 말하는 약"));
        }
    }

    public void explainT15(View v) {
        if (player.isInventory(17)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("고대 마법책"));
        }
    }

    public void explainT16(View v) {
        if (player.isInventory(18)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("장검"));
        }
    }

    public void explainT17(View v) {
        if (player.isInventory(19)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("보청기"));
        }
    }

    public void explainT18(View v) {
        if (player.isInventory(20)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("서랍열쇠"));
        }
    }

    public void explainT19(View v) {
        if (player.isInventory(21)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("갈색의 고운 가루"));
        }
    }

    public void explainT20(View v) {
        if (player.isInventory(22)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("파란색의 단단한 금속"));
        }
    }

    public void explainT21(View v) {
        if (player.isInventory(23)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("빨간색의 뜨거운 기름"));
        }
    }
    public void explainT22(View v) {
        if (player.isInventory(24)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("하얀색의 말랑한 고체"));
        }
    }

    public void explainT23(View v) {
        if (player.isInventory(25)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("초록색의 푹신한 섬유"));
        }
    }

    public void explainT24(View v) {
        if (player.isInventory(26)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("울새의 깃털"));
        }
    }
    public void explainT25(View v) {
        if (player.isInventory(27)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("나비의 날개"));
        }
    }

    public void explainT26(View v) {
        if (player.isInventory(28)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("고양이의 수염"));
        }
    }

    public void explainT27(View v) {
        if (player.isInventory(29)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("송어의 비늘"));
        }
    }

    public void explainT28(View v) {
        if (player.isInventory(30)) {
            choice = findViewById(R.id.choice);
            choice.setBackgroundResource(R.drawable.img_464209);
            text = findViewById(R.id.item_text);
            text.setText(String.format("개구리 알"));
        }
    }

}