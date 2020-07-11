package org.techtown.edc;
import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class subActivity_f1 extends AppCompatActivity {
    //FrameLayout icon_pop;
    LinearLayout map;
    ImageView img;
    ConstraintLayout choice1, choice2, choice3, choice4, choice5, choice6;
    TextView character, mainText;
    Button c11, c21, c22, c31, c32, c33, c41, c42, c43, c44, c51, c52, c53, c54, c55, c61, c62, c63, c64, c65, c66;
    Button b42;

    String name = " ";
    int []choices = new int [70];
    int []prev = new int [2];

    Princess player;
    //0황금주머니, 1수정구슬, 2육감티아라, 3새장열쇠, 4하녀옷, 5우유,6 치즈 7후추,
    // 8지랫대, 9바늘, 10밧줄, 11맛있는 스튜, 12허가증, 13 수선된 드레스, 14 잠드는 약, 15 빵조각, 16 동물과 말하는 약, 17 고대 마법책, 18 장검
    // 19 보청기, 20 서랍열쇠;
    int [] itemlist = new int [20];

    //도박 구현시 필요한 변수
    int pr = -1, mo = -1, A = -1, B = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subf1);

        choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.INVISIBLE);
        choice2 = findViewById(R.id.choice_no2); choice2.setVisibility(View.INVISIBLE);
        choice3 = findViewById(R.id.choice_no3); choice3.setVisibility(View.INVISIBLE);
        choice4 = findViewById(R.id.choice_no4); choice4.setVisibility(View.INVISIBLE);
        choice5 = findViewById(R.id.choice_no5); choice5.setVisibility(View.INVISIBLE);
        choice6 = findViewById(R.id.choice_no6); choice6.setVisibility(View.INVISIBLE);
        //Button heart = findViewById(R.id.b42);
        //heart.setText(life);

        //일단 임시로 setting 버튼 첫화면으로 가는 버튼으로 바꿈, 이후 팝업창 만들어서 저장등 메뉴 띄울 생각
        Button Back = findViewById(R.id.back);
        Back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE); choice2.setVisibility(View.INVISIBLE);
                choice3.setVisibility(View.INVISIBLE); choice4.setVisibility(View.INVISIBLE);
                choice5.setVisibility(View.INVISIBLE);
                back1(prev[0], prev[1]);
            }
        });


        Button home = findViewById(R.id.b45);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                //startActivity(intent);
            }
        });


        Button map_open = (Button) findViewById(R.id.b43);
        map_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(subActivity_f1.this, map.class);
                intent.putExtra("player", player);
                intent.putExtra("floor", 1);
                startActivity(intent);
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

        /*
        //미니맵 열기 -> b43('map')버튼 : map 레이아웃을 visible로, 닫기 -> map_c ('X')버튼 : mamp 레이아웃을 invisible로
        Button map_open = findViewById(R.id.b43);
        Button map_close = findViewById(R.id.map_c);
        map = findViewById(R.id.map);
        map_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.setVisibility(View.VISIBLE);
            }
        });

        map_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.setVisibility((View.INVISIBLE));
            }
        });
        */

        /*
        Intent intent = getIntent();

        if(intent.getIntExtra("floor", 1) == 2) {
            player = (Princess) intent.getSerializableExtra("player");
            b42 = findViewById(R.id.b42);
            b42.setText(String.valueOf(player.getHeart()));
            f1_13();
        } else{
            player = new Princess();
            b42 = findViewById(R.id.b42);
            b42.setText(String.valueOf(player.getHeart()));

            f1_51();
        }*/

        player = new Princess();
        b42 = findViewById(R.id.b42);
        b42.setText(String.valueOf(player.getHeart()));

        f1_51();
    }

    //choice들을 INVISIBLE 바꾸기 함수
    public void allInvisible() {
        choice1.setVisibility(View.INVISIBLE);
        choice2.setVisibility(View.INVISIBLE);
        choice3.setVisibility(View.INVISIBLE);
        choice4.setVisibility(View.INVISIBLE);
        choice5.setVisibility(View.INVISIBLE);
        choice6.setVisibility(View.INVISIBLE);
    }

    //1층 시작

    public void choosePrincess() {
        allInvisible();
        c31 = findViewById(R.id.choice3_1);
        c32 = findViewById(R.id.choice3_2);
        c33 = findViewById(R.id.choice3_3);
        choice3 = findViewById(R.id.choice_no3);
        choice3.setVisibility(View.VISIBLE);
        c31.setText(getString(R.string.goldP));
        c32.setText(getString(R.string.starP));
        c33.setText(getString(R.string.tigerP));

        //player에 임의로 넣었지만 이후 공주 객체 만든 다음 객체를 저장할 예정.
        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //who 버튼 구현 및 play staus 구현 후 자세히 설정 현재는 text만 설정.
                Button who = findViewById(R.id.b41);
                player.setType(0);
                player.addInventory(0);
                Toast toast = Toast.makeText(getApplicationContext(), "item : 황금 주머니를 얻었다", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
                toast.show();
                //who.setText(String.valueOf(player.getType()));
                who.setText(getString(R.string.goldP));
                //itemlist[0] = 1;
                name = getString(R.string.goldP);
                choice3.setVisibility(View.INVISIBLE);
                f1_52();
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //who 버튼 구현 및 play staus 구현 후 자세히 설정 현재는 text만 설정.
                Button who = findViewById(R.id.b41);
                player.setType(1);
                player.addInventory(1);
                Toast toast = Toast.makeText(getApplicationContext(), "item : 수정 구슬을 얻었다", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
                toast.show();
                who.setText(getString(R.string.starP));
                //itemlist[1] = 1;
                name = getString(R.string.starP);
                choice3.setVisibility(View.INVISIBLE);
                f1_52();
            }
        });
        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //who 버튼 구현 및 play staus 구현 후 자세히 설정 현재는 text만 설정.
                Button who = findViewById(R.id.b41);
                player.setType(2);
                player.addInventory(2);
                Toast toast = Toast.makeText(getApplicationContext(), "item : 육감의 티아라를 얻었다", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
                toast.show();
                who.setText(getString(R.string.tigerP));
                //itemlist[2] = 1;
                name = getString(R.string.tigerP);
                choice3.setVisibility(View.INVISIBLE);
                //f1_52();
                f1_52();
            }
        });

    }

    public void f1_51(){
        allInvisible();
        player.setF1_choices(51);
        player.setLocation(0);
        //choices[51] = 1;
        prev[1] = 51;
        img = findViewById(R.id.imageView);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        img.setImageResource(R.drawable.a111);
        character.setText(" ");
        mainText.setText(getString(R.string.f1_51_1));
        c11.setText(getString(R.string.click));

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev[0] = 51;
                img.setImageResource(R.drawable.a112);
                character.setText(getString(R.string.doll_dog));
                mainText.setText(getString(R.string.f1_51_2));
                choice1.setVisibility(View.INVISIBLE);
                choosePrincess();
            }
        });
    }

    public void f1_52(){
        allInvisible();
        player.setF1_choices(52);
        player.setLocation(0);
        //choices[52] = 1;
        prev[1] = 52;
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice2 = findViewById(R.id.choice_no2);
        choice2.setVisibility(View.VISIBLE);
        c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);

        character.setText(getString(R.string.doll_dog));
        mainText.setText(String.format(getString(R.string.f1_52), name));

        c21.setText(getString(R.string.f1_52c1));
        c22.setText(getString(R.string.f1_52c2));

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev[0] = 52;
                choice2.setVisibility(View.INVISIBLE);
                f1_0();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev[0] = 52;
                choice2.setVisibility(View.INVISIBLE);
                f1_0();
            }
        });

    }

    public void f1_0(){
        allInvisible();
        player.setF1_choices(0);
        player.setLocation(0);
        //choices[0] = 1;
        prev[1] = 0;
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        //if(itemlist[0] == 1) {
        if(player.isInventory(0)){
            choice4 = findViewById(R.id.choice_no4); choice4.setVisibility(View.VISIBLE);
            c41 = findViewById(R.id.choice4_1); c42 = findViewById(R.id.choice4_2);
            c43 = findViewById(R.id.choice4_3); c44 = findViewById(R.id.choice4_4);
        }else {
            choice3 = findViewById(R.id.choice_no3); choice3.setVisibility(View.VISIBLE);
            c41 = findViewById(R.id.choice3_1); c42 = findViewById(R.id.choice3_2);
            c43 = findViewById(R.id.choice3_3);
        }

        character.setText(getString(R.string.doll_dog));
        mainText.setText(getString(R.string.f1_0));
        c41.setText(getString(R.string.f1_0c1));
        c42.setText(getString(R.string.f1_0c2));
        c43.setText(getString(R.string.f1_0c3));

        //if(itemlist[0] == 1) {
        if(player.isInventory(0)){
            c44.setText(getString(R.string.f1_0c4));
            c44.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice4.setVisibility(View.INVISIBLE);
                    prev[0] = 0;
                    f1_4();
                }
            });
        }

        c41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);
                choice3.setVisibility(View.INVISIBLE);
                prev[0] = 0;
                f1_1();
            }
        });
        c42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);
                choice3.setVisibility(View.INVISIBLE);
                prev[0] = 0;
                f1_2();
            }
        });
        c43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);
                choice3.setVisibility(View.INVISIBLE);
                prev[0] = 0;
                f1_3();
            }
        });

    }

    public void f1_1(){
        allInvisible();
        player.setF1_choices(1);
        player.setLocation(0);
        //choices[1] = 1;
        prev[1] = 1;
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice3 = findViewById(R.id.choice_no3); choice2 = findViewById(R.id.choice_no2);
        choice1 = findViewById(R.id.choice_no1);

        //if(itemlist[0] == 1 && choices[2] == 0) {
        if(player.isInventory(0) && !player.getF1_choices(2)){
            choice3.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice3_1);
            c32 = findViewById(R.id.choice3_2);
            c33 = findViewById(R.id.choice3_3);
            c31.setText(getString(R.string.f1_0c3));
            c32.setText(getString(R.string.f1_0c2));
            c33.setText(getString(R.string.f1_0c4));
        }
        //else if (itemlist[0] == 1 || choices[2] == 0){
        else if (player.isInventory(0) || !player.getF1_choices(2)){
            choice2.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice2_1);
            c32 = findViewById(R.id.choice2_2);
            c31.setText(getString(R.string.f1_0c3));
            //if(itemlist[0] == 1){
            if(player.isInventory(0)){
                c32.setText(getString(R.string.f1_0c4));
            } //else if(choices[2] == 0){
            else if (!player.getF1_choices(2)){
                c32.setText(getString(R.string.f1_0c2));
            }
        } else {
            choice1.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice1_1);
            c31.setText(getString(R.string.f1_0c3));
        }

        character.setText(getString(R.string.doll_dog));
        mainText.setText(getString(R.string.f1_1));

        //if(itemlist[0] == 1) {
        if(player.isInventory(0)){
            c33.setText(getString(R.string.f1_0c4));
            c33.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice3.setVisibility(View.INVISIBLE);
                    prev[0] = 1;
                    f1_4();
                }
            });
        }
        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                choice2.setVisibility(View.INVISIBLE);
                choice1.setVisibility(View.INVISIBLE);
                prev[0] = 1;
                f1_3();
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                choice2.setVisibility(View.INVISIBLE);
                prev[0] = 1;
                /*
                if(itemlist[0] == 1){ f1_4(); }
                else if(choices[2] == 0){ f1_2(); }
                 */
                if(c32.getText().toString().equals(getString(R.string.f1_0c4))){f1_4();}
                else if(c32.getText().toString().equals(getString(R.string.f1_0c2))){ f1_2();}
            }
        });

    }

    public void f1_2(){
        allInvisible();
        //choices[2] = 1;
        player.setLocation(0);
        player.setF1_choices(2); prev[1] = 2;
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice2 = findViewById(R.id.choice_no2); choice1 = findViewById(R.id.choice_no1);
        c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        c11 = findViewById(R.id.choice1_1);

        choice1.setVisibility(View.VISIBLE);
        character.setText(getString(R.string.doll_dog));
        mainText.setText(getString(R.string.f1_2_1));
        c11.setText(getString(R.string.click));

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(getString(R.string.f1_2_1))) {
                    character.setText(" ");
                    mainText.setText(getString(R.string.f1_2_2));
                    choice2.setVisibility(View.VISIBLE);
                    choice1.setVisibility(View.INVISIBLE);
                    c21.setText(getString(R.string.f1_2c1));
                    c22.setText(getString(R.string.f1_23c2));
                }
            }
        });
        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                prev[0] = 2;
                f1_5();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                prev[0] = 2;
                f1_6();
            }
        });


    }

    public void f1_3(){
        allInvisible();
        //choices[3] = 1;
        player.setLocation(0);
        player.setF1_choices(3); prev[1] = 3;

        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice2 = findViewById(R.id.choice_no2); choice2.setVisibility(View.VISIBLE);
        c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);

        character.setText(getString(R.string.doll_dog));
        mainText.setText(getString(R.string.f1_3));
        c21.setText(getString(R.string.f1_3c1));
        c22.setText(getString(R.string.f1_23c2));

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                prev[0] = 3;
                f1_7();
            }
        });

        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                prev[0] = 3;
                f1_6();
            }
        });
    }

    public void f1_4(){
        allInvisible();
        //choices[4] = 1;
        player.setLocation(0);
        player.setF1_choices(4); prev[1] = 4;

        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        character.setText(getString(R.string.doll_dog));
        mainText.setText(getString(R.string.f1_4_1));

        c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f1_4_1))) {
                    mainText.setText(getString(R.string.f1_4_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f1_4_2))) {
                    character.setText(" ");
                    mainText.setText(getString(R.string.f1_4_3));
                } else  if(mainText.getText().toString().equals(getString(R.string.f1_4_3))) {
                    character.setText(" ");
                    mainText.setText(getString(R.string.f1_4_4));
                    c11.setText(getString(R.string.f1_4c1)); player.addInventory(3);

                    Toast toast = Toast.makeText(getApplicationContext(), "item : 새장열쇠를 얻었다", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
                    toast.show();
                } else {
                    choice1.setVisibility(View.INVISIBLE);
                    prev[0] = 4;
                    f1_9();
                }
            }
        });

    }
    public void f1_5(){
        allInvisible();
        //choices[5] = 1;
        player.setLocation(0);
        player.setF1_choices(5); prev[1] = 5;

        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);

        //황금 주머니가 있거나 여기 어디임?(0c1) 선택지 안 들렸을 경우 이를 보여주는 조건 set
        if (player.isInventory(0) && !player.getF1_choices(1)) {
            choice3 = findViewById(R.id.choice_no3);
            c31 = findViewById(R.id.choice3_1); c32 = findViewById(R.id.choice3_2); c33 = findViewById(R.id.choice3_3);
            c31.setText(getString(R.string.f1_0c1));
            c32.setText(R.string.f1_0c3);
            c33.setText(getString(R.string.f1_0c4));
        } else if(player.isInventory(0) || !player.getF1_choices(1)) {
            choice3 = findViewById(R.id.choice_no2);
            c31 = findViewById(R.id.choice2_1); c32 = findViewById(R.id.choice2_2); c33 = findViewById(R.id.choice3_3);
            if (player.isInventory(0)) {  //if (itemlist[0] == 1) {
                c31.setText(R.string.f1_0c3);
                c32.setText(getString(R.string.f1_0c4));
            } else if (!player.getF1_choices(1)) {  //choices[1] == 0){
                c31.setText(R.string.f1_0c3);
                c32.setText(getString(R.string.f1_0c1));
            }
        }
        choice1.setVisibility(View.VISIBLE);
        character.setText(getString(R.string.doll_dog));
        mainText.setText(getString(R.string.f1_5_1));
        c11.setText(getString(R.string.click));

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f1_5_1))) {
                    mainText.setText(getString(R.string.f1_5_2));
                } else if (mainText.getText().toString().equals(getString(R.string.f1_5_2))) {
                    mainText.setText(getString(R.string.f1_5_3));
                    player.addInventory(4);
                    Toast toast = Toast.makeText(getApplicationContext(), "item : 하녀복을 얻었다", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
                    toast.show();
                    //토스트 메세지 하녀옷을 얻었다!  itemlist[4] = 1;
                    choice1.setVisibility(View.INVISIBLE);
                    choice3.setVisibility(View.VISIBLE);
                }
            }
        });
        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                prev[0] = 5;
                if(c31.getText().toString().equals(getString(R.string.f1_0c1))){
                    f1_1();
                } else if(c31.getText().toString().equals(getString(R.string.f1_0c3))){
                    f1_3();
                }
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                prev[0] = 5;
                if(c32.getText().toString().equals(getString(R.string.f1_0c1))){
                    f1_1();
                } else if(c32.getText().toString().equals(getString(R.string.f1_0c3))){
                    f1_3();
                }  else if(c32.getText().toString().equals(getString(R.string.f1_0c4))){
                    f1_4();
                }
            }
        });
        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                prev[0] = 5;
                f1_4();
            }
        });

    }

    public void f1_6(){
        allInvisible();
        //choices[6] = 1;
        player.setLocation(0);
        player.setF1_choices(6);  prev[1] = 6;

        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice2 = findViewById(R.id.choice_no2); choice2.setVisibility(View.VISIBLE);
        c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);


        character.setText(" "); mainText.setText(getString(R.string.f1_6));
        c21.setText(getString(R.string.f1_6c1));
        c22.setText(getString(R.string.f1_6c2));

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                prev[0] = 6;
                if(player.getF1_choices(2) && !player.isInventory(4)){ //if(choices[2] == 1 && itemlist[4] == 0){
                     f1_5();
                } else if (!player.getF1_choices(2) || player.getF1_choices(5)){ //else if(choices[2] == 0 || choices[5] == 1){
                    f1_7();
                }
            }
        });

        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                prev[0] = 6;
                f1_8();
            }
        });
    }

    public void f1_7(){
        allInvisible();
        //choices[7] = 1;
        player.setLocation(0);
        player.setF1_choices(7); prev[1] = 7;

        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);
        character.setText(" "); mainText.setText(getString(R.string.f1_7));
        if(player.getF1_choices(6)){//if(choices[6] == 1){
            c11.setText(getString(R.string.f1_7c1));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice1.setVisibility(View.INVISIBLE);
                    prev[0] = 7;
                    f1_8();
                }
            });
        }else{
            c11.setText(getString(R.string.f1_7c2));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice1.setVisibility(View.INVISIBLE);
                    prev[0] = 7;
                    f1_6();
                }
            });
        }
    }
    public void f1_8(){
        allInvisible();
        //choices[8] = 1;
        player.setLocation(0);
        player.setF1_choices(8); prev[1] = 8;
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);
        character.setText(" ");
        mainText.setText(getString(R.string.f1_8));
        c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f1_8))) {
                    if (player.isInventory(2)) {//if (itemlist[2] == 1) { //호랑이 공주 티아라 ~ 체력 감소x
                        player.setF1_choices(54);//choices[54] = 1;
                        mainText.setText(getString(R.string.f1_54));
                    } else { // 그 외 공주 낙법x 체력 감소o
                        player.setF1_choices(53); //choices[53] = 1;
                        mainText.setText(getString(R.string.f1_53));
                        player.damage(); b42 = findViewById(R.id.b42); b42.setText(String.valueOf(player.getHeart()));

                        Toast toast = Toast.makeText(getApplicationContext(), " : 체력이 -1 감소했다", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -340);
                        toast.show();
                    }
                } else { //8은 이미 출력해서 써 먹었고, maintext가 54 (육감의 티아라 발동~이나, 53 (~라기엔 너무 아팠다) 일 경우
                    choice1.setVisibility(View.INVISIBLE);
                    prev[0] = 8;
                    f1_9();
                }
            }
        });

    }

    public void f1_9(){
        allInvisible();
        //choices[9] = 1;
        player.setLocation(1);
        player.setF1_choices(9); prev[1] = 9;

        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); choice4 = findViewById(R.id.choice_no4);
        choice1.setVisibility(View.VISIBLE);
        c41 = findViewById(R.id.choice4_1); c42 = findViewById(R.id.choice4_2);
        c43 = findViewById(R.id.choice4_3); c44 = findViewById(R.id.choice4_4);
        c11 = findViewById(R.id.choice1_1);
        character.setText(" ");
        mainText.setText(getString(R.string.f1_9_1));
        c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE); choice4.setVisibility(View.VISIBLE);
                mainText.setText(getString(R.string.f1_9_2));
                c41.setText(getString(R.string.f1_9c1));
                c42.setText(getString(R.string.f1_9c2));
                c43.setText(getString(R.string.f1_9c3));
                c44.setText(getString(R.string.f1_9c4));
            }
        });

        c41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);
                if(!player.getF1_choices(14) && !player.getF1_choices(16)){//if(choices[14] == 0 && choices[16] == 0) {
                    prev[0] = 9;
                    f1_10();
                } else {
                    prev[0] = 9;
                    f1_15();
                }
            }
        });
        c42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);
                prev[0] = 9;
                f1_11();
            }
        });
        c43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);
                prev[0] = 9;
                if(player.getF1_choices(21)){
                    f1_67();
                } else {
                    f1_12();
                }
            }
        });
        c44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);
                prev[0] = 9;
                f1_13();
            }
        });

    }

    public void f1_10(){
        allInvisible();
        //choices[10] = 1;
        player.setF1_choices(10); prev[1] = 10;

        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);

        choice1.setVisibility(View.VISIBLE); character.setText(" ");
        mainText.setText(getString(R.string.f1_10_1));
        c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText(getString(R.string.f1_10_2));
                choice1.setVisibility(View.INVISIBLE);
                choice3.setVisibility(View.VISIBLE);
            }
        });
        //c33 아 씨 바늘이네의 선택지 생성 조건 ( 만족시 3택, 불만족시 2택)
        if(player.getF2_choices(66) || player.getF2_choices(70) || player.getF2_choices(82)) {
            c31 = findViewById(R.id.choice3_1);
            c32 = findViewById(R.id.choice3_2);
            c33 = findViewById(R.id.choice3_3);
            choice3 = findViewById(R.id.choice_no3);
        }else {
            c31 = findViewById(R.id.choice2_1);
            c32 = findViewById(R.id.choice2_2);
            c33 = findViewById(R.id.choice3_3);
            choice3 = findViewById(R.id.choice_no2);
        }

        c31.setText(getString(R.string.f1_10c1));
        c32.setText(getString(R.string.f1_10c2));
        c33.setText(getString(R.string.f1_10c3));

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                prev[0] = 10;
                f1_14();
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                prev[0] = 10;
                f1_15();
            }
        });
        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                prev[0] = 10;
                f1_16();
            }
        });


    }

    public void f1_11(){
        allInvisible();
        //choices[11] = 1;
        player.setF1_choices(11); prev[1] = 11;

        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice2 = findViewById(R.id.choice_no2);
        c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        choice2.setVisibility(View.VISIBLE);
        character.setText(" ");
        mainText.setText(getString(R.string.f1_11));
        c21.setText(getString(R.string.f1_11c1));
        c22.setText(getString(R.string.f1_11c2));

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                prev[0]= 11;
                //우유나 후추가 없을 경우 itemlist[5] = 우유, itemlist[7] = 후추
                if(!player.isInventory(5) && !player.isInventory(7)){//if(itemlist[5] == 0 && itemlist[7] == 0 ) {
                    if(player.getF1_choices(3) && player.isInventory(4) && !player.getF1_choices(17)){//if (choices[3] == 1 && itemlist[4] == 1 && choices[17] == 0) {
                        f1_17();
                    } else if(!player.getF1_choices(3) && player.isInventory(4) && !player.getF1_choices(55)) {//else if (choices[3] == 0 && itemlist[4] == 1 && choices[55] == 0) {
                        f1_55();
                    } else if(player.getF1_choices(4) && !player.isInventory(4) && !player.getF1_choices(56)) {//else if (choices[4] == 1 && itemlist[4] == 0 && choices[56] == 0) {
                        f1_56();
                    } else if(!player.getF1_choices(4) && !player.isInventory(4) && !player.getF1_choices(18)){//else if (choices[4] == 0 && itemlist[4] == 0 && choices[18] == 0) {
                        f1_18();
                    } else if((player.getF1_choices(56) || player.getF1_choices(18)) && !player.isInventory(4) && !player.getF1_choices(29)) {
                        //else if ((choices[56] == 1 || choices[18] == 1) && itemlist[4] == 0 && choices[29] == 0) {
                        f1_29();
                    }else if((player.getF1_choices(17) && !player.getF1_choices(34)) ||(player.getF1_choices(55) && !player.getF1_choices(33))
                                || (player.getF1_choices(33) && !player.getF1_choices(36) && !player.getF1_choices(35) )
                                || (player.getF1_choices(34) && !player.getF1_choices(36) && !player.getF1_choices(35))){
                        /*else if ((choices[17] == 1 && choices[34] == 0) || (choices[55] == 1 && choices[33] == 0)
                                || (choices[33] == 1 && choices[36] == 0 && choices[35] == 0) || (choices[34] == 1 && choices[36] == 0 && choices[35] == 0)){
                        */
                        f1_37();
                    } else if(player.getF1_choices(36) || player.getF1_choices(35)){//else if (choices[36] == 1 || choices[35] == 1){
                        f1_63();
                    } else{
                        f1_100();
                    }
                } //우유나 후추가 있을 경우.
                else if(player.isInventory(5) || player.isInventory(7)) { //else if(itemlist[5] == 1 || itemlist[7] == 1){
                    if(player.isInventory(5) && player.getF1_choices(55) && !player.getF1_choices(33)) {//if(itemlist[5] == 1 && choices[55] == 1 && choices[33] == 0){
                        f1_33();
                    } else if(player.isInventory(7) && player.getF1_choices(17) && !player.getF1_choices(34)){ //else if (itemlist[7] == 1 && choices[17] == 1 && choices[34] == 0){
                        f1_34();
                    } else if(!player.getF1_choices(36) && (player.isInventory(7) && player.getF1_choices(33)) || (player.isInventory(5) && player.getF1_choices(34))) {
                        //else if (choices[36] == 0 && ((itemlist[7] == 1 && choices[33] == 1) || (itemlist[5] == 1 && choices[34] == 1))){
                        f1_36();
                    }
                }
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev[0] = 11;
                choice2.setVisibility(View.INVISIBLE);
                if(player.getF1_choices(57) || player.getF1_choices(19)){ //if(choices[57] == 1 || choices[19] == 1){
                    f1_9();
                } else if(player.getF1_choices(2) && !player.getF1_choices(5) && !player.isInventory(1)) { //else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 0){
                    f1_19();
                } else if(player.getF1_choices(2) && !player.getF1_choices(5) && player.isInventory(1)){//else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 1){
                    f1_20();
                } else{
                    f1_9();
                }
            }
        });
    }

    public void f1_12(){
        allInvisible();
        //choices[12] = 1;
        player.setF1_choices(12); prev[1] = 12;

        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); choice2 = findViewById(R.id.choice_no2);
        character.setText(" ");
        mainText.setText(getString(R.string.f1_12));

        //c22 : 지랫대 유무에 따라 선택지 개수 유무.
        if(player.isInventory(8)){//if(itemlist[8] == 1) {
            c21 = findViewById(R.id.choice2_1);
            c22 = findViewById(R.id.choice2_2);
            choice2.setVisibility(View.VISIBLE);

            c21.setText(getString(R.string.f1_12c1));
            c22.setText(getString(R.string.f1_12c2));
        }else{
            c21 = findViewById(R.id.choice1_1);
            c22 = findViewById(R.id.choice2_2);
            choice1.setVisibility(View.VISIBLE);
            c21.setText(getString(R.string.f1_12c1));
        }

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev[0] = 12;
                choice2.setVisibility(View.INVISIBLE);
                choice1.setVisibility(View.INVISIBLE);
                if(player.getF1_choices(57) || player.getF1_choices(19)) {//if(choices[57] == 1 || choices[19] == 1){
                    f1_9();
                }else if(player.getF1_choices(2) && !player.getF1_choices(5) && !player.isInventory(0)){ //}else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 0){
                    f1_19();
                } else if(player.getF1_choices(2) && !player.getF1_choices(5) && player.isInventory(1)){ //else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 1){
                    f1_20();
                }else {
                    f1_9();
                }
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev[0] = 12;
                choice2.setVisibility(View.INVISIBLE);
                f1_21();
            }
        });
    }

    public void f1_13(){
        allInvisible();
        //choices[13] = 1;
        player.setF1_choices(13);

        prev[1] = 13;

        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice3 = findViewById(R.id.choice_no3); choice3.setVisibility(View.VISIBLE);
        c31 = findViewById(R.id.choice3_1); c32 = findViewById(R.id.choice3_2); c33 = findViewById(R.id.choice3_3);
        character.setText(" "); mainText.setText(getString(R.string.f1_13));

        c31.setText(getString(R.string.f1_13c1));  c32.setText(getString(R.string.f1_13c2));  c33.setText(getString(R.string.f1_13c3));

        //구현x
        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                //3_1(); //위로
                //Intent intent = new Intent(getApplicationContext(), subActivity_f2.class);
                //intent.putExtra("player", player);
                //startActivity(intent);
                //finish();
                f2_0();
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                //2_1(); // 아래로
                //Intent intent = new Intent(getApplicationContext(), subActivity_B1.class);
                //intent.putExtra("player", player);
                //startActivity(intent);
                //finish();
                b1_1();
            }
        });
        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev[0] = 13;
                choice3.setVisibility(View.INVISIBLE);
                if(player.getF1_choices(57) || player.getF1_choices(19)){//if(choices[57] == 1 || choices[19] == 1){
                    f1_9();
                } else if(player.getF1_choices(2) && !player.getF1_choices(5) && !player.isInventory(1)){//else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 0){
                    f1_19();
                }else if(player.getF1_choices(2) && !player.getF1_choices(5) && player.isInventory(1)){//else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 1){
                    f1_20();
                }else {
                    f1_9();
                }
            }
        });
    }
    public void f1_14(){
        allInvisible();
        //choices[14] = 1;
        player.setF1_choices(14); prev[1] = 14;

        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice2 = findViewById(R.id.choice_no2); choice2.setVisibility(View.VISIBLE);
        c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        character.setText(" "); mainText.setText(getString(R.string.f1_14));
        b42 = findViewById(R.id.b42); player.damage(); b42.setText(String.valueOf(player.getHeart()));
        player.addInventory(9); //itemlist[9] = 1;
        Toast toast = Toast.makeText(getApplicationContext(), "item : 바늘을 얻었다 \n 체력이 -1 감소했다.", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
        toast.show();

        c21.setText(getString(R.string.f1_14c1));  c22.setText(getString(R.string.f1_14c2));

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev[0] = 14;
                choice2.setVisibility(View.INVISIBLE);
                f1_15();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev[0] = 14;
                choice2.setVisibility(View.INVISIBLE);
                if(player.getF1_choices(57) || player.getF1_choices(19)){//if(choices[57] == 1 || choices[19] == 1){
                    f1_9();
                } else if(player.getF1_choices(2) && !player.getF1_choices(5) && !player.isInventory(1)){//else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 0){
                    f1_19();
                } else if (player.getF1_choices(2) && !player.getF1_choices(5) && player.isInventory(1)){//else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 1){
                    f1_20();
                } else{
                    f1_9();
                }
            }
        });
    }

    public void f1_15() {
        allInvisible();
        //추가 서술 조건상 choices[15]는 f1_152()에서 1로 체크됨.
        prev[1] = 15;
        character = findViewById(R.id.character);
        mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1);

        // 1. 15번 출력-> 버튼의 경우  2.15번출력 ->60번이나 61번 출력 -> 버튼의 경우
        character.setText(" ");
        mainText.setText(getString(R.string.f1_15)); //찐으로 처음와서 15번 출력하고 이 뒤에 60이나 61번 출력이 되는지 확인, 출력
        if(!player.getF1_choices(60) && !player.getF1_choices(15) && (player.getF1_choices(20)) || player.getF1_choices(31)){
            //if (choices[60] == 0 && choices[15] == 0 && (choices[20] == 1 || choices[31] == 1)) { //60번 출력
            choice1.setVisibility(View.VISIBLE);
            c11.setText(getString(R.string.click));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    prev[0] = 15;
                    choice1.setVisibility(View.INVISIBLE);
                    mainText.setText(getString(R.string.f1_60));
                    player.setF1_choices(60); //choices[60] = 1;
                    f1_152();
                }
            });
        } else if(player.getF1_choices(60) || (player.getF1_choices(30) || player.getF1_choices(20))){
            //else if (choices[60] == 1 || (choices[30] == 1 || choices[20] == 1)) { //61번 출력
            choice1.setVisibility(View.VISIBLE);
            c11.setText(getString(R.string.click));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    prev[0] = 15;
                    choice1.setVisibility(View.INVISIBLE);
                    mainText.setText(getString(R.string.f1_61));
                    player.setF1_choices(61); //choices[61] = 1;
                    f1_152();
                }
            });
        }else {
            prev[0] = 15;
            f1_152();
        }

    }
    public void f1_152(){
        {
            allInvisible();
            player.setF1_choices(15); //choices[15] = 1;
            choice2 = findViewById(R.id.choice_no2); choice2.setVisibility(View.VISIBLE);
            c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);

            c21.setText(getString(R.string.f1_15c1));
            c22.setText(getString(R.string.f1_15c2));
            c21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    if (player.getF1_choices(45)){//else if (choices[45] == 1) {
                        f1_47();
                    } else if(player.getF1_choices(60) && !player.getF1_choices(22)){// else if (choices[60] == 1 && choices[22] == 0) {
                        f1_22();
                    } else if(player.getF1_choices(61) && !player.getF1_choices(23)){//if (choices[61] == 1 && choices[23] == 0) {
                        f1_23();
                    } else if(!player.getF1_choices(60) && !player.getF1_choices(61) && player.isInventory(4) && !player.getF1_choices(24)){
                        //else if (choices[60] == 0 && choices[61] == 0 && itemlist[4] == 1 && choices[24] == 0) {
                        f1_24();
                    } else if(!player.getF1_choices(60) && !player.getF1_choices(61) && !player.isInventory(4) && !player.getF1_choices(25)){
                        //else if (choices[60] == 0 && choices[61] == 0 && itemlist[4] == 0 && choices[25] == 0) {
                        f1_25();
                    } else if(player.getF1_choices(24) || player.getF1_choices(25)){
                        //else if (choices[24] == 1 || choices[25] == 1) {
                        f1_62();
                    } else {
                        f1_100();
                    }
                }
            });
            c22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    if(player.getF1_choices(57) || player.getF1_choices(19)){//if (choices[57] == 1 || choices[19] == 1) {
                        f1_9();
                    } else if(player.getF1_choices(2) && !player.getF1_choices(5) && !player.isInventory(1)){//else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 0) {
                        f1_19();
                    }  else if(player.getF1_choices(2) && !player.getF1_choices(5) && player.isInventory(1)){//else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 1) {
                        f1_20();
                    } else {
                        f1_9();
                    }
                }
            });
        }
    }
    public void f1_16(){
        allInvisible();
        //choices[16] = 1;
        player.setF1_choices(16); prev[1] = 16;
        choice2 = findViewById(R.id.choice_no2); choice2.setVisibility(View.VISIBLE);
        c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        character.setText(" ");
        mainText.setText(getString(R.string.f1_16));
        player.addInventory(9); //itemlist[9] = 1; //바늘 item
        Toast toast = Toast.makeText(getApplicationContext(), "item : 바늘을 얻었다", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
        toast.show();
        c21.setText(getString(R.string.f1_16c1));
        c22.setText(getString(R.string.f1_16c2));

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                prev[0] = 16;
                f1_15();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                prev[0] = 16;
                if(player.getF1_choices(57) || player.getF1_choices(19)){//if (choices[57] == 1 || choices[19] == 1) {
                    f1_9();
                }  else if(player.getF1_choices(2) && !player.getF1_choices(5) && !player.isInventory(1)){//else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 0) {
                    f1_19();
                }  else if(player.getF1_choices(2) && !player.getF1_choices(5) && player.isInventory(1)){//else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 1) {
                    f1_20();
                } else {
                    f1_9();
                }
            }
        });
    }
    public void f1_17(){
        allInvisible();
        prev[1] = 17;
        choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        character.setText(getString(R.string.doll_bear));

        //5859 부터 시작할지 17_1 부터 시작할지 결정
        if(player.getF1_choices(18)) {//else if(choices[18] == 1){
            player.setF1_choices(59); //choices[59] = 1;
            mainText.setText(getString(R.string.f1_5859));
            c11.setText(getString(R.string.click));
        } else if(!player.getF1_choices(18)){
            player.setF1_choices(17); //choices[17] = 1;
            mainText.setText(getString(R.string.f1_17_1));
            c11.setText(getString(R.string.click));
        }

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f1_5859))) {
                    player.setF1_choices(17); //choices[17] = 1;
                    mainText.setText(getString(R.string.f1_17_1));
                } else if(mainText.getText().toString().equals(getString(R.string.f1_17_1))) {
                    mainText.setText(getString(R.string.f1_17_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f1_17_2))){
                    mainText.setText(getString(R.string.f1_17_3));
                    c11.setText(getString(R.string.f1_17c1));
                } else {
                    choice1.setVisibility(View.INVISIBLE);
                    prev[0] = 17;
                    f1_11();
                }
            }
        });

    }
    public void f1_55(){
        allInvisible();
        //choices[55] = 1;
        player.setF1_choices(55); prev[1] = 55;
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1);
        choice2 = findViewById(R.id.choice_no2);
        c21 = findViewById(R.id.choice2_1);
        c22 = findViewById(R.id.choice2_2);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        character.setText(getString(R.string.doll_bear));
        if(!mainText.getText().toString().equals(getString(R.string.f1_55_3))) {
            //처음 55에 진입 했을 때 5859할건지 55_1 출력할건지 결정
            if (player.getF1_choices(18)) {//else if(choices[18] == 1){
                player.setF1_choices(58); //choices[59] = 1;
                mainText.setText(getString(R.string.f1_5859));
                c11.setText(getString(R.string.click));
                choice1.setVisibility(View.VISIBLE);
            } else {
                player.setF1_choices(55); //choices[17] = 1;
                mainText.setText(getString(R.string.f1_55_1));
                c11.setText(getString(R.string.click));
                choice1.setVisibility(View.VISIBLE);
            }
        }
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f1_5859))) {
                    player.setF1_choices(55); //choices[55] = 1;
                    mainText.setText(getString(R.string.f1_55_1));
                } else if(mainText.getText().toString().equals(getString(R.string.f1_55_1))) {
                    mainText.setText(getString(R.string.f1_55_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f1_55_2))){
                    mainText.setText(getString(R.string.f1_55_3));
                    choice1.setVisibility(View.INVISIBLE);
                    f1_55();
                }
            }
        });

        //55_3 출력 후 선택 1개인지 2개인지 조건 결정
        if(mainText.getText().toString().equals(getString(R.string.f1_55_3))) {
            if(!player.isInventory(5)){ //if(itemlist[5] == 0){
                choice2 = findViewById(R.id.choice_no1);
                c21 = findViewById(R.id.choice1_1);
                c22 = findViewById(R.id.choice2_2);
                c21.setText(getString(R.string.f1_55c1));
                c22.setText(getString(R.string.f1_55c2));
                choice2.setVisibility(View.VISIBLE);
            }
            else {
                choice2 = findViewById(R.id.choice_no2);
                c21 = findViewById(R.id.choice2_1);
                c22 = findViewById(R.id.choice2_2);
                c21.setText(getString(R.string.f1_55c1));
                c22.setText(getString(R.string.f1_55c2));
                choice2.setVisibility(View.VISIBLE);
            }
            c21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    prev[0] = 55;
                    choice2.setVisibility(View.INVISIBLE);
                    if(player.getF1_choices(57) || player.getF1_choices(19)){//if(choices[57] == 1 || choices[19] == 1){
                        f1_11();
                    }  else if(player.getF1_choices(2) && !player.getF1_choices(5) && !player.isInventory(1)){ //else if(choices[2] == 1 && choices[5] == 0 && itemlist[1] == 0){
                        f1_19();
                    }  else if(player.getF1_choices(2) && !player.getF1_choices(5) && player.isInventory(1)){ //else if(choices[2] == 1 && choices[5] == 0 && itemlist[1] == 1){
                        f1_20();
                    }else{
                        f1_11();
                    }
                }
            });
            c22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    prev[0] = 55;
                    choice2.setVisibility(View.INVISIBLE);
                    f1_50();
                }
            });
        }

    }
    public void f1_18(){
        allInvisible();
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);

        character.setText(getString(R.string.doll_bear));

        //18_1에 대한 것은 아래 else문에, 여기는 18_3이나 57_3을 출력한 뒤에 다음 분기에 대한 선택지 고르는 if문ㄴ
        if(mainText.getText().toString().equals(getString((R.string.f1_18_3)))
                || mainText.getText().toString().equals(getString((R.string.f1_57_3)))){
            if(player.getF1_choices(57)){//if(choices[57] == 1){
                choice2 = findViewById(R.id.choice_no2);
                choice2.setVisibility(View.VISIBLE);
                c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
                c21.setText(getString(R.string.f1_18c1)); c22.setText(getString(R.string.f1_18c2));
                c21.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        prev[0] = 18;
                        choice2.setVisibility(View.INVISIBLE);
                        f1_28();
                    }
                });
                c22.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        prev[0] = 18;
                        choice2.setVisibility(View.INVISIBLE);
                        f1_27();
                    }
                });
            } else{
                choice1.setVisibility(View.VISIBLE);
                c11.setText(getString(R.string.f1_18c1));
                c11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        prev[0] = 18;
                        choice1.setVisibility(View.INVISIBLE);
                        f1_28();
                    }
                });
            }
        }else {
            player.setF1_choices(18); prev[1] = 18;
            mainText.setText(getString(R.string.f1_18_1));
            choice1.setVisibility(View.VISIBLE);
            c11.setText(getString(R.string.click));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mainText.getText().toString().equals(getString(R.string.f1_18_1))) {
                        mainText.setText(getString(R.string.f1_18_2));
                    }else if(mainText.getText().toString().equals(getString(R.string.f1_18_2))) {
                        mainText.setText(getString(R.string.f1_18_3));
                        choice1.setVisibility(View.INVISIBLE);
                        //18_3 뒤에 57을 출력할것인지 아니면 바로 선택지를 출력할 것인지에 대한 조건문
                        if (player.getF1_choices(2) && !player.getF1_choices(5) && !player.getF1_choices(19)) {//if(choices[2] == 1 && choices[5] == 0 && choices[19] == 0){
                            f1_57();
                        } else {
                            f1_18();
                        }
                    }
                }
            });

        }

    }
    public void f1_57(){
        allInvisible();
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);

        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        character.setText(" ");

        //choices[57] = 1;
        player.setF1_choices(57); prev[1] = 57;
        c11.setText(getString(R.string.click));

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(getString(R.string.f1_18_3))) {
                    mainText.setText(getString(R.string.f1_57_1));
                } else if (mainText.getText().toString().equals(getString(R.string.f1_57_1))) {
                    character.setText(getString(R.string.doll_dog));
                    mainText.setText(getString(R.string.f1_57_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f1_57_2))) {
                    mainText.setText(getString(R.string.f1_57_3));

                    choice1.setVisibility(View.INVISIBLE);
                    player.addInventory(4); //itemlist[4] = 1;
                    Toast toast = Toast.makeText(getApplicationContext(), "item : 하녀복을 얻었다", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
                    toast.show();

                    prev[0] = 57;
                    f1_18();
                }
            }
        });

    }
    public void f1_56(){
        allInvisible();
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);

        //choices[56] = 1;
        player.setF1_choices(56); prev[1] = 56;
        character.setText(getString(R.string.doll_dog));
        mainText.setText(getString(R.string.f1_18_1));
        choice1.setVisibility(View.VISIBLE);
        c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f1_18_1))) {
                    mainText.setText(getString(R.string.f1_18_2));
                }if(mainText.getText().toString().equals(getString(R.string.f1_18_2))) {
                    character.setText(" ");
                    mainText.setText(getString(R.string.f1_18_3));
                    c11.setText(getString(R.string.f1_18c1));
                } else {
                    choice1.setVisibility(View.INVISIBLE);
                    prev[0] = 56;
                    f1_48();
                }
            }
        });

    }
    public void f1_19(){
        allInvisible();
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);

        player.setF1_choices(19); prev[1] = 19;
        mainText.setText(getString(R.string.f1_19_1));
        choice1.setVisibility(View.VISIBLE);
        c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f1_19_1))) {
                    character.setText(getString(R.string.doll_dog));
                    mainText.setText(getString(R.string.f1_19_2));

                    //어떤 공주냐에 따라 타개책이 다름. (수정공주의 경우 이전에 회피 선택지를 이미 주워졌기에 여기서는 선택x)
                    if(player.isInventory(0)){//if(itemlist[0] == 1) {
                        c11.setText(getString(R.string.f1_19c1));
                    }
                    else if(player.isInventory(2)){ //else if(itemlist[2] == 1){
                        c11.setText(getString(R.string.f1_19c2));
                    }
                    else if(player.isInventory(1)){//else if(itemlist[1] == 1){
                        c11.setText(getString(R.string.click));
                    }
                } else {
                    prev[0] = 19;
                    choice1.setVisibility(View.INVISIBLE);
                    if(player.isInventory(0)){//if(itemlist[0] == 1){
                        f1_30();
                    }else if(player.isInventory(2)){//else if (itemlist[2] == 1){
                        Random rd = new Random();
                        int sf = rd.nextInt(2);
                        String stsf = String.valueOf(sf); //확인용2222
                        c11.setText(stsf); //호랑이 공주 난수 잘 나오는지 확인용
                        if(sf == 0){ //호랑이공주 위협 성공
                            f1_31();
                        }else{ //위협 실패
                            f1_22();
                        }
                    }else if( player.isInventory(1)){ //else if(itemlist[1] == 1){
                        f1_22();
                    }
                }
            }
        });

    }
    public void f1_20(){
        allInvisible();
        //choices[20] = 1;
        player.setF1_choices(20); prev[1] = 20;
        choice2 = findViewById(R.id.choice_no2);
        c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        choice2.setVisibility(View.VISIBLE);
        character.setText(" ");
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        mainText.setText(getString(R.string.f1_20));
        c21.setText(getString(R.string.f1_20c1)); c22.setText(getString(R.string.f1_20c2));
        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev[0] = 20;
                choice2.setVisibility(View.INVISIBLE);
                f1_19();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev[0] = 20;
                choice2.setVisibility(View.INVISIBLE);
                f1_65();
            }
        });
    }

    public void f1_21(){
        allInvisible();
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        choice1.setVisibility(View.VISIBLE);

        character.setText(" ");
        //choices[21] = 1;
        player.setF1_choices(21); prev[1] = 21;
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character); character.setText(" ");
        mainText.setText(getString(R.string.f1_21_1));
        b42 = findViewById(R.id.b42); player.damage(); b42.setText(String.valueOf(player.getHeart()));

        //2까지 출력 후. 밧줄이나 육감의 티아라 아이템 여부에 따라서 선택지를 열음.
        if (player.isInventory(9) || player.isInventory(2)) {//if(itemlist[9] == 1 || itemlist[2] == 1){
            //1. 밧줄과 육감의 티아라가 동시에 있는 경우
            if(player.isInventory(9) && player.isInventory(2)){ //if(itemlist[9] == 1 && itemlist[2] == 1){
                choice3 = findViewById(R.id.choice_no3);
                c31 = findViewById(R.id.choice3_1); c32 = findViewById(R.id.choice3_2); c33 = findViewById(R.id.choice3_3);
                c31.setText(getString(R.string.f1_21c1_2));
                c32.setText(getString(R.string.f1_21c2));
                c33.setText(getString(R.string.f1_21c3));
            } else {
                //2. 밧줄과 티아라 중 1개 만 있는 경우
                choice3 = findViewById(R.id.choice_no2);
                c31 = findViewById(R.id.choice2_1); c32 = findViewById(R.id.choice2_2); c33 = findViewById(R.id.choice3_3);

                if(player.isInventory(9)){ //밧줄이 있는 경우
                    c31.setText(getString(R.string.f1_21c1_2));
                    c32.setText(getString(R.string.f1_21c2));
                } else { //티아라가 있는 경우
                    c31.setText(getString(R.string.f1_21c1_2));
                    c32.setText(getString(R.string.f1_21c3));
                }
            }
        } else {
            //3. 아이템 둘 다 없는 경우 1개짜리 선택지에 없음. 뜸.
            choice3 = findViewById(R.id.choice_no1);
            c31 = findViewById(R.id.choice1_1);
            c31.setText(getString(R.string.f1_21c1_1));
        }

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f1_21_1))) {
                    mainText.setText(getString(R.string.f1_21_2));
                    choice1.setVisibility(View.INVISIBLE);
                    choice3.setVisibility(View.VISIBLE);
                }
            }
        });

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev[0] = 21;
                choice3.setVisibility(View.INVISIBLE);
                f1_12();
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //도망
                mainText.setText("도망엔딩");
                choice3.setVisibility(View.INVISIBLE);
            }
        });
        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //도망
                mainText.setText("도망엔딩");
                choice3.setVisibility(View.INVISIBLE);
            }
        });


    }

    public void f1_22(){
        allInvisible();
        //choices[22] = 1;
        player.setF1_choices(22);
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        character.setText(" ");
        mainText.setText(getString(R.string.f1_22_1));
        c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText(getString(R.string.f1_22_2)); //베드엔딩
            }
        });
    }
    public void f1_23(){
        allInvisible();
        //choices[23] = 1;
        player.setF1_choices(23);
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        character.setText(getString(R.string.doll_guard));
        mainText.setText(getString(R.string.f1_23_1));
        c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText(getString(R.string.f1_23_2)); //베드엔딩
            }
        });
    }

    public void f1_24(){
        allInvisible();
        //choices[24] = 1;
        player.setF1_choices(24); prev[1] = 24;
        choice3 = findViewById(R.id.choice_no3);
        c31 = findViewById(R.id.choice3_1); c32 = findViewById(R.id.choice3_2); c33 = findViewById(R.id.choice3_3);
        choice3.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        character.setText(getString(R.string.doll_guard));
        mainText.setText(getString(R.string.f1_24));
        c31.setText(getString(R.string.f1_24c1)); c32.setText(getString(R.string.f1_24c2)); c33.setText(getString(R.string.f1_24c3));
        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev[0] = 24;
                choice3.setVisibility(View.INVISIBLE);
                f1_38();
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev[0] = 24;
                choice3.setVisibility(View.INVISIBLE);
                f1_39();
            }
        });
        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev[0] = 24;
                choice3.setVisibility(View.INVISIBLE);
                f1_64();
            }
        });
    }

    public void f1_25(){
        allInvisible();
        //choices[25] = 1;
        player.setF1_choices(25); prev[1] = 25;
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        choice3 = findViewById(R.id.choice_no3);
        c31 = findViewById(R.id.choice3_1); c32 = findViewById(R.id.choice3_2); c33 = findViewById(R.id.choice3_3);

        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        character.setText(getString(R.string.doll_guard));
        mainText.setText(getString(R.string.f1_25_1));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                choice3.setVisibility(View.VISIBLE);
                mainText.setText(getString(R.string.f1_25_2));
            }
        });

        c31.setText(getString(R.string.f1_25c1)); c32.setText(getString(R.string.f1_25c2)); c33.setText(getString(R.string.f1_25c3));
        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev[0] = 25;
                choice3.setVisibility(View.INVISIBLE);
                f1_41();
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev[0] = 25;
                choice3.setVisibility(View.INVISIBLE);
                f1_39();
            }
        });
        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev[0] = 25;
                choice3.setVisibility(View.INVISIBLE);
                f1_64();
            }
        });
    }
    public void f1_26(){
        allInvisible();
        player.setF1_choices(26);
        //choices[26] = 1;
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        character.setText(getString(R.string.doll_guard));
        mainText.setText(getString(R.string.f1_26));
        player.removeInventory(12); //itemlist[12] = 0;
        Toast toast = Toast.makeText(getApplicationContext(), "item : 허가증이 사라졌다.", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
        toast.show();
        c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("도망 엔딩"); //도망 엔딩
                choice1.setVisibility(View.INVISIBLE);
            }
        });
    }
    public void f1_27(){
        allInvisible();
        //choices[27] = 1;
        player.setF1_choices(27); prev[1] = 27;
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        character.setText(" ");
        mainText.setText(getString(R.string.f1_27));
        c11.setText(getString(R.string.f1_27c1));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev[0] = 27;
                choice1.setVisibility(View.INVISIBLE);
                f1_28();
            }
        });
    }

    public void f1_28(){
        allInvisible();
        //choices[28] = 1;
        player.setF1_choices(28); prev[1] = 28;
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        character.setText(" ");
        mainText.setText(getString(R.string.f1_28));
        c11.setText(getString(R.string.f1_28c1));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev[0] = 28;
                choice1.setVisibility(View.INVISIBLE);
                f1_9();
            }
        });
    }
    public void f1_29() {
        allInvisible();
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1);
        choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        player.setF1_choices(29); //choices[29] = 1;
        character.setText(" ");
        mainText.setText(getString(R.string.f1_29_1));
        choice1.setVisibility(View.VISIBLE);
        c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(getString(R.string.f1_29_1))) {
                    character.setText(getString(R.string.doll_bear));
                    mainText.setText(getString(R.string.f1_29_2));
                } else if (mainText.getText().toString().equals(getString(R.string.f1_29_2))) {
                    choice1.setVisibility(View.INVISIBLE);
                    character.setText(" ");
                    mainText.setText(getString(R.string.f1_29_3)); //베드엔딩
                }

            }
        });

    }

    public void f1_30(){
        allInvisible();
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);

        //choices[30] = 1;
        player.setF1_choices(30); prev[1] = 30;
        character.setText(getString(R.string.doll_dog));
        mainText.setText(getString(R.string.f1_30_1));
        c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f1_30_1))) {
                    character.setText(" ");
                    mainText.setText(getString(R.string.f1_30_2));
                } else {
                    choice1.setVisibility(View.INVISIBLE);
                    prev[0] = 30;
                    f1_9();
                }
            }
        });

    }
    public void f1_31(){
        allInvisible();
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);

        //choices[31] = 1;
        player.setF1_choices(31); prev[1] = 31;
        character.setText(getString(R.string.doll_dog));
        mainText.setText(getString(R.string.f1_31_1));
        c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f1_31_1))) {
                    character.setText(" ");
                    mainText.setText(getString(R.string.f1_31_2));
                    player.addInventory(4); //itemlist[4] = 1;
                    Toast toast = Toast.makeText(getApplicationContext(), "item : 하녀 복을 얻었다", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
                    toast.show();
                } else if(mainText.getText().toString().equals(getString(R.string.f1_31_2))) {
                    choice1.setVisibility(View.INVISIBLE);
                    prev[0] = 31;
                    f1_9();
                }
            }
        });

    }
    public void f1_32(){
        allInvisible();
        //choices[32] = 1;
        player.setF1_choices(32);
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        character.setText(" ");
        mainText.setText(getString(R.string.f1_32));
        c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("도망 엔딩"); //도망 엔딩
            }
        });
    }
    public void f1_33() {
        allInvisible();
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1);
        choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

       //choices[33] = 1;
       player.setF1_choices(33); prev[1] = 33;
       character.setText(getString(R.string.doll_bear));
       mainText.setText(getString(R.string.f1_33_1));
       c11.setText(getString(R.string.click));
       c11.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(mainText.getText().toString().equals(getString(R.string.f1_33_1))){
                   character.setText(" ");
                   mainText.setText(getString(R.string.f1_33_2));
               } else if(mainText.getText().toString().equals(getString(R.string.f1_33_2))){
                   character.setText(getString(R.string.doll_bear));
                   mainText.setText(getString(R.string.f1_33_3));
                   player.removeInventory(5); //itemlist[5] = 0;
                   Toast toast = Toast.makeText(getApplicationContext(), "item : 우유가 사라졌다.", Toast.LENGTH_LONG);
                   toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
                   toast.show();
                   c11.setText(getString(R.string.f1_33c1));
               } else if(mainText.getText().toString().equals(getString(R.string.f1_33_3))){
                   choice1.setVisibility(View.INVISIBLE);
                   prev[0] = 33;
                   f1_11();
               }

           }
       });

    }
    public void f1_34(){
        allInvisible();
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        player.addInventory(5);
        if(mainText.getText().toString().equals(getString(R.string.f1_34_3))) {
            if (player.isInventory(5)) { //if(itemlist[5] == 1) {
                choice2 = findViewById(R.id.choice_no2);
                c21 = findViewById(R.id.choice2_1);
                c22 = findViewById(R.id.choice2_2);
                choice1.setVisibility(View.INVISIBLE);
                choice2.setVisibility(View.VISIBLE);
                c21.setText(getString(R.string.f1_34c1));
                c22.setText(getString(R.string.f1_34c2));
            } else {
                choice2 = findViewById(R.id.choice_no1);
                c21 = findViewById(R.id.choice1_1);
                c22 = findViewById(R.id.choice2_2);
                c21.setText(getString(R.string.f1_34c1));
            }
            choice2.setVisibility(View.VISIBLE);
            c21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    prev[0] = 34;
                    f1_11();
                }
            });
            c22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    prev[0] = 34;
                    f1_35();
                }
            });
        } else {
            player.setF1_choices(34);
            prev[1] = 34;
            character.setText(getString(R.string.doll_bear));
            mainText.setText(getString(R.string.f1_34_1));
            choice1.setVisibility(View.VISIBLE);

            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mainText.getText().toString().equals(getString(R.string.f1_34_1))) {
                        mainText.setText(getString(R.string.f1_34_2));
                    } else if (mainText.getText().toString().equals(getString(R.string.f1_34_2))) {
                        mainText.setText(getString(R.string.f1_34_3));
                        player.removeInventory(7); //itemlist[7] = 0;
                        Toast toast = Toast.makeText(getApplicationContext(), "item : 후추가 사라졌다.", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -420);
                        toast.show();

                        choice1.setVisibility(View.INVISIBLE);
                        f1_34();
                    }
                }
            });
        }

    }
    public void f1_35(){
        allInvisible();
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        b42 = findViewById(R.id.b42);

        //choices[35] = 1;
        player.setF1_choices(35); prev[1] = 35;
        character.setText(getString(R.string.doll_bear));
        mainText.setText(getString(R.string.f1_35_1));
        c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f1_35_1))) {
                    mainText.setText(getString(R.string.f1_35_2));
                    player.removeInventory(5);
                    player.addInventory(11); //itemlist[5] = 0; itemlist[11] = 1;
                    Toast toast = Toast.makeText(getApplicationContext(), "item : 우유가 사라졌다\nitem : 맛있는 스튜를 얻었다", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
                    toast.show();
                } else if(mainText.getText().toString().equals(getString(R.string.f1_35_2))) {
                    mainText.setText(getString(R.string.f1_35_3));
                    player.heal(); b42.setText(String.valueOf(player.getHeart()));
                    Toast toast = Toast.makeText(getApplicationContext(), " : 체력을 +1 회복했다", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
                    toast.show();
                    c11.setText(getString(R.string.f1_35c1));
                } else {
                    choice1.setVisibility(View.INVISIBLE);
                    prev[0] = 35;
                    f1_11();
                }
            }
        });

    }
    public void f1_36(){
        allInvisible();
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);

        //choices[36] = 1;
        player.setF1_choices(36); prev[1] = 36;
        character.setText(getString(R.string.doll_bear));
        mainText.setText(getString(R.string.f1_36_1));
        c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f1_36_1))) {
                    mainText.setText(getString(R.string.f1_36_2));
                    player.addInventory(11); //itemlist[5] = 0; itemlist[11] = 1;
                    player.removeInventory(5);
                    Toast toast = Toast.makeText(getApplicationContext(), "item : 우유가 사라졌다\nitem : 맛있는 스튜를 얻었다", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
                    toast.show();
                } else if(mainText.getText().toString().equals(getString(R.string.f1_36_2))) {
                    mainText.setText(getString(R.string.f1_35_3));
                    c11.setText(getString(R.string.f1_36c1));
                    player.heal(); b42.setText(String.valueOf(player.getHeart()));
                    Toast toast = Toast.makeText(getApplicationContext(), " : 체력을 +1 회복했다", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
                    toast.show();
                }else {
                    choice1.setVisibility(View.INVISIBLE);
                    prev[0] = 36;
                    f1_11();
                }
            }
        });
    }
    public void f1_37(){
        allInvisible();
        //choices[37] = 1;
        player.setF1_choices(37); prev[1] = 37;
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        character.setText(getString(R.string.doll_bear));
        mainText.setText(getString(R.string.f1_37));
        c11.setText(getString(R.string.f1_37c1));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                prev[0] = 37;
                f1_11();
            }
        });
    }
    public void f1_38(){
        allInvisible();
        //choices[38] = 1;
        player.setF1_choices(38); prev[1] = 38;
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        character.setText(getString(R.string.doll_guard));
        mainText.setText(getString(R.string.f1_38));

        c41 = findViewById(R.id.choice4_1);  c42 = findViewById(R.id.choice4_2);
        c43 = findViewById(R.id.choice4_3);  c44 = findViewById(R.id.choice4_4);
        c42.setText("_"); c43.setText("_"); c44.setText("_");

        int cook = 0, pill = 0, maid = 0, gold = 0, sumC = 0;
        if((player.getF1_choices(17) || player.getF1_choices(33) || player.getF1_choices(34) || player.getF1_choices(55))
            && !player.getF1_choices(36) && !player.getF1_choices(35)){
        //if((choices[17] == 1 || choices[33] == 1 || choices[34] == 1 || choices[55] == 1) && choices[36] == 0 && choices[35] == 0){
            cook = 1;
        }
        if(player.isInventory(0)){//if(itemlist[0] == 1){
            gold = 1;
        }
        if((player.getF2_choices(10) || player.getF2_choices(22)) && !player.getF2_choices(25) && !player.getF2_choices(17)){
            pill = 1;
        }
        //player_ 지하 1층 다녀온 선택지 구현 후 시종장 조건 구현하기.
        /*//maid와 pill 확인용 임시 조건 조건 정해지면 수정예정.
        if(itemlist[3] == 1){
            maid = 1;
        }
        if(itemlist[4] == 1){
            pill = 1;
        }*/
        //시종장의 경우 choices를 어캐할 건지 고민 후 구현,,
        //약사의 경우 2층 스크립터 완료 후 구현.

        sumC = cook + pill + maid + gold;
        switch (sumC){
            case 0: choice4 = findViewById(R.id.choice_no1);
                     c41 = findViewById(R.id.choice1_1);
                     break;
            case 1: choice4 = findViewById(R.id.choice_no2);
                    c41 = findViewById(R.id.choice2_1);  c42 = findViewById(R.id.choice2_2);
                    break;
            case 2: choice4 = findViewById(R.id.choice_no3);
                    c41 = findViewById(R.id.choice3_1);  c42 = findViewById(R.id.choice3_2);
                    c43 = findViewById(R.id.choice3_3);
                    break;
            case 3: choice4 = findViewById(R.id.choice_no4);
                    c41 = findViewById(R.id.choice4_1);  c42 = findViewById(R.id.choice4_2);
                    c43 = findViewById(R.id.choice4_3);  c44 = findViewById(R.id.choice4_4);
                    break;
            case 4 : choice5 = findViewById(R.id.choice_no5); choice5.setVisibility(View.VISIBLE);
                    c51 = findViewById(R.id.choice5_1);  c52 = findViewById(R.id.choice5_2);
                    c53 = findViewById(R.id.choice5_3);  c54 = findViewById(R.id.choice5_4);
                    c55 = findViewById(R.id.choice5_5);
                    break;
        }
        if(sumC == 4){
            c51.setText(getString(R.string.f1_38c1)); c52.setText(getString(R.string.f1_38c2));
            c53.setText(getString(R.string.f1_38c3)); c54.setText(getString(R.string.f1_38c4));
            c55.setText(getString(R.string.f1_38c5));
        }
        else if(sumC == 3){
            if(gold == 0){
                c42.setText(getString(R.string.f1_38c3)); c43.setText(getString(R.string.f1_38c4));
                c44.setText(getString(R.string.f1_38c5));
            }else if(maid == 0){
                c42.setText(getString(R.string.f1_38c2)); c43.setText(getString(R.string.f1_38c4));
                c44.setText(getString(R.string.f1_38c5));
            } else if(pill == 0){
                c42.setText(getString(R.string.f1_38c2)); c43.setText(getString(R.string.f1_38c3));
                c44.setText(getString(R.string.f1_38c5));
            } else if(cook == 0){
                c42.setText(getString(R.string.f1_38c2)); c43.setText(getString(R.string.f1_38c3));
                c44.setText(getString(R.string.f1_38c4));
            }
        } else if(sumC == 2){
            if(gold == 0 && maid == 0){
                c42.setText(getString(R.string.f1_38c4)); c43.setText(getString(R.string.f1_38c5));
            } else if(gold == 0 && pill == 0){
                c42.setText(getString(R.string.f1_38c3)); c43.setText(getString(R.string.f1_38c5));
            } else if(gold == 0 && cook == 0){
                c42.setText(getString(R.string.f1_38c3)); c43.setText(getString(R.string.f1_38c4));
            } else if(maid == 0 && pill == 0){
                c42.setText(getString(R.string.f1_38c2)); c43.setText(getString(R.string.f1_38c5));
            } else if(maid == 0 && cook == 0){
                c42.setText(getString(R.string.f1_38c2)); c43.setText(getString(R.string.f1_38c4));
            } else if(pill == 0 && cook == 0){
                c42.setText(getString(R.string.f1_38c2)); c43.setText(getString(R.string.f1_38c3));
            } else{
                c42.setText("error"); c43.setText("error");
            }
        } else if(sumC == 1){
            if(gold == 1){
                c42.setText(getString(R.string.f1_38c2));
            }else if(maid == 1){
                c42.setText(getString(R.string.f1_38c3));
            } else if(pill == 1){
                c42.setText(getString(R.string.f1_38c4));
            } else if(cook == 1){
                c42.setText(getString(R.string.f1_38c5));
            }
        }

        if(sumC != 4) {
            choice4.setVisibility(View.VISIBLE);
            c41.setText(getString(R.string.f1_38c1));
            c41.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice4.setVisibility(View.INVISIBLE);
                    prev[0] = 38;
                    f1_45();
                }
            });
            c42.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice4.setVisibility(View.INVISIBLE);
                    f1_38go(c42.getText().toString());
                }
            });
            c43.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice4.setVisibility(View.INVISIBLE);
                    f1_38go(c43.getText().toString());
                }
            });
            c44.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice4.setVisibility(View.INVISIBLE);
                    f1_38go(c44.getText().toString());
                }
            });
        } else {
            c51.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice5.setVisibility(View.INVISIBLE);
                    prev[0] = 38;
                    f1_45();
                }
            });
            c52.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice5.setVisibility(View.INVISIBLE);
                    f1_38go(c52.getText().toString());
                }
            });
            c53.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice5.setVisibility(View.INVISIBLE);
                    f1_38go(c53.getText().toString());
                }
            });
            c54.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice5.setVisibility(View.INVISIBLE);
                    f1_38go(c54.getText().toString());
                }
            });
            c55.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice5.setVisibility(View.INVISIBLE);
                    f1_38go(c55.getText().toString());
                }
            });
        }
    }
   public void f1_38go(String txt){
        //확인용 mainText
       mainText = findViewById(R.id.main_text);
        if(txt.equals(getString(R.string.f1_38c2))){
            //mainText.setText("gold");
            prev[0] = 38;
            f1_32();
        } else  if(txt.equals(getString(R.string.f1_38c3))){
            //mainText.setText("maid");
            prev[0] = 38;
            f1_44();
        } else  if(txt.equals(getString(R.string.f1_38c4))){
            //mainText.setText("pill");
            prev[0] = 38;
            f1_43();
        } else  if(txt.equals(getString(R.string.f1_38c5))){
            //mainText.setText("cook");
            prev[0] = 38;
            f1_42();
        } else {
            mainText.setText("error");
        }
   }
   public void f1_39(){
       allInvisible();
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        choice2 = findViewById(R.id.choice_no2); c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        c11.setText(getString(R.string.click));
        player.setF1_choices(39); prev[1] = 39;
        choice1.setVisibility(View.VISIBLE);
        character.setText(getString(R.string.doll_guard));
        mainText.setText(getString(R.string.f1_39_1));

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f1_39_1))) {
                    mainText.setText(getString(R.string.f1_39_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f1_39_2))){
                    mainText.setText(getString(R.string.f1_39_3));
                } else if(mainText.getText().toString().equals(getString(R.string.f1_39_3))){
                    mainText.setText(getString(R.string.f1_39_4));
                } else if(mainText.getText().toString().equals(getString(R.string.f1_39_4))){
                    character.setText(" ");
                    mainText.setText(getString(R.string.f1_39_5));
                    choice2.setVisibility(View.VISIBLE);
                    choice1.setVisibility(View.INVISIBLE);
                    c21.setText(getString(R.string.f1_39c1)); c22.setText(getString(R.string.f1_39c2));
                }
            }
        });
        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev[0] = 39;
                choice2.setVisibility(View.INVISIBLE);
                if(player.getF1_choices(24) && !player.getF1_choices(25)){//if(choices[24] == 1 && choices[25] == 0){
                    f1_38();
                }else if(!player.getF1_choices(24) && player.getF1_choices(25)){//else if(choices[24] == 0 && choices[25] == 1){
                    f1_41();
                }
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //수정 별도 확인 필요.
                prev[0] = 39;
                choice2.setVisibility(View.INVISIBLE);
                f1_64();
                /*if(choices[57] == 1 || choices[19] == 1){
                    f1_64();
                }else if(choices[2] == 1 && choices[5] == 0 && itemlist[1] == 0){
                    f1_19();
                }else if(choices[2] == 1 && choices[5] == 0 && itemlist[1] == 1){
                    f1_20();
                }else{
                    f1_64();
                }*/
            }
        });
   }
   public void f1_40(){
       allInvisible();
        //choices[40] = 1;
        player.setF1_choices(40); prev[1] = 40;
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        character.setText(getString(R.string.doll_guard));
        mainText.setText(getString(R.string.f1_40));
        choice2 = findViewById(R.id.choice_no2); choice2.setVisibility(View.VISIBLE);
        c21 = findViewById(R.id.choice2_1); c22 =findViewById(R.id.choice2_2);
        c21.setText(getString(R.string.f1_40c1)); c21.setText(getString(R.string.f1_40c2));
       c21.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               choice2.setVisibility(View.INVISIBLE);
               prev[0] = 40;
               f1_38();
           }
       });
       c21.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               choice2.setVisibility(View.INVISIBLE);
               prev[0] = 40;
               f1_64();
           }
       });
   }
   public void f1_41(){
       allInvisible();
       choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
       mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);

       character.setText(getString(R.string.doll_guard));
       if(mainText.getText().toString().equals(getString(R.string.f1_41_2))) {
           c22 = findViewById(R.id.choice2_2);
           if(player.isInventory(12)) {
               c21 = findViewById(R.id.choice2_1);
               choice1.setVisibility(View.INVISIBLE);
               choice2 = findViewById(R.id.choice_no2);
               choice2.setVisibility(View.VISIBLE);
               c21.setText(getString(R.string.f1_41c1));
               c22.setText(getString(R.string.f1_41c2));
           }else{
               c21 = findViewById(R.id.choice1_1);
               choice2 = findViewById(R.id.choice_no1);
               c21.setText(getString(R.string.f1_41c1));
           }
           c21.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   choice2.setVisibility(View.INVISIBLE);
                   prev[0] = 41;
                   f1_64();
               }
           });
           c22.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   choice2.setVisibility(View.INVISIBLE);
                   prev[0] = 41;
                   f1_26();
               }
           });
       } else {
           //choices[41] = 1;
           player.setF1_choices(41); prev[1] = 41;
           mainText.setText(getString(R.string.f1_41_1));
           choice1.setVisibility(View.VISIBLE);
           c11.setText(getString(R.string.click));
           c11.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   mainText.setText(getString(R.string.f1_41_2));
                   f1_41();
               }
           });
       }
   }
   public void f1_42(){
       allInvisible();
       //choices[42] = 1;
       player.setF1_choices(42);
       choice1 = findViewById(R.id.choice_no1);
       c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
       mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
       character.setText(" ");
       mainText.setText(getString(R.string.f1_42));
       c11.setText(getString(R.string.click));
       c11.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               mainText.setText("도망 엔딩"); //도망 엔딩
               choice1.setVisibility(View.INVISIBLE);
           }
       });
   }
   public void f1_43(){
       allInvisible();
       //choices[43] = 1;
       player.setF1_choices(43);
       choice1 = findViewById(R.id.choice_no1);
       c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
       mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
       character.setText(" ");
       mainText.setText(getString(R.string.f1_43));
       c11.setText(getString(R.string.click));
       c11.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               mainText.setText("도망 엔딩"); //도망 엔딩
               choice1.setVisibility(View.INVISIBLE);
           }
       });
   }
   public void f1_44(){
       allInvisible();
       choice1 = findViewById(R.id.choice_no1);
       c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
       mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
       character.setText(" ");
       if(!mainText.getText().toString().equals(getString(R.string.f1_44_2))) {
           player.setF1_choices(44); //choices[44] = 1;
           mainText.setText(getString(R.string.f1_44_1));
           c11.setText(getString(R.string.click));
           c11.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   mainText.setText(getString(R.string.f1_44_2));
                   f1_44();
               }
           });
       }else{
           c11.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   mainText.setText("도망 엔딩"); //도망 엔딩
                   choice1.setVisibility(View.INVISIBLE);
               }
           });
       }
   }
   public void f1_45(){
       allInvisible();
       //choices[45] = 1;
       player.setF1_choices(45); prev[1] = 45;
       mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);

       character.setText(getString(R.string.doll_guard));
       mainText.setText(getString(R.string.f1_45));
       if(player.isInventory(0)){//if(itemlist[0] == 1){
           choice2 = findViewById(R.id.choice_no2); choice2.setVisibility(View.VISIBLE);
           c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
           c21.setText(getString(R.string.f1_45c1)); c22.setText(getString(R.string.f1_45c2));
       }else{
           choice2 = findViewById(R.id.choice_no1); choice2.setVisibility(View.VISIBLE);
           c21 = findViewById(R.id.choice1_1);  c22 = findViewById(R.id.choice2_2);
           c21.setText(getString(R.string.f1_45c1));
       }
       c21.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               prev[0] = 45;
               choice2.setVisibility(View.INVISIBLE);
               f1_15();
           }
       });
       c22.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               prev[0] = 45;
               choice2.setVisibility(View.INVISIBLE);
               f1_46();
           }
       });
   }
   public void f1_46(){
       allInvisible();
       //choices[46] = 1;
       player.setF1_choices(46); prev[1] = 46;
       mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
       character.setText(getString(R.string.doll_guard));
       mainText.setText(getString(R.string.f1_46));

       choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.VISIBLE);
       c11 = findViewById(R.id.choice1_1); c11.setText(getString(R.string.f1_46c1));

       c11.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               choice1.setVisibility(View.INVISIBLE);
               prev[0] = 46;
               f1_64();
           }
       });
   }
   public void f1_47(){
       allInvisible();
       //choices[47] = 1;
       player.setF1_choices(47); prev[1] = 47;
       mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
       character.setText(getString(R.string.doll_guard));
       mainText.setText(getString(R.string.f1_47));

       choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.VISIBLE);
       c11 = findViewById(R.id.choice1_1); c11.setText(getString(R.string.f1_47c1));

       c11.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               choice1.setVisibility(View.INVISIBLE);
               prev[0] = 47;
               f1_9();
           }
       });
   }
   public void f1_48(){
       allInvisible();
       //choices[48] = 1;
       player.setF1_choices(48); prev[1] = 48;
       mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
       character.setText(" ");
       mainText.setText(getString(R.string.f1_48));

       choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.VISIBLE);
       c11 = findViewById(R.id.choice1_1); c11.setText(getString(R.string.f1_48c1));

       c11.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               choice1.setVisibility(View.INVISIBLE);
               prev[0] = 48;
               f1_9();
           }
       });
   }
   public void f1_49(){
       allInvisible();
       player.setF1_choices(49); //choices[49] = 1;
       mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
       character.setText(getString(R.string.doll_bear));
       mainText.setText(getString(R.string.f1_49_1));

       choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.VISIBLE);
       c11 = findViewById(R.id.choice1_1); c11.setText(getString(R.string.click));
       c11.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               mainText.setText(getString(R.string.f1_49_2));
           }
       });
       if(mainText.getText().toString().equals(getString(R.string.f1_49_2))){
           c11.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   mainText.setText("베드엔딩");
                   choice1.setVisibility(View.INVISIBLE);
               }
           });
       }
   }
   public void f1_50() {
       allInvisible();
       choice1 = findViewById(R.id.choice_no1);
       c11 = findViewById(R.id.choice1_1);
       choice1.setVisibility(View.VISIBLE);
       mainText = findViewById(R.id.main_text);
       character = findViewById(R.id.character);

       if (!mainText.getText().toString().equals(getString(R.string.f1_50_2))) {
           player.setF1_choices(50); //choices[50] = 1;
           prev[1] = 50;
           mainText.setText(getString(R.string.f1_50_1));
           c11.setText(getString(R.string.click));
           c11.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   mainText.setText(getString(R.string.f1_50_2));
                   prev[0] = 50;
                   f1_50();
               }
           });
       } else {
           c11.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   choice1.setVisibility(View.INVISIBLE);
                   prev[0] = 50;
                   f1_11();
               }
           });
       }
   }
   public void f1_62(){
       allInvisible();
       //choices[62] = 1;
       player.setF1_choices(62); prev[1] = 62;
       choice2 = findViewById(R.id.choice_no2);
       c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
       mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
       choice2.setVisibility(View.VISIBLE);
       character.setText(getString(R.string.doll_guard));
       mainText.setText(getString(R.string.f1_62));
       c21.setText(getString(R.string.f1_62c1)); c22.setText(getString(R.string.f1_62c2));
       c21.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               choice2.setVisibility(View.INVISIBLE);
               prev[0] = 62;
               f1_64();
           }
       });
       c22.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               choice2.setVisibility(View.INVISIBLE);
               prev[0] = 62;
               if(player.isInventory(4)){//if(itemlist[4] == 1){
                   if(player.getF1_choices(25)){//if(choices[25] == 1){
                       f1_40();
                   }if(!player.getF1_choices(25)){//else if(choices[25] == 0){
                       f1_38();
                   }
               } else if(!player.isInventory(4)){//else if(itemlist[4] == 0){
                   f1_41();
               }
           }
       });
   }
   public void f1_63(){
       allInvisible();
       //choices[63] = 1;
       player.setF1_choices(63); prev[1] = 63;
       mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
       character.setText(getString(R.string.doll_bear));
       mainText.setText(getString(R.string.f1_63));

       choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.VISIBLE);
       c11 = findViewById(R.id.choice1_1); c11.setText(getString(R.string.f1_63c1));

       c11.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               choice1.setVisibility(View.INVISIBLE);
               prev[0] = 63;
               f1_11();
           }
       });
   }
    public void f1_64(){
        allInvisible();
        //choices[64] = 1;
        player.setF1_choices(64); prev[1] = 64;
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        character.setText(getString(R.string.doll_guard));
        mainText.setText(getString(R.string.f1_64));

        choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1); c11.setText(getString(R.string.f1_64c1));

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                prev[0] = 64;
                f1_15();
            }
        });
    }
    public void f1_65(){
        allInvisible();
        //choices[65] = 1;
        player.setF1_choices(65); prev[1] = 65;
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        character.setText(" ");
        mainText.setText(getString(R.string.f1_65));

        choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1); c11.setText(getString(R.string.f1_65c1));

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                prev[0] = 65;
                f1_9();
            }
        });
    }
    public void f1_66(){
        allInvisible();
        //choices[65] = 1;
        player.setF1_choices(66); prev[1] = 66;
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        character.setText(" ");
        mainText.setText(getString(R.string.f1_66));

        choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1); c11.setText(getString(R.string.f1_66c1));

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                prev[0] = 66;
                f1_13();
            }
        });
    }

    public void f1_67(){
        allInvisible();
        player.setF1_choices(67); prev[1] = 67;
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        character.setText(" ");
        mainText.setText(getString(R.string.f1_67));

        choice2 = findViewById(R.id.choice_no2); c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        c21.setText(getString(R.string.f1_67c1)); c22.setText(getString(R.string.f1_67c2));

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                prev[0] = 67;
                f1_9();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                prev[0] = 67;
                mainText.setText("탈출 엔딩. 4-33으로.");
            }
        });

    }

   public void f1_100(){
       allInvisible();
        mainText = findViewById(R.id.main_text);
        mainText.setText(getString(R.string.f1_100));
   }

   public void back1(int prev, int now){
        if(prev == 51){ f1_51();}
        else if(prev == 52){ choices[now] = 0; f1_52();}
        else if(prev == 0){choices[now] = 0;f1_0();}
        else if(prev == 1){choices[now] = 0;f1_1();}
        else if(prev == 2){choices[now] = 0;f1_2();}
        else if(prev == 3){choices[now] = 0;f1_3();}
        else if(prev == 4){choices[now] = 0;f1_4();}
        else if(prev == 5){choices[now] = 0;f1_5();}
        else if(prev == 6){choices[now] = 0;f1_6();}
        else if(prev == 7){choices[now] = 0;f1_7();}
        else if(prev == 8){choices[now] = 0;f1_8();}
        else if(prev == 9){choices[now] = 0;f1_9();}
        else if(prev == 10){choices[now] = 0;f1_10();}
        else if(prev == 11){choices[now] = 0;f1_11();}
        else if(prev == 12){choices[now] = 0;f1_12();}
        else if(prev == 13){choices[now] = 0;f1_13();}
        else if(prev == 14){choices[now] = 0;f1_14();}
        else if(prev == 15){choices[now] = 0;f1_15();}
        else if(prev == 16){choices[now] = 0;f1_16();}
        else if(prev == 17){choices[now] = 0;f1_17();}
        else if(prev == 55){choices[now] = 0;f1_55();}
        else if(prev == 18){choices[now] = 0;f1_18();}
        else if(prev == 57){choices[now] = 0;f1_57();}
        else if(prev == 56){choices[now] = 0;f1_56();}
        else if(prev == 19){choices[now] = 0;f1_19();}
        else if(prev == 20){choices[now] = 0;f1_20();}
        else if(prev == 21){choices[now] = 0;f1_21();}
        else if(prev == 24){choices[now] = 0;f1_24();}
        else if(prev == 25){choices[now] = 0;f1_25();}
        else if(prev == 27){choices[now] = 0;f1_27();}
        else if(prev == 28){choices[now] = 0;f1_28();}
        else if(prev == 30){choices[now] = 0;f1_30();}
        else if(prev == 31){choices[now] = 0;f1_31();}
        else if(prev == 33){choices[now] = 0;f1_33();}
        else if(prev == 34){choices[now] = 0;f1_34();}
        else if(prev == 35){choices[now] = 0;f1_35();}
        else if(prev == 36){choices[now] = 0;f1_36();}
        else if(prev == 37){choices[now] = 0;f1_37();}
        else if(prev == 38){choices[now] = 0;f1_38();}
        else if(prev == 39){choices[now] = 0;f1_39();}
        else if(prev == 40){choices[now] = 0;f1_40();}
        else if(prev == 41){choices[now] = 0;f1_41();}
        else if(prev == 45){choices[now] = 0;f1_45();}
        else if(prev == 46){choices[now] = 0;f1_46();}
        else if(prev == 47){choices[now] = 0;f1_47();}
        else if(prev == 48){choices[now] = 0;f1_48();}
        else if(prev == 50){choices[now] = 0;f1_50();}
        else if(prev == 62){choices[now] = 0;f1_62();}
        else if(prev == 63){choices[now] = 0;f1_63();}
        else if(prev == 64){choices[now] = 0;f1_64();}
        else if(prev == 65){choices[now] = 0;f1_65();}
        else if(prev == 66){choices[now] = 0;f1_66();}

   }


   //2층 시작
   public void f2_0(){
       allInvisible();
       player.setF2_choices(0);
       mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
       choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.VISIBLE);
       c11 = findViewById(R.id.choice1_1);
       mainText.setText(getString(R.string.f2_0));
       c11.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               choice1.setVisibility(View.INVISIBLE);
               f2_1();
           }
       });
   }
    public void f2_1(){
        allInvisible();
        player.setF2_choices(1);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.VISIBLE);
        choice6 = findViewById(R.id.choice_no6);
        c61 = findViewById(R.id.choice6_1); c62 = findViewById(R.id.choice6_2); c63 = findViewById(R.id.choice6_3);
        c64 = findViewById(R.id.choice6_4); c65 = findViewById(R.id.choice6_5); c66 = findViewById(R.id.choice6_6);
        character.setText(" ");
        mainText.setText(getString(R.string.f2_1_1)); c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                choice6.setVisibility(View.VISIBLE);
                mainText.setText(getString(R.string.f2_1_2));
            }
        });

        c61.setText(getString(R.string.f2_1c1)); c62.setText(getString(R.string.f2_1c2));
        c63.setText(getString(R.string.f2_1c3)); c64.setText(getString(R.string.f2_1c4));
        c65.setText(getString(R.string.f2_1c5)); c66.setText(getString(R.string.f2_1c6));

        c61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice6.setVisibility(View.INVISIBLE);
                f2_2();
            }
        });
        c62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice6.setVisibility(View.INVISIBLE);
                if(player.getF2_choices(51) && !player.getF2_choices(57)){
                    f2_64();
                } else if(player.isInventory(14) || player.getB1_choices(80)){ //잠드는 약 == 코코아.
                    f2_76();
                } else{
                    f2_3();
                }
            }
        });
        c63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice6.setVisibility(View.INVISIBLE);
                if(player.getF2_choices(51) && !player.getF2_choices(57)){
                    f2_64();
                }else{
                    f2_4();
                }
            }
        });
        c64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice6.setVisibility(View.INVISIBLE);
                f2_5();
            }
        });
        c65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice6.setVisibility(View.INVISIBLE);
                if(!player.getF2_choices(6)){
                    f2_6();
                } else {
                    f2_28();
                }
            }
        });
        c66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice6.setVisibility(View.INVISIBLE);
                f2_79();
            }
        });
    }
    public void f2_2(){
        allInvisible();
        player.setF2_choices(2);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice2 = findViewById(R.id.choice_no2); choice2.setVisibility(View.VISIBLE);
        c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);

        mainText.setText(getString(R.string.f2_2));
        c21.setText(getString(R.string.f2_2c1)); c22.setText(getString(R.string.f2_2c2));
        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                if(!player.getF2_choices(9)){
                    f2_9();
                } else if (player.getF2_choices(9) && player.getF2_choices(51)){
                    f2_53();
                } else{
                    f2_14();
                }
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f2_1();
            }
        });
    }
    public void f2_3(){
        allInvisible();
        player.setF2_choices(3);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice2 = findViewById(R.id.choice_no2); choice2.setVisibility(View.VISIBLE);
        c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);

        mainText.setText(getString(R.string.f2_3));
        if(!player.isInventory(19)){ //보청기i
            c21.setText(getString(R.string.f2_3c1));
            c21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    if((player.getF1_choices(5) || player.getF1_choices(57)) && !player.getF2_choices(70)){
                        f2_70();
                    }else if(!player.isInventory(4) && !player.getF2_choices(65)){
                        f2_65();
                    }else if((player.getF2_choices(70) || player.getF2_choices(66)) && !player.getF2_choices(71)){
                        f2_67();
                    } else{
                        f2_72();
                    }
                }
            });
        } else { //보청기v
            c21.setText(getString(R.string.f2_3c2));
            c21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    f2_74();
                }
            });

        }
        c22.setText(getString(R.string.f2_3c3));
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f2_1();
            }
        });
    }
    public void f2_4(){
        allInvisible();
        player.setF2_choices(4);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        mainText.setText(getString(R.string.f2_4));
        if(!player.getF2_choices(88) || (player.isInventory(22)) && player.getF2_choices(87)){
            if(!player.getF2_choices(88) && (player.isInventory(22)) && player.getF2_choices(87)){
                choice5 = findViewById(R.id.choice_no5);
                choice5.setVisibility(View.VISIBLE);
                c51 = findViewById(R.id.choice5_1);
                c52 = findViewById(R.id.choice5_2);
                c53 = findViewById(R.id.choice5_3);
                c54 = findViewById(R.id.choice5_4);
                c55 = findViewById(R.id.choice5_5);
            }else {
                choice5 = findViewById(R.id.choice_no4);
                choice5.setVisibility(View.VISIBLE);
                c51 = findViewById(R.id.choice4_1);
                c52 = findViewById(R.id.choice4_2);
                c53 = findViewById(R.id.choice4_3);
                c54 = findViewById(R.id.choice4_4);
                c55 = findViewById(R.id.choice5_5);
            }
        } else{
            choice5 = findViewById(R.id.choice_no3); choice5.setVisibility(View.VISIBLE);
            c51 = findViewById(R.id.choice3_1); c52 = findViewById(R.id.choice3_2); c53 = findViewById(R.id.choice5_3);
            c54 = findViewById(R.id.choice5_4); c55 = findViewById(R.id.choice5_5);
        }
        c51.setText(getString(R.string.f2_4c1)); c52.setText(getString(R.string.f2_4c2)); c53.setText(getString(R.string.f2_4c3));
        if(!player.getF2_choices(88) || (player.isInventory(22)) && player.getF2_choices(87)) {
            if (!player.getF2_choices(88) && (player.isInventory(22)) && player.getF2_choices(87)) {
                c54.setText(getString(R.string.f2_4c4)); c55.setText(getString(R.string.f2_4c5));
            } else {
                if(!player.getF2_choices(88)){
                    c54.setText(getString(R.string.f2_4c4));
                } else {
                    c55.setText(getString(R.string.f2_4c5));
                }
            }
        }

        c51.setOnClickListener(new View.OnClickListener() {
            @Override
            //서랍열쇠v
            public void onClick(View v) {
                choice5.setVisibility(View.INVISIBLE);
                if(player.isInventory(20) && !player.getF2_choices(83)){
                    f2_83();
                } else if (player.isInventory(20) && player.getF2_choices(83)){
                    f2_84();
                } else {
                    f2_85();
                }
            }
        });
        c52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice5.setVisibility(View.INVISIBLE);
                if(player.getF2_choices(40) && !player.getF2_choices(86)){
                    f2_86();
                }else{
                    f2_87();
                }
            }
        });
        c53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice5.setVisibility(View.INVISIBLE);
                f2_1();
            }
        });
        c54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice5.setVisibility(View.INVISIBLE);
                if(!player.getF2_choices(88)){
                    f2_88();
                } else {
                    f2_93();
                }
            }
        });
        c55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice5.setVisibility(View.INVISIBLE);
                f2_93();
            }
        });
    }
    public void f2_5(){
        allInvisible();
        player.setF2_choices(5);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        if(player.getB1_choices(35) && !player.getF2_choices(51) && !player.getF2_choices(62)){
            choice2 = findViewById(R.id.choice_no2); c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        }else{
            choice2 = findViewById(R.id.choice_no1); c21 = findViewById(R.id.choice1_1); c22 = findViewById(R.id.choice2_2);
        }
        mainText.setText(getString(R.string.f2_5));
        c21.setText(getString(R.string.f2_5c1)); c22.setText(getString(R.string.f2_5c2));
        choice2.setVisibility(View.VISIBLE);
        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f2_1();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f2_47();
            }
        });
    }
    public void f2_6(){
        allInvisible();
        player.setF2_choices(6);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        choice2 = findViewById(R.id.choice_no2); c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);

        choice1.setVisibility(View.VISIBLE); c11.setText(getString(R.string.click));
        mainText.setText(getString(R.string.f2_6_1));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_6_1))) {
                    mainText.setText(getString(R.string.f2_6_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_6_2))){
                    mainText.setText(getString(R.string.f2_6_3));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_6_3))) {
                    mainText.setText(getString(R.string.f2_6_4));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_6_4))) {
                    choice1.setVisibility(View.INVISIBLE);
                    choice2.setVisibility(View.VISIBLE);
                }
            }
        });

        c21.setText(getString(R.string.f2_6c1)); c22.setText(getString(R.string.f2_6c2));
        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f2_26();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f2_27();
            }
        });
    }
    public void f2_7(){
        allInvisible();
        player.setF2_choices(7);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);

        if(mainText.getText().toString().equals(getString(R.string.f2_7_3))){
            //c2 : 다른 공주는 어디있지와 c3 : 그래서 숲의 마녀는? 은 선택형 지문,
            int c2 = 0, c3 = 0, q23 = -1;
            if(!player.getB1_choices(23) || !player.getF2_choices(50) || (!player.getB1_choices(23)
                    && !player.getF2_choices(50)) && !player.getF2_choices(12)) {
                c2 = 1;
            }
            if(!player.getF2_choices(91)){ c3 = 1;}
            if(c2 == 1 || c3 == 1){
                if(c2 == 1 && c3 == 1){
                    choice3 = findViewById(R.id.choice_no2);
                    c31 = findViewById(R.id.choice3_1); c32 = findViewById(R.id.choice3_2); c33 = findViewById(R.id.choice3_3);
                    c31.setText(getString(R.string.f2_7c1)); c32.setText(getString(R.string.f2_7c2)); c33.setText(getString(R.string.f2_7c3));
                }else {
                    choice3 = findViewById(R.id.choice_no2);
                    c31 = findViewById(R.id.choice2_1); c32 = findViewById(R.id.choice2_2); c33 = findViewById(R.id.choice3_3);
                    choice3.setVisibility(View.VISIBLE); choice1.setVisibility(View.INVISIBLE);
                    if (c2 == 1) {
                        q23 = 0;
                        c31.setText(getString(R.string.f2_7c1)); c32.setText(getString(R.string.f2_7c2));
                    } else {
                        q23 = 1;
                        c31.setText(getString(R.string.f2_7c1)); c32.setText(getString(R.string.f2_7c3));
                    }

                    c31.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            choice2.setVisibility(View.INVISIBLE);
                            if (!player.getF2_choices(15)) {
                                f2_15();
                            } else {
                                f2_16();
                            }
                        }
                    });
                    final int finalQ2 = q23;
                    c32.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            choice2.setVisibility(View.INVISIBLE);
                            if(finalQ2 == 0) {
                                f2_12();
                            } else{
                                f2_91();
                            }
                        }
                    });
                    c33.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            choice2.setVisibility(View.INVISIBLE);
                            f2_91();
                        }
                    });
                }
            }else{
                c11.setText(getString(R.string.f2_7c2));
                c11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        choice1.setVisibility(View.INVISIBLE);
                        if(!player.getF2_choices(15)){
                            f2_15();
                        }else{
                            f2_16();
                        }
                    }
                });
            }
        }else if(mainText.getText().toString().equals(getString(R.string.f2_7_2))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_7_3));
                    choice1.setVisibility(View.INVISIBLE);
                    f2_7();
                }
            });
        } else {
            choice1.setVisibility(View.VISIBLE); c11.setText(getString(R.string.click));
            mainText.setText(getString(R.string.f2_7_1));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_7_2));
                    f2_7();
                }
            });
        }
    }
    public void f2_8(){
        allInvisible();
        player.setF2_choices(8);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);

        if(mainText.getText().toString().equals(getString(R.string.f2_8_3))){
            int c3 = 0, c4 = 0, q34 = -1;
            if(!player.getB1_choices(23) || !player.getF2_choices(50) || (!player.getB1_choices(23) && !player.getF2_choices(50))){
                c3 = 1;
            }
            if(!player.getF2_choices(91)){ c4 = 1;}
            if(c3 == 1 || c4 == 1){
                if(c3 == 1 && c4 == 1){
                    choice4 = findViewById(R.id.choice_no4);
                    c41 = findViewById(R.id.choice4_1); c42 = findViewById(R.id.choice4_2);
                    c43 = findViewById(R.id.choice4_3); c44 = findViewById(R.id.choice4_4);
                    c41.setText(getString(R.string.f2_8c1)); c42.setText(getString(R.string.f2_8c2));
                    c43.setText(getString(R.string.f2_8c3)); c44.setText(getString(R.string.f2_8c4));
                }else {
                    c44 = findViewById(R.id.choice4_4);
                    choice4 = findViewById(R.id.choice_no3);
                    c41 = findViewById(R.id.choice3_1); c42 = findViewById(R.id.choice3_2); c43 = findViewById(R.id.choice3_3);
                    if (c3 == 1) {
                        q34 = 0;
                        c41.setText(getString(R.string.f2_8c1)); c42.setText(getString(R.string.f2_8c2)); c43.setText(getString(R.string.f2_8c3));
                    } else {
                        q34 = 1;
                        c41.setText(getString(R.string.f2_8c1)); c42.setText(getString(R.string.f2_8c2)); c43.setText(getString(R.string.f2_8c4));
                    }
                }
            } else{
                choice4 = findViewById(R.id.choice_no2);
                c41 = findViewById(R.id.choice2_1); c42 = findViewById(R.id.choice2_2); c43 = findViewById(R.id.choice3_3);
                c41.setText(getString(R.string.f2_8c1)); c42.setText(getString(R.string.f2_8c2));
            }
            choice4.setVisibility(View.VISIBLE);
            c41.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice4.setVisibility(View.INVISIBLE);
                    if(!player.getF2_choices(15)){
                        f2_15();
                    }else{
                        f2_16();
                    }
                }
            });
            c42.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice4.setVisibility(View.INVISIBLE);
                    f2_7();
                }
            });
            final int finalQ3 = q34;
            c43.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice4.setVisibility(View.INVISIBLE);
                    if(finalQ3 == 0) { //f2_8c3
                        f2_12();
                    }else{ //f2_8c4
                        f2_91();
                    }
                }
            });
            c44.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice4.setVisibility(View.INVISIBLE);
                    f2_91();
                }
            });

        }else if(mainText.getText().toString().equals(getString(R.string.f2_8_2))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_8_3));
                    choice1.setVisibility(View.INVISIBLE);
                    f2_8();
                }
            });
        } else {
            choice1.setVisibility(View.VISIBLE); c11.setText(getString(R.string.click));
            mainText.setText(getString(R.string.f2_8_1));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_8_2));
                    f2_8();
                }
            });
        }
    }
    public void f2_9(){
        allInvisible();
        player.setF2_choices(9);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        choice2 = findViewById(R.id.choice_no2); c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        choice1.setVisibility(View.VISIBLE);
        mainText.setText(getString(R.string.f2_9_1));
        c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                choice2.setVisibility(View.VISIBLE);
                mainText.setText(getString(R.string.f2_9_2));
            }
        });
        c21.setText(getString(R.string.f2_9c1)); c22.setText(getString(R.string.f2_9c2));
        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f2_8();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f2_16();
            }
        });
    }
    public void f2_10(){
        allInvisible();
        player.setF2_choices(10);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        if(mainText.getText().toString().equals(getString(R.string.f2_10_4))){
            c11.setText(getString(R.string.f2_10c1));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice1.setVisibility(View.INVISIBLE);
                    f2_16();
                }
            });

        }else if(mainText.getText().toString().equals(getString(R.string.f2_10_3))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_10_4));
                    f2_10();
                }
            });
        }else if(mainText.getText().toString().equals(getString(R.string.f2_10_2))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_10_3));
                    f2_10();
                }
            });
        } else {
            choice1.setVisibility(View.VISIBLE); c11.setText(getString(R.string.click));
            mainText.setText(getString(R.string.f2_10_1));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_10_2));
                    f2_10();
                }
            });
        }
    }
    public void f2_11(){
        allInvisible();
        player.setF2_choices(11);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);

        if(mainText.getText().toString().equals(getString(R.string.f2_11_3))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText("~베드엔딩~");
                }
            });

        }else if(mainText.getText().toString().equals(getString(R.string.f2_11_2))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_11_3));
                    f2_11();
                }
            });
        } else {
            choice1.setVisibility(View.VISIBLE); c11.setText(getString(R.string.click));
            mainText.setText(getString(R.string.f2_11_1));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_11_2));
                    f2_11();
                }
            });
        }
    }
    public void f2_12(){
        allInvisible();
        player.setF2_choices(12);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);

        if(mainText.getText().toString().equals(getString(R.string.f2_12_4))){

            if(!player.getF2_choices(7) || !player.getF2_choices(91)){
                if(!player.getF2_choices(7) && !player.getF2_choices(91)){
                    choice3 = findViewById(R.id.choice_no3);
                    c31 = findViewById(R.id.choice3_1); c32 = findViewById(R.id.choice3_2);  c33 = findViewById(R.id.choice3_3);
                }else {
                    choice3 = findViewById(R.id.choice_no2);
                    c31 = findViewById(R.id.choice2_1);
                    c32 = findViewById(R.id.choice2_2);
                    c33 = findViewById(R.id.choice3_3);
                    if(!player.getF2_choices(7)){
                        c31.setText(getString(R.string.f2_12c1));
                        c32.setText(getString(R.string.f2_12c2));
                    } else{
                        c31.setText(getString(R.string.f2_12c1));
                        c32.setText(getString(R.string.f2_12c3));
                    }
                }
                choice3.setVisibility(View.VISIBLE); choice1.setVisibility(View.INVISIBLE);
            }else{
                c31 = findViewById(R.id.choice1_1); c32 = findViewById(R.id.choice3_2); c33 = findViewById(R.id.choice3_3);
                c31.setText(getString(R.string.f2_12c1));
            }
            c31.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice1.setVisibility(View.INVISIBLE);
                    choice3.setVisibility(View.INVISIBLE);
                    if(!player.getF2_choices(15)){
                        f2_15();
                    }else{ f2_16(); }
                }
            });
            c32.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice3.setVisibility(View.INVISIBLE);
                    if(!player.getF2_choices(7)) {
                        f2_7();
                    } else {
                        f2_91();
                    }
                }
            });
            c33.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice3.setVisibility(View.INVISIBLE);
                    f2_91();
                }
            });

        }else if(mainText.getText().toString().equals(getString(R.string.f2_12_3))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_12_4));
                    f2_12();
                }
            });
        }else if(mainText.getText().toString().equals(getString(R.string.f2_12_2))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_12_3));
                    f2_12();
                }
            });
        } else {
            choice1.setVisibility(View.VISIBLE); c11.setText(getString(R.string.click));
            mainText.setText(getString(R.string.f2_12_1));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_12_2));
                    f2_12();
                }
            });
        }
    } public void f2_13(){
        allInvisible();
        player.setF2_choices(13);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        if(mainText.getText().toString().equals(getString(R.string.f2_13_3))){
            c11.setText(getString(R.string.f2_13c1));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice1.setVisibility(View.INVISIBLE);
                    f2_2();
                }
            });

        }else if(mainText.getText().toString().equals(getString(R.string.f2_13_2))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_13_3));
                    f2_13();
                }
            });
        } else {
            choice1.setVisibility(View.VISIBLE); c11.setText(getString(R.string.click));
            mainText.setText(getString(R.string.f2_13_1));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_13_2));
                    f2_13();
                }
            });
        }
    }
    public void f2_14(){
        allInvisible();
        player.setF2_choices(14);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        int c2 = 0, c3 = 0, c4 = 0, c5 = 0, sumC = 0; //f2_14c2 ~ f2_14c5의 선택지 조건들 flag 변수
        int brown = 0, white = 0; //갈색약장/하얀약장 아이템 중 1개 이상 있는지 체크여부, 갈색(27-31), 하얀(22-26)
        for(int i = 21; i <= 25; i++){ //하얀약장 아이템 유무 체크
            if(player.isInventory(i)){
                white = 1;
                break;
            }
        }
        for(int i = 26; i <= 30; i++){ //갈색약장~
            if(player.isInventory(i)){
                brown = 1;
                break;
            }
        }
        if(player.getF2_choices(15) && brown == 1 && !player.getF2_choices(32) && !player.getF2_choices(17)){
            c2 = 1;
        }
        if(player.getB1_choices(13) && !player.getB1_choices(17) && !player.getF2_choices(13)){
            c3 = 1;
        }
        if(player.getF2_choices(75) && !player.getF2_choices(22)){
            c4 = 1;
        }else if(player.getF2_choices(22) && white == 1 && !player.getF2_choices(25)){
            c5 = 1;
        }
        sumC = c2 + c3 + c4 + c5;

        switch(sumC) {
            case 0:
                choice4 = findViewById(R.id.choice_no1);
                c41 = findViewById(R.id.choice1_1);
                c42 = findViewById(R.id.choice4_2);
                c43 = findViewById(R.id.choice4_3);
                c44 = findViewById(R.id.choice4_4);
                c41.setText(getString(R.string.f2_14c1));
                break;
            case 1:
                choice4 = findViewById(R.id.choice_no2);
                c41 = findViewById(R.id.choice2_1);
                c42 = findViewById(R.id.choice2_2);
                c43 = findViewById(R.id.choice4_3);
                c44 = findViewById(R.id.choice4_4);

                c41.setText(getString(R.string.f2_14c1));
                if (c2 == 1) {
                    c42.setText(getString(R.string.f2_14c2));
                } else if (c3 == 1) {
                    c42.setText(getString(R.string.f2_14c3));
                } else if (c4 == 1) {
                    c42.setText(getString(R.string.f2_14c4));
                } else if (c5 == 1) {
                    c42.setText(getString(R.string.f2_14c5));
                }
                break;
            case 2:
                choice4 = findViewById(R.id.choice_no3);
                c41 = findViewById(R.id.choice3_1);
                c42 = findViewById(R.id.choice3_2);
                c43 = findViewById(R.id.choice3_3);
                c44 = findViewById(R.id.choice4_4);

                c41.setText(getString(R.string.f2_14c1));
                if (c2 == 1 && c3 == 1) {
                    c42.setText(getString(R.string.f2_14c2));
                    c43.setText(getString(R.string.f2_14c3));
                } else if (c2 == 1 && c4 == 1) {
                    c42.setText(getString(R.string.f2_14c2));
                    c43.setText(getString(R.string.f2_14c4));
                } else if (c2 == 1 && c5 == 1) {
                    c42.setText(getString(R.string.f2_14c2));
                    c43.setText(getString(R.string.f2_14c5));
                } else if (c3 == 1 && c4 == 1) {
                    c42.setText(getString(R.string.f2_14c3));
                    c43.setText(getString(R.string.f2_14c4));
                } else if (c3 == 1 && c5 == 1){
                    c42.setText(getString(R.string.f2_14c3));
                    c43.setText(getString(R.string.f2_14c5));
                }
                break;
            case 3:
                choice4 = findViewById(R.id.choice_no4);
                c41 = findViewById(R.id.choice4_1);
                c42 = findViewById(R.id.choice4_2);
                c43 = findViewById(R.id.choice4_3);
                c44 = findViewById(R.id.choice4_4);
                if(c4 == 1){
                    c41.setText(getString(R.string.f2_14c1));
                    c42.setText(getString(R.string.f2_14c2));
                    c43.setText(getString(R.string.f2_14c3));
                    c44.setText(getString(R.string.f2_14c4));
                } else if(c5 == 1){
                    c41.setText(getString(R.string.f2_14c1));
                    c42.setText(getString(R.string.f2_14c2));
                    c43.setText(getString(R.string.f2_14c3));
                    c44.setText(getString(R.string.f2_14c5));
                }
                break;
        }
        choice4.setVisibility(View.VISIBLE);
        c41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);
                f2_16();
            }
        });
        c42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);
                f2_14go(c42.getText().toString());
            }
        });
        c43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);
                f2_14go(c43.getText().toString());
            }
        });
        c44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);
                f2_14go(c44.getText().toString());
            }
        });

    }
    public void f2_14go(String txt){
        //확인용 mainText
        mainText = findViewById(R.id.main_text);
        if(txt.equals(getString(R.string.f2_14c2))){
            //mainText.setText("동물과 말하는 약");
            if(player.isInventory(27) && player.isInventory(30)){
                //28 나비의 날개 31 개구리 알
                f2_17();
            }else if(player.isInventory(28) && player.isInventory(29) && !player.getF2_choices(18)){
                f2_18();
                //29 고양이 수염 30 송어의 알
            } else if(player.getF2Recipe(0) == 0){ //첫번째 실패 레시피1
                int a = 0, b = 0;
                for(int i = 26; i <= 30; i++){ //갈색약장 아이템 뭐 있는지 체크, 저장
                    if(player.isInventory(i)){
                        if(a == 0){
                            a = i;
                        }else if(b == 0){
                            b = i;
                            player.setF2Recipe(a, b);
                            break;
                        }
                    }
                }
                f2_19();
            } else{
                int a = player.getF2Recipe(0), b = player.getF2Recipe(1);
                int c = 0, d = 0;
                for(int i = 26; i <= 30; i++){ //갈색약장 체크,
                    if(player.isInventory(i)){
                        if(c == 0){
                            c = i;
                        }else if(b == 0){
                            d = i;
                            break;
                        }
                    }
                }
                if(a != c && b != d){
                    //두번째 실패 레시피2 ( 레시피1 != 레시피2)
                    f2_21();
                }else if(a == c && b == d){
                    //첫번째 실패 레시피와 같을 경우
                    f2_20();
                } else{
                    f2_100();
                }
            }
        } else if(txt.equals(getString(R.string.f2_14c3))){
            f2_13();
        } else  if(txt.equals(getString(R.string.f2_14c4))){
            f2_22();
        } else  if(txt.equals(getString(R.string.f2_14c5))){
            if(player.isInventory(21) && player.isInventory(24)){
                //갈색가루 22 , 하얀 고체 25
                f2_25();
            } else if(player.isInventory(23) && player.isInventory(25)){
                //빨간 기름 24, 초록 섬유 26
                f2_24();
            } else {
                f2_23();
            }
        } else {
            mainText.setText(getString(R.string.f2_100));
        }
    }
    public void f2_15(){
        allInvisible();
        player.setF2_choices(15);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        choice2 = findViewById(R.id.choice_no2); c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);

        if(mainText.getText().toString().equals(getString(R.string.f2_15_3))){
            choice1.setVisibility(View.INVISIBLE);
            choice2.setVisibility(View.VISIBLE);
            c21.setText(getString(R.string.f2_15c1)); c22.setText(getString(R.string.f2_15c2));
            c21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    f2_10();
                }
            });
            c22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    f2_11();
                }
            });
        }else if(mainText.getText().toString().equals(getString(R.string.f2_15_2))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_15_3));
                    f2_15();
                }
            });
        } else {
            choice1.setVisibility(View.VISIBLE); c11.setText(getString(R.string.click));
            mainText.setText(getString(R.string.f2_15_1));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_15_2));
                    f2_15();
                }
            });
        }
    }
    public void f2_16(){
        allInvisible();
        player.setF2_choices(16);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        c11.setText(getString(R.string.click)); choice1.setVisibility(View.VISIBLE);

        if(mainText.getText().toString().equals(getString(R.string.f2_16_2))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice1.setVisibility(View.INVISIBLE);
                    f2_2();
                }
            });
        } else {
            mainText.setText(getString(R.string.f2_16_1));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_16_2));
                    f2_16();
                }
            });
        }

    }
    public void f2_17(){
        allInvisible();
        player.setF2_choices(17);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        c11.setText(getString(R.string.click));

        if(mainText.getText().toString().equals(getString(R.string.f2_17_4))){
            c11.setText(getString(R.string.f2_17c1));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    f2_16();
                }
            });
        }else if(mainText.getText().toString().equals(getString(R.string.f2_17_3))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_17_4));
                    player.addInventory(16); //16 item 동물과 말하는 약
                    f2_17();
                }
            });
        }else if(mainText.getText().toString().equals(getString(R.string.f2_17_2))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_17_3));
                    f2_17();
                }
            });
        }else{
            choice1.setVisibility(View.VISIBLE);
            mainText.setText(getString(R.string.f2_17_1));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_17_2));
                    f2_17();
                }
            });
        }
    }

    public void f2_18(){
        allInvisible();
        player.setF2_choices(18);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);

        if(mainText.getText().toString().equals(getString(R.string.f2_18_4))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(c11.getText().toString().equals(getString(R.string.click))) {
                        mainText.setText(getString(R.string.f2_18_5));
                        c11.setText(getString(R.string.f2_18c1));
                    } else{
                        f2_16();
                    }
                }
            });
        }else if(mainText.getText().toString().equals(getString(R.string.f2_18_3))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_18_4));
                    f2_18();
                }
            });
        }else if(mainText.getText().toString().equals(getString(R.string.f2_18_2))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_18_3));
                    f2_18();
                }
            });
        }else{
            choice1.setVisibility(View.VISIBLE);
            mainText.setText(getString(R.string.f2_18_1)); c11.setText(getString(R.string.click));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_18_2));
                    player.heal();  player.heal(); b42 = findViewById(R.id.b42); b42.setText(String.valueOf(player.getHeart()));
                    f2_18();
                }
            });
        }
    }

    public void f2_19(){
        allInvisible();
        player.setF2_choices(19);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);

        if(mainText.getText().toString().equals(getString(R.string.f2_19_4))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(c11.getText().toString().equals(getString(R.string.click))) {
                        mainText.setText(getString(R.string.f2_19_5));
                        c11.setText(getString(R.string.f2_19c1));
                    } else{
                        f2_16();
                    }
                }
            });
        }else if(mainText.getText().toString().equals(getString(R.string.f2_19_3))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_19_4));
                    f2_19();
                }
            });
        }else if(mainText.getText().toString().equals(getString(R.string.f2_19_2))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_19_3));
                    f2_19();
                }
            });
        }else{
            choice1.setVisibility(View.VISIBLE);
            mainText.setText(getString(R.string.f2_19_1)); c11.setText(getString(R.string.click));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_19_2));
                    f2_19();
                }
            });
        }
    }

    public void f2_20(){
        allInvisible();
        player.setF2_choices(20);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);

        choice1.setVisibility(View.VISIBLE);
        mainText.setText(getString(R.string.f2_20_1)); c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_20_1))) {
                    mainText.setText(getString(R.string.f2_20_2));
                }
                else if(mainText.getText().toString().equals(getString(R.string.f2_20_2))){
                    mainText.setText(getString(R.string.f2_20_3));
                    c11.setText(getString(R.string.f2_20c1));
                }else if(mainText.getText().toString().equals(getString(R.string.f2_20_3))){
                    choice1.setVisibility(View.INVISIBLE);
                    f2_16();
                }
            }
        });
    }
    public void f2_21(){
        allInvisible();
        player.setF2_choices(21);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);

        choice1.setVisibility(View.VISIBLE);
        mainText.setText(getString(R.string.f2_21_1)); c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_21_1))) {
                    mainText.setText(getString(R.string.f2_21_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_21_2))){
                    mainText.setText(getString(R.string.f2_21_3));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_21_3))){
                    mainText.setText(getString(R.string.f2_21_4));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_21_4))){
                    mainText.setText(getString(R.string.f2_21_5));
                    c11.setText(getString(R.string.f2_21c1));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_21_5))){
                    choice1.setVisibility(View.INVISIBLE);
                    f2_2();
                }
            }
        });
    }
    public void f2_22(){
        allInvisible();
        player.setF2_choices(22);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);

        choice1.setVisibility(View.VISIBLE);
        mainText.setText(getString(R.string.f2_22_1)); c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_22_1))) {
                    mainText.setText(getString(R.string.f2_22_2));
                }
                else if(mainText.getText().toString().equals(getString(R.string.f2_22_2))){
                    mainText.setText(getString(R.string.f2_22_3));
                    c11.setText(getString(R.string.f2_22c1));
                }else if(mainText.getText().toString().equals(getString(R.string.f2_22_3))){
                    choice1.setVisibility(View.INVISIBLE);
                    f2_16();
                }
            }
        });
    }
    public void f2_23(){
        allInvisible();
        player.setF2_choices(23);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);

        choice1.setVisibility(View.VISIBLE);
        mainText.setText(getString(R.string.f2_23)); c11.setText(getString(R.string.f2_23c1));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                f2_16();
            }
        });
    }
    public void f2_24(){
        allInvisible();
        player.setF2_choices(24);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);

        choice1.setVisibility(View.VISIBLE);
        mainText.setText(getString(R.string.f2_24_1)); c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_24_1))) {
                    mainText.setText(getString(R.string.f2_24_2));
                    player.heal();  player.heal(); b42 = findViewById(R.id.b42); b42.setText(String.valueOf(player.getHeart()));
                }
                else if(mainText.getText().toString().equals(getString(R.string.f2_24_2))){
                    mainText.setText(getString(R.string.f2_24_3));
                    c11.setText(getString(R.string.f2_24c1));
                }else if(mainText.getText().toString().equals(getString(R.string.f2_24_3))){
                    choice1.setVisibility(View.INVISIBLE);
                    f2_16();
                }
            }
        });
    }
    public void f2_25(){
        allInvisible();
        player.setF2_choices(25);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);

        choice1.setVisibility(View.VISIBLE);
        mainText.setText(getString(R.string.f2_25_1)); c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_25_1))) {
                    mainText.setText(getString(R.string.f2_25_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_25_2))) {
                    mainText.setText(getString(R.string.f2_25_3));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_25_3))){
                    mainText.setText(getString(R.string.f2_25_4));
                    player.addInventory(14); //item : 잠드는 약 얻음.
                    c11.setText(getString(R.string.f2_25c1));
                }else if(mainText.getText().toString().equals(getString(R.string.f2_25_4))){
                    choice1.setVisibility(View.INVISIBLE);
                    f2_16();
                }
            }
        });
    }
    public void f2_26(){
        allInvisible();
        player.setF2_choices(26);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        mainText.setText(getString(R.string.f2_26));
        if(player.isInventory(2)){ //item : 육감의 티아라 v
            choice2 = findViewById(R.id.choice_no2);
            c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        } else{
            choice2 = findViewById(R.id.choice_no1);
            c21 = findViewById(R.id.choice1_1); c22 = findViewById(R.id.choice2_2);
        }
        c21.setText(getString(R.string.f2_26c1)); c22.setText(getString(R.string.f2_26c2));
        choice2.setVisibility(View.VISIBLE);
        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f2_28();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f2_39();
            }
        });
    }
    public void f2_27(){
        allInvisible();
        player.setF2_choices(27);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);

        choice1.setVisibility(View.VISIBLE);
        mainText.setText(getString(R.string.f2_27_1)); c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_27_1))) {
                    mainText.setText(getString(R.string.f2_27_2));
                    c11.setText(getString(R.string.f2_27c1));
                }if(mainText.getText().toString().equals(getString(R.string.f2_27_2))){
                    f2_28();
                }
            }
        });
    }

    public void f2_28(){
        allInvisible();
        player.setF2_choices(28);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);

        choice1.setVisibility(View.VISIBLE);
        mainText.setText(getString(R.string.f2_28_1)); c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_28_1))) {
                    mainText.setText(getString(R.string.f2_28_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_28_2))){
                    if(player.getF2_choices(27) && !player.getF2_choices(26)){
                        mainText.setText(getString(R.string.f2_29));
                        player.setF2_choices(29);
                    }
                    choice1.setVisibility(View.INVISIBLE);
                    f2_28go();
                }
            }
        });
    }
    public void f2_28go(){
        int c4 = 0, c5 = 0, c6 = 0, q456 = 0;

        if(player.getF2_choices(27) && !player.getF2_choices(26) && !player.getF2_choices(26)){
            c4 = 1;
        } else{
            if(player.getF2_choices(26) && player.isInventory(10)) { //item 10 = 밧줄
                c5 = 1;
            }
            if(player.getF2_choices(26) && player.isInventory(2)){
                c6 = 1;
            }
        }
        if(true) {
            if (c5 == 1 && c6 == 1) {
                choice5 = findViewById(R.id.choice_no5);
                c51 = findViewById(R.id.choice5_1);
                c52 = findViewById(R.id.choice5_2);
                c53 = findViewById(R.id.choice5_3);
                c54 = findViewById(R.id.choice5_4);
                c55 = findViewById(R.id.choice5_5);

                c51.setText(getString(R.string.f2_28c1));
                c52.setText(getString(R.string.f2_28c2));
                c53.setText(getString(R.string.f2_28c3));
                c54.setText(getString(R.string.f2_28c5));
                c55.setText(getString(R.string.f2_28c6));
            } else if (c4 == 1 || c5 == 1 || c6 == 1) {
                choice5 = findViewById(R.id.choice_no4);
                c51 = findViewById(R.id.choice4_1);
                c52 = findViewById(R.id.choice4_2);
                c53 = findViewById(R.id.choice4_3);
                c54 = findViewById(R.id.choice4_4);
                c55 = findViewById(R.id.choice5_5);

                c51.setText(getString(R.string.f2_28c1));
                c52.setText(getString(R.string.f2_28c2));
                c53.setText(getString(R.string.f2_28c3));
                if (c4 == 1) {
                    c54.setText(getString(R.string.f2_28c4));
                } else if (c5 == 1) {
                    c54.setText(getString(R.string.f2_28c5));
                } else if (c6 == 1) {
                    c54.setText(getString(R.string.f2_28c6));
                }
            } else {
                choice5 = findViewById(R.id.choice_no3);
                c51 = findViewById(R.id.choice3_1);
                c52 = findViewById(R.id.choice3_2);
                c53 = findViewById(R.id.choice3_3);
                c54 = findViewById(R.id.choice4_4);
                c55 = findViewById(R.id.choice5_5);
                c51.setText(getString(R.string.f2_28c1));
                c52.setText(getString(R.string.f2_28c2));
                c53.setText(getString(R.string.f2_28c3));
            }

            choice5.setVisibility(View.VISIBLE);
            c51.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice5.setVisibility(View.INVISIBLE);
                    if (player.getF2_choices(22) && !player.getF2_choices(25)) {
                        f2_30();
                    } else {
                        f2_36();
                    }
                }
            });
            c52.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice5.setVisibility(View.INVISIBLE);
                    if (player.getF2_choices(10) && (!player.getF2_choices(17) || !player.getF2_choices(21))
                            || player.getF2_choices(54) && !player.getF2_choices(56)) {
                        f2_31();
                    } else {
                        f2_90();
                    }
                }
            });
            c53.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice5.setVisibility(View.INVISIBLE);
                    f2_1();
                }
            });
            final int finalC4 = c4, finalC5 = c5, finalC6 = c6;

            c54.setOnClickListener(new View.OnClickListener() { //c4 c5 c6 셋 중 하나 가능
                @Override
                public void onClick(View v) {
                    choice5.setVisibility(View.INVISIBLE);
                    if (finalC4 == 1) {
                        f2_26();
                    } else if (finalC5 == 1) {
                        f2_41();
                    } else if (finalC6 == 1) {
                        f2_39();
                    }
                }
            });

            c55.setOnClickListener(new View.OnClickListener() { //c55는 무조건 발톱을 써서 위로 밖에 없음.
                @Override
                public void onClick(View v) {
                    choice5.setVisibility(View.INVISIBLE);
                    f2_39();
                }
            });
        }
    }
    public void f2_30(){
        allInvisible();
        player.setF2_choices(30);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        choice3 = findViewById(R.id.choice_no3);
        c31 = findViewById(R.id.choice3_1); c32 = findViewById(R.id.choice3_2); c33 = findViewById(R.id.choice3_3);

        choice1.setVisibility(View.VISIBLE);
        mainText.setText(getString(R.string.f2_30_1));
        c11.setOnClickListener(new View.OnClickListener() { //c55는 무조건 발톱을 써서 위로 밖에 없음.
            @Override
            public void onClick(View v) {
                mainText.setText(getString(R.string.f2_30_2));
                choice1.setVisibility(View.INVISIBLE);
                c31.setText(getString(R.string.f2_30c1)); c32.setText(getString(R.string.f2_30c2)); c33.setText(getString(R.string.f2_30c3));
                choice3.setVisibility(View.VISIBLE);
            }
        });
        //아이템 선택 전 하얀 약장 아이템이 전부 사라짐.
        for(int i = 21; i <= 25; i++){
            if(player.isInventory(i)){
                player.removeInventory(i);
            }
        }

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                player.addInventory(21); //갈색가루
                f2_37();
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                player.addInventory(22); //파란색 금속
                f2_37();
            }
        });
        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                player.addInventory(23); //빨간 기름름
                f2_37();
            }
        });

    }
    public void f2_31(){
        allInvisible();
        player.setF2_choices(31);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        choice3 = findViewById(R.id.choice_no3);
        c31 = findViewById(R.id.choice3_1); c32 = findViewById(R.id.choice3_2); c33 = findViewById(R.id.choice3_3);

        choice1.setVisibility(View.VISIBLE);
        mainText.setText(getString(R.string.f2_31_1));
        c11.setOnClickListener(new View.OnClickListener() { //c55는 무조건 발톱을 써서 위로 밖에 없음.
            @Override
            public void onClick(View v) {
                mainText.setText(getString(R.string.f2_31_2));
                choice1.setVisibility(View.INVISIBLE);
                c31.setText(getString(R.string.f2_31c1)); c32.setText(getString(R.string.f2_31c2)); c33.setText(getString(R.string.f2_31c3));
                choice3.setVisibility(View.VISIBLE);
            }
        });
        //아이템 선택 전 갈색 약장 아이템이 전부 사라짐.
        for(int i = 26; i <= 30; i++){
            if(player.isInventory(i)){
                player.removeInventory(i);
            }
        }

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                player.addInventory(26); //울새 깃털
                if(player.getF2_choices(54) && !player.getF2_choices(56)){
                    f2_34();
                } else{
                    f2_32();
                }
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                player.addInventory(27); //나비 날개
                if(player.getF2_choices(54) && !player.getF2_choices(56)){
                    f2_89();
                } else{
                    f2_32();
                }
            }
        });
        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                player.addInventory(28); //구양이 수염
                if(player.getF2_choices(54) && !player.getF2_choices(56)){
                    f2_89();
                } else{
                    f2_32();
                }
            }
        });

    }
    public void f2_32(){
        allInvisible();
        player.setF2_choices(32);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        if(!player.getF2_choices(33)) {
            choice3 = findViewById(R.id.choice_no3);
            c31 = findViewById(R.id.choice3_1); c32 = findViewById(R.id.choice3_2); c33 = findViewById(R.id.choice3_3);
        } else{
            choice3 = findViewById(R.id.choice_no2);
            c31 = findViewById(R.id.choice2_1); c32 = findViewById(R.id.choice2_2); c33 = findViewById(R.id.choice3_3);
        }
        c31.setText(getString(R.string.f2_32c1)); c32.setText(getString(R.string.f2_32c2)); c33.setText(getString(R.string.f2_32c3));

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                player.addInventory(29); //송어
                f2_35();
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                player.addInventory(30); //개구리
                f2_35();
            }
        });
        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                f2_33();
            }
        });

    }
    public void f2_33(){
        allInvisible();
        player.setF2_choices(33);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        choice2 = findViewById(R.id.choice_no2); c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        choice1.setVisibility(View.VISIBLE);
        mainText.setText(getString(R.string.f2_33_1)); c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_33_1))) {
                    mainText.setText(getString(R.string.f2_33_2));
                    player.damage(); b42 = findViewById(R.id.b42); b42.setText(String.valueOf(player.getHeart()));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_33_2))){
                    mainText.setText(getString(R.string.f2_33_3));
                    choice1.setVisibility(View.INVISIBLE);
                    c21.setText(getString(R.string.f2_33c1));
                    c22.setText(getString(R.string.f2_33c2));
                    choice2.setVisibility(View.VISIBLE);
                }
            }
        });
        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                player.addInventory(29); //송어
                f2_35();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                player.addInventory(30); //개구리
                f2_35();
            }
        });
    }
    public void f2_34(){
        allInvisible();
        player.setF2_choices(34);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_34)); c11.setText(getString(R.string.f2_34c1));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                f2_28();
            }
        });
    }
    public void f2_35(){
        allInvisible();
        player.setF2_choices(35);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_35)); c11.setText(getString(R.string.f2_35c1));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                f2_28();
            }
        });
    }
    public void f2_36(){
        allInvisible();
        player.setF2_choices(36);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_36)); c11.setText(getString(R.string.f2_36c1));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                f2_28();
            }
        });
    }
    public void f2_37(){
        allInvisible();
        player.setF2_choices(37);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        if(!player.getF2_choices(38)) {
            choice3 = findViewById(R.id.choice_no3);
            c31 = findViewById(R.id.choice3_1); c32 = findViewById(R.id.choice3_2); c33 = findViewById(R.id.choice3_3);
        } else{
            choice3 = findViewById(R.id.choice_no2);
            c31 = findViewById(R.id.choice2_1); c32 = findViewById(R.id.choice2_2); c33 = findViewById(R.id.choice3_3);
        }
        c31.setText(getString(R.string.f2_37c1)); c32.setText(getString(R.string.f2_37c2)); c33.setText(getString(R.string.f2_37c3));

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                player.addInventory(24); //하얀 고체
                f2_35();
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                player.addInventory(25); //초록 섬유
                f2_35();
            }
        });
        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                f2_38(); //보라 액체
            }
        });
    }
    public void f2_38(){
        allInvisible();
        player.setF2_choices(33);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        choice2 = findViewById(R.id.choice_no2); c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        choice1.setVisibility(View.VISIBLE);
        mainText.setText(getString(R.string.f2_38_1)); c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_38_1))) {
                    mainText.setText(getString(R.string.f2_38_2));
                    player.damage(); b42 = findViewById(R.id.b42); b42.setText(String.valueOf(player.getHeart()));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_38_2))){
                    mainText.setText(getString(R.string.f2_38_3));
                    choice1.setVisibility(View.INVISIBLE);
                    c21.setText(getString(R.string.f2_38c1));
                    c22.setText(getString(R.string.f2_38c2));
                    choice2.setVisibility(View.VISIBLE);
                }
            }
        });
        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                player.addInventory(24); //하얀 고체
                f2_35();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                player.addInventory(25); //초록 섬유
                f2_35();
            }
        });
    }
    public void f2_39(){
        allInvisible();
        player.setF2_choices(39);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        choice1.setVisibility(View.VISIBLE);
        mainText.setText(getString(R.string.f2_39_1)); c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_39_1))) {
                    mainText.setText(getString(R.string.f2_39_2));
                    c11.setText(getString(R.string.f2_39c1));
                } else{
                    choice1.setVisibility(View.INVISIBLE);
                    f2_40();
                }
            }
        });
    }
    public void f2_40(){
        allInvisible();
        player.setF2_choices(40);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        choice1.setVisibility(View.VISIBLE);
        choice2 = findViewById(R.id.choice_no2); c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);

        mainText.setText(getString(R.string.f2_40_1)); c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_40_1))) {
                    mainText.setText(getString(R.string.f2_40_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_40_2))) {
                    mainText.setText(getString(R.string.f2_40_3));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_40_3))){
                    mainText.setText(getString(R.string.f2_40_4));
                    player.addInventory(14); //item : 잠드는 약 얻음.
                }else if(mainText.getText().toString().equals(getString(R.string.f2_40_4))){
                    choice1.setVisibility(View.INVISIBLE);
                    c21.setText(getString(R.string.f2_40c1)); c22.setText(getString(R.string.f2_40c2));
                    choice2.setVisibility(View.VISIBLE);
                }
            }
        });
        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f2_43();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f2_42();
            }
        });
    }
    public void f2_41(){
        allInvisible();
        player.setF2_choices(41);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        choice1.setVisibility(View.VISIBLE);
        mainText.setText(getString(R.string.f2_41_1)); c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_41_1))) {
                    mainText.setText(getString(R.string.f2_41_2));
                    c11.setText(getString(R.string.f2_41c1));
                } else{
                    choice1.setVisibility(View.INVISIBLE);
                    f2_40();
                }
            }
        });
    }
    public void f2_42(){
        allInvisible();
        player.setF2_choices(42);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        choice1.setVisibility(View.VISIBLE);
        mainText.setText(getString(R.string.f2_42_1)); c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_42_1))) {
                    mainText.setText(getString(R.string.f2_42_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_42_2))) {
                    mainText.setText(getString(R.string.f2_42_3));
                    c11.setText(getString(R.string.f2_42c1));
                } else{
                    choice1.setVisibility(View.INVISIBLE);
                    f2_43();
                }
            }
        });
    }
    public void f2_43(){
        allInvisible();
        player.setF2_choices(43);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice2 = findViewById(R.id.choice_no2); c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        choice2.setVisibility(View.VISIBLE);
        mainText.setText(getString(R.string.f2_43));
        c21.setText(getString(R.string.f2_43c1)); c22.setText(getString(R.string.f2_43c2));

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                if(!player.getF2_choices(44)){
                    f2_44();
                }else {
                    f2_46();
                }
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f2_45();
            }
        });
    }
    public void f2_44(){
        allInvisible();
        player.setF2_choices(44);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        choice1.setVisibility(View.VISIBLE);
        mainText.setText(getString(R.string.f2_44_1)); c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_44_1))) {
                    mainText.setText(getString(R.string.f2_44_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_44_2))) {
                    mainText.setText(getString(R.string.f2_44_3));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_44_3))) {
                    mainText.setText(getString(R.string.f2_44_4));
                    c11.setText(getString(R.string.f2_44c1));
                }  else{
                    choice1.setVisibility(View.INVISIBLE);
                    f2_43();
                }
            }
        });
    }
    public void f2_45(){
        allInvisible();
        player.setF2_choices(45);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_45_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_45_1))) {
                    mainText.setText(getString(R.string.f2_45_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_45_2))) {
                    choice1.setVisibility(View.INVISIBLE);
                    f2_28();
                }
            }
        });
    }
    public void f2_46(){
        allInvisible();
        player.setF2_choices(46);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_46)); c11.setText(getString(R.string.f2_46c1));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                f2_43();
            }
        });
    }
    public void f2_47(){
        allInvisible();
        player.setF2_choices(47);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice3 = findViewById(R.id.choice_no3); c31 = findViewById(R.id.choice3_1); c32 = findViewById(R.id.choice3_2); c33 = findViewById(R.id.choice3_3);
        c31.setText(getString(R.string.f2_47c1));  c32.setText(getString(R.string.f2_47c2));
        if(!player.isInventory(19)){ //보청기 아이템 여부
            c33.setText(getString(R.string.f2_47c3));
        } else {
            c33.setText(getString(R.string.f2_47c4));
        }
        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                f2_48();
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                f2_5();
            }
        });
        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                if(!player.isInventory(19)){ //보청기 아이템 여부
                    //c3의 경우
                    f2_58();
                } else { //c4
                    if(!player.getF2_choices(48)) {
                        f2_59();
                    } else{
                        f2_60();
                    }
                }
            }
        });
    }


    public void f2_48(){
        allInvisible();
        player.setF2_choices(48);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice2 = findViewById(R.id.choice_no2); c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        mainText.setText(getString(R.string.f2_48)); c21.setText(getString(R.string.f2_48c1)); c22.setText(getString(R.string.f2_48c2));
        choice2.setVisibility(View.VISIBLE);

        final int pass[] = new int[6]; //right = 1, left = 2; pass = 22111

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player.getCnt() < 5) {
                    player.setCnt();
                    pass[player.getCnt()] = 1;
                    if(player.getCnt() == 5){
                        choice2.setVisibility(View.INVISIBLE);
                        f2_pass(pass);
                    }
                }
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player.getCnt() < 5) {
                    player.setCnt();
                    pass[player.getCnt()] = 2;
                    if(player.getCnt() == 5){
                        choice2.setVisibility(View.INVISIBLE);
                        f2_pass(pass);
                    }
                }
            }
        });

    }
    //5번 다 돌린 경우 체크 하는 방식으로 구현
    public void f2_pass(int []pass){
        boolean flag = false;
        if(pass[1] == 2){
            if(pass[2] == 2){
                if(pass[3] == 1){
                    if(pass[4] == 1){
                        if(pass[5] == 1){
                            flag = true;
                            f2_50();
                        }
                    }
                }
            }
        }
        if(flag == false){
            f2_49();
        }
    }
    public void f2_49(){
        allInvisible();
        player.setF2_choices(49);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_49_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_49_1))) {
                    mainText.setText(getString(R.string.f2_49_2));
                    c11.setText(getString(R.string.f2_49c1));
                } else{
                    choice1.setVisibility(View.INVISIBLE);
                    f2_47();
                }
            }
        });
    }
    public void f2_50(){
        allInvisible();
        player.setF2_choices(50);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_50_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);

        player.setBook();  //책 공주 구출 완료!

        if(player.getF1_choices(13)){
            choice3 = findViewById(R.id.choice_no3);
            c31 = findViewById(R.id.choice3_1); c32 = findViewById(R.id.choice3_2); c33 = findViewById(R.id.choice3_3);
        } else{
            choice3 = findViewById(R.id.choice_no2);
            c31 = findViewById(R.id.choice2_1); c32 = findViewById(R.id.choice2_2); c33 = findViewById(R.id.choice3_3);
        }


        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_50_1))) {
                    mainText.setText(getString(R.string.f2_50_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_50_2))) {
                    mainText.setText(getString(R.string.f2_50_3));
                } else  if(mainText.getText().toString().equals(getString(R.string.f2_50_3))) {
                    mainText.setText(getString(R.string.f2_50_4));
                    choice1.setVisibility(View.INVISIBLE);
                    c31.setText(getString(R.string.f2_50c1)); c32.setText(getString(R.string.f2_50c2)); c33.setText(getString(R.string.f2_50c3));
                    choice3.setVisibility(View.VISIBLE);
                }

                //선택지 클릭 후:
                if(mainText.getText().toString().equals(getString(R.string.f2_50c1_1))) {
                    choice1.setVisibility(View.INVISIBLE);
                    f2_61();
                } else if(mainText.getText().toString().equals(getString(R.string.f2_50c3_1))) {
                    mainText.setText(getString(R.string.f2_50c3_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_50c3_2))) {
                    choice1.setVisibility(View.INVISIBLE);
                    f2_51();
                }

            }
        });

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                mainText.setText(getString(R.string.f2_50c1_1));
                c11.setText(getString(R.string.click));
                choice1.setVisibility(View.VISIBLE);
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                f2_62();
            }
        });
        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                mainText.setText(getString(R.string.f2_50c3_1));
                c11.setText(getString(R.string.click));
                choice1.setVisibility(View.VISIBLE);
            }
        });

    }

    public void f2_51(){
        allInvisible();
        player.setF2_choices(51);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_51_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_51_1))) {
                    mainText.setText(getString(R.string.f2_51_2));
                    c11.setText(getString(R.string.f2_51c1));
                } else{
                    choice1.setVisibility(View.INVISIBLE);
                    f2_5();
                }
            }
        });
    }
    public void f2_52(){
        allInvisible();
        player.setF2_choices(52);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_52_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_52_1))) {
                    mainText.setText(getString(R.string.f2_52_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_52_2))) {
                    mainText.setText(getString(R.string.f2_52_3));
                    c11.setText(getString(R.string.f2_52c1));
                } else{
                    choice1.setVisibility(View.INVISIBLE);
                    f2_55();
                }
            }
        });
    }
    public void f2_53(){
        allInvisible();
        player.setF2_choices(53);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_53_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_53_1))) {
                    mainText.setText(getString(R.string.f2_53_2));
                    c11.setText(getString(R.string.f2_53c1));
                } else if(c11.getText().toString().equals(getString(R.string.f2_53c1))) {
                    c11.setText(getString(R.string.f2_53c1_1));
                } else{
                    choice1.setVisibility(View.INVISIBLE);
                    f2_54();
                }
            }
        });
    }
    public void f2_54(){
        allInvisible();
        player.setF2_choices(54);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_54_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_54_1))) {
                    mainText.setText(getString(R.string.f2_54_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_54_2))) {
                    mainText.setText(getString(R.string.f2_54_3));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_54_3))) {
                    mainText.setText(getString(R.string.f2_54_4));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_54_4))) {
                    mainText.setText(getString(R.string.f2_54_5));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_54_5))) {
                    mainText.setText(getString(R.string.f2_54_6));
                    c11.setText(getString(R.string.f2_54c1));
                } else{
                    choice1.setVisibility(View.INVISIBLE);
                    f2_55();
                }
            }
        });
    }
    public void f2_55(){
        allInvisible();
        player.setF2_choices(55);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        mainText.setText(getString(R.string.f2_55));
        int c1 = 0, c2 = 0, c3 = 0, sumC = 0;
        if(player.isInventory(26)){ c1 = 1;}
        if((player.isInventory(27) || player.isInventory(28)) && !player.getF2_choices(52)){c2 = 1;}
        if((player.isInventory(27) || player.isInventory(28)) && player.getF2_choices(52)){c3 = 1;}
        sumC = c1 + c2 + c3;
        switch(sumC){
            case 0 :
                choice3 = findViewById(R.id.choice_no1); c31 = findViewById(R.id.choice1_1);
                c32 = findViewById(R.id.choice3_2); c33 = findViewById(R.id.choice3_3);
                c31.setText(getString(R.string.f2_55c4));
                break;
            case 1:
                choice3 = findViewById(R.id.choice_no1); c31 = findViewById(R.id.choice1_1);
                c32 = findViewById(R.id.choice3_2); c33 = findViewById(R.id.choice3_3);
                if(c1 == 1){ c31.setText(getString(R.string.f2_55c1));}
                else if(c2 == 1){ c31.setText(getString(R.string.f2_55c2));}
                else if(c3 == 1){ c31.setText(getString(R.string.f2_55c3));}
                break;
            case 2:
                choice3 = findViewById(R.id.choice_no2); c31 = findViewById(R.id.choice2_1);
                c32 = findViewById(R.id.choice2_2); c33 = findViewById(R.id.choice3_3);
                if(c1 == 1 && c2 == 1){
                    c31.setText(getString(R.string.f2_55c1));
                    c32.setText(getString(R.string.f2_55c2));
                } else if(c2 == 1 && c3 == 1){
                    c31.setText(getString(R.string.f2_55c2));
                    c32.setText(getString(R.string.f2_55c3));
                } else if(c3 == 1 && c1 == 1){
                    c31.setText(getString(R.string.f2_55c1));
                    c32.setText(getString(R.string.f2_55c3));
                }
                break;
            case 3:
                c31.setText(getString(R.string.f2_55c1));
                c32.setText(getString(R.string.f2_55c2));
                c33.setText(getString(R.string.f2_55c3));
                break;
        }
        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                f2_55go(c31.getText().toString());
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                f2_55go(c31.getText().toString());
            }
        });
        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f2_55go(c31.getText().toString());
            }
        });
    }
    public void f2_55go(final String txt){
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText = findViewById(R.id.main_text); choice1.setVisibility(View.VISIBLE);
        c11.setText(getString(R.string.click));
        if(txt.equals(getString(R.string.f2_55c1))){
            f2_56();
        } else  if(txt.equals(getString(R.string.f2_55c2))){
            f2_52();
        } else  if(txt.equals(getString(R.string.f2_55c3)) || txt.equals(getString(R.string.f2_55c4))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mainText.getText().toString().equals(getString(R.string.f2_55c3_1))
                            || (mainText.getText().toString().equals(getString(R.string.f2_55c4_1)))){
                        f2_1();
                    } else if(txt.equals(getString(R.string.f2_55c3))){
                        mainText.setText(getString(R.string.f2_55c3_1));
                    }else if(txt.equals(getString(R.string.f2_55c4))){
                        mainText.setText(getString(R.string.f2_55c4_1));
                    }
                }
            });
        } else {
            mainText.setText(getString(R.string.f2_100));
        }
    }
    public void f2_56(){
        allInvisible();
        player.setF2_choices(56);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_56_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_56_1))){
                    mainText.setText(getString(R.string.f2_56_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_56_2))){
                    mainText.setText(getString(R.string.f2_56_3));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_56_3))){
                    mainText.setText(getString(R.string.f2_56_4));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_56_4))){
                    mainText.setText(getString(R.string.f2_56_5));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_56_5))){
                    mainText.setText(getString(R.string.f2_56_6));
                    c11.setText(getString(R.string.f2_56c1));
                } else {
                    choice1.setVisibility(View.INVISIBLE);
                    f2_57();
                }
            }
        });
    }
    public void f2_57(){
        allInvisible();
        player.setF2_choices(57);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_57_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_57_1))){
                    mainText.setText(getString(R.string.f2_57_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_57_2))){
                    mainText.setText(getString(R.string.f2_57_3));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_57_3))){
                    mainText.setText(getString(R.string.f2_57_4));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_57_4))){
                    mainText.setText(getString(R.string.f2_57_5));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_57_5))){
                    mainText.setText(getString(R.string.f2_57_6));
                    c11.setText(getString(R.string.f2_57c1));
                } else {
                    choice1.setVisibility(View.INVISIBLE);
                    f2_2();
                }
            }
        });
    }
    public void f2_58(){
        allInvisible();
        player.setF2_choices(58);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_58)); c11.setText(getString(R.string.f2_58c1));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                f2_47();
            }
        });
    }
    public void f2_59(){
        allInvisible();
        player.setF2_choices(58);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_59)); c11.setText(getString(R.string.f2_59c1));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                f2_47();
            }
        });
    }
    public void f2_60(){
        allInvisible();
        player.setF2_choices(60);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_60_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_60_1))){
                    mainText.setText(getString(R.string.f2_60_2));
                    c11.setText(getString(R.string.f2_60c1));
                } else {
                    choice1.setVisibility(View.INVISIBLE);
                    f2_47();
                }
            }
        });
    }
    public void f2_61(){
        allInvisible();
        player.setF2_choices(61);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_61)); c11.setText(getString(R.string.f2_61c1));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                f2_63();
            }
        });
    }
    public void f2_62(){
        allInvisible();
        player.setF2_choices(62);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_62_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_62_1))){
                    mainText.setText(getString(R.string.f2_62_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_62_2))){
                    mainText.setText(getString(R.string.f2_62_3));
                    c11.setText(getString(R.string.f2_62c1));
                } else {
                    choice1.setVisibility(View.INVISIBLE);
                    f2_5();
                }
            }
        });
    }
    public void f2_63(){
        allInvisible();
        player.setF2_choices(63);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_63)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);

        if(player.getF1_choices(7)){
            choice3 = findViewById(R.id.choice_no3);
            c31 = findViewById(R.id.choice3_1); c32 = findViewById(R.id.choice3_2); c33 = findViewById(R.id.choice3_3);
        } else{
            choice3 = findViewById(R.id.choice_no2);
            c31 = findViewById(R.id.choice2_1); c32 = findViewById(R.id.choice2_2); c33 = findViewById(R.id.choice3_3);
        }


        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_63))) {
                    choice1.setVisibility(View.INVISIBLE);
                    choice3.setVisibility(View.VISIBLE);
                    c31.setText(getString(R.string.f2_63c1));
                    c32.setText(getString(R.string.f2_63c2));
                    c33.setText(getString(R.string.f2_63c3));
                }
                //선택지 클릭 후:
                if(mainText.getText().toString().equals(getString(R.string.f2_63c1_1))) {
                    choice1.setVisibility(View.INVISIBLE);
                    f2_61();
                } else if(mainText.getText().toString().equals(getString(R.string.f2_63c2_1))) {
                    choice1.setVisibility(View.INVISIBLE);
                    f2_62();
                } else if(mainText.getText().toString().equals(getString(R.string.f2_63c3_1))) {
                    mainText.setText(getString(R.string.f2_50c3_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_63c3_2))) {
                    choice1.setVisibility(View.INVISIBLE);
                    f2_51();
                }

            }
        });

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                mainText.setText(getString(R.string.f2_63c1_1));
                c11.setText(getString(R.string.click));
                choice1.setVisibility(View.VISIBLE);
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                mainText.setText(getString(R.string.f2_63c2_1));
                c11.setText(getString(R.string.click));
                choice1.setVisibility(View.VISIBLE);
            }
        });
        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                mainText.setText(getString(R.string.f2_63c3_1));
                c11.setText(getString(R.string.click));
                choice1.setVisibility(View.VISIBLE);
            }
        });
    }
    public void f2_64(){
        allInvisible();
        player.setF2_choices(64);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_64_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_64_1))){
                    mainText.setText(getString(R.string.f2_64_2));
                    c11.setText(getString(R.string.f2_62c1));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_62_2))){
                    choice1.setVisibility(View.INVISIBLE);
                    f2_1();
                }
            }
        });
    }
    public void f2_65(){
        allInvisible();
        player.setF2_choices(65);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        choice1.setVisibility(View.VISIBLE);

        int c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0, sumC = 0;
        if(!player.getF2_choices(92)){ c2 = 1;}
        if(player.getF2_choices(58) && !player.getF2_choices(73)){ c3 = 1;}
        if(player.getF1_choices(39) && !player.getF2_choices(75)){ c4 = 1;}
        if(!player.isInventory(4) && !player.getF2_choices(66) && !player.getF2_choices(81)
                && !player.getF2_choices(71) && !player.getF2_choices(70)){ c5 = 1; }
        if(!player.isInventory(10) && player.getF2_choices(26)){ c6 = 1;}
        sumC = c2 + c3 + c4 + c5 + c6;

        switch(sumC){
            case 0:
                choice6 = findViewById(R.id.choice_no1);
                c61 = findViewById(R.id.choice1_1); c62 = findViewById(R.id.choice6_2); c63 = findViewById(R.id.choice6_3);
                c64 = findViewById(R.id.choice6_4); c65 = findViewById(R.id.choice6_5); c66 = findViewById(R.id.choice6_6);
                c61.setText(getString(R.string.f2_65c1));
                break;
            case 1:
                choice6 = findViewById(R.id.choice_no2);
                c61 = findViewById(R.id.choice2_1); c62 = findViewById(R.id.choice2_2); c63 = findViewById(R.id.choice6_3);
                c64 = findViewById(R.id.choice6_4); c65 = findViewById(R.id.choice6_5); c66 = findViewById(R.id.choice6_6);
                c61.setText(getString(R.string.f2_65c1));
                if(c2 == 1){ c62.setText(getString(R.string.f2_65c2));}
                else if(c3 == 1){c62.setText(getString(R.string.f2_65c3));}
                else if(c4 == 1){c62.setText(getString(R.string.f2_65c4));}
                else if(c5 == 1){c62.setText(getString(R.string.f2_65c5));}
                else if(c6 == 1){c62.setText(getString(R.string.f2_65c6));}
                break;
            case 2:
                choice6 = findViewById(R.id.choice_no3);
                c61 = findViewById(R.id.choice3_1); c62 = findViewById(R.id.choice3_2); c63 = findViewById(R.id.choice3_3);
                c64 = findViewById(R.id.choice6_4); c65 = findViewById(R.id.choice6_5); c66 = findViewById(R.id.choice6_6);
                c61.setText(getString(R.string.f2_65c1));
                if(c2 == 1){
                    c62.setText(getString(R.string.f2_65c2));
                    if(c3 == 1){
                        c63.setText(getString(R.string.f2_65c3));
                    } else if(c4 == 1){
                        c63.setText(getString(R.string.f2_65c4));
                    } else if(c5 == 1){
                        c63.setText(getString(R.string.f2_65c5));
                    } else if(c6 == 1){
                        c63.setText(getString(R.string.f2_65c6));
                    }
                } else if(c3 == 1){
                    c62.setText(getString(R.string.f2_65c3));
                    if(c4 == 1){
                        c63.setText(getString(R.string.f2_65c4));
                    } else if(c5 == 1){
                        c63.setText(getString(R.string.f2_65c5));
                    } else if(c6 == 1){
                        c63.setText(getString(R.string.f2_65c6));
                    }
                } else if(c4 == 1){
                    c62.setText(getString(R.string.f2_65c4));
                    if(c5 == 1){
                        c63.setText(getString(R.string.f2_65c5));
                    } else if(c6 == 1){
                        c63.setText(getString(R.string.f2_65c6));
                    }
                } else{
                    c62.setText(getString(R.string.f2_65c5));
                    c63.setText(getString(R.string.f2_65c6));
                }
                break;
            case 3 :
                choice6 = findViewById(R.id.choice_no4);
                c61 = findViewById(R.id.choice4_1); c62 = findViewById(R.id.choice4_2); c63 = findViewById(R.id.choice4_3);
                c64 = findViewById(R.id.choice4_4); c65 = findViewById(R.id.choice6_5); c66 = findViewById(R.id.choice6_6);
                c61.setText(getString(R.string.f2_65c1));
                if(c2 == 1){
                    c62.setText(getString(R.string.f2_65c2));
                    if(c3 == 1){
                        c63.setText(getString(R.string.f2_65c3));
                        if(c4 == 1){
                            c64.setText(getString(R.string.f2_65c4)); //c2 c3 c4
                        }else if(c5 == 1){
                            c64.setText(getString(R.string.f2_65c5)); //c2 c3 c5
                        } else if(c6 == 1){
                            c64.setText(getString(R.string.f2_65c6)); //c2 c3 c6
                        }
                    } else if(c4 == 1){
                        c63.setText(getString(R.string.f2_65c4));
                        if(c5 == 1){
                            c64.setText(getString(R.string.f2_65c5)); //c2 c4 c5
                        } else if(c6 == 1){
                            c64.setText(getString(R.string.f2_65c6)); //c2 c4 c6
                        }
                    } else if(c5 == 1){
                        c63.setText(getString(R.string.f2_65c5)); //c2 c5 c6
                        c64.setText(getString(R.string.f2_65c6));
                    }
                } else if(c3 == 1){
                    c62.setText(getString(R.string.f2_65c3));
                    if(c4 == 1){
                        c63.setText(getString(R.string.f2_65c4));
                        if(c5 == 1){
                            c64.setText(getString(R.string.f2_65c5)); //c3 c4 c5
                        } else if(c6 == 1){
                            c64.setText(getString(R.string.f2_65c6)); //c3 c4 c6
                        }
                    } else if(c5 == 1){
                        c63.setText(getString(R.string.f2_65c5)); //c3 c5 c6
                        c64.setText(getString(R.string.f2_65c6));
                    }
                } else if(c4 == 1) {
                    c62.setText(getString(R.string.f2_65c4)); //c4 c5 c6
                    c63.setText(getString(R.string.f2_65c5));
                    c64.setText(getString(R.string.f2_65c6));
                }
                break;
            case 4:
                choice6 = findViewById(R.id.choice_no5);
                c61 = findViewById(R.id.choice5_1); c62 = findViewById(R.id.choice5_2); c63 = findViewById(R.id.choice5_3);
                c64 = findViewById(R.id.choice5_4); c65 = findViewById(R.id.choice5_5); c66 = findViewById(R.id.choice6_6);
                c61.setText(getString(R.string.f2_65c1));
                if(c2 == 0){
                    c62.setText(getString(R.string.f2_65c3)); c63.setText(getString(R.string.f2_65c4));
                    c64.setText(getString(R.string.f2_65c5)); c65.setText(getString(R.string.f2_65c6));
                } else if(c3 == 0){
                    c62.setText(getString(R.string.f2_65c2)); c63.setText(getString(R.string.f2_65c4));
                    c64.setText(getString(R.string.f2_65c5)); c65.setText(getString(R.string.f2_65c6));
                } else if(c4 == 0){
                    c62.setText(getString(R.string.f2_65c2)); c63.setText(getString(R.string.f2_65c3));
                    c64.setText(getString(R.string.f2_65c5)); c65.setText(getString(R.string.f2_65c6));
                } else if(c5 == 0){
                    c62.setText(getString(R.string.f2_65c2)); c63.setText(getString(R.string.f2_65c3));
                    c64.setText(getString(R.string.f2_65c4)); c65.setText(getString(R.string.f2_65c6));
                } else if(c6 == 0){
                    c62.setText(getString(R.string.f2_65c2)); c63.setText(getString(R.string.f2_65c3));
                    c64.setText(getString(R.string.f2_65c4)); c65.setText(getString(R.string.f2_65c5));
                }
                break;
            case 5 :
                choice6 = findViewById(R.id.choice_no6);
                c61 = findViewById(R.id.choice6_1); c62 = findViewById(R.id.choice6_2); c63 = findViewById(R.id.choice6_3);
                c64 = findViewById(R.id.choice6_4); c65 = findViewById(R.id.choice6_5); c66 = findViewById(R.id.choice6_6);
                c61.setText(getString(R.string.f2_65c1)); c62.setText(getString(R.string.f2_65c2));
                c63.setText(getString(R.string.f2_65c3)); c64.setText(getString(R.string.f2_65c4));
                c65.setText(getString(R.string.f2_65c5)); c66.setText(getString(R.string.f2_65c6));
                break;
        }


        mainText.setText(getString(R.string.f2_65_1)); c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText(getString(R.string.f2_65_2));
                choice1.setVisibility(View.INVISIBLE);
                choice6.setVisibility(View.VISIBLE);
            }
        });

        c61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice6.setVisibility(View.INVISIBLE);
                f2_69();
            }
        });
        c62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice6.setVisibility(View.INVISIBLE);
                f2_65go(c62.getText().toString());
            }
        });
        c63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice6.setVisibility(View.INVISIBLE);
                f2_65go(c63.getText().toString());
            }
        });
        c64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice6.setVisibility(View.INVISIBLE);
                f2_65go(c64.getText().toString());
            }
        });
        c65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice6.setVisibility(View.INVISIBLE);
                f2_65go(c65.getText().toString());
            }
        });
        c66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice6.setVisibility(View.INVISIBLE);
                f2_65go(c66.getText().toString());
            }
        });
    }
    public void f2_65go(String txt){
        if(txt.equals(getString(R.string.f2_65c2))){
            f2_92();
        } else  if(txt.equals(getString(R.string.f2_65c3))){
            f2_73();
        } else  if(txt.equals(getString(R.string.f2_65c4))){
            f2_75();
        } else if(txt.equals(getString(R.string.f2_65c5))){
            if(player.getF1_choices(2) && !player.getF1_choices(5)){
                f2_81();
            } else if(player.getF1_choices(31)){
                f2_82();
            } else{
                f2_66();
            }
        } else if(txt.equals(getString(R.string.f2_65c6))){
            f2_80();
        } else {
            mainText.setText(getString(R.string.f2_100));
        }
    }
    public void f2_66(){
        allInvisible();
        player.setF2_choices(66);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);

        if(player.isInventory(9)) { //바늘v
            choice2 = findViewById(R.id.choice_no2);
            c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
            c21.setText(getString(R.string.f2_66c1)); c22.setText(getString(R.string.f2_66c2));
        }else{
            choice2 = findViewById(R.id.choice_no1);
            c21 = findViewById(R.id.choice1_1); c22 = findViewById(R.id.choice2_2);
            c21.setText(getString(R.string.f2_66c1)); c22.setText(getString(R.string.f2_66c2));
        }


        mainText.setText(getString(R.string.f2_66_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_66_1))){
                    mainText.setText(getString(R.string.f2_66_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_66_2))){
                    mainText.setText(getString(R.string.f2_66_3));
                    player.addInventory(4); //item 하녀옷 획득
                } else if(mainText.getText().toString().equals(getString(R.string.f2_66_3))){
                    mainText.setText(getString(R.string.f2_66_4));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_66_4))){
                    mainText.setText(getString(R.string.f2_66_5));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_66_5))){
                    mainText.setText(getString(R.string.f2_66_6));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_66_6))){
                    mainText.setText(getString(R.string.f2_66_7));
                    choice1.setVisibility(View.INVISIBLE);
                    choice2.setVisibility(View.VISIBLE);
                }
            }
        });

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f2_69();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f2_71();
            }
        });
    }
    public void f2_67(){
        allInvisible();
        player.setF2_choices(67);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);

        if(player.isInventory(9)) { //바늘v
            choice2 = findViewById(R.id.choice_no2);
            c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
            c21.setText(getString(R.string.f2_67c1)); c22.setText(getString(R.string.f2_67c2));

            c21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    f2_68();
                }
            });
            c22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    f2_71();
                }
            });
        }

        mainText.setText(getString(R.string.f2_67_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_67_1))){
                    mainText.setText(getString(R.string.f2_67_2));
                    if(player.isInventory(9)){
                        choice2.setVisibility(View.VISIBLE);
                        choice1.setVisibility(View.INVISIBLE);
                    } else{
                        c11.setText(getString(R.string.f2_67c1));
                    }
                } else if(!player.isInventory(9) && mainText.getText().toString().equals(getString(R.string.f2_67_2))){
                    choice1.setVisibility(View.INVISIBLE);
                    f2_68();
                }
            }
        });


    }
    public void f2_68(){
        allInvisible();
        player.setF2_choices(68);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);

        mainText.setText(getString(R.string.f2_68_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_68_1))){
                    mainText.setText(getString(R.string.f2_68_2));
                    c11.setText(getString(R.string.f2_68c1));
                } else {
                    choice1.setVisibility(View.INVISIBLE);
                    f2_69();
                }
            }
        });
    }
    public void f2_69(){
        allInvisible();
        player.setF2_choices(69);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);

        mainText.setText(getString(R.string.f2_69_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_69_1))){
                    mainText.setText(getString(R.string.f2_69_2));
                } else {
                    choice1.setVisibility(View.INVISIBLE);
                    f2_3();
                }
            }
        });
    }
    ///
    public void f2_70(){
        allInvisible();
        player.setF2_choices(70);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);

        if(player.isInventory(9)) { //바늘v
            choice2 = findViewById(R.id.choice_no2);
            c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
            c21.setText(getString(R.string.f2_70c1)); c22.setText(getString(R.string.f2_70c2));

            c21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    f2_69();
                }
            });
            c22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    f2_71();
                }
            });
        }


        mainText.setText(getString(R.string.f2_70_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_70_1))){
                    mainText.setText(getString(R.string.f2_70_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_70_2))){
                    mainText.setText(getString(R.string.f2_70_3));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_70_3))){
                    mainText.setText(getString(R.string.f2_70_4));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_70_4))){
                    mainText.setText(getString(R.string.f2_70_5));

                    if(player.isInventory(9)) {
                        choice1.setVisibility(View.INVISIBLE);
                        choice2.setVisibility(View.VISIBLE);
                    }  else{
                        c11.setText(getString(R.string.f2_67c1));
                    }
                } else if(!player.isInventory(9) && mainText.getText().toString().equals(getString(R.string.f2_67_2))){
                    choice1.setVisibility(View.INVISIBLE);
                    f2_68();
                }
            }
        });

    }
    public void f2_71(){
        allInvisible();
        player.setF2_choices(71);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_71_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_71_1))){
                    mainText.setText(getString(R.string.f2_71_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_71_2))){
                    mainText.setText(getString(R.string.f2_71_3));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_71_3))){
                    mainText.setText(getString(R.string.f2_71_4));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_71_4))){
                    mainText.setText(getString(R.string.f2_71_5));
                    player.addInventory(13); //수선 드레스
                    player.removeInventory(9); //바늘 x
                } else if(mainText.getText().toString().equals(getString(R.string.f2_71_5))){
                    mainText.setText(getString(R.string.f2_71_6));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_71_6))){
                    mainText.setText(getString(R.string.f2_71_7));
                    c11.setText(getString(R.string.f2_71c1));
                } else {
                    choice1.setVisibility(View.INVISIBLE);
                    f2_72();
                }
            }
        });
    }
    public void f2_72(){
        allInvisible();
        player.setF2_choices(72);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        choice1.setVisibility(View.VISIBLE);

        int c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0, sumC = 0;
        if(!player.getF2_choices(92)){ c2 = 1;}
        if(player.getF2_choices(58) && !player.getF2_choices(73)){ c3 = 1;}
        if(player.getF1_choices(39) && !player.getF2_choices(75)){ c4 = 1;}
        if(!player.isInventory(4) && !player.getF2_choices(66) && !player.getF2_choices(81)
                && !player.getF2_choices(71) && !player.getF2_choices(70)){ c5 = 1; }
        if(!player.isInventory(10) && player.getF2_choices(26)){ c6 = 1;}
        sumC = c2 + c3 + c4 + c5 + c6;

        switch(sumC){
            case 0:
                choice6 = findViewById(R.id.choice_no1);
                c61 = findViewById(R.id.choice1_1); c62 = findViewById(R.id.choice6_2); c63 = findViewById(R.id.choice6_3);
                c64 = findViewById(R.id.choice6_4); c65 = findViewById(R.id.choice6_5); c66 = findViewById(R.id.choice6_6);
                c61.setText(getString(R.string.f2_72c1));
                break;
            case 1:
                choice6 = findViewById(R.id.choice_no2);
                c61 = findViewById(R.id.choice2_1); c62 = findViewById(R.id.choice2_2); c63 = findViewById(R.id.choice6_3);
                c64 = findViewById(R.id.choice6_4); c65 = findViewById(R.id.choice6_5); c66 = findViewById(R.id.choice6_6);
                c61.setText(getString(R.string.f2_72c1));
                if(c2 == 1){ c62.setText(getString(R.string.f2_72c2));}
                else if(c3 == 1){c62.setText(getString(R.string.f2_72c3));}
                else if(c4 == 1){c62.setText(getString(R.string.f2_72c4));}
                else if(c5 == 1){c62.setText(getString(R.string.f2_72c5));}
                else if(c6 == 1){c62.setText(getString(R.string.f2_72c6));}
                break;
            case 2:
                choice6 = findViewById(R.id.choice_no3);
                c61 = findViewById(R.id.choice3_1); c62 = findViewById(R.id.choice3_2); c63 = findViewById(R.id.choice3_3);
                c64 = findViewById(R.id.choice6_4); c65 = findViewById(R.id.choice6_5); c66 = findViewById(R.id.choice6_6);
                c61.setText(getString(R.string.f2_72c1));
                if(c2 == 1){
                    c62.setText(getString(R.string.f2_72c2));
                    if(c3 == 1){
                        c63.setText(getString(R.string.f2_72c3));
                    } else if(c4 == 1){
                        c63.setText(getString(R.string.f2_72c4));
                    } else if(c5 == 1){
                        c63.setText(getString(R.string.f2_72c5));
                    } else if(c6 == 1){
                        c63.setText(getString(R.string.f2_72c6));
                    }
                } else if(c3 == 1){
                    c62.setText(getString(R.string.f2_72c3));
                    if(c4 == 1){
                        c63.setText(getString(R.string.f2_72c4));
                    } else if(c5 == 1){
                        c63.setText(getString(R.string.f2_72c5));
                    } else if(c6 == 1){
                        c63.setText(getString(R.string.f2_72c6));
                    }
                } else if(c4 == 1){
                    c62.setText(getString(R.string.f2_72c4));
                    if(c5 == 1){
                        c63.setText(getString(R.string.f2_72c5));
                    } else if(c6 == 1){
                        c63.setText(getString(R.string.f2_72c6));
                    }
                } else{
                    c62.setText(getString(R.string.f2_72c5));
                    c63.setText(getString(R.string.f2_72c6));
                }
                break;
            case 3 :
                choice6 = findViewById(R.id.choice_no4);
                c61 = findViewById(R.id.choice4_1); c62 = findViewById(R.id.choice4_2); c63 = findViewById(R.id.choice4_3);
                c64 = findViewById(R.id.choice4_4); c65 = findViewById(R.id.choice6_5); c66 = findViewById(R.id.choice6_6);
                c61.setText(getString(R.string.f2_72c1));
                if(c2 == 1){
                    c62.setText(getString(R.string.f2_72c2));
                    if(c3 == 1){
                        c63.setText(getString(R.string.f2_72c3));
                        if(c4 == 1){
                            c64.setText(getString(R.string.f2_72c4)); //c2 c3 c4
                        }else if(c5 == 1){
                            c64.setText(getString(R.string.f2_72c5)); //c2 c3 c5
                        } else if(c6 == 1){
                            c64.setText(getString(R.string.f2_72c6)); //c2 c3 c6
                        }
                    } else if(c4 == 1){
                        c63.setText(getString(R.string.f2_72c4));
                        if(c5 == 1){
                            c64.setText(getString(R.string.f2_72c5)); //c2 c4 c5
                        } else if(c6 == 1){
                            c64.setText(getString(R.string.f2_72c6)); //c2 c4 c6
                        }
                    } else if(c5 == 1){
                        c63.setText(getString(R.string.f2_72c5)); //c2 c5 c6
                        c64.setText(getString(R.string.f2_72c6));
                    }
                } else if(c3 == 1){
                    c62.setText(getString(R.string.f2_72c3));
                    if(c4 == 1){
                        c63.setText(getString(R.string.f2_72c4));
                        if(c5 == 1){
                            c64.setText(getString(R.string.f2_72c5)); //c3 c4 c5
                        } else if(c6 == 1){
                            c64.setText(getString(R.string.f2_72c6)); //c3 c4 c6
                        }
                    } else if(c5 == 1){
                        c63.setText(getString(R.string.f2_72c5)); //c3 c5 c6
                        c64.setText(getString(R.string.f2_72c6));
                    }
                } else if(c4 == 1) {
                    c62.setText(getString(R.string.f2_72c4)); //c4 c5 c6
                    c63.setText(getString(R.string.f2_72c5));
                    c64.setText(getString(R.string.f2_72c6));
                }
                break;
            case 4:
                choice6 = findViewById(R.id.choice_no5);
                c61 = findViewById(R.id.choice5_1); c62 = findViewById(R.id.choice5_2); c63 = findViewById(R.id.choice5_3);
                c64 = findViewById(R.id.choice5_4); c65 = findViewById(R.id.choice5_5); c66 = findViewById(R.id.choice6_6);
                c61.setText(getString(R.string.f2_72c1));
                if(c2 == 0){
                    c62.setText(getString(R.string.f2_72c3)); c63.setText(getString(R.string.f2_72c4));
                    c64.setText(getString(R.string.f2_72c5)); c65.setText(getString(R.string.f2_72c6));
                } else if(c3 == 0){
                    c62.setText(getString(R.string.f2_72c2)); c63.setText(getString(R.string.f2_72c4));
                    c64.setText(getString(R.string.f2_72c5)); c65.setText(getString(R.string.f2_72c6));
                } else if(c4 == 0){
                    c62.setText(getString(R.string.f2_72c2)); c63.setText(getString(R.string.f2_72c3));
                    c64.setText(getString(R.string.f2_72c5)); c65.setText(getString(R.string.f2_72c6));
                } else if(c5 == 0){
                    c62.setText(getString(R.string.f2_72c2)); c63.setText(getString(R.string.f2_72c3));
                    c64.setText(getString(R.string.f2_72c4)); c65.setText(getString(R.string.f2_72c6));
                } else if(c6 == 0){
                    c62.setText(getString(R.string.f2_72c2)); c63.setText(getString(R.string.f2_72c3));
                    c64.setText(getString(R.string.f2_72c4)); c65.setText(getString(R.string.f2_72c5));
                }
                break;
            case 5 :
                choice6 = findViewById(R.id.choice_no6);
                c61 = findViewById(R.id.choice6_1); c62 = findViewById(R.id.choice6_2); c63 = findViewById(R.id.choice6_3);
                c64 = findViewById(R.id.choice6_4); c65 = findViewById(R.id.choice6_5); c66 = findViewById(R.id.choice6_6);
                c61.setText(getString(R.string.f2_72c1)); c62.setText(getString(R.string.f2_72c2));
                c63.setText(getString(R.string.f2_72c3)); c64.setText(getString(R.string.f2_72c4));
                c65.setText(getString(R.string.f2_72c5)); c66.setText(getString(R.string.f2_72c6));
                break;
        }


        mainText.setText(getString(R.string.f2_72_1)); c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText(getString(R.string.f2_72_2));
                choice1.setVisibility(View.INVISIBLE);
                choice6.setVisibility(View.VISIBLE);
            }
        });

        c61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice6.setVisibility(View.INVISIBLE);
                f2_69();
            }
        });
        c62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice6.setVisibility(View.INVISIBLE);
                f2_72go(c62.getText().toString());
            }
        });
        c63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice6.setVisibility(View.INVISIBLE);
                f2_72go(c63.getText().toString());
            }
        });
        c64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice6.setVisibility(View.INVISIBLE);
                f2_72go(c64.getText().toString());
            }
        });
        c65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice6.setVisibility(View.INVISIBLE);
                f2_72go(c65.getText().toString());
            }
        });
        c66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice6.setVisibility(View.INVISIBLE);
                f2_72go(c66.getText().toString());
            }
        });
    }
    public void f2_72go(String txt){
        if(txt.equals(getString(R.string.f2_72c2))){
            f2_92();
        } else  if(txt.equals(getString(R.string.f2_72c3))){
            f2_73();
        } else  if(txt.equals(getString(R.string.f2_72c4))){
            f2_75();
        } else if(txt.equals(getString(R.string.f2_72c5))){
            if(player.getF1_choices(2) && !player.getF1_choices(5)){
                f2_81();
            } else if(player.getF1_choices(31)){
                f2_82();
            } else{
                f2_66();
            }
        } else if(txt.equals(getString(R.string.f2_72c6))){
            f2_80();
        } else {
            mainText.setText(getString(R.string.f2_100));
        }
    }
    public void f2_73(){
        allInvisible();
        player.setF2_choices(73);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_73_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_73_1))) {
                    mainText.setText(getString(R.string.f2_73_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_73_2))) {
                    mainText.setText(getString(R.string.f2_73_3));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_73_3))) {
                    mainText.setText(getString(R.string.f2_73_4));
                    player.addInventory(19);
                    c11.setText(getString(R.string.f2_73c1));
                } else{
                    choice1.setVisibility(View.INVISIBLE);
                    f2_69();
                }
            }
        });
    }
    public void f2_74(){
        allInvisible();
        player.setF2_choices(74);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_74_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_74_1))) {
                    mainText.setText(getString(R.string.f2_74_2));
                    c11.setText(getString(R.string.f2_74c1));
                } else{
                    choice1.setVisibility(View.INVISIBLE);
                    f2_72();
                }
            }
        });
    }
    public void f2_75(){
        allInvisible();
        player.setF2_choices(75);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_75_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_75_1))) {
                    mainText.setText(getString(R.string.f2_75_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_75_2))) {
                    mainText.setText(getString(R.string.f2_75_3));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_75_3))) {
                    mainText.setText(getString(R.string.f2_75_4));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_75_4))) {
                    mainText.setText(getString(R.string.f2_75_5));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_75_5))) {
                    mainText.setText(getString(R.string.f2_75_6));
                    c11.setText(getString(R.string.f2_75c1));
                } else{
                    choice1.setVisibility(View.INVISIBLE);
                    f2_72();
                }
            }
        });
    }

    public void f2_76(){
        allInvisible();
        player.setF2_choices(76);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        mainText.setText(getString(R.string.f2_76));

        if(!player.isInventory(20) || (!player.isInventory(19) && !player.getF2_choices(74))){
            if(!player.isInventory(20) && (!player.isInventory(19) && !player.getF2_choices(74))){
                choice3 = findViewById(R.id.choice_no3);
                c31 = findViewById(R.id.choice3_1); c32 = findViewById(R.id.choice3_2); c33 = findViewById(R.id.choice3_3);
                c31.setText(R.string.f2_76c1);  c32.setText(R.string.f2_76c2);  c33.setText(R.string.f2_76c3);
            } else {
                if(!player.isInventory(20)){
                    choice3 = findViewById(R.id.choice_no2);
                    c31 = findViewById(R.id.choice2_1); c32 = findViewById(R.id.choice2_2); c33 = findViewById(R.id.choice3_3);
                    c31.setText(R.string.f2_76c1);  c32.setText(R.string.f2_76c2);
                } else if(!player.getF2_choices(74) && !player.isInventory(19)) {
                    choice3 = findViewById(R.id.choice_no2);
                    c31 = findViewById(R.id.choice2_1); c32 = findViewById(R.id.choice2_2); c33 = findViewById(R.id.choice3_3);
                    c31.setText(R.string.f2_76c1);  c32.setText(R.string.f2_76c3);
                }
            }
        } else{
            choice3 = findViewById(R.id.choice_no1);
            c31 = findViewById(R.id.choice1_1); c32 = findViewById(R.id.choice3_2); c33 = findViewById(R.id.choice3_3);
            c31.setText(R.string.f2_76c1);
        }

        choice3.setVisibility(View.VISIBLE);
        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                f2_1();
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                if(!player.isInventory(20)){
                    f2_78();
                }else {
                    f2_77();
                }
            }
        });
        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                f2_77();
            }
        });
    }
    public void f2_77(){
        allInvisible();
        player.setF2_choices(77);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_77)); c11.setText(getString(R.string.f2_77c1));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                player.addInventory(19); //보청기v
                f2_76();
            }
        });
    }
    public void f2_78(){
        allInvisible();
        player.setF2_choices(78);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_78)); c11.setText(getString(R.string.f2_78c1));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                player.addInventory(20); //서랍열쇠v
                f2_76();
            }
        });
    }
    public void f2_79(){
        allInvisible();
        player.setF2_choices(79);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice2 = findViewById(R.id.choice_no2); c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        mainText.setText(getString(R.string.f2_79)); c21.setText(getString(R.string.f2_79c1)); c22.setText(getString(R.string.f2_79c2));
        choice2.setVisibility(View.VISIBLE);
        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                //mainText.setText("구현 아직 안했....");
                f3_0();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                //Intent intent = new Intent(getApplicationContext(), subActivity_f1.class);
                //intent.putExtra("player", player);
                //intent.putExtra("floor", 2);
                //startActivity(intent);
                //finish();
                f1_13();
            }
        });
    }
    public void f2_80(){
        allInvisible();
        player.setF2_choices(80);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_80_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_80_1))){
                    mainText.setText(getString(R.string.f2_80_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_80_2))){
                    mainText.setText(getString(R.string.f2_80_3));
                    player.addInventory(10); //밧줄v
                    c11.setText(getString(R.string.f2_80c1));
                } else{
                    choice1.setVisibility(View.INVISIBLE);
                    f2_72();
                }
            }
        });
    }

    public void f2_81(){
        allInvisible();
        player.setF2_choices(81);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_81_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_81_1))){
                    mainText.setText(getString(R.string.f2_81_2));
                    c11.setText(getString(R.string.f2_81c1));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_80_2))){
                    choice1.setVisibility(View.INVISIBLE);
                    f2_72();
                }
            }
        });
    }
    public void f2_82(){
        allInvisible();
        player.setF2_choices(82);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_82_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_82_1))){
                    mainText.setText(getString(R.string.f2_82_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_82_2))){
                    mainText.setText(getString(R.string.f2_82_3));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_82_3))){
                    mainText.setText(getString(R.string.f2_82_4));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_82_4))){
                    mainText.setText(getString(R.string.f2_82_5));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_82_5))){
                    mainText.setText(getString(R.string.f2_82_6));
                    c11.setText(getString(R.string.f2_82c1));
                } else{
                    choice1.setVisibility(View.INVISIBLE);
                    f2_69();
                }
            }
        });
    }
    public void f2_83(){
        allInvisible();
        player.setF2_choices(83);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_83)); c11.setText(getString(R.string.f2_83c1));
        choice1.setVisibility(View.VISIBLE); player.addInventory(18);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                f2_4();
            }
        });
    }
    public void f2_84(){
        allInvisible();
        player.setF2_choices(84);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_84)); c11.setText(getString(R.string.f2_84c1));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                f2_4();
            }
        });
    }
    public void f2_85(){
        allInvisible();
        player.setF2_choices(85);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_85)); c11.setText(getString(R.string.f2_85c1));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                f2_4();
            }
        });
    }
    public void f2_86(){
        allInvisible();
        player.setF2_choices(86);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_86)); c11.setText(getString(R.string.f2_86c1));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                f2_4();
            }
        });
    }
    public void f2_87(){
        allInvisible();
        player.setF2_choices(87);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_87_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_87_1))){
                    mainText.setText(getString(R.string.f2_87_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_87_2))){
                    mainText.setText(getString(R.string.f2_87_3));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_87_3))){
                    mainText.setText(getString(R.string.f2_87_4));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_87_4))){
                    mainText.setText(getString(R.string.f2_87_5));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_87_5))){
                    mainText.setText(getString(R.string.f2_87_6));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_87_6))){
                    mainText.setText(getString(R.string.f2_87_7));
                    c11.setText(getString(R.string.f2_87c1));
                } else {
                    choice1.setVisibility(View.INVISIBLE);
                    f2_4();
                }
            }
        });
    }
    public void f2_88(){
        allInvisible();
        player.setF2_choices(88);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_88)); c11.setText(getString(R.string.f2_88c1));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                f2_4();
            }
        });
    }
    public void f2_89(){
        allInvisible();
        player.setF2_choices(89);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_89)); c11.setText(getString(R.string.f2_89c1));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                f2_28();
            }
        });
    }
    public void f2_90(){
        allInvisible();
        player.setF2_choices(90);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_90)); c11.setText(getString(R.string.f2_90c1));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                f2_28();
            }
        });
    }
    public void f2_91(){
        allInvisible();
        player.setF2_choices(91);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_91_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);

        if(!player.getB1_choices(23) || !player.getF2_choices(50) || (!player.getB1_choices(23) && !player.getF2_choices(50))){
            choice3 = findViewById(R.id.choice_no3);
            c31 = findViewById(R.id.choice3_1); c32 = findViewById(R.id.choice3_2); c33 = findViewById(R.id.choice3_3);
        } else {
            choice3 = findViewById(R.id.choice_no2);
            c31 = findViewById(R.id.choice2_1); c32 = findViewById(R.id.choice2_2); c33 = findViewById(R.id.choice3_3);
        }
        c31.setText(getString(R.string.f2_91c1)); c32.setText(getString(R.string.f2_91c2)); c33.setText(getString(R.string.f2_91c3));

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_91_1))){
                    mainText.setText(getString(R.string.f2_91_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_91_2))){
                    mainText.setText(getString(R.string.f2_91_3));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_91_3))){
                    mainText.setText(getString(R.string.f2_91_4));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_91_4))){
                    mainText.setText(getString(R.string.f2_91_5));
                    choice1.setVisibility(View.INVISIBLE);
                    choice3.setVisibility(View.VISIBLE);
                }
            }
        });
        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                f2_7();
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                if(!player.getF2_choices(15)){
                    f2_15();
                } else{
                    f2_16();
                }
            }
        });
        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                f2_12();
            }
        });
    }
    public void f2_92(){
        allInvisible();
        player.setF2_choices(92);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_92_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_92_1))){
                    mainText.setText(getString(R.string.f2_92_2));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_92_2))){
                    mainText.setText(getString(R.string.f2_92_3));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_92_3))){
                    mainText.setText(getString(R.string.f2_92_4));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_92_4))){
                    mainText.setText(getString(R.string.f2_92_5));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_92_5))){
                    mainText.setText(getString(R.string.f2_92_6));
                } else if(mainText.getText().toString().equals(getString(R.string.f2_92_6))){
                    mainText.setText(getString(R.string.f2_92_7));
                    c11.setText(getString(R.string.f2_92c1));
                } else {
                    choice1.setVisibility(View.INVISIBLE);
                    f2_72();
                }
            }
        });
    }
    public void f2_93(){
        allInvisible();
        player.setF2_choices(93);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_93_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainText.getText().toString().equals(getString(R.string.f2_93_1))){
                    mainText.setText(getString(R.string.f2_93_2));
                    c11.setText(getString(R.string.f2_93c1));
                } else {
                    choice1.setVisibility(View.INVISIBLE);
                    //구현x :  4-33으로 이동, 옥상 구현 후 intent에 putExtra로 4-33으로 이동하는 변수를 넣어 보내자!
                    // ~도망엔딩~
                }
            }
        });
    }

    public void f2_100(){
        allInvisible();
        mainText = findViewById(R.id.main_text);
        mainText.setText(getString(R.string.f2_100));
    }

    //지하 1층 시작
    public void b1_1(){
        allInvisible();
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

                //Intent intent = new Intent(getApplicationContext(), subActivity_f1.class);
                //intent.putExtra("player", player);
                //startActivity(intent);
                //finish();
                f1_13();
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
        allInvisible();
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

                b1_10();
            }
        });
        c44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                b1_14();
            }
        });
    }

    public void b1_3(){
        allInvisible();
        player.setB1_choices(3);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_3a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_3a))
                {
                    mainText.setText(R.string.b1_3b);
                    c11.setText(R.string.b1_3_1);
                }
                else
                {
                    choice1.setVisibility(View.INVISIBLE);

                    if (player.getB1_choices(15))
                    {
                        b1_12();
                    }
                    else
                    {
                        b1_2();
                    }
                }
            }
        });
    }

    public void b1_4() {
        allInvisible();
        player.setB1_choices(4);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_4a);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_4a))
                {
                    mainText.setText(R.string.b1_4b);
                }
                else if (mainText.getText().toString().equals(R.string.b1_4b))
                {
                    mainText.setText(R.string.b1_4c);
                }
                else
                {
                    if (player.getType() == 2)
                    {
                        mainText.setText(R.string.b1_31);
                    }
                    else if (player.getType() == 1)
                    {
                        mainText.setText(R.string.b1_32);
                    }
                    else
                    {
                        mainText.setText(R.string.b1_33);
                    }

                    if (player.getF2_choices(42)) {
                        choice1.setVisibility(View.INVISIBLE);
                        choice3 = findViewById(R.id.choice_no2);
                        choice3.setVisibility(View.VISIBLE);
                        c31 = findViewById(R.id.choice2_1);
                        c33 = findViewById(R.id.choice2_2);

                        c31.setText(R.string.b1_4_1);
                        c32.setText(R.string.b1_4_3);
                    }
                    else if (player.getType() == 1)
                    {
                        choice1.setVisibility(View.INVISIBLE);
                        choice3 = findViewById(R.id.choice_no2);
                        choice3.setVisibility(View.VISIBLE);
                        c32 = findViewById(R.id.choice2_1);
                        c33 = findViewById(R.id.choice2_2);

                        c21.setText(R.string.b1_4_2);
                        c22.setText(R.string.b1_4_3);
                    }
                    else
                    {
                        choice1.setVisibility(View.INVISIBLE);
                        choice3 = findViewById(R.id.choice_no1);
                        choice3.setVisibility(View.VISIBLE);
                        c33 = findViewById(R.id.choice1_1);

                        c33.setText(R.string.b1_4_3);
                    }
                }
            }
        });

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_3();
            }
        });

        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_30();
            }
        });

        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                if (player.getB1_choices(15))
                    b1_12();
                else
                    b1_2();
            }
        });
    }

    public void b1_5() {
        allInvisible();
        player.setB1_choices(5);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_5a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_5a))
                {
                    mainText.setText(R.string.b1_5b);
                }
                else if (mainText.getText().toString().equals(R.string.b1_5b))
                {
                    mainText.setText(R.string.b1_5c);
                    c11.setText(R.string.b1_5_1);
                }
                else
                {
                    choice1.setVisibility(View.INVISIBLE);

                    b1_13();
                }
            }
        });

    }

    public void b1_24()
    {
        allInvisible();
        player.setB1_choices(24);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_24a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_24a))
                {
                    mainText.setText(R.string.b1_24b);
                }
                else if (mainText.getText().toString().equals(R.string.b1_24b))
                {
                    mainText.setText(R.string.b1_24c);
                    c11.setText(R.string.b1_24_1);
                }
                else
                {
                    choice1.setVisibility(View.INVISIBLE);

                    b1_13();
                }
            }
        });

    }

    public void b1_6() {
        allInvisible();
        player.setB1_choices(6);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_6a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_6a))
                {
                    mainText.setText(R.string.b1_6b);
                }
                else
                {
                    choice1.setVisibility(View.INVISIBLE);

                    b1_2();
                }
            }
        });

    }

    public void b1_7() {
        allInvisible();
        player.setB1_choices(7);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        mainText.setText(R.string.b1_7);

        if (player.getB1_choices(13) && (player.getF1_choices(17) || player.getF1_choices(33)))
        {
            choice3 = findViewById(R.id.choice_no3);
            choice3.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice3_1);
            c32 = findViewById(R.id.choice3_2);
            c33 = findViewById(R.id.choice3_3);

            c31.setText(R.string.b1_7_1);
            c32.setText(R.string.b1_7_2);
            c33.setText(R.string.b1_7_3);
        }
        else if (player.getB1_choices(13))
        {
            choice3 = findViewById(R.id.choice_no2);
            choice3.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice2_1);
            c32 = findViewById(R.id.choice2_2);

            c31.setText(R.string.b1_7_1);
            c33.setText(R.string.b1_7_3);
        }
        else if (player.getF1_choices(17) || player.getF1_choices(33))
        {
            choice3 = findViewById(R.id.choice_no2);
            choice3.setVisibility(View.VISIBLE);
            c32 = findViewById(R.id.choice2_1);
            c33 = findViewById(R.id.choice2_2);

            c32.setText(R.string.b1_7_2);
            c33.setText(R.string.b1_7_3);
        }
        else
        {
            choice3 = findViewById(R.id.choice_no1);
            choice3.setVisibility(View.VISIBLE);
            c33 = findViewById(R.id.choice1_1);

            c33.setText(R.string.b1_7_3);
        }

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                b1_25();
            }
        });

        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                b1_15();
            }
        });

        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                b1_6();
            }
        });

    }

    public void b1_8() {
        allInvisible();
        player.setB1_choices(8);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_8a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_8a))
                {
                    mainText.setText(R.string.b1_8b);
                    c11.setText(R.string.b1_8_1);
                }
                else
                {
                    choice1.setVisibility(View.INVISIBLE);

                    if (player.getB1_choices(37))
                        b1_44();
                    else
                        b1_12();
                }
            }
        });

    }

    public void b1_9() {
        allInvisible();
        player.setB1_choices(9);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        c33 = findViewById(R.id.choice3_3);

        mainText.setText(R.string.b1_9);

        if (((player.getF1_choices(34) || player.getF1_choices(55)) && player.isInventory(5) == false && player.getF1_choices(35) == false && player.getF1_choices(36) == false && player.getF1_choices(33) == false) && (player.getF1_choices(17) || player.getF1_choices(33)))
        {
            choice3 = findViewById(R.id.choice_no3);
            choice3.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice3_1);
            c32 = findViewById(R.id.choice3_2);
            c33 = findViewById(R.id.choice3_3);

            c31.setText(R.string.b1_9_1);
            c32.setText(R.string.b1_9_2);
            c33.setText(R.string.b1_9_3);
        }
        else if ((player.getF1_choices(34) || player.getF1_choices(55)) && player.isInventory(5) == false && player.getF1_choices(35) == false && player.getF1_choices(36) == false && player.getF1_choices(33) == false)
        {
            choice3 = findViewById(R.id.choice_no2);
            choice3.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice2_1);
            c32 = findViewById(R.id.choice2_2);

            c31.setText(R.string.b1_9_1);
            c32.setText(R.string.b1_9_2);
        }
        else if (player.getF1_choices(17) || player.getF1_choices(33))
        {
            choice3 = findViewById(R.id.choice_no2);
            choice3.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice2_1);
            c33 = findViewById(R.id.choice2_2);

            c31.setText(R.string.b1_9_1);
            c33.setText(R.string.b1_9_3);
        }
        else
        {
            choice3 = findViewById(R.id.choice_no1);
            choice3.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice1_1);

            c31.setText(R.string.b1_9_1);
        }

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                if (player.getB1_choices(37))
                {
                    b1_44();
                }
                else
                {
                    b1_12();
                }
            }
        });

        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_18();
            }
        });

        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_26();
            }
        });
    }

    public void b1_10()
    {
        allInvisible();
        player.setB1_choices(10);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_10);
        c11.setText(R.string.b1_10);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                if (player.getB1_choices(37))
                {
                    b1_44();
                }
                else
                {
                    b1_2();
                }
            }
        });
    }

    public void b1_11()
    {
        allInvisible();
        player.setB1_choices(11);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        mainText.setText(R.string.b1_11);

        if (!player.getB1_choices(35))
        {
            if (player.getB1_choices(19) || player.getB1_choices(26))
            {
                if ((player.getB1_choices(3) || player.getB1_choices(30)) && !player.getB1_choices(22))
                {
                    choice5 = findViewById(R.id.choice_no4);
                    c51 = findViewById(R.id.choice4_1);
                    c52 = findViewById(R.id.choice4_2);
                    c54 = findViewById(R.id.choice4_3);
                    c55 = findViewById(R.id.choice4_4);

                    c51.setText(R.string.b1_11_1);
                    c52.setText(R.string.b1_11_2);
                    c54.setText(R.string.b1_11_4);
                    c55.setText(R.string.b1_11_5);
                }
                else
                {
                    choice5 = findViewById(R.id.choice_no3);
                    c51 = findViewById(R.id.choice3_1);
                    c52 = findViewById(R.id.choice3_2);
                    c55 = findViewById(R.id.choice3_3);

                    c51.setText(R.string.b1_11_1);
                    c52.setText(R.string.b1_11_2);
                    c55.setText(R.string.b1_11_5);
                }
            }
            else if (!player.getB1_choices(19) && !player.getB1_choices(26) && player.getB1_choices(22))
            {
                if ((player.getB1_choices(3) || player.getB1_choices(30)) && !player.getB1_choices(22))
                {
                    choice5 = findViewById(R.id.choice_no4);
                    c51 = findViewById(R.id.choice4_1);
                    c53 = findViewById(R.id.choice4_2);
                    c54 = findViewById(R.id.choice4_3);
                    c55 = findViewById(R.id.choice4_4);

                    c51.setText(R.string.b1_11_1);
                    c53.setText(R.string.b1_11_3);
                    c54.setText(R.string.b1_11_4);
                    c55.setText(R.string.b1_11_5);
                }
                else
                {
                    choice5 = findViewById(R.id.choice_no3);
                    c51 = findViewById(R.id.choice3_1);
                    c53 = findViewById(R.id.choice3_2);
                    c55 = findViewById(R.id.choice3_3);

                    c51.setText(R.string.b1_11_1);
                    c53.setText(R.string.b1_11_3);
                    c55.setText(R.string.b1_11_5);
                }
            }
            else
            {
                if ((player.getB1_choices(3) || player.getB1_choices(30)) && !player.getB1_choices(22))
                {
                    choice5 = findViewById(R.id.choice_no3);
                    c51 = findViewById(R.id.choice3_1);
                    c54 = findViewById(R.id.choice3_2);
                    c55 = findViewById(R.id.choice3_3);

                    c51.setText(R.string.b1_11_1);
                    c54.setText(R.string.b1_11_4);
                    c55.setText(R.string.b1_11_5);
                }
                else
                {
                    choice5 = findViewById(R.id.choice_no2);
                    c51 = findViewById(R.id.choice2_1);
                    c55 = findViewById(R.id.choice2_2);

                    c51.setText(R.string.b1_11_1);
                    c55.setText(R.string.b1_11_5);
                }
            }
        }
        else
        {
            if (player.getB1_choices(19) || player.getB1_choices(26))
            {
                if ((player.getB1_choices(3) || player.getB1_choices(30)) && !player.getB1_choices(22))
                {
                    choice5 = findViewById(R.id.choice_no3);
                    c52 = findViewById(R.id.choice3_1);
                    c54 = findViewById(R.id.choice3_2);
                    c55 = findViewById(R.id.choice4_4);

                    c52.setText(R.string.b1_11_2);
                    c54.setText(R.string.b1_11_4);
                    c55.setText(R.string.b1_11_5);
                }
                else
                {
                    choice5 = findViewById(R.id.choice_no2);
                    c52 = findViewById(R.id.choice2_1);
                    c55 = findViewById(R.id.choice2_2);

                    c52.setText(R.string.b1_11_2);
                    c55.setText(R.string.b1_11_5);
                }
            }
            else if (!player.getB1_choices(19) && !player.getB1_choices(26) && player.getB1_choices(22))
            {
                if ((player.getB1_choices(3) || player.getB1_choices(30)) && !player.getB1_choices(22))
                {
                    choice5 = findViewById(R.id.choice_no3);
                    c53 = findViewById(R.id.choice3_1);
                    c54 = findViewById(R.id.choice3_2);
                    c55 = findViewById(R.id.choice3_3);

                    c53.setText(R.string.b1_11_3);
                    c54.setText(R.string.b1_11_4);
                    c55.setText(R.string.b1_11_5);
                }
                else
                {
                    choice5 = findViewById(R.id.choice_no2);
                    c53 = findViewById(R.id.choice2_1);
                    c55 = findViewById(R.id.choice2_2);

                    c53.setText(R.string.b1_11_3);
                    c55.setText(R.string.b1_11_5);
                }
            }
            else
            {
                if ((player.getB1_choices(3) || player.getB1_choices(30)) && !player.getB1_choices(22))
                {
                    choice5 = findViewById(R.id.choice_no2);
                    c54 = findViewById(R.id.choice2_1);
                    c55 = findViewById(R.id.choice2_2);

                    c54.setText(R.string.b1_11_4);
                    c55.setText(R.string.b1_11_5);
                }
                else
                {
                    choice5 = findViewById(R.id.choice_no1);
                    c55 = findViewById(R.id.choice1_1);

                    c55.setText(R.string.b1_11_5);
                }
            }
        }

        c51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice5.setVisibility(View.INVISIBLE);

                b1_35();
            }
        });

        c52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice5.setVisibility(View.INVISIBLE);

                b1_19();
            }
        });

        c53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice5.setVisibility(View.INVISIBLE);

                b1_34();
            }
        });

        c54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice5.setVisibility(View.INVISIBLE);

                b1_20();
            }
        });

        c55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice5.setVisibility(View.INVISIBLE);

                b1_12();
            }
        });
    }

    public void b1_12()
    {
        allInvisible();
        player.setB1_choices(12);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice4 = findViewById(R.id.choice_no4);
        choice4.setVisibility(View.VISIBLE);
        c41 = findViewById(R.id.choice4_1);
        c42 = findViewById(R.id.choice4_2);
        c43 = findViewById(R.id.choice4_3);
        c44 = findViewById(R.id.choice4_4);

        mainText.setText(R.string.b1_12);
        c41.setText(R.string.b1_12_1);
        c42.setText(R.string.b1_12_2);
        c43.setText(R.string.b1_12_3);
        c44.setText(R.string.b1_12_4);

        c41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                if (player.getB1_choices(20))
                    b1_38();
                else if (player.getB1_choices(3))
                    b1_3();
                else if (player.getB1_choices(30))
                    b1_30();
                else if (player.getB1_choices(4))
                    b1_68();
                else
                    b1_4();
            }
        });

        c42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                if (player.getB1_choices(19) && player.isInventory(8))
                    b1_8();
                else if (player.getB1_choices(19) && !player.isInventory(8))
                    b1_21();
                else if (player.getB1_choices(8))
                    b1_9();
                else
                    b1_100();
            }
        });

        c43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                b1_11();
            }
        });

        c44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                b1_14();
            }
        });

    }

    public void b1_13()
    {
        allInvisible();
        player.setB1_choices(13);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_13a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_13a))
                {
                    mainText.setText(R.string.b1_13b);
                }
                else if (mainText.getText().toString().equals(R.string.b1_13b))
                {
                    mainText.setText(R.string.b1_13c);
                    c11.setText(R.string.b1_13_1);
                }
                else
                {
                    choice1.setVisibility(View.INVISIBLE);

                    b1_2();
                }
            }
        });

    }

    public void b1_14()
    {
        allInvisible();
        player.setB1_choices(14);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice4 = findViewById(R.id.choice_no4);
        choice1.setVisibility(View.VISIBLE);
        c41 = findViewById(R.id.choice4_1);
        c42 = findViewById(R.id.choice4_2);
        c43 = findViewById(R.id.choice4_3);
        c44 = findViewById(R.id.choice4_4);

        mainText.setText(R.string.b1_14);
        c41.setText(R.string.b1_14_1);
        c42.setText(R.string.b1_14_2);
        c43.setText(R.string.b1_14_3);
        c44.setText(R.string.b1_14_4);

        c41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                b1_28();
            }
        });

        c42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                if (player.getB1_choices(29))
                    b1_42();
                else
                    b1_29();
            }
        });

        c43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                if (player.getB1_choices(37))
                    b1_44();
                else if (player.getB1_choices(15))
                    b1_21();
                else
                    b1_2();
            }
        });

        c44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                Intent intent = new Intent(getApplicationContext(), subActivity_f1.class);
                intent.putExtra("player", player);
                startActivity(intent);
                finish();
            }
        });
    }

    public void b1_15()
    {
        allInvisible();
        player.setB1_choices(15);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_15a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_15a))
                {
                    mainText.setText(R.string.b1_15b);
                }
                else if (mainText.getText().toString().equals(R.string.b1_15b))
                {
                    mainText.setText(R.string.b1_15c);
                }
                else if (mainText.getText().toString().equals(R.string.b1_15c))
                {
                    mainText.setText(R.string.b1_15d);
                    c11.setText(R.string.b1_15_1);
                }
                else
                {
                    choice1.setVisibility(View.INVISIBLE);

                    b1_12();
                }
            }
        });

    }

    //b1_16()은 63 아래에 있음

    public void b1_17()
    {
        allInvisible();
        player.setB1_choices(17);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_17a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_17a))
                {
                    mainText.setText(R.string.b1_17b);
                }
                else if (mainText.getText().toString().equals(R.string.b1_17b))
                {
                    mainText.setText(R.string.b1_17c);
                    choice1.setVisibility(View.INVISIBLE);

                    if ((player.getF1_choices(33) || player.getF1_choices(17)) && player.getF2_choices(13))
                    {
                        choice3 = findViewById(R.id.choice_no3);
                        choice3.setVisibility(View.VISIBLE);
                        c31 = findViewById(R.id.choice3_1);
                        c32 = findViewById(R.id.choice3_2);
                        c33 = findViewById(R.id.choice3_3);

                        c31.setText(R.string.b1_17_1);
                        c32.setText(R.string.b1_17_2);
                        c33.setText(R.string.b1_17_3);
                    }
                    else if (player.getF1_choices(33) || player.getF1_choices(17))
                    {
                        choice3 = findViewById(R.id.choice_no2);
                        choice3.setVisibility(View.VISIBLE);
                        c31 = findViewById(R.id.choice2_1);
                        c32 = findViewById(R.id.choice2_2);

                        c31.setText(R.string.b1_17_1);
                        c32.setText(R.string.b1_17_2);
                    }
                    else if (player.getF2_choices(13))
                    {
                        choice3 = findViewById(R.id.choice_no2);
                        choice3.setVisibility(View.VISIBLE);
                        c31 = findViewById(R.id.choice2_1);
                        c33 = findViewById(R.id.choice2_2);

                        c31.setText(R.string.b1_17_1);
                        c33.setText(R.string.b1_17_3);
                    }
                    else
                    {
                        choice3 = findViewById(R.id.choice_no1);
                        choice3.setVisibility(View.VISIBLE);
                        c31 = findViewById(R.id.choice1_1);

                        c31.setText(R.string.b1_17_1);
                    }
                }
            }
        });

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_2();
            }
        });

        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_15();
            }
        });

        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_25();
            }
        });

    }

    public void b1_18()
    {
        allInvisible();
        player.setB1_choices(18);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_18a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_18a))
                {
                    mainText.setText(R.string.b1_18b);
                    c11.setText(R.string.b1_18_1);
                }
                else
                {
                    choice1.setVisibility(View.INVISIBLE);

                    if (player.getB1_choices(37))
                        b1_44();
                    else
                        b1_12();
                }
            }
        });

    }

    public void b1_19()
    {
        allInvisible();
        player.setB1_choices(19);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_19a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_19a))
                {
                    mainText.setText(R.string.b1_19b);
                }
                else if (mainText.getText().toString().equals(R.string.b1_19b))
                {
                    mainText.setText(R.string.b1_19c);
                    c11.setText(R.string.b1_19_1);
                }
                else
                {
                    choice1.setVisibility(View.INVISIBLE);

                    player.addInventory(8);

                    Toast toast = Toast.makeText(getApplicationContext(), "item : 지랫대를 얻었다", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
                    toast.show();

                    b1_12();
                }
            }
        });

    }

    public void b1_20()
    {
        allInvisible();
        player.setB1_choices(20);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_20a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_20a))
                {
                    mainText.setText(R.string.b1_20b);
                }
                else
                {
                    mainText.setText(R.string.b1_20c);
                    choice1.setVisibility(View.INVISIBLE);

                    if (player.getType() == 0 || player.isInventory(12))
                    {
                        choice2 = findViewById(R.id.choice_no2);
                        choice2.setVisibility(View.VISIBLE);
                        c21 = findViewById(R.id.choice2_1);
                        c22 = findViewById(R.id.choice2_2);

                        c21.setText(R.string.b1_20_1);
                        c22.setText(R.string.b1_20_2);
                    }
                    else
                    {
                        choice2 = findViewById(R.id.choice_no1);
                        choice2.setVisibility(View.VISIBLE);
                        c22 = findViewById(R.id.choice1_1);

                        c22.setText(R.string.b1_20_2);
                    }
                }
            }
        });

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_22();
            }
        });

        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_12();
            }
        });
    }

    public void b1_21()
    {
        allInvisible();
        player.setB1_choices(21);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_21a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_21a))
                {
                    mainText.setText(R.string.b1_21b);
                    c11.setText(R.string.b1_21_1);
                }
                else
                {
                    choice1.setVisibility(View.INVISIBLE);

                    b1_12();
                }
            }
        });

    }

    public void b1_22()
    {
        allInvisible();
        player.setB1_choices(22);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_22a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_22a))
                {
                    mainText.setText(R.string.b1_22b);
                }
                else if (mainText.getText().toString().equals(R.string.b1_22b))
                {
                    mainText.setText(R.string.b1_22c);
                }
                else
                {
                    mainText.setText(R.string.b1_22d);
                    choice1.setVisibility(View.INVISIBLE);

                    if (player.isInventory(8))
                    {
                        choice2 = findViewById(R.id.choice_no2);
                        choice2.setVisibility(View.VISIBLE);
                        c21 = findViewById(R.id.choice2_1);
                        c22 = findViewById(R.id.choice2_2);

                        c21.setText(R.string.b1_22_1);
                        c22.setText(R.string.b1_22_2);
                    }
                    else
                    {
                        choice2 = findViewById(R.id.choice_no1);
                        choice2.setVisibility(View.VISIBLE);
                        c22 = findViewById(R.id.choice1_1);

                        c22.setText(R.string.b1_22_2);
                    }
                }
            }
        });

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_23();
            }
        });

        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_11();
            }
        });
    }

    public void b1_23()
    {
        allInvisible();
        player.setB1_choices(23);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_23a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_23a))
                {
                    mainText.setText(R.string.b1_23b);
                }
                else if (mainText.getText().toString().equals(R.string.b1_23b))
                {
                    mainText.setText(R.string.b1_23c);
                }
                else if (mainText.getText().toString().equals(R.string.b1_23c))
                {
                    mainText.setText(R.string.b1_23d);
                    c11.setText(R.string.b1_23_1);
                }
                else
                {
                    player.setSword();
                    choice1.setVisibility(View.INVISIBLE);

                    if (player.getB1_choices(37))
                        b1_44();
                    else
                        b1_12();
                }
            }
        });

    }

    public void b1_25()
    {
        allInvisible();
        player.setB1_choices(25);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_25a);
        c11.setText("next");

        c44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_25a))
                {
                    mainText.setText(R.string.b1_25b);
                }
                else if (mainText.getText().toString().equals(R.string.b1_25b))
                {
                    mainText.setText(R.string.b1_25c);
                }
                else if (mainText.getText().toString().equals(R.string.b1_25c))
                {
                    mainText.setText(R.string.b1_25d);
                }
                else if (mainText.getText().toString().equals(R.string.b1_25d))
                {
                    mainText.setText(R.string.b1_25e);
                    c11.setText(R.string.b1_25_1);
                }
                else
                {
                    choice1.setVisibility(View.INVISIBLE);

                    b1_12();
                }
            }
        });

    }

    public void b1_26()
    {
        allInvisible();
        player.setB1_choices(26);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        if (player.isInventory(8))
        {
            choice2 = findViewById(R.id.choice_no2);
            choice2.setVisibility(View.VISIBLE);
            c21 = findViewById(R.id.choice2_1);
            c22 = findViewById(R.id.choice2_2);

            c21.setText(R.string.b1_26_1);
            c22.setText(R.string.b1_26_2);
        }
        else
        {
            choice2 = findViewById(R.id.choice_no1);
            choice2.setVisibility(View.VISIBLE);
            c21 = findViewById(R.id.choice1_1);

            c21.setText(R.string.b1_26_1);
        }

        mainText.setText(R.string.b1_3a);

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_12();
            }
        });

        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_8();
            }
        });
    }

    public void b1_27()
    {
        allInvisible();
        player.setB1_choices(27);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_27a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_27a))
                    mainText.setText(R.string.b1_27b);
                else if (mainText.getText().toString().equals(R.string.b1_27b))
                {
                    mainText.setText(R.string.b1_27c);
                    c11.setText(R.string.b1_27_1);
                }
                else
                {
                    choice1.setVisibility(View.INVISIBLE);
                    b1_40();
                }

            }
        });

    }

    public void b1_28()
    {
        allInvisible();
        player.setB1_choices(28);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        if (player.getB1_choices(47) && !player.getB1_choices(69))
        {
            choice4 = findViewById(R.id.choice_no4);
            choice4.setVisibility(View.VISIBLE);
            c41 = findViewById(R.id.choice4_1);
            c42 = findViewById(R.id.choice4_2);
            c43 = findViewById(R.id.choice4_3);
            c44 = findViewById(R.id.choice4_4);

            c41.setText(R.string.b1_28_1);
            c42.setText(R.string.b1_28_2);
            c43.setText(R.string.b1_28_3);
            c44.setText(R.string.b1_28_4);
        }
        else
        {
            choice4 = findViewById(R.id.choice_no2);
            choice4.setVisibility(View.VISIBLE);
            c41 = findViewById(R.id.choice2_1);
            c44 = findViewById(R.id.choice2_2);

            c41.setText(R.string.b1_28_1);
            c44.setText(R.string.b1_28_4);
        }

        mainText.setText(R.string.b1_28);

        c41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                if (player.getB1_choices(69))
                    b1_75();
                else
                    b1_69();
            }
        });

        c42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                b1_70();
            }
        });

        c43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                b1_69();
            }
        });

        c44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                b1_14();
            }
        });

    }

    public void b1_29()
    {
        allInvisible();
        player.setB1_choices(29);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_29);
        c11.setText(R.string.b1_29_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                b1_39();
            }
        });

    }

    public void b1_30()
    {
        allInvisible();
        player.setB1_choices(30);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_30);
        c11.setText(R.string.b1_30_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                if (player.getB1_choices(15))
                    b1_12();
                else
                    b1_2();
            }
        });

    }

    public void b1_34()
    {
        allInvisible();
        player.setB1_choices(34);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        if (player.getType() == 2 && (player.getType() == 0 || player.isInventory(12)))
        {
            choice3 = findViewById(R.id.choice_no3);
            choice3.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice3_1);
            c32 = findViewById(R.id.choice3_2);
            c33 = findViewById(R.id.choice3_3);

            c31.setText(R.string.b1_34_1);
            c32.setText(R.string.b1_34_2);
            c33.setText(R.string.b1_34_3);
        }
        else if (player.getType() == 2)
        {
            choice3 = findViewById(R.id.choice_no2);
            choice3.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice2_1);
            c32 = findViewById(R.id.choice2_2);

            c31.setText(R.string.b1_34_1);
            c32.setText(R.string.b1_34_2);
        }
        else if (player.getType() == 0 || player.isInventory(12))
        {
            choice3 = findViewById(R.id.choice_no2);
            choice3.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice2_1);
            c33 = findViewById(R.id.choice2_2);

            c31.setText(R.string.b1_34_1);
            c33.setText(R.string.b1_34_3);
        }
        else
        {
            choice3 = findViewById(R.id.choice_no1);
            choice3.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice1_1);

            c31.setText(R.string.b1_34_1);
        }

        mainText.setText(R.string.b1_34);

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_12();
            }
        });

        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_37();
            }
        });

        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_36();
            }
        });
    }

    public void b1_35()
    {
        allInvisible();
        player.setB1_choices(35);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_35a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_35a))
                    mainText.setText(R.string.b1_35b);
                else if (mainText.getText().toString().equals(R.string.b1_35b))
                {
                    mainText.setText(R.string.b1_35c);
                    c11.setText(R.string.b1_35_1);
                }
                else
                {
                    choice1.setVisibility(View.INVISIBLE);
                    b1_11();
                }
            }
        });

    }

    public void b1_36()
    {
        allInvisible();
        player.setB1_choices(36);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_36);
        c11.setText(R.string.b1_36_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                player.addInventory(8);

                Toast toast = Toast.makeText(getApplicationContext(), "item : 지랫대를 얻었다", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
                toast.show();

                player.removeInventory(12);

                toast = Toast.makeText(getApplicationContext(), "item : 허가증을 사용했다", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
                toast.show();

                b1_12();
            }
        });
    }

    public void b1_37()
    {
        allInvisible();
        player.setB1_choices(37);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_37);
        c11.setText(R.string.b1_37_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                player.addInventory(8);

                Toast toast = Toast.makeText(getApplicationContext(), "item : 지랫대를 얻었다", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
                toast.show();

                b1_44();
            }
        });

    }

    public void b1_38()
    {
        allInvisible();
        player.setB1_choices(38);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        if (player.isInventory(8))
        {
            choice2 = findViewById(R.id.choice_no2);
            choice2.setVisibility(View.VISIBLE);
            c21 = findViewById(R.id.choice2_1);
            c22 = findViewById(R.id.choice2_2);

            c21.setText(R.string.b1_38_1);
            c22.setText(R.string.b1_38_2);
        }
        else
        {
            choice2 = findViewById(R.id.choice_no1);
            choice2.setVisibility(View.VISIBLE);
            c22 = findViewById(R.id.choice1_1);

            c22.setText(R.string.b1_38_2);
        }

        mainText.setText(R.string.b1_38);

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_23();
            }
        });

        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_12();
            }
        });

    }

    public void b1_39()
    {
        allInvisible();
        player.setB1_choices(39);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        if (!player.getB1_choices(72) && player.isInventory(16) && player.getType() == 2)
        {
            choice3 = findViewById(R.id.choice_no3);
            choice3.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice3_1);
            c32 = findViewById(R.id.choice3_2);
            c33 = findViewById(R.id.choice3_3);

            c31.setText(R.string.b1_39_1);
            c32.setText(R.string.b1_39_2);
            c33.setText(R.string.b1_39_3);
        }
        else if (!player.getB1_choices(72) && player.isInventory(16))
        {
            choice3 = findViewById(R.id.choice_no2);
            choice3.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice2_1);
            c33 = findViewById(R.id.choice2_2);

            c31.setText(R.string.b1_39_1);
            c33.setText(R.string.b1_39_3);
        }
        else if (player.getB1_choices(72) || player.getType() == 2)
        {
            choice3 = findViewById(R.id.choice_no2);
            choice3.setVisibility(View.VISIBLE);
            c32 = findViewById(R.id.choice2_1);
            c33 = findViewById(R.id.choice2_2);

            c32.setText(R.string.b1_39_2);
            c33.setText(R.string.b1_39_3);
        }
        else
        {
            choice3 = findViewById(R.id.choice_no1);
            choice3.setVisibility(View.VISIBLE);
            c33 = findViewById(R.id.choice1_1);

            c33.setText(R.string.b1_39_3);
        }

        mainText.setText(R.string.b1_39);

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_40();
            }
        });

        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_41();
            }
        });

        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_42();
            }
        });

    }

    public void b1_40()
    {
        allInvisible();
        player.setB1_choices(40);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_40a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_40a))
                    mainText.setText(R.string.b1_40b);
                else if (mainText.getText().toString().equals(R.string.b1_40b))
                {
                    mainText.setText(R.string.b1_40c);
                    c11.setText(R.string.b1_40_1);
                }
                else
                {
                    choice1.setVisibility(View.INVISIBLE);
                    player.removeInventory(16);

                    Toast toast = Toast.makeText(getApplicationContext(), "item : 동물과 말하는 약을 사용했다.", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
                    toast.show();

                    b1_42();
                }

            }
        });

    }

    public void b1_41()
    {
        allInvisible();
        player.setB1_choices(41);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_41a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_41a))
                {
                    mainText.setText(R.string.b1_41b);
                }
                else if (mainText.getText().toString().equals(R.string.b1_41b))
                {
                    mainText.setText(R.string.b1_41c);
                    c11.setText(R.string.b1_41_1);
                }
                else
                {
                    choice1.setVisibility(View.INVISIBLE);
                    b1_42();
                }
            }
        });

    }

    public void b1_42()
    {
        allInvisible();
        player.setB1_choices(42);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        if (!player.getB1_choices(67))
        {
            choice3 = findViewById(R.id.choice_no3);
            choice3.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice3_1);
            c32 = findViewById(R.id.choice3_2);
            c33 = findViewById(R.id.choice3_3);

            c31.setText(R.string.b1_42_1);
            c32.setText(R.string.b1_42_2);
            c33.setText(R.string.b1_42_3);
        }
        else
        {
            choice3 = findViewById(R.id.choice_no2);
            choice3.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice2_1);
            c33 = findViewById(R.id.choice2_2);

            c31.setText(R.string.b1_42_1);
            c33.setText(R.string.b1_42_3);
        }

        mainText.setText(R.string.b1_42);

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                if (!player.getB1_choices(40) && !player.getB1_choices(41))
                    b1_39();
                else if (!player.getB1_choices(45))
                    b1_45();
                else if (player.getB1_choices(45) && !player.getB1_choices(47))
                    b1_49();
                else if (player.getB1_choices(69) || player.getB1_choices(70))
                    b1_49();
                else
                    b1_48();
            }
        });

        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                if (!player.getB1_choices(40) && !player.getB1_choices(41))
                    b1_39();
                else if (!player.getB1_choices(46))
                    b1_46();
                else
                    b1_59();
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

    public void b1_44()
    {
        allInvisible();
        player.setB1_choices(44);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice4 = findViewById(R.id.choice_no4);
        choice4.setVisibility(View.VISIBLE);
        c41 = findViewById(R.id.choice4_1);
        c42 = findViewById(R.id.choice4_2);
        c43 = findViewById(R.id.choice4_3);
        c44 = findViewById(R.id.choice4_4);

        mainText.setText(R.string.b1_44);
        c41.setText(R.string.b1_44_1);
        c42.setText(R.string.b1_44_2);
        c43.setText(R.string.b1_44_3);
        c44.setText(R.string.b1_44_4);

        c41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                if (player.getB1_choices(20))
                    b1_38();
                else if (!player.getB1_choices(4) && !player.getB1_choices(30) && !player.getB1_choices(3))
                    b1_4();
                else if (player.getB1_choices(3))
                    b1_3();
                else if (player.getB1_choices(30))
                    b1_30();
                else if (player.getB1_choices(4))
                    b1_68();
                else
                    b1_100();
            }
        });

        c42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                if (player.getB1_choices(19) && player.isInventory(8))
                    b1_8();
                else if (player.getB1_choices(19) && !player.isInventory(8))
                    b1_21();
                else if (player.getB1_choices(8))
                    b1_9();
                else
                    b1_100();
            }
        });

        c43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                b1_10();
            }
        });

        c41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                b1_14();
            }
        });

    }

    public void b1_45()
    {
        allInvisible();
        player.setB1_choices(45);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        choice2 = findViewById(R.id.choice_no2);
        c21 = findViewById(R.id.choice2_1);
        c22 = findViewById(R.id.choice2_2);

        mainText.setText(R.string.b1_45a);
        c11.setText("next");
        c21.setText(R.string.b1_45_1);
        c22.setText(R.string.b1_45_2);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_45a))
                    mainText.setText(R.string.b1_45b);
                else if (mainText.getText().toString().equals(R.string.b1_45b))
                {
                    mainText.setText(R.string.b1_45c);

                    player.heal();

                    Toast toast = Toast.makeText(getApplicationContext(), "heart: 생명 +1", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
                    toast.show();


                    choice1.setVisibility(View.INVISIBLE);
                    choice2.setVisibility(View.VISIBLE);
                }
            }
        });

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_47();
            }
        });

        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_42();
            }
        });

    }

    public void b1_46()
    {
        allInvisible();
        player.setB1_choices(46);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_46a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_46a))
                    mainText.setText(R.string.b1_46b);
                else if (mainText.getText().toString().equals(R.string.b1_46b))
                {
                    mainText.setText(R.string.b1_46c);
                    choice1.setVisibility(View.INVISIBLE);

                    choice2 = findViewById(R.id.choice_no2);
                    choice2.setVisibility(View.VISIBLE);
                    c21 = findViewById(R.id.choice2_1);
                    c22 = findViewById(R.id.choice2_2);

                    c21.setText(R.string.b1_46_1);
                    c22.setText(R.string.b1_46_2);
                }
            }
        });

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                b1_50();
            }
        });

        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                b1_61();
            }
        });
    }

    public void b1_47()
    {
        allInvisible();
        player.setB1_choices(47);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_47a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_47a))
                {
                    mainText.setText(R.string.b1_47b);
                    c11.setText(R.string.b1_47_1);
                }
                else
                {
                    choice1.setVisibility(View.INVISIBLE);

                    b1_42();
                }

            }
        });
    }

    public void b1_48()
    {
        allInvisible();
        player.setB1_choices(48);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_48);
        c11.setText(R.string.b1_48);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                b1_42();
            }
        });
    }

    public void b1_49()
    {
        allInvisible();
        player.setB1_choices(49);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_49a);
        c11.setText("next");

        c44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_49a))
                {
                    mainText.setText(R.string.b1_49b);
                    c11.setText(R.string.b1_49_1);
                }
                else
                {
                    choice1.setVisibility(View.INVISIBLE);

                    b1_42();
                }
            }
        });

    }

    public void b1_50()
    {
        allInvisible();
        player.setB1_choices(50);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        mainText.setText(R.string.b1_50);

        if (player.isInventory(15) && !player.isInventory(5))
        {
            if (player.isInventory(12) && !player.isInventory(6))
            {
                if (player.isInventory(11) && !player.isInventory(17) && !player.getB1_choices(60) && !player.getB1_choices(77))
                {
                    choice4 = findViewById(R.id.choice_no4);
                    choice4.setVisibility(View.VISIBLE);
                    c41 = findViewById(R.id.choice4_1);
                    c42 = findViewById(R.id.choice4_2);
                    c43 = findViewById(R.id.choice4_3);
                    c44 = findViewById(R.id.choice4_4);

                    c41.setText(R.string.b1_50_1);
                    c42.setText(R.string.b1_50_2);
                    c43.setText(R.string.b1_50_3);
                    c44.setText(R.string.b1_50_4);
                }
                else
                {
                    choice4 = findViewById(R.id.choice_no3);
                    choice4.setVisibility(View.VISIBLE);
                    c41 = findViewById(R.id.choice3_1);
                    c42 = findViewById(R.id.choice3_2);
                    c44 = findViewById(R.id.choice3_3);

                    c41.setText(R.string.b1_50_1);
                    c42.setText(R.string.b1_50_2);
                    c44.setText(R.string.b1_50_4);
                }
            }
            else
            {
                if (player.isInventory(11) && !player.isInventory(17) && !player.getB1_choices(60) && !player.getB1_choices(77))
                {
                    choice4 = findViewById(R.id.choice_no3);
                    choice4.setVisibility(View.VISIBLE);
                    c41 = findViewById(R.id.choice3_1);
                    c43 = findViewById(R.id.choice3_2);
                    c44 = findViewById(R.id.choice3_3);

                    c41.setText(R.string.b1_50_1);
                    c43.setText(R.string.b1_50_3);
                    c44.setText(R.string.b1_50_4);
                }
                else
                {
                    choice4 = findViewById(R.id.choice_no2);
                    choice4.setVisibility(View.VISIBLE);
                    c41 = findViewById(R.id.choice2_1);
                    c44 = findViewById(R.id.choice2_2);

                    c41.setText(R.string.b1_50_1);
                    c44.setText(R.string.b1_50_4);
                }
            }
        }
        else
        {
            if (player.isInventory(12) && !player.isInventory(6))
            {
                if (player.isInventory(11) && !player.isInventory(17) && !player.getB1_choices(60) && !player.getB1_choices(77))
                {
                    choice4 = findViewById(R.id.choice_no3);
                    choice4.setVisibility(View.VISIBLE);
                    c42 = findViewById(R.id.choice3_1);
                    c43 = findViewById(R.id.choice3_2);
                    c44 = findViewById(R.id.choice3_3);

                    c42.setText(R.string.b1_50_2);
                    c43.setText(R.string.b1_50_3);
                    c44.setText(R.string.b1_50_4);
                }
                else
                {
                    choice4 = findViewById(R.id.choice_no2);
                    choice4.setVisibility(View.VISIBLE);
                    c42 = findViewById(R.id.choice2_1);
                    c44 = findViewById(R.id.choice2_2);

                    c42.setText(R.string.b1_50_2);
                    c44.setText(R.string.b1_50_4);
                }
            }
            else
            {
                if (player.isInventory(11) && !player.isInventory(17) && !player.getB1_choices(60) && !player.getB1_choices(77))
                {
                    choice4 = findViewById(R.id.choice_no2);
                    choice4.setVisibility(View.VISIBLE);
                    c43 = findViewById(R.id.choice2_1);
                    c44 = findViewById(R.id.choice2_2);

                    c43.setText(R.string.b1_50_3);
                    c44.setText(R.string.b1_50_4);
                }
                else
                {
                    choice4 = findViewById(R.id.choice_no1);
                    choice4.setVisibility(View.VISIBLE);
                    c44 = findViewById(R.id.choice1_1);

                    c44.setText(R.string.b1_50_4);
                }
            }
        }

        c41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                b1_51();
            }
        });

        c42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                b1_52();
            }
        });

        c43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                if (player.getB1_choices(59))
                    b1_60();
                else
                    b1_53();
            }
        });

        c44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                b1_61();
            }
        });

    }

    public void b1_51()
    {
        allInvisible();
        player.setB1_choices(51);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        mainText.setText(R.string.b1_51);

        if (player.getType() == 1)
        {
            choice1 = findViewById(R.id.choice_no1);
            choice1.setVisibility(View.VISIBLE);
            c11 = findViewById(R.id.choice1_1);

            c11.setText("next");
        }
        else
        {
            choice2 = findViewById(R.id.choice_no2);
            choice2.setVisibility(View.VISIBLE);
            c21 = findViewById(R.id.choice2_1);
            c22 = findViewById(R.id.choice2_2);

            c21.setText(R.string.b1_51_1);
            c22.setText(R.string.b1_51_2);
        }

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = (int)(Math.random() * 10 % 2);

                if (n == 1)
                    mainText.setText(R.string.b1_55a);
                else
                    mainText.setText(R.string.b1_55b);

                choice1.setVisibility(View.INVISIBLE);
                choice2 = findViewById(R.id.choice_no2);
                choice2.setVisibility(View.VISIBLE);
                c21 = findViewById(R.id.choice2_1);
                c22 = findViewById(R.id.choice2_2);

                c21.setText(R.string.b1_51_1);
                c22.setText(R.string.b1_51_2);
            }
        });

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_54();
            }
        });

        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_54();
            }
        });
    }

    public void b1_52()
    {
        allInvisible();
        player.setB1_choices(52);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        mainText.setText(R.string.b1_52);

        if (player.getType() == 1)
        {
            choice1 = findViewById(R.id.choice_no1);
            choice1.setVisibility(View.VISIBLE);
            c11 = findViewById(R.id.choice1_1);

            c11.setText("next");
        }
        else
        {
            choice2 = findViewById(R.id.choice_no2);
            choice2.setVisibility(View.VISIBLE);
            c21 = findViewById(R.id.choice2_1);
            c22 = findViewById(R.id.choice2_2);

            c21.setText(R.string.b1_52_1);
            c22.setText(R.string.b1_52_2);
        }

        A = (int)(Math.random() * 10 % 5 + 1);
        B = (int)(Math.random() * 10 % 5 + 1);

        while(A == B)
        {
            A = (int)(Math.random() * 10 % 6 + 1);
            B = (int)(Math.random() * 10 % 6 + 1);
        }

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (A > B)
                    mainText.setText(R.string.b1_56a);
                else
                    mainText.setText(R.string.b1_56b);

                choice1.setVisibility(View.INVISIBLE);
                choice2 = findViewById(R.id.choice_no2);
                choice2.setVisibility(View.VISIBLE);
                c21 = findViewById(R.id.choice2_1);
                c22 = findViewById(R.id.choice2_2);

                c21.setText(R.string.b1_52_1);
                c22.setText(R.string.b1_52_2);
            }
        });

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                pr = A;
                mo = B;

                if (pr > mo)
                    b1_57();
                else
                    b1_58();
            }
        });

        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                pr = B;
                mo = A;

                if (pr > mo)
                    b1_57();
                else
                    b1_58();
            }
        });

    }

    public void b1_53()
    {
        allInvisible();
        player.setB1_choices(53);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_53a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_53a))
                {
                    mainText.setText((R.string.b1_53b));
                    choice1.setVisibility(View.INVISIBLE);

                    if (player.getType() == 1)
                    {
                        choice3 = findViewById(R.id.choice_no3);
                        choice3.setVisibility(View.VISIBLE);
                        c31 = findViewById(R.id.choice3_1);
                        c32 = findViewById(R.id.choice3_2);
                        c33 = findViewById(R.id.choice3_3);

                        c31.setText(R.string.b1_53_1);
                        c32.setText(R.string.b1_53_2);
                        c33.setText(R.string.b1_53_3);
                    }
                    else
                    {
                        choice3 = findViewById(R.id.choice_no2);
                        choice3.setVisibility(View.VISIBLE);
                        c32 = findViewById(R.id.choice2_1);
                        c33 = findViewById(R.id.choice2_2);

                        c32.setText(R.string.b1_53_2);
                        c33.setText(R.string.b1_53_3);
                    }
                }
            }
        });

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_64();
            }
        });

        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_65();
            }
        });

        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_65();
            }
        });
    }

    public void b1_54()
    {
        allInvisible();
        player.setB1_choices(54);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice2 = findViewById(R.id.choice_no2);
        choice2.setVisibility(View.VISIBLE);
        c21 = findViewById(R.id.choice2_1);
        c22 = findViewById(R.id.choice2_2);

        pr = (int)(Math.random() * 10 % 3 + 4);
        mo = (int)(Math.random() * 10 % 3 + 1);

        mainText.setText(String.format("네가 %d고 내가 %d니까... 네가 이겼어! 자! 우유받아. 생쥐가 우유를 건내줬다. 어때? 게임 더 할래?", pr, mo));
        c21.setText(R.string.b1_54_1);
        c22.setText(R.string.b1_54_2);

        player.addInventory(5);
        Toast toast = Toast.makeText(getApplicationContext(), "item : 우유를 얻었다", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
        toast.show();


        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_50();
            }
        });

        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_61();
            }
        });
    }

    public void b1_57()
    {
        allInvisible();
        player.setB1_choices(57);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice2 = findViewById(R.id.choice_no2);
        choice2.setVisibility(View.VISIBLE);
        c21 = findViewById(R.id.choice2_1);
        c22 = findViewById(R.id.choice2_2);

        mainText.setText(String.format("네가 %d, 내가 %d 이니까 네가 이겼어. 이 치즈 정말정말 맛있는 건데... 생쥐는 입맛을 다시며 치즈를 건냈다. (아이템 치즈 획득) 다른 내기 할래?", pr, mo));
        c21.setText(R.string.b1_57_1);
        c22.setText(R.string.b1_57_2);

        player.addInventory(6);
        Toast toast = Toast.makeText(getApplicationContext(), "item : 치즈를 얻었다", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
        toast.show();

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_50();
            }
        });

        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_61();
            }
        });

    }

    public void b1_58()
    {
        allInvisible();
        player.setB1_choices(58);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        mainText.setText(String.format("네가 %d, 내가 %d 이니까 내가 이겼어! 야호! 당신은 허가증을 생쥐에게 건냈다. (아이템 허가증 없어짐) 다른 내기할래?", pr, mo));

        player.removeInventory(12);
        Toast toast = Toast.makeText(getApplicationContext(), "item : 허가증을 사용했다.", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
        toast.show();

        if (player.getType() == 0)
        {
            choice3 = findViewById(R.id.choice_no3);
            choice3.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice3_1);
            c32 = findViewById(R.id.choice3_2);
            c33 = findViewById(R.id.choice3_3);

            c31.setText(R.string.b1_58_1);
            c32.setText(R.string.b1_58_2);
            c33.setText(R.string.b1_58_3);
        }
        else
        {
            choice3 = findViewById(R.id.choice_no2);
            choice3.setVisibility(View.VISIBLE);
            c32 = findViewById(R.id.choice2_1);
            c33 = findViewById(R.id.choice2_2);

            c32.setText(R.string.b1_58_2);
            c33.setText(R.string.b1_58_3);
        }

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_62();
            }
        });

        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_50();
            }
        });

        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_61();
            }
        });
    }

    public void b1_59()
    {
        allInvisible();
        player.setB1_choices(59);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice2 = findViewById(R.id.choice_no2);
        choice2.setVisibility(View.VISIBLE);
        c21 = findViewById(R.id.choice2_1);
        c22 = findViewById(R.id.choice2_1);

        mainText.setText(R.string.b1_59);
        c21.setText(R.string.b1_59_1);
        c22.setText(R.string.b1_59_2);

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_50();
            }
        });

        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_61();
            }
        });

    }

    public void b1_60()
    {
        allInvisible();
        player.setB1_choices(60);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_60a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_60a))
                {
                    mainText.setText(R.string.b1_60b);

                    choice1.setVisibility(View.INVISIBLE);

                    choice2 = findViewById(R.id.choice_no2);
                    choice2.setVisibility(View.VISIBLE);
                    c21 = findViewById(R.id.choice2_1);
                    c22 = findViewById(R.id.choice2_2);

                    c21.setText(R.string.b1_60_1);
                    c22.setText(R.string.b1_60_2);
                }
            }
        });


        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_50();
            }
        });

        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_61();
            }
        });
    }

    public void b1_61()
    {
        allInvisible();
        player.setB1_choices(61);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_61);
        c11.setText(R.string.b1_61_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                b1_42();
            }
        });
    }

    public void b1_62()
    {
        allInvisible();
        player.setB1_choices(62);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        mainText.setText(R.string.b1_62);

        choice2 = findViewById(R.id.choice_no2);
        choice2.setVisibility(View.VISIBLE);
        c21 = findViewById(R.id.choice2_1);
        c22 = findViewById(R.id.choice2_2);

        c21.setText(R.string.b1_62_1);
        c22.setText(R.string.b1_62_2);

        A = (int)(Math.random() * 10 % 5 + 1);
        B = (int)(Math.random() * 10 % 5 + 1);

        while(A == B)
        {
            A = (int)(Math.random() * 10 % 6 + 1);
            B = (int)(Math.random() * 10 % 6 + 1);
        }


        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                pr = A;
                mo = B;

                if (pr > mo)
                    b1_63();
                else
                    b1_16();
            }
        });

        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                pr = B;
                mo = A;

                if (pr > mo)
                    b1_63();
                else
                    b1_16();
            }
        });
    }

    public void b1_63()
    {
        allInvisible();
        player.setB1_choices(63);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        mainText.setText(String.format("네가 %d, 내가 %d 이니까 네가 이겼어. 내가 너무 욕심을 부렸나봐! 생쥐가 당신에게 허가증과 치즈를 줬다. (아이템 허가증, 아이템 치즈 획득) 그럼... 다른 내기할래?", pr, mo));

        player.addInventory(12);
        player.addInventory(6);
        Toast toast = Toast.makeText(getApplicationContext(), "item : 허가증과 치즈를 획득했다.", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
        toast.show();

        choice2 = findViewById(R.id.choice_no2);
        choice2.setVisibility(View.VISIBLE);
        c21 = findViewById(R.id.choice2_1);
        c22 = findViewById(R.id.choice2_2);

        c21.setText(R.string.b1_63_1);
        c22.setText(R.string.b1_63_2);

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_50();
            }
        });

        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_61();
            }
        });
    }

    public void b1_16()
    {
        allInvisible();
        player.setB1_choices(63);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        mainText.setText(String.format("네가 %d, 내가 %d 이니까 내가 이겼어. 야호! 황금, 잘쓸게! 생쥐가 당신에게서 황금을 받아갔다. 그럼, 다른 내기할래?", pr, mo));

        choice2 = findViewById(R.id.choice_no2);
        choice2.setVisibility(View.VISIBLE);
        c21 = findViewById(R.id.choice2_1);
        c22 = findViewById(R.id.choice2_2);

        c21.setText(R.string.b1_16_1);
        c22.setText(R.string.b1_16_2);

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_50();
            }
        });

        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_61();
            }
        });
    }

    public void b1_64()
    {
        allInvisible();
        player.setB1_choices(64);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_64a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_64a))
                    mainText.setText(R.string.b1_64b);
                else if (mainText.getText().toString().equals(R.string.b1_64b))
                {
                    mainText.setText(R.string.b1_64c);

                    choice1.setVisibility(View.INVISIBLE);

                    choice2 = findViewById(R.id.choice_no2);
                    choice2.setVisibility(View.VISIBLE);
                    c21 = findViewById(R.id.choice2_1);
                    c22 = findViewById(R.id.choice2_2);

                    c21.setText(R.string.b1_64_1);
                    c22.setText(R.string.b1_64_2);
                }
            }
        });

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_66();
            }
        });


        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_67();
            }
        });
    }

    public void b1_65()
    {
        allInvisible();
        player.setB1_choices(65);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        pr = (int)(Math.random() * 10 / 3 + 1);
        mo = (int)(Math.random() * 10 / 3 + 4);
        mainText.setText(String.format("네가 %d고 내가 %d니까... 내가 이겼어! 야호! 생쥐가 크게 기뻐하며 스프를 가져갔다. 어때 다른 내기도 할래?", pr, mo));

        player.removeInventory(11);
        Toast toast = Toast.makeText(getApplicationContext(), "item : 맛있는 스튜를 사용했다.", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
        toast.show();

        choice2 = findViewById(R.id.choice_no2);
        choice2.setVisibility(View.VISIBLE);
        c21 = findViewById(R.id.choice2_1);
        c22 = findViewById(R.id.choice2_2);

        c21.setText(R.string.b1_65_1);
        c22.setText(R.string.b1_65_2);

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_50();
            }
        });

        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_61();
            }
        });
    }

    public void b1_66()
    {
        allInvisible();
        player.setB1_choices(66);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_66);
        c11.setText(R.string.b1_66_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                b1_42();
            }
        });
    }

    public void b1_67()
    {
        allInvisible();
        player.setB1_choices(67);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_67);
        c11.setText(R.string.b1_67_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                b1_42();
            }
        });
    }

    public void b1_68()
    {
        allInvisible();
        player.setB1_choices(68);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        mainText.setText(R.string.b1_68);

        if (player.getB1_choices(42))
        {
            choice3 = findViewById(R.id.choice_no2);
            choice3.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice2_1);
            c33 = findViewById(R.id.choice2_2);

            c31.setText(R.string.b1_68_1);
            c33.setText(R.string.b1_68_3);
        }
        else if (player.getType() == 1)
        {
            choice3 = findViewById(R.id.choice_no2);
            choice3.setVisibility(View.VISIBLE);
            c32 = findViewById(R.id.choice2_1);
            c33 = findViewById(R.id.choice2_2);

            c32.setText(R.string.b1_68_2);
            c33.setText(R.string.b1_68_3);
        }
        else
        {
            choice3 = findViewById(R.id.choice_no1);
            choice3.setVisibility(View.VISIBLE);
            c33 = findViewById(R.id.choice1_1);

            c33.setText(R.string.b1_68_3);
        }

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_3();
            }
        });

        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_30();
            }
        });

        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                if (player.getB1_choices(15))
                    b1_12();
                else
                    b1_2();
            }
        });
    }

    public void b1_69()
    {
        allInvisible();
        player.setB1_choices(69);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        mainText.setText(R.string.b1_69);

        if (!player.getB1_choices(40) && player.isInventory(16) && player.getType() == 2)
        {
            choice3 = findViewById(R.id.choice_no3);
            choice3.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice3_1);
            c32 = findViewById(R.id.choice3_2);
            c33 = findViewById(R.id.choice3_3);

            c31.setText(R.string.b1_69_1);
            c32.setText(R.string.b1_69_2);
            c33.setText(R.string.b1_69_3);
        }
        else if (player.getB1_choices(40) || player.getType() == 2)
        {
            choice3 = findViewById(R.id.choice_no2);
            choice3.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice2_1);
            c33 = findViewById(R.id.choice2_2);

            c31.setText(R.string.b1_69_1);
            c33.setText(R.string.b1_69_3);
        }
        else if (!player.getB1_choices(40) && player.isInventory(16))
        {
            choice3 = findViewById(R.id.choice_no2);
            choice3.setVisibility(View.VISIBLE);
            c32 = findViewById(R.id.choice2_1);
            c33 = findViewById(R.id.choice2_2);

            c32.setText(R.string.b1_69_2);
            c33.setText(R.string.b1_69_3);
        }
        else
        {
            choice3 = findViewById(R.id.choice_no1);
            choice3.setVisibility(View.VISIBLE);
            c33 = findViewById(R.id.choice1_1);

            c33.setText(R.string.b1_69_3);
        }

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_71();
            }
        });

        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_72();
            }
        });

        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_73();
            }
        });
    }

    public void b1_70()
    {
        allInvisible();
        player.setB1_choices(70);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_70a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_70a))
                    mainText.setText(R.string.b1_70b);
                else if (mainText.getText().toString().equals(R.string.b1_70b))
                {
                    mainText.setText(R.string.b1_70c);
                    c11.setText(R.string.b1_70_1);
                }
                else
                {
                    choice1.setVisibility(View.INVISIBLE);

                    b1_74();
                }
            }
        });
    }

    public void b1_71()
    {
        allInvisible();
        player.setB1_choices(71);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_71a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_71a))
                {
                    mainText.setText(R.string.b1_71b);
                    c11.setText(R.string.b1_71_1);
                }
                else
                {
                    choice1.setVisibility(View.INVISIBLE);

                    b1_74();
                }
            }
        });
    }

    public void b1_72()
    {
        allInvisible();
        player.setB1_choices(72);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_72a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_72a))
                    mainText.setText(R.string.b1_72b);
                else if (mainText.getText().toString().equals(R.string.b1_72b))
                {
                    mainText.setText(R.string.b1_72c);
                    c11.setText(R.string.b1_72_1);
                }
                else
                {
                    choice1.setVisibility(View.INVISIBLE);

                    b1_74();
                }
            }
        });
    }

    public void b1_73()
    {
        allInvisible();
        player.setB1_choices(73);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_73);
        c11.setText(R.string.b1_73_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                b1_28();
            }
        });
    }

    public void b1_74()
    {
        allInvisible();
        player.setB1_choices(74);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        mainText.setText(R.string.b1_74);

        if (player.isInventory(6) && !player.isInventory(12))
        {
            if (player.isInventory(11) && !player.isInventory(17))
            {
                if (player.isInventory(14) && !player.getB1_choices(78))
                {
                    choice4 = findViewById(R.id.choice_no4);
                    choice4.setVisibility(View.VISIBLE);
                    c41 = findViewById(R.id.choice4_1);
                    c42 = findViewById(R.id.choice4_2);
                    c43 = findViewById(R.id.choice4_3);
                    c44 = findViewById(R.id.choice4_4);

                    c41.setText(R.string.b1_74_1);
                    c42.setText(R.string.b1_74_2);
                    c43.setText(R.string.b1_74_3);
                    c44.setText(R.string.b1_74_4);
                }
                else
                {
                    choice4 = findViewById(R.id.choice_no3);
                    choice4.setVisibility(View.VISIBLE);
                    c41 = findViewById(R.id.choice3_1);
                    c42 = findViewById(R.id.choice3_2);
                    c44 = findViewById(R.id.choice3_3);

                    c41.setText(R.string.b1_74_1);
                    c42.setText(R.string.b1_74_2);
                    c44.setText(R.string.b1_74_4);
                }
            }
            else
            {
                if (player.isInventory(14) && !player.getB1_choices(78))
                {
                    choice4 = findViewById(R.id.choice_no3);
                    choice4.setVisibility(View.VISIBLE);
                    c41 = findViewById(R.id.choice3_1);
                    c43 = findViewById(R.id.choice3_2);
                    c44 = findViewById(R.id.choice3_3);

                    c41.setText(R.string.b1_74_1);
                    c43.setText(R.string.b1_74_3);
                    c44.setText(R.string.b1_74_4);
                }
                else
                {
                    choice4 = findViewById(R.id.choice_no2);
                    choice4.setVisibility(View.VISIBLE);
                    c41 = findViewById(R.id.choice2_1);
                    c44 = findViewById(R.id.choice2_2);

                    c41.setText(R.string.b1_74_1);
                    c44.setText(R.string.b1_74_4);
                }
            }
        }
        else
        {
            if (player.isInventory(11) && !player.isInventory(17))
            {
                if (player.isInventory(14) && !player.getB1_choices(78))
                {
                    choice4 = findViewById(R.id.choice_no3);
                    choice4.setVisibility(View.VISIBLE);
                    c42 = findViewById(R.id.choice3_1);
                    c43 = findViewById(R.id.choice3_2);
                    c44 = findViewById(R.id.choice3_3);

                    c42.setText(R.string.b1_74_2);
                    c43.setText(R.string.b1_74_3);
                    c44.setText(R.string.b1_74_4);
                }
                else
                {
                    choice4 = findViewById(R.id.choice_no2);
                    choice4.setVisibility(View.VISIBLE);
                    c42 = findViewById(R.id.choice2_1);
                    c44 = findViewById(R.id.choice2_2);

                    c42.setText(R.string.b1_74_2);
                    c44.setText(R.string.b1_74_4);
                }
            }
            else
            {
                if (player.isInventory(14) && !player.getB1_choices(78))
                {
                    choice4 = findViewById(R.id.choice_no2);
                    choice4.setVisibility(View.VISIBLE);
                    c43 = findViewById(R.id.choice2_1);
                    c44 = findViewById(R.id.choice2_2);

                    c43.setText(R.string.b1_74_3);
                    c44.setText(R.string.b1_74_4);
                }
                else
                {
                    choice4 = findViewById(R.id.choice_no1);
                    choice4.setVisibility(View.VISIBLE);
                    c44 = findViewById(R.id.choice1_1);

                    c44.setText(R.string.b1_74_4);
                }
            }
        }

        c41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                b1_76();
            }
        });

        c42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                b1_77();
            }
        });

        c43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                b1_78();
            }
        });

        c44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);

                b1_79();
            }
        });
    }

    public void b1_75()
    {
        allInvisible();
        player.setB1_choices(75);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        mainText.setText(R.string.b1_75);

        if (player.getB1_choices(40) || player.getB1_choices(72) || player.getType() == 2)
        {
            choice2 = findViewById(R.id.choice_no2);
            choice2.setVisibility(View.VISIBLE);
            c21 = findViewById(R.id.choice2_1);
            c22 = findViewById(R.id.choice2_2);

            c21.setText(R.string.b1_75_1);
            c22.setText(R.string.b1_75_2);
        }
        else
        {
            choice2 = findViewById(R.id.choice_no1);
            choice2.setVisibility(View.VISIBLE);
            c22 = findViewById(R.id.choice1_1);

            c22.setText(R.string.b1_75_2);
        }

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_74();
            }
        });

        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                b1_73();
            }
        });

    }

    public void b1_76()
    {
        allInvisible();
        player.setB1_choices(76);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_76);
        c11.setText(R.string.b1_76_1);

        player.addInventory(12);
        player.removeInventory(6);

        Toast toast = Toast.makeText(getApplicationContext(), "item : 치즈 사용, 허가증 획득", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
        toast.show();

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                b1_74();
            }
        });
    }

    public void b1_77()
    {
        allInvisible();
        player.setB1_choices(77);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_77a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainText.getText().toString().equals(R.string.b1_77a))
                {
                    mainText.setText(R.string.b1_77b);
                    c11.setText(R.string.b1_77_1);

                    player.addInventory(17);
                    player.removeInventory(11);

                    Toast toast = Toast.makeText(getApplicationContext(), "item : 스튜 사용, 마법책 획득", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
                    toast.show();
                }
                else
                {
                    choice1.setVisibility(View.INVISIBLE);
                    b1_74();
                }
            }
        });
    }

    public void b1_78()
    {
        allInvisible();
        player.setB1_choices(78);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_78a);
        c11.setText("next");

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText(R.string.b1_78b);
                choice1.setVisibility(View.INVISIBLE);

                choice3 = findViewById(R.id.choice_no3);
                choice3.setVisibility(View.VISIBLE);
                c31 = findViewById(R.id.choice3_1);
                c32 = findViewById(R.id.choice3_2);
                c33 = findViewById(R.id.choice3_3);
            }
        });

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_80();
            }
        });

        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_81();
            }
        });

        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);

                b1_82();
            }
        });

    }

    public void b1_79()
    {
        allInvisible();
        player.setB1_choices(79);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_79);
        c11.setText(R.string.b1_79_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                b1_28();
            }
        });
    }

    public void b1_80()
    {
        allInvisible();
        player.setB1_choices(80);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_80);
        c11.setText(R.string.b1_80_1);

        player.heal();
        player.removeInventory(14);
        Toast toast = Toast.makeText(getApplicationContext(), "heart +1, 잠드는 약 사용", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
        toast.show();

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                b1_74();
            }
        });
    }

    public void b1_81()
    {
        allInvisible();
        player.setB1_choices(81);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_81);
        c11.setText(R.string.b1_81_1);

        player.removeInventory(14);
        Toast toast = Toast.makeText(getApplicationContext(), "item: 잠드는 약 사용", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -380);
        toast.show();

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                mainText.setText("탈출!(미구현)");
            }
        });
    }

    public void b1_82()
    {
        allInvisible();
        player.setB1_choices(82);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.b1_82);
        c11.setText(R.string.b1_82_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                b1_74();
            }
        });
    }

    public void b1_100()
    {
        allInvisible();
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        mainText.setText(R.string.b1_100);
    }

    //옥상 시작
    public void f3_0() {
        allInvisible();
        player.setF3_choices(0);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice2 = findViewById(R.id.choice_no2);
        choice2.setVisibility(View.VISIBLE);
        c21 = findViewById(R.id.choice2_1);
        c22 = findViewById(R.id.choice2_2);

        mainText.setText(R.string.f3_0);
        c21.setText(R.string.f3_0_1);
        c22.setText(R.string.f3_0_2);

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);

                if(player.isInventory(13) == false && player.isInventory(4))
                    f3_5();
                else if (player.getSword() && player.getBook())
                    f3_1();
                else if (player.getBook())
                    f3_3();
                else if (player.getSword())
                    f3_2();
                else
                    f3_4();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                choice2.setVisibility(View.INVISIBLE);

                f2_0();
            }
        });
    }

    public void f3_1() {
        allInvisible();
        player.setF3_choices(1);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_1);

        if (player.isInventory(17))
        {
            c11.setText(R.string.f3_1_1);
        }
        else
            c11.setText(R.string.f3_1_2);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                if(player.isInventory(17)) {
                    player.damage();
                }
                else {
                    player.damage();
                    player.damage();
                }

                f3_10();
            }
        });
    }

    public void f3_2() {
        allInvisible();
        player.setF3_choices(2);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_2);

        c11.setText(R.string.f3_2_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                f3_6();
            }
        });
    }

    public void f3_3() {
        allInvisible();
        player.setF3_choices(3);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_3);

        if (player.isInventory(17))
        {
            c11.setText(R.string.f3_3_1);
        }
        else
            c11.setText(R.string.f3_3_2);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                if(player.isInventory(17))
                    f3_19();
                else
                    f3_20();
            }
        });
    }

    public void f3_4() {
        allInvisible();
        player.setF3_choices(4);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_4);

        c11.setText(R.string.f3_4_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                f3_0();
            }
        });
    }

    public void f3_5() {
        allInvisible();
        player.setF3_choices(5);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_5);

        c11.setText(R.string.f3_5_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                f3_0();
            }
        });
    }

    public void f3_6() {
        allInvisible();
        player.setF3_choices(6);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_6);

        if (player.isInventory(18))
        {
            c11.setText(R.string.f3_6_1);
        }
        else
            c11.setText(R.string.f3_6_2);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                if(player.isInventory(17)) {
                    player.damage();
                    player.damage();
                    f3_7();
                }
                else {
                    player.damage();
                    f3_7();
                }
            }
        });
    }

    public void f3_7() {
        allInvisible();
        player.setF3_choices(7);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_7);

        c11.setText(R.string.f3_7_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                //end03으로 이동
                Intent intent = new Intent(getApplicationContext(), subActivity_end.class);
                intent.putExtra("end", 3);
                startActivity(intent);
                finish();
            }
        });
    }

    public void f3_8() {
        allInvisible();
        player.setF3_choices(8);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_8);

        c11.setText(R.string.f3_8_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                //end04
                Intent intent = new Intent(getApplicationContext(), subActivity_end.class);
                intent.putExtra("end", 4);
                startActivity(intent);
                finish();
            }
        });
    }

    public void f3_9() {
        allInvisible();
        player.setF3_choices(9);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_9);

        c11.setText(R.string.f3_9_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                //end00
                Intent intent = new Intent(getApplicationContext(), subActivity_end.class);
                intent.putExtra("end", 0);
                startActivity(intent);
                finish();
            }
        });
    }

    public void f3_10() {
        allInvisible();
        player.setF3_choices(10);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_10);

        if (player.isInventory(18))
        {
            c11.setText(R.string.f3_10_1);
        }
        else
            c11.setText(R.string.f3_10_2);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                if(player.isInventory(18)) {
                    player.damage();
                    if (player.isInventory(17))
                        f3_11();
                    else
                        f3_18();
                }
                else {
                    player.damage();
                    player.damage();
                    f3_18();
                }
            }
        });
    }
    public void f3_11() {
        allInvisible();
        player.setF3_choices(11);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_11);

        if (player.getType() == 0)
            c11.setText(R.string.f3_11_1);
        else if (player.getType() == 2)
            c11.setText(R.string.f3_11_2);
        else
            c11.setText(R.string.f3_11_3);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                if(player.getType() == 0)
                    f3_12();
                else if (player.getType() == 2)
                    f3_13();
                else
                    f3_14();
            }
        });
    }

    public void f3_12() {
        allInvisible();
        player.setF3_choices(12);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_12);

        c11.setText(R.string.f3_12_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                f3_15();
            }
        });
    }

    public void f3_13() {
        allInvisible();
        player.setF3_choices(13);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_13);

        c11.setText(R.string.f3_13_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                f3_15();
            }
        });
    }

    public void f3_14() {
        allInvisible();
        player.setF3_choices(14);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_14);

        c11.setText(R.string.f3_14_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                f3_15();
            }
        });
    }

    public void f3_15() {
        allInvisible();
        player.setF3_choices(15);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_15);

        c11.setText(R.string.f3_15_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                f3_16();
            }
        });
    }

    public void f3_16() {
        allInvisible();
        player.setF3_choices(16);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_16);

        c11.setText(R.string.f3_16_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                f3_17();
            }
        });
    }

    public void f3_17() {
        allInvisible();
        player.setF3_choices(17);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_17);

        c11.setText(R.string.f3_17_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                //end01
                Intent intent = new Intent(getApplicationContext(), subActivity_end.class);
                intent.putExtra("end", 1);
                startActivity(intent);
                finish();
            }
        });
    }

    public void f3_18() {
        allInvisible();
        player.setF3_choices(18);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_18);

        c11.setText(R.string.f3_18_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                //end02
                Intent intent = new Intent(getApplicationContext(), subActivity_end.class);
                intent.putExtra("end", 2);
                startActivity(intent);
                finish();
            }
        });
    }

    public void f3_19() {
        allInvisible();
        player.setF3_choices(19);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_19);

        //2층 퀘 다함. 임의로 정함
        if (player.getF2_choices(90))
            c11.setText(R.string.f3_19_1);
        else
            c11.setText(R.string.f3_19_2);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                if (player.getF2_choices(90))
                    f3_21();
                else
                    f3_22();
            }
        });
    }
    public void f3_20() {
        allInvisible();
        player.setF3_choices(20);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_20);

        if (player.getF2_choices(90))
            c11.setText(R.string.f3_20_1);
        else
            c11.setText(R.string.f3_20_2);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                if(player.getF2_choices(90))
                    f3_21();
                else
                    f3_24();
            }
        });
    }

    public void f3_21() {
        allInvisible();
        player.setF3_choices(21);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_21);

        if (player.getF3_choices(19))
            c11.setText(R.string.f3_21_1);
        else
            c11.setText(R.string.f3_21_2);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                if (player.getF3_choices(19))
                    f3_25();
                else
                    f3_23();
            }
        });
    }

    public void f3_22() {
        allInvisible();
        player.setF3_choices(22);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_22);

        c11.setText(R.string.f3_22_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                //end06
                Intent intent = new Intent(getApplicationContext(), subActivity_end.class);
                intent.putExtra("end", 6);
                startActivity(intent);
                finish();
            }
        });
    }

    public void f3_23() {
        allInvisible();
        player.setF3_choices(23);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_23);

        c11.setText(R.string.f3_23_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                //end05
                Intent intent = new Intent(getApplicationContext(), subActivity_end.class);
                intent.putExtra("end", 5);
                startActivity(intent);
                finish();
            }
        });
    }

    public void f3_24() {
        allInvisible();
        player.setF3_choices(24);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_24);

        c11.setText(R.string.f3_24_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                //end00
                Intent intent = new Intent(getApplicationContext(), subActivity_end.class);
                intent.putExtra("end", 0);
                startActivity(intent);
                finish();
            }
        });
    }

    public void f3_25() {
        allInvisible();
        player.setF3_choices(25);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_25);

        c11.setText(R.string.f3_25_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                //end06
                Intent intent = new Intent(getApplicationContext(), subActivity_end.class);
                intent.putExtra("end", 6);
                startActivity(intent);
                finish();
            }
        });
    }

    public void f3_26() {
        allInvisible();
        player.setF3_choices(26);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        mainText.setText(R.string.f3_26);

        c11.setText(R.string.f3_26_1);

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);

                //end7
                Intent intent = new Intent(getApplicationContext(), subActivity_end.class);
                intent.putExtra("end", 7);
                startActivity(intent);
                finish();
            }
        });
    }
}
