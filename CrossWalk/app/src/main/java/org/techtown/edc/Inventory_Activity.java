package org.techtown.edc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Inventory_Activity extends Activity implements View.OnClickListener {
    private Princess player;
    private Button b[] = new Button[29];
    private int item[] = new int[29];
    Button  choice;
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.exit:
                this.finish();
                break;
        }
    }

    //처음 인벤토리 화면 구현
    public void setInventory() {
        b[0] = findViewById(R.id.i0);
        b[1] = findViewById(R.id.i1);
        b[2] = findViewById(R.id.i2);
        b[3] = findViewById(R.id.i3);
        b[4] = findViewById(R.id.i4);
        b[5] = findViewById(R.id.i5);
        b[6] = findViewById(R.id.i6);
        b[7] = findViewById(R.id.i7);
        b[8] = findViewById(R.id.i8);
        b[9] = findViewById(R.id.i9);
        b[10] = findViewById(R.id.i10);
        b[11] = findViewById(R.id.i11);
        b[12] = findViewById(R.id.i12);
        b[13] = findViewById(R.id.i13);
        b[14] = findViewById(R.id.i14);
        b[15] = findViewById(R.id.i15);
        b[16] = findViewById(R.id.i16);
        b[17] = findViewById(R.id.i17);
        b[18] = findViewById(R.id.i18);
        b[19] = findViewById(R.id.i19);
        b[20] = findViewById(R.id.i20);
        b[21] = findViewById(R.id.i21);
        b[22] = findViewById(R.id.i22);
        b[23] = findViewById(R.id.i23);
        b[24] = findViewById(R.id.i24);
        b[25] = findViewById(R.id.i25);
        b[26] = findViewById(R.id.i26);
        b[27] = findViewById(R.id.i27);
        b[28] = findViewById(R.id.i28);

        int n = 0;

        for (int i : player.inventory) {
            item[n] = i;

            switch (i) {
                case 0:
                    b[n].setBackgroundResource(R.drawable.crown);
                    break;
                case 1:
                    b[n].setBackgroundResource(R.drawable.crown);
                    break;
                case 2:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 3:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 4:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 5:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 6:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 7:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 8:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 9:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 10:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 11:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 12:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 13:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 14:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 15:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 16:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 17:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 18:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 19:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 20:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 21:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 22:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 23:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 24:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 25:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 26:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 27:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 28:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 29:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
                case 30:
                    b[n].setBackgroundResource(R.drawable.img_464209);
                    break;
            }

            n++;
        }
    }

    //버튼 클릭 시 choice부분 바뀌는 함수
    public void explain(View v) {
        Button newB = (Button) v;

        for (int i = 0; i < player.getInvNum(); i++) {
            if (b[i] == newB) {
                choice = findViewById(R.id.choice);
                text = findViewById(R.id.item_text);

                switch (item[i]) {
                    case 0:
                        choice.setBackgroundResource(R.drawable.crown);
                        text.setText(String.format("황금주머니"));
                        break;
                    case 1:
                        choice.setBackgroundResource(R.drawable.crown);
                        text.setText(String.format("수정구슬"));
                        break;
                    case 2:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("육감의 티아라"));
                        break;
                    case 3:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("새장열쇠"));
                        break;
                    case 4:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("하녀옷"));
                        break;
                    case 5:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("우유"));
                        break;
                    case 6:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("치즈"));
                        break;
                    case 7:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("후추"));
                        break;
                    case 8:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("지랫대"));
                        break;
                    case 9:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("바늘"));
                        break;
                    case 10:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("밧줄"));
                        break;
                    case 11:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("맛있는 스튜"));
                        break;
                    case 12:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("허가증"));
                        break;
                    case 13:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("수선된 드레스"));
                        break;
                    case 14:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("잠드는 약"));
                        break;
                    case 15:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("빵조각"));
                        break;
                    case 16:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("동물과 말하는 약"));
                        break;
                    case 17:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("고대 마법책"));
                        break;
                    case 18:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("장검"));
                        break;
                    case 19:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("보청기"));
                        break;
                    case 20:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("서랍열쇠"));
                        break;
                    case 21:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("갈색의 고운 가루"));
                        break;
                    case 22:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("파란색의 단단한 금속"));
                        break;
                    case 23:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("빨간색의 뜨거운 기름"));
                        break;
                    case 24:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("하얀색의 말랑한 고체"));
                        break;
                    case 25:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("초록색의 푹신한 섬유"));
                        break;
                    case 26:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("울새의 깃털"));
                        break;
                    case 27:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("나비의 날개"));
                        break;
                    case 28:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("고양이의 수염"));
                        break;
                    case 29:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("송어의 비늘"));
                        break;
                    case 30:
                        choice.setBackgroundResource(R.drawable.img_464209);
                        text.setText(String.format("개구리알"));
                        break;

                }

            }
        }
    }
}
