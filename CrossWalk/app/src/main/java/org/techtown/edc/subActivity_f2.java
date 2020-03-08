package org.techtown.edc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class subActivity_f2<player> extends AppCompatActivity {
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

    //0황금주머니, 1수정구슬, 2육감티아라, 3새장열쇠, 4하녀옷, 5우유,6 치즈 7후추,
    // 8지랫대, 9바늘, 10밧줄, 11맛있는 스튜, 12허가증, 13 수선된 드레스, 14 잠드는 약, 15 빵조각, 16 동물과 말하는 약, 17 고대 마법책, 18 장검
    // 19 보청기, 20 서랍열쇠, 21 코코아;
    //(하얀 약장~)22 갈색의 고운 가루, 23 파란색의 단단한 금속, 24 빨간색의 뜨거운 기름, 25 하얀색의 말랑한 고체, 26 초록색의 푹신한 섬유
    //(갈색 약장~)27울새의 깃털, 28 나비의 날개, 29 고양이의 수염, 30 송어의 비늘, 31 개구리 알
    int [] itemlist = new int [20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subf2);
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
                startActivity(new Intent(subActivity_f2.this, map.class));
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

        if(intent.getIntExtra("floor", 2) == 3) {
            f2_79();
        } else{
            f2_0();
        }

    }

    public void f2_0(){
        player.setF2_choices(0);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_0));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                f2_27();
            }
        });
    }
    public void f2_1(){
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
                } else if(player.isInventory(14)){ //잠드는 약 == 코코아.
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
        player.setF2_choices(4);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        mainText.setText(getString(R.string.f2_4));
        if(!player.getF2_choices(88)){
            choice4 = findViewById(R.id.choice_no4); choice4.setVisibility(View.VISIBLE);
            c41 = findViewById(R.id.choice4_1); c42 = findViewById(R.id.choice4_2); c43 = findViewById(R.id.choice4_3);
            c44 = findViewById(R.id.choice4_4);
        } else{
            choice4 = findViewById(R.id.choice_no3); choice3.setVisibility(View.VISIBLE);
            c41 = findViewById(R.id.choice3_1); c42 = findViewById(R.id.choice3_2); c43 = findViewById(R.id.choice4_3);
            c44 = findViewById(R.id.choice4_4);
        }
        c41.setText(getString(R.string.f2_4c1)); c42.setText(getString(R.string.f2_4c2)); c43.setText(getString(R.string.f2_4c3)); c44.setText(getString(R.string.f2_4c4));
        c41.setOnClickListener(new View.OnClickListener() {
            @Override
            //서랍열쇠v
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);
                if(player.isInventory(20) && !player.getF2_choices(83)){
                    f2_83();
                } else if (player.isInventory(20) && player.getF2_choices(83)){
                    f2_84();
                } else {
                    f2_85();
                }
            }
        });
        c42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);
                if(player.getF2_choices(40) && !player.getF2_choices(86)){
                    f2_86();
                }else{
                    f2_87();
                }
            }
        });
        c43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);
                f2_1();
            }
        });
        c44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);
                f2_88();
            }
        });
    }
    public void f2_5(){
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
        player.setF2_choices(6);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        choice2 = findViewById(R.id.choice_no2); c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        if(mainText.getText().toString().equals(getString(R.string.f2_6_4))){
            choice1.setVisibility(View.INVISIBLE);
            choice2.setVisibility(View.VISIBLE);
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
        }else if(mainText.getText().toString().equals(getString(R.string.f2_6_3))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_6_4));
                    choice1.setVisibility(View.INVISIBLE);
                    f2_6();
                }
            });
        }else if(mainText.getText().toString().equals(getString(R.string.f2_6_2))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_6_3));
                    f2_6();
                }
            });
        } else {
            choice1.setVisibility(View.VISIBLE); c11.setText(getString(R.string.click));
            mainText.setText(getString(R.string.f2_6_1));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_6_2));
                    f2_6();
                }
            });
        }
    }
    public void f2_7(){
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
        player.setF2_choices(14);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        int c2 = 0, c3 = 0, c4 = 0, c5 = 0, sumC = 0; //f2_14c2 ~ f2_14c5의 선택지 조건들 flag 변수
        int brown = 0, white = 0; //갈색약장/하얀약장 아이템 중 1개 이상 있는지 체크여부, 갈색(27-31), 하얀(22-26)
        for(int i = 22; i <= 26; i++){ //하얀약장 아이템 유무 체크
            if(player.isInventory(i)){
                white = 1;
                break;
            }
        }
        for(int i = 27; i <= 31; i++){ //갈색약장~
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
            if(player.isInventory(28) && player.isInventory(31)){
                //28 나비의 날개 31 개구리 알
                f2_17();
            }else if(player.isInventory(29) && player.isInventory(30) && !player.getF2_choices(18)){
                f2_18();
                //29 고양이 수염 30 송어의 알
            } else if(player.getF2Recipe(0) == 0){ //첫번째 실패 레시피1
                int a = 0, b = 0;
                for(int i = 27; i <= 31; i++){ //갈색약장 아이템 뭐 있는지 체크, 저장
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
                for(int i = 27; i <= 31; i++){ //갈색약장 체크,
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
            if(player.isInventory(22) && player.isInventory(25)){
                //갈색가루 22 , 하얀 고체 25
                f2_25();
            } else if(player.isInventory(24) && player.isInventory(26)){
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

        if(player.getF2_choices(29) && !player.getF2_choices(26)){
            c4 = 1;
        } else{
            if(player.getF2_choices(26) && player.isInventory(10)) { //item 10 = 밧줄
                c5 = 1;
            }
            if(player.getF2_choices(26) && player.isInventory(2)){
                c6 = 1;
            }
        }

        if(c5 == 1 && c6 == 1){
            choice5 = findViewById(R.id.choice_no5);
            c51 = findViewById(R.id.choice5_1); c52 = findViewById(R.id.choice5_2); c53 = findViewById(R.id.choice5_3);
            c54 = findViewById(R.id.choice5_4); c55 = findViewById(R.id.choice5_5);
            c54.setText(getString(R.string.f2_28c5));
            c55.setText(getString(R.string.f2_28c6));
        } else if(c4 == 1 || c5 == 1 || c6 == 1){
            choice5 = findViewById(R.id.choice_no4);
            c51 = findViewById(R.id.choice4_1); c52 = findViewById(R.id.choice4_2); c53 = findViewById(R.id.choice4_3);
            c54 = findViewById(R.id.choice4_4); c55 = findViewById(R.id.choice5_5);
        }
        choice5.setVisibility(View.VISIBLE);
        c51.setText(getString(R.string.f2_28c1));
        c52.setText(getString(R.string.f2_28c2));
        c53.setText(getString(R.string.f2_28c3));

        if(c4 == 1) {
            c54.setText(getString(R.string.f2_28c4));
        } else if(c5 == 1){
            c54.setText(getString(R.string.f2_28c5));
        } else if (c6 == 1){
            c54.setText(getString(R.string.f2_28c6));
        }

        c51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice5.setVisibility(View.INVISIBLE);
                if(player.getF2_choices(22) && !player.getF2_choices(25)){
                    f2_30();
                } else{
                    f2_36();
                }
            }
        });
        c52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice5.setVisibility(View.INVISIBLE);
                if(player.getF2_choices(10) && (!player.getF2_choices(17) || !player.getF2_choices(21))
                        || player.getF2_choices(54) && !player.getF2_choices(56)){
                    f2_31();
                } else{
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
                if(finalC4 == 1){
                    f2_26();
                } else if(finalC5 == 1){
                    f2_41();
                } else if(finalC6 == 1){
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
    public void f2_30(){
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
        for(int i = 22; i <= 26; i++){
            if(player.isInventory(i)){
                player.removeInventory(i);
            }
        }

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                player.addInventory(22); //갈색가루
                f2_37();
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                player.addInventory(23); //파란색 금속
                f2_37();
            }
        });
        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                player.addInventory(24); //빨간 기름름
               f2_37();
            }
        });

    }
    public void f2_31(){
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
        for(int i = 27; i <= 31; i++){
            if(player.isInventory(i)){
                player.removeInventory(i);
            }
        }

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                player.addInventory(27); //울새 깃털
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
                player.addInventory(28); //나비 날개
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
                player.addInventory(29); //구양이 수염
                if(player.getF2_choices(54) && !player.getF2_choices(56)){
                    f2_89();
                } else{
                    f2_32();
                }
            }
        });

    }
    public void f2_32(){
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
                player.addInventory(30); //송어
                f2_35();
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                player.addInventory(31); //개구리
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
                player.addInventory(30); //송어
                f2_35();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                player.addInventory(31); //개구리
                f2_35();
            }
        });
    }
    public void f2_34(){
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
                player.addInventory(25); //하얀 고체
                f2_35();
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                player.addInventory(26); //초록 섬유
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
                player.addInventory(25); //하얀 고체
                f2_35();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                player.addInventory(26); //초록 섬유
                f2_35();
            }
        });
    }
    public void f2_39(){
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
        player.setF2_choices(50);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
        mainText.setText(getString(R.string.f2_50_1)); c11.setText(getString(R.string.click));
        choice1.setVisibility(View.VISIBLE);
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
        player.setF2_choices(55);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        mainText.setText(getString(R.string.f2_55));
        int c1 = 0, c2 = 0, c3 = 0, sumC = 0;
        if(player.isInventory(27)){ c1 = 1;}
        if((player.isInventory(28) || player.isInventory(29)) && !player.getF2_choices(52)){c2 = 1;}
        if((player.isInventory(28) || player.isInventory(29)) && player.getF2_choices(52)){c3 = 1;}
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
                } else {
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
        player.setF2_choices(79);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice2 = findViewById(R.id.choice_no2); c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        mainText.setText(getString(R.string.f2_79)); c21.setText(getString(R.string.f2_79c1)); c22.setText(getString(R.string.f2_79c2));
        choice2.setVisibility(View.VISIBLE);
        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                mainText.setText("구현 아직 안했....");
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(getApplicationContext(), subActivity_f1.class);
                intent.putExtra("player", player);
                intent.putExtra("floor", 2);
                startActivity(intent);
                finish();
            }
        });
    }
    public void f2_80(){
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
                    c11.setText(getString(R.string.f2_87c1));
                } else {
                    choice1.setVisibility(View.INVISIBLE);
                    f2_4();
                }
            }
        });
    }
    public void f2_88(){
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

    public void f2_100(){
        mainText = findViewById(R.id.main_text);
        mainText.setText(getString(R.string.f2_100));
    }
}
