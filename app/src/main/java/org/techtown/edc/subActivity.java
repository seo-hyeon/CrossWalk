package org.techtown.edc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class subActivity extends AppCompatActivity {
    //FrameLayout icon_pop;
    LinearLayout map, choice1, choice2, choice3, choice4;
    TextView character, mainText;
    Button c11, c21, c22, c31, c32, c33, c41, c42, c43, c44;
    String position = " ";
    String player = " ";
    int []choices = new int [62];

    int life = 5;
    //0황금주머니, 1수정구슬, 2육감티아라, 3새장열쇠, 4하녀옷, 5우유, 6치즈, 7후추, 8지랫대, 9바늘, 10밧줄, 11맛있는 스튜, 12허가증
    int [] itemlist = new int [20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.INVISIBLE);
        choice2 = findViewById(R.id.choice_no2); choice2.setVisibility(View.INVISIBLE);
        choice3 = findViewById(R.id.choice_no3); choice3.setVisibility(View.INVISIBLE);
        choice4 = findViewById(R.id.choice_no4); choice4.setVisibility(View.INVISIBLE);

        //Button heart = findViewById(R.id.b42);
        //heart.setText(life);

        //일단 임시로 setting 버튼 첫화면으로 가는 버튼으로 바꿈, 이후 팝업창 만들어서 저장등 메뉴 띄울 생각
        Button home = findViewById(R.id.b45);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

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

        f1_51();
    }

    public void choosePrincess() {
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
                who.setText(getString(R.string.goldP));
                itemlist[0] = 1;
                player = getString(R.string.goldP);
                choice3.setVisibility(View.INVISIBLE);
                f1_52();
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //who 버튼 구현 및 play staus 구현 후 자세히 설정 현재는 text만 설정.
                Button who = findViewById(R.id.b41);
                who.setText(getString(R.string.starP));
                itemlist[1] = 1;
                player = getString(R.string.starP);
                choice3.setVisibility(View.INVISIBLE);
                f1_52();
            }
        });
        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //who 버튼 구현 및 play staus 구현 후 자세히 설정 현재는 text만 설정.
                Button who = findViewById(R.id.b41);
                who.setText(getString(R.string.tigerP));
                itemlist[2] = 1;
                player = getString(R.string.tigerP);
                choice3.setVisibility(View.INVISIBLE);
                f1_52();
            }
        });

    }

    public void f1_51(){
        choices[51] = 1;
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1);
        choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        character.setText(" ");
        mainText.setText(getString(R.string.f1_51_1));
        c11.setText(getString(R.string.click));

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                character.setText(getString(R.string.doll_dog));
                mainText.setText(getString(R.string.f1_51_2));
                choice1.setVisibility(View.INVISIBLE);
                choosePrincess();
            }
        });


    }

    public void f1_52(){
        choices[52] = 1;
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice2 = findViewById(R.id.choice_no2);
        choice2.setVisibility(View.VISIBLE);
        c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);

        character.setText(getString(R.string.doll_dog));
        mainText.setText(String.format(getString(R.string.f1_52), player));
        c21.setText(getString(R.string.f1_52c1));
        c22.setText(getString(R.string.f1_52c2));

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f1_0();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f1_0();
            }
        });

    }

    public void f1_0(){
        choices[0] = 1;
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        if(itemlist[0] == 1) {
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

        if(itemlist[0] == 1) {
            c44.setText(getString(R.string.f1_0c4));
            c44.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice4.setVisibility(View.INVISIBLE);
                    f1_4();
                }
            });
        }

        c41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);
                choice3.setVisibility(View.INVISIBLE);
                f1_1();
            }
        });
        c42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);
                choice3.setVisibility(View.INVISIBLE);
                f1_2();
            }
        });
        c43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);
                choice3.setVisibility(View.INVISIBLE);
                f1_3();
            }
        });

    }

    public void f1_1(){
        choices[1] = 1;
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice3 = findViewById(R.id.choice_no3); choice2 = findViewById(R.id.choice_no2);

        if(itemlist[0] == 1) {
            choice3.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice3_1);
            c32 = findViewById(R.id.choice3_2);
            c33 = findViewById(R.id.choice3_3);
        }
        else{
            choice2.setVisibility(View.VISIBLE);
            c31 = findViewById(R.id.choice2_1);
            c32 = findViewById(R.id.choice2_2);
        }

        character.setText(getString(R.string.doll_dog));
        mainText.setText(getString(R.string.f1_1));
        c31.setText(getString(R.string.f1_0c2));
        c32.setText(getString(R.string.f1_0c3));

        if(itemlist[0] == 1) {
            c33.setText(getString(R.string.f1_0c4));
            c33.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice3.setVisibility(View.INVISIBLE);
                    f1_4();
                }
            });
        }
        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                choice2.setVisibility(View.INVISIBLE);
                f1_2();
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                choice2.setVisibility(View.INVISIBLE);
                f1_3();
            }
        });

    }

    public void f1_2(){
        choices[2] = 1;
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice2 = findViewById(R.id.choice_no2); choice1 = findViewById(R.id.choice_no1);
        c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        c11 = findViewById(R.id.choice1_1);

        if(mainText.getText().toString().equals(getString(R.string.f1_2_2))){
            choice2.setVisibility(View.VISIBLE);
            c21.setText(getString(R.string.f1_2c1));
            c22.setText(getString(R.string.f1_23c2));
            c21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    f1_5();
                }
            });
            c22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    f1_6();
                }
            });
        }else {
            choice1.setVisibility(View.VISIBLE);
            character.setText(getString(R.string.doll_dog));
            mainText.setText(getString(R.string.f1_2_1));
            c11.setText(getString(R.string.click));

            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice1.setVisibility(View.INVISIBLE);
                    character.setText(" ");
                    mainText.setText(getString(R.string.f1_2_2));
                    f1_2();
                }
            });
        }

    }

    public void f1_3(){
        choices[3] = 1;

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
                f1_7();
            }
        });

        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f1_6();
            }
        });
    }

    public void f1_4(){
        choices[4] = 1;

        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        if(mainText.getText().toString().equals(getString(R.string.f1_4_2))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_4_3));
                    c11.setText(getString(R.string.f1_4c1));
                    //토스트 메세지 : 새장 열쇠를 얻었다!
                    itemlist[3] = 1;
                    f1_4();
                }
            });
        }
        else if(mainText.getText().toString().equals(getString(R.string.f1_4_3))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice1.setVisibility(View.INVISIBLE);
                    f1_9();
                }
            });
        }
        else {
            character.setText(getString(R.string.doll_dog));
            mainText.setText(getString(R.string.f1_4_1));

            c11.setText(getString(R.string.click));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_4_2));
                    f1_4();
                }
            });
        }
    }
    public void f1_5(){
        choices[5] = 1;

        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); choice2 = findViewById(R.id.choice_no2);
        c11 = findViewById(R.id.choice1_1); c21 = findViewById(R.id.choice2_1);
        c22 = findViewById(R.id.choice2_2);

        if(mainText.getText().toString().equals(getString(R.string.f1_5_2))) {
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_5_3));
                    //토스트 메세지 하녀옷을 얻었다!
                    itemlist[4] = 1;

                    if (itemlist[0] == 1) {
                        choice1.setVisibility(View.INVISIBLE);
                        choice2.setVisibility(View.VISIBLE);
                        c21.setText(R.string.f1_0c3);
                        c22.setText(getString(R.string.f1_0c4));
                        f1_5();
                    }else{
                        c11.setText(R.string.f1_0c3);
                        f1_5();
                    }
                }
            });
        }else if(mainText.getText().toString().equals(getString(R.string.f1_5_3))) {
            if(itemlist[0] == 1){
                c21.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        choice2.setVisibility(View.INVISIBLE);
                        f1_3();
                    }
                });
                c22.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        choice2.setVisibility(View.INVISIBLE);
                        f1_4();
                    }
                });
            } else{
                c11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        choice1.setVisibility(View.INVISIBLE);
                        f1_3();
                    }
                });
            }
        } else{
            choice1.setVisibility(View.VISIBLE);
            character.setText(getString(R.string.doll_dog));
            mainText.setText(getString(R.string.f1_5_1));
            c11.setText(getString(R.string.click));

            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_5_2));
                    f1_5();
                }
            });
        }
    }

    public void f1_6(){
        choices[6] = 1;

        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice2 = findViewById(R.id.choice_no2); choice2.setVisibility(View.VISIBLE);
        c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);


        character.setText(" "); mainText.setText(getString(R.string.f1_6));
        c21.setText(getString(R.string.f1_6c1));
        c22.setText(getString(R.string.f1_6c2));

        if(choices[2] == 1){
            c21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    f1_5();
                }
            });
        }
        else{
            c21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    f1_7();
                }
            });
        }
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f1_8();
            }
        });
    }

    public void f1_7(){
        choices[7] = 1;

        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);
        character.setText(" "); mainText.setText(getString(R.string.f1_7));
        if(choices[6] == 1){
            c11.setText(getString(R.string.f1_7c1));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice1.setVisibility(View.INVISIBLE);
                    f1_8();
                }
            });
        }else{
            c11.setText(getString(R.string.f1_7c2));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice1.setVisibility(View.INVISIBLE);
                    f1_6();
                }
            });
        }
    }
    public void f1_8(){
        choices[8] = 1;
        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);

        if(mainText.getText().toString().equals(getString(R.string.f1_53)) || (mainText.getText().toString().equals(getString(R.string.f1_54)))){
            c11.setText(getString(R.string.f1_8c1));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice1.setVisibility(View.INVISIBLE);
                    f1_9();
                }
            });
        }else {
            character.setText(" ");
            mainText.setText(getString(R.string.f1_8));
            c11.setText(getString(R.string.click));
            if (choices[2] == 1) {
                c11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mainText.setText(getString(R.string.f1_54));
                        choice1.setVisibility(View.INVISIBLE);
                        f1_8();
                    }
                });
            } else {
                c11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mainText.setText(getString(R.string.f1_53));
                        choice1.setVisibility(View.INVISIBLE);
                        f1_8();
                    }
                });
            }
        }

    }

    public void f1_9(){
        choices[9] = 1;

        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); choice4 = findViewById(R.id.choice_no4);
        choice1.setVisibility(View.VISIBLE);
        c41 = findViewById(R.id.choice4_1); c42 = findViewById(R.id.choice4_2);
        c43 = findViewById(R.id.choice4_3); c44 = findViewById(R.id.choice4_4);
        c11 = findViewById(R.id.choice1_1);

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
                f1_10();
            }
        });
        c42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);
                f1_11();
            }
        });
        c43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);
                //f1_12();
            }
        });
        c44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);
                //f1_13();
            }
        });

    }

    public void f1_10(){
        choices[10] = 1;

        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); choice2 = findViewById(R.id.choice_no2); choice3 = findViewById(R.id.choice_no3);
        c11 = findViewById(R.id.choice1_1);

        choice1.setVisibility(View.VISIBLE);
        mainText.setText(getString(R.string.f1_10_1));
        c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText(getString(R.string.f1_10_2));
                choice1.setVisibility(View.INVISIBLE);
            }
        });

        //재봉사 이야기 들었는지 여부에 의해 수정될 예정, 일단 틀만 만들어 두자.
        choice3.setVisibility(View.VISIBLE);
        c31 = findViewById(R.id.choice3_1);  c32 = findViewById(R.id.choice3_2);  c33 = findViewById(R.id.choice3_3);
        c31.setText(getString(R.string.f1_10c1));
        c32.setText(getString(R.string.f1_10c2));
        c33.setText(getString(R.string.f1_10c3));

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                //f1_14();
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                //f1_15();
            }
        });
        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //f1_16();
            }
        });
    }

    public void f1_11(){
        choices[11] = 1;

        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice2 = findViewById(R.id.choice_no2);
        c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        choice2.setVisibility(View.VISIBLE);

        mainText.setText(getString(R.string.f1_11));
        c21.setText(getString(R.string.f1_11c1));
        c22.setText(getString(R.string.f1_11c2));

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                if(choices[3] == 1 && itemlist[4] == 1){
                    //f1_17();
                } else if(choices[3] == 1 && itemlist[4] != 1){
                    //f1_56
                } else if(choices[3] != 1 && itemlist[4] == 1){
                    //f1_55
                } else if(choices[3] != 1 && itemlist[4] != 1){
                    //f1_18
                } else if (choices[18] == 1 && itemlist[4] != 1){
                    //f1_29
                } else if (choices[55] == 1 && (itemlist[5] == 1 || itemlist[6] == 1)){
                    //5.우유 또는 6.치즈 선택하는 선택지 출력
                    //f1_33
                } else if(choices[17] == 1 && itemlist[7] == 1){
                    //f1_34
                } else if(choices[17] == 1 && itemlist[7] == 1 && (itemlist[5] == 1 || itemlist[6] == 1)){
                    //5.우유, 6.치즈 선택 선택지 출력
                    //f1_35
                } else if((choices[33] == 1 && itemlist[7] == 1) || (itemlist[34] == 1 && (itemlist[5] == 1 || itemlist[6] == 1))){
                    //f1_36
                } else if(choices[35] == 1 || choices[36] == 1){
                    //f1_37
                } else{
                    //f1_100 : error 발생.
                }
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                if(choices[57] == 1 || choices[19] == 1){
                    f1_9();
                } else if (choices[2] == 1 && choices[5] != 1 && itemlist[1] != 1){
                    //f1_19();
                } else if (choices[2] == 1 && choices[5] != 1 && itemlist[1] == 1){
                    //f1_20();
                } else{
                    f1_9();
                }
            }
        });
    }

    public void f1_12(){
        choices[12] = 1;

        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1); choice2 = findViewById(R.id.choice_no2);

        mainText.setText(getString(R.string.f1_12));
        if(itemlist[8] == 1) {
            c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
            choice2.setVisibility(View.VISIBLE);

            c21.setText(getString(R.string.f1_12c1));
            c22.setText(getString(R.string.f1_11c2));
        }
    }

}