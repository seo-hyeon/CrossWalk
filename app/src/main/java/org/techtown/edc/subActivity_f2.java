package org.techtown.edc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class subActivity_f2 extends AppCompatActivity {
    ConstraintLayout choice1, choice2, choice3, choice4, choice5, choice6;
    TextView character, mainText;
    Button c11, c21, c22, c31, c32, c33, c41, c42, c43, c44, c51, c52, c53, c54, c55, c61, c62, c63, c64, c65, c66;
    Button b42;
    String position = " ";
    String name = " ";
    int []choices = new int [70];
    int []prev = new int [2];
    int life = 5;
    Princess player = new Princess();
    //0황금주머니, 1수정구슬, 2육감티아라, 3새장열쇠, 4하녀옷, 5우유,6 치즈 7후추,
    // 8지랫대, 9바늘, 10밧줄, 11맛있는 스튜, 12허가증, 13 수선된 드레스, 14 잠드는 약, 15 빵조각, 16 동물과 말하는 약, 17 고대 마법책, 18 장검
    // 19 보청기, 20 서랍열쇠;
    int [] itemlist = new int [20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subf2);
        //1층에서 썼었던 객체 가져옴.
        Intent intent = getIntent();
        Princess player = (Princess) intent.getSerializableExtra("player");

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
                choice5.setVisibility(View.INVISIBLE); choice6.setVisibility(View.INVISIBLE);
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

        b42 = findViewById(R.id.b42);
        b42.setText(String.valueOf(player.getHeart()));


        f2_0();

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
                f2_1();
            }
        });
    }
    public void f2_1(){
        player.setF2_choices(1);
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice6 = findViewById(R.id.choice_no6); choice6.setVisibility(View.VISIBLE);
        c61 = findViewById(R.id.choice6_1); c62 = findViewById(R.id.choice6_2); c63 = findViewById(R.id.choice6_3);
        c64 = findViewById(R.id.choice6_4); c65 = findViewById(R.id.choice6_5); c66 = findViewById(R.id.choice6_6);

        mainText.setText(getString(R.string.f2_1));

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
                    //f2_64();
                } else if(player.isInventory(21)){ //코코아v
                    //f2_76();
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
                    //f2_64();
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
                    //f2_28();
                }
            }
        });
        c66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice6.setVisibility(View.INVISIBLE);
                //f2_79();
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
                    //f2_53();
                } else{
                    //f2_14();
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
        if(player.isInventory(19)){ //보청기v
            c21.setText(getString(R.string.f2_3c1));
            c21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    if((player.getF1_choices(5) || player.getF1_choices(57)) && !player.getF2_choices(70)){
                        //f2_70();
                    }else if(!player.isInventory(4) && !player.getF2_choices(65)){
                        //f2_65();
                    }else if((player.getF2_choices(70) || player.getF2_choices(66)) && !player.getF2_choices(71)){
                        //f2_67();
                    } else{
                        //f2_72();
                    }
                }
            });
        } else { //보청기i
            c21.setText(getString(R.string.f2_3c2));
            c21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    //f2_74();
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
        if(!player.isInventory(15)){ //빵조각i
            choice3 = findViewById(R.id.choice_no3); choice3.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice3_1); c32 = findViewById(R.id.choice3_2); c33 = findViewById(R.id.choice3_3);
            c33.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice3.setVisibility(View.INVISIBLE);
                    //f2_88();
                }
            });
        } else{
            choice3 = findViewById(R.id.choice_no2); choice3.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice2_1); c32 = findViewById(R.id.choice2_2); c33 = findViewById(R.id.choice3_3);
        }
        c31.setText(getString(R.string.f2_4c1)); c32.setText(getString(R.string.f2_4c2)); c33.setText(getString(R.string.f2_4c3));
        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            //서랍열쇠v
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                if(player.isInventory(20) && !player.getF2_choices(83)){
                    //f2_83();
                } else if (player.isInventory(20) && player.getF2_choices(83)){
                    //f2_84();
                } else {
                    //f2_85();
                }
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                if(player.getF2_choices(40) && !player.getF2_choices(86)){
                    //f2_86();
                }else{
                    //f2_87();
                }
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
               //f2_47();
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
                    //f2_26();
                }
            });
            c22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    //f2_27();
                }
            });
        }else if(mainText.getText().toString().equals(getString(R.string.f2_6_3))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_6_4));
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
        choice2 = findViewById(R.id.choice_no2); c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);

        if(mainText.getText().toString().equals(getString(R.string.f2_7_3))){
            if(!player.getB1_choices(23) || !player.getF2_choices(50) || (!player.getB1_choices(23) && !player.getF2_choices(50)) && !player.getF2_choices(12)){
                choice2.setVisibility(View.VISIBLE); choice1.setVisibility(View.INVISIBLE);

                c21.setText(getString(R.string.f2_7c1)); c22.setText(getString(R.string.f2_7c2));
                c21.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        choice2.setVisibility(View.INVISIBLE);
                        f2_12();
                    }
                });
                c22.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        choice2.setVisibility(View.INVISIBLE);
                        if(!player.getF2_choices(15)){
                            //f2_15();
                        }else{
                            //f2_16();
                        }
                    }
                });
            }else{
                c11.setText(getString(R.string.f2_7c2));
                c11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        choice1.setVisibility(View.INVISIBLE);
                        if(!player.getF2_choices(15)){
                            //f2_15();
                        }else{
                            //f2_16();
                        }
                    }
                });
            }
        }else if(mainText.getText().toString().equals(getString(R.string.f2_7_2))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_7_3));
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
            if(!player.getB1_choices(23) || !player.getF2_choices(50) || (!player.getB1_choices(23) && !player.getF2_choices(50))){
               choice3 = findViewById(R.id.choice_no3);
               c31 = findViewById(R.id.choice3_1); c32 = findViewById(R.id.choice3_2); c33 = findViewById(R.id.choice3_3);
               c31.setText(getString(R.string.f2_8c1)); c32.setText(getString(R.string.f2_8c2)); c33.setText(getString(R.string.f2_8c3));

            } else{
                choice3 = findViewById(R.id.choice_no2);
                c31 = findViewById(R.id.choice2_1); c32 = findViewById(R.id.choice2_2); c33 = findViewById(R.id.choice3_3);
                c31.setText(getString(R.string.f2_8c1)); c32.setText(getString(R.string.f2_8c2));
            }
            choice3.setVisibility(View.VISIBLE);
            c31.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice3.setVisibility(View.INVISIBLE);
                    if(!player.getF2_choices(15)){
                        //f2_15();
                    }else{
                        //f2_16();
                    }
                }
            });
            c32.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice3.setVisibility(View.INVISIBLE);
                    f2_7();
                }
            });
            c33.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice3.setVisibility(View.INVISIBLE);
                    f2_12();
                }
            });

        }else if(mainText.getText().toString().equals(getString(R.string.f2_8_2))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_8_3));
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
        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f2_8();
            }
        });
        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                //f2_16();
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
                    //f2_16();
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
            if(!player.getF2_choices(7)){
                choice2 = findViewById(R.id.choice_no2);
                c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
                choice2.setVisibility(View.VISIBLE); choice1.setVisibility(View.INVISIBLE);
            }else{
                c21 = findViewById(R.id.choice1_1); c22 = findViewById(R.id.choice2_2);
                c21.setText(getString(R.string.f2_12c1));
            }
            c21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!player.getF2_choices(15)){
                        f2_15();
                    }else{ f2_16(); }
                }
            });
            c22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f2_12_4));
                    f2_7();
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
                    //f2_2();
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
                //f2_17();
            }else if(player.isInventory(29) && player.isInventory(30) && !player.getF2_choices(18)){
                //f2_18();
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
                //f2_19();
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
                    //f2_21();
                }else if(a == c && b == d){
                    //첫번째 실패 레시피와 같을 경우
                    // f2_20();
                } else{
                    //f2_100();
                }
            }
        } else if(txt.equals(getString(R.string.f2_14c3))){
            f2_13();
        } else  if(txt.equals(getString(R.string.f2_14c4))){
            //f2_22();
        } else  if(txt.equals(getString(R.string.f2_14c5))){
            if(player.isInventory(22) && player.isInventory(25)){
                //갈색가루 22 , 하얀 고체 25
                //f2_25();
            } else if(player.isInventory(24) && player.isInventory(26)){
                //빨간 기름 24, 초록 섬유 26
                //f2_24();
            } else {
                //f2_23();
            }
        } else {
            mainText.setText("error");
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
        c11.setText(getString(R.string.click));

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
}
