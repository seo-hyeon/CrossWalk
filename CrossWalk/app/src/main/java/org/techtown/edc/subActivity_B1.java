package org.techtown.edc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class subActivity_B1<player> extends AppCompatActivity {
    ConstraintLayout choice1, choice2, choice3, choice4, choice5, choice6;
    TextView character, mainText;
    Button c11, c21, c22, c31, c32, c33, c41, c42, c43, c44, c51, c52, c53, c54, c55, c61, c62, c63, c64, c65, c66;
    Button b42, b41;
    String position = " ";
    String name = " ";
    int []choices = new int [70];
    int []prev = new int [2];
    int life = 5;

    Princess player;

    int [] itemlist = new int [20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subb1);
        //1층에서 썼었던 객체 가져옴.
        Intent intent = getIntent();
        player = (Princess) intent.getSerializableExtra("player");

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.INVISIBLE);
        choice2 = findViewById(R.id.choice_no2);
        choice2.setVisibility(View.INVISIBLE);
        choice3 = findViewById(R.id.choice_no3);
        choice3.setVisibility(View.INVISIBLE);
        choice4 = findViewById(R.id.choice_no4);
        choice4.setVisibility(View.INVISIBLE);
        choice5 = findViewById(R.id.choice_no5);
        choice5.setVisibility(View.INVISIBLE);
        choice6 = findViewById(R.id.choice_no6);
        choice6.setVisibility(View.INVISIBLE);

        //Button heart = findViewById(R.id.b42);
        //heart.setText(life);

        //일단 임시로 setting 버튼 첫화면으로 가는 버튼으로 바꿈, 이후 팝업창 만들어서 저장등 메뉴 띄울 생각
        Button Back = findViewById(R.id.back);
        Back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                choice2.setVisibility(View.INVISIBLE);
                choice3.setVisibility(View.INVISIBLE);
                choice4.setVisibility(View.INVISIBLE);
                choice5.setVisibility(View.INVISIBLE);
                choice6.setVisibility(View.INVISIBLE);
                //back1(prev[0], prev[1]);
            }
        });

        //일단 세팅 버튼을 홈으로 귀한하는 버튼으로 사용함. (임시)
        Button home = findViewById(R.id.b45);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        Button map_open = (Button) findViewById(R.id.b43);
        map_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(subActivity_B1.this, map.class));
            }
        });

        Button item_view = (Button) findViewById(R.id.b44);
        item_view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Inventory_Activity.class);
                intent.putExtra("player", player);
                startActivity(intent);
            }
        });

        b42 = findViewById(R.id.b42);
        b42.setText(String.valueOf(player.getHeart()));
        b41 = findViewById(R.id.b41);
        //아이콘 생기기 전 임시
        int t = player.getType();
        if(t == 0){b41.setText(getString(R.string.goldP));}
        else if (t == 1){b41.setText(getString(R.string.starP));}
        else if (t == 2){b41.setText(getString(R.string.tigerP));}

        b1_1();

    }

    public void b1_1(){
        player.setB1_choices(1);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice3 = findViewById(R.id.choice_no3);
        choice3.setVisibility(View.VISIBLE);
        c31 = findViewById(R.id.choice3_1);
        c32 = findViewById(R.id.choice3_2);
        c33 = findViewById(R.id.choice3_3);

        mainText.setText(R.string.b1_1);
        c31.setText(R.string.b1_1_1);
        c32.setText(R.string.b1_1_2);
        c33.setText(R.string.b1_1_3);

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                b1_2();
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                choice3.setVisibility(View.INVISIBLE);
                //1층으로 넘어감

                Intent intent = new Intent(getApplicationContext(), subActivity_f1.class);
                intent.putExtra("player", player);
                startActivity(intent);
                finish();
            }
        });
        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                b1_14();
            }
        });

    }

    public void b1_2() {
        player.setB1_choices(2);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice4 = findViewById(R.id.choice_no4);
        choice4.setVisibility(View.VISIBLE);
        c41 = findViewById(R.id.choice4_1);
        c42 = findViewById(R.id.choice4_2);
        c43 = findViewById(R.id.choice4_3);
        c44 = findViewById(R.id.choice4_4);

        mainText.setText(R.string.b1_2);
        c41.setText(R.string.b1_2_1);
        c42.setText(R.string.b1_2_2);
        c43.setText(R.string.b1_2_3);
        c44.setText(R.string.b1_2_4);

        c41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                if (player.getB1_choices(20)){b1_38();}
                else if (player.getB1_choices(3)){b1_3();}
                else if (player.getB1_choices(30)){b1_30();}
                else if (player.getB1_choices(4)){b1_68();}
                else {b1_4();}
            }
        });
        c42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                if (player.getB1_choices(17)){b1_27();}
                else if (player.getB1_choices(7)){b1_17();}
                else if (player.getB1_choices(5) || player.getB1_choices(24)){b1_7();}
                else if (player.isInventory(4)){b1_5();}
                else {b1_24();}
            }
        });
        c43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                b_10();
            }
        });
        c44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                b_14();
            }
        });
    }

    public void b1_3(){
        player.setB1_choices(3);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_3a)
    }


}
