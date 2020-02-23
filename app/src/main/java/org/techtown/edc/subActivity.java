package org.techtown.edc;
import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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
    ConstraintLayout choice5;
    TextView character, mainText;
    Button c11, c21, c22, c31, c32, c33, c41, c42, c43, c44, c51, c52, c53, c54, c55;
    String position = " ";
    String player = " ";
    int []choices = new int [70];

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
        choice5 = findViewById(R.id.choice_no5); choice5.setVisibility(View.INVISIBLE);
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
            if (itemlist[2] == 1) {
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
                if(choices[14] == 0 && choices[15] == 0) {
                    f1_10();
                } else {
                    f1_15();
                }
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
                f1_12();
            }
        });
        c44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice4.setVisibility(View.INVISIBLE);
                f1_13();
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

                //재봉사 이야기 들었는지 여부에 의해 수정될 예정, 일단 틀만 만들어 두자.
                choice3.setVisibility(View.VISIBLE);
                c31 = findViewById(R.id.choice3_1);  c32 = findViewById(R.id.choice3_2);  c33 = findViewById(R.id.choice3_3);
                c31.setText(getString(R.string.f1_10c1));
                c32.setText(getString(R.string.f1_10c2));
                c33.setText(getString(R.string.f1_10c3));
            }
        });


        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                f1_14();
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                f1_15();
            }
        });
        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                f1_16();
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

                //우유나 후추가 없을 경우
                if(itemlist[5] == 0 && itemlist[7] == 0 ) {
                    if (choices[3] == 1 && itemlist[4] == 1 && choices[17] == 0) {
                        f1_17();
                    } else if (choices[3] == 1 && itemlist[4] == 0 && choices[56] == 0) {
                        f1_56();
                    } else if (choices[3] == 0 && itemlist[4] == 1 && choices[55] == 0) {
                        f1_55();
                    } else if (choices[3] == 0 && itemlist[4] == 0 && choices[18] == 0) {
                        f1_18();
                    } else if (choices[18] == 1 && itemlist[4] == 0 && choices[29] == 0) {
                        f1_29();
                    } else if ((choices[36] == 1 || choices[35] == 1) && choices[37] == 0){
                        f1_37();
                    }
                } //우유나 후추가 있을 경우.
                else if(itemlist[5] == 1 || itemlist[7] == 1){
                    if(itemlist[5] == 1 && choices[55] == 1 && choices[33] == 0){
                        f1_33();
                    } else if (itemlist[7] == 1 && choices[17] == 1 && choices[34] == 0){
                        f1_34();
                    } else if (choices[36] == 0 && ((itemlist[7] == 1 && choices[33] == 1) || (itemlist[5] == 1 && choices[34] == 1))){
                        f1_36();
                    }
                }
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                if(choices[57] == 1 || choices[19] == 1){
                    f1_9();
                } else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 0){
                    f1_19();
                } else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 1){
                    f1_20();
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
            c21 = findViewById(R.id.choice2_1);
            c22 = findViewById(R.id.choice2_2);
            choice2.setVisibility(View.VISIBLE);

            c21.setText(getString(R.string.f1_12c1));
            c22.setText(getString(R.string.f1_12c2));
        }else{
            c21 = findViewById(R.id.choice1_1);
            choice1.setVisibility(View.VISIBLE);
            c21.setText(getString(R.string.f1_12c1));
        }
        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                if(choices[57] == 1 || choices[19] == 1){
                    f1_9();
                }else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 0){
                    f1_19();
                }else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 1){
                    f1_20();
                }else {
                    f1_9();
                }
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f1_21();
            }
        });
    }

    public void f1_13(){
        choices[13] = 1;

        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice3 = findViewById(R.id.choice_no3); choice3.setVisibility(View.VISIBLE);
        c31 = findViewById(R.id.choice3_1); c32 = findViewById(R.id.choice3_2); c33 = findViewById(R.id.choice3_3);
        mainText.setText(getString(R.string.f1_13));
        c31.setText(getString(R.string.f1_13c1));  c32.setText(getString(R.string.f1_13c2));  c33.setText(getString(R.string.f1_13c3));

        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                //3_1(); //위로
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                //2_1(); // 아래로
            }
        });
        c33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice3.setVisibility(View.INVISIBLE);
                if(choices[57] == 1 || choices[19] == 1){
                    f1_9();
                }else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 0){
                    f1_19();
                }else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 1){
                    f1_20();
                }else {
                    f1_9();
                }
            }
        });

    }
    public void f1_14(){
        choices[14] = 1;

        character = findViewById(R.id.character); mainText = findViewById(R.id.main_text);
        choice2 = findViewById(R.id.choice_no2); choice2.setVisibility(View.VISIBLE);
        c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        mainText.setText(getString(R.string.f1_14));
        c21.setText(getString(R.string.f1_14c1));  c22.setText(getString(R.string.f1_14c2));

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f1_15();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                if(choices[57] == 1 || choices[19] == 1){
                    f1_9();
                } else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 0){
                    f1_19();
                } else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 1){
                    f1_20();
                } else{
                    f1_9();
                }
            }
        });
    }

    public void f1_15() {
        //추가 서술 조건상 choices[15]는 f1_152()에서 1로 체크됨.
        character = findViewById(R.id.character);
        mainText = findViewById(R.id.main_text);
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1);

        // 1. 15번 출력-> 버튼의 경우  2.15번출력 ->60번이나 61번 출력 -> 버튼의 경우
        mainText.setText(getString(R.string.f1_15)); //찐으로 처음와서 15번 출력하고 이 뒤에 60이나 61번 출력이 되는지 확인, 출력
        if (choices[60] == 0 && choices[15] == 0 && (choices[20] == 1 || choices[31] == 1)) { //60번 출력
            choice1.setVisibility(View.VISIBLE);
            c11.setText(getString(R.string.click));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice1.setVisibility(View.INVISIBLE);
                    mainText.setText(getString(R.string.f1_60));
                    choices[60] = 1;
                    f1_152();
                }
            });
        } else if (choices[60] == 1 || (choices[30] == 1 || choices[20] == 1)) { //61번 출력
            choice1.setVisibility(View.VISIBLE);
            c11.setText(getString(R.string.click));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice1.setVisibility(View.INVISIBLE);
                    mainText.setText(getString(R.string.f1_61));
                    choices[61] = 1;
                    f1_152();
                }
            });
        }else {
            f1_152();
        }

    }
    public void f1_152(){
        {
            choices[15] = 1;
            choice2 = findViewById(R.id.choice_no2); choice2.setVisibility(View.VISIBLE);
            c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);

            c21.setText(getString(R.string.f1_15c1));
            c22.setText(getString(R.string.f1_15c2));
            c21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    if (choices[61] == 1 && choices[23] == 0) {
                        f1_23();
                    } else if (choices[60] == 1 && choices[22] == 0) {
                        f1_22();
                    } else if (choices[60] == 0 && choices[61] == 0 && itemlist[4] == 1 && choices[24] == 0) {
                        f1_24();
                    } else if (choices[60] == 0 && choices[61] == 0 && itemlist[4] == 0 && choices[25] == 0) {
                        f1_25();
                    } else if (choices[24] == 1 && choices[25] == 1) {
                        f1_62();
                    } else if (choices[45] == 1) {
                        f1_47();
                    } else {
                        f1_100();
                    }
                }
            });
            c22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    if (choices[57] == 1 || choices[19] == 1) {
                        f1_9();
                    } else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 0) {
                        f1_19();
                    } else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 1) {
                        f1_20();
                    } else {
                        f1_9();
                    }
                }
            });
        }
    }
    public void f1_16(){
        choices[16] = 1;
        choice2 = findViewById(R.id.choice_no2); choice2.setVisibility(View.VISIBLE);
        c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);

        mainText.setText(getString(R.string.f1_16));
        itemlist[9] = 1; //바늘
        c21.setText(getString(R.string.f1_16c1));
        c22.setText(getString(R.string.f1_16c2));

        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f1_15();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                if (choices[57] == 1 || choices[19] == 1) {
                    f1_9();
                } else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 0) {
                    f1_19();
                } else if (choices[2] == 1 && choices[5] == 0 && itemlist[1] == 1) {
                    f1_20();
                } else {
                    f1_9();
                }
            }
        });
    }
    public void f1_17(){
        choices[17] = 1;
        choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.VISIBLE);
        c11 = findViewById(R.id.choice1_1);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);

        if(choices[18] == 1 && !mainText.getText().toString().equals(getString(R.string.f1_17_1))){
            choices[59] = 1;
            mainText.setText(getString(R.string.f1_5859));
            c11.setText(getString(R.string.click));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_17_1));
                    f1_17();
                }
            });
        } else if(choices[18] == 0 && !mainText.getText().toString().equals(getString(R.string.f1_17_1))){
            mainText.setText(getString(R.string.f1_17_1));
            f1_17();
        }

        if(mainText.getText().toString().equals(getString(R.string.f1_17_1))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_17_2));
                    f1_17();
                }
            });
        } else if(mainText.getText().toString().equals(getString(R.string.f1_17_2))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_17_3));
                    f1_17();
                }
            });
        } else if(mainText.getText().toString().equals(getString(R.string.f1_17_3))){
            c11.setText(getString(R.string.f1_17c1));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    f1_9();
                }
            });
        }
    }
    public void f1_55(){
        choices[55] = 1;
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);

        if(choices[18] == 1 && !mainText.getText().toString().equals(getString(R.string.f1_55_1))){
            choice1.setVisibility(View.VISIBLE);
            choices[58] = 1;
            mainText.setText(getString(R.string.f1_5859));
            c11.setText(getString(R.string.click));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_55_1));
                    f1_55();
                }
            });
        } else if(choices[18] == 0 && !mainText.getText().toString().equals(getString(R.string.f1_55_1))){
            mainText.setText(getString(R.string.f1_55_1));
            f1_55();
        }

        if(mainText.getText().toString().equals(getString(R.string.f1_55_1))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_55_2));
                    f1_55();
                }
            });
        } else if(mainText.getText().toString().equals(getString(R.string.f1_55_2))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice1.setVisibility(View.INVISIBLE);
                    mainText.setText(getString(R.string.f1_55_3));
                    f1_55();
                }
            });
        } else if(mainText.getText().toString().equals(getString(R.string.f1_55_3))){
            if(itemlist[5] == 0){
                choice2 = findViewById(R.id.choice_no1);
                c21 = findViewById(R.id.choice1_1);
            }
            else {
                choice2 = findViewById(R.id.choice_no2);
                c21 = findViewById(R.id.choice2_1);
                c22 = findViewById(R.id.choice2_2);
                c22.setText(getString(R.string.f1_55c2));
            }
            choice2.setVisibility(View.VISIBLE);
            c21.setText(getString(R.string.f1_55c1));
            c21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    if(choices[57] == 1 || choices[19] == 1){
                        f1_9();
                    } else if(choices[2] == 1 && choices[5] == 0 && itemlist[1] == 0){
                        f1_19();
                    } else if(choices[2] == 1 && choices[5] == 0 && itemlist[1] == 1){
                        f1_20();
                    }else{
                        f1_9();
                    }

                }
            });
            c22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    f1_50();
                }
            });
        }
    }
    public void f1_18(){
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);

        if(choices[18] == 0) {
            choices[18] = 1;
            mainText.setText(getString(R.string.f1_18_1));
            choice1.setVisibility(View.VISIBLE);
            c11.setText(getString(R.string.click));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_18_2));
                    f1_18();
                }
            });
        } else if(mainText.getText().toString().equals(getString(R.string.f1_18_2))) {
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_18_3));
                    if(choices[2] == 1 && choices[5] == 0 && choices[19] == 0){
                        f1_57();
                    }else{
                        f1_18();
                    }
                }
            });
        } else if(mainText.getText().toString().equals(getString((R.string.f1_18_3))) || mainText.getText().toString().equals(getString((R.string.f1_57_3)))){
            if(choices[57] == 1){
                choice2 = findViewById(R.id.choice_no2);
                choice2.setVisibility(View.VISIBLE);
                c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
                c21.setText(getString(R.string.f1_18c1)); c22.setText(getString(R.string.f1_18c2));
                c21.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        f1_28();
                    }
                });
                c22.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        f1_27();
                    }
                });
            } else{
                choice1.setVisibility(View.VISIBLE);
                c11.setText(getString(R.string.f1_18c1));
                c11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        f1_28();
                    }
                });
            }
        }


    }
    public void f1_57(){
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);

        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);

        if(choices[57] == 0) {
            choices[57] = 1;
            c11.setText(getString(R.string.click));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_57_1));
                    f1_57();
                }
            });
        } else if(mainText.getText().toString().equals(getString(R.string.f1_57_1))) {
            c11.setText(getString(R.string.click));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_57_2));
                    f1_57();
                }
            });
        } else if(mainText.getText().toString().equals(getString(R.string.f1_57_2))) {
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_57_3));
                    choice1.setVisibility(View.INVISIBLE);
                    f1_18();
                }
            });
        }
    }
    public void f1_56(){
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);

        if(choices[56] == 0) {
            choices[56] = 1;
            mainText.setText(getString(R.string.f1_18_1));
            choice1.setVisibility(View.VISIBLE);
            c11.setText(getString(R.string.click));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_18_2));
                    f1_56();
                }
            });
        } else if(mainText.getText().toString().equals(getString(R.string.f1_18_2))) {
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_18_3));
                    f1_56();
                }
            });
        } else if(mainText.getText().toString().equals(getString(R.string.f1_18_3))){
            c11.setText(getString(R.string.f1_18c1));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice1.setVisibility(View.INVISIBLE);
                    f1_48();
                }
            });
        }
    }
    public void f1_19(){
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);

        if(choices[19] == 0) {
            choices[19] = 1;
            mainText.setText(getString(R.string.f1_19_1));
            choice1.setVisibility(View.VISIBLE);
            c11.setText(getString(R.string.click));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_19_2));
                    f1_19();
                }
            });
        } else if(mainText.getText().toString().equals(getString(R.string.f1_19_2))) {
            if(itemlist[0] == 1) {c11.setText(getString(R.string.f1_19c1));}
            else if(itemlist[2] == 1){c11.setText(getString(R.string.f1_19c2));}
            else if(itemlist[1] == 1){c11.setText(getString(R.string.click));}
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice1.setVisibility(View.INVISIBLE);
                    if(itemlist[0] == 1){
                        f1_30();
                    }else if (itemlist[2] == 1){
                        Random rd = new Random();
                        int sf = rd.nextInt(2);
                        String stsf = String.valueOf(sf); //확인용2222
                        c11.setText(stsf); //호랑이 공주 난수 잘 나오는지 확인용
                        if(sf == 0){ //호랑이공주 위협 성공
                            f1_31();
                        }else{ //위협 실패
                            f1_22();
                        }
                    } else if(itemlist[1] == 1){
                        f1_22();
                    }
                }
            });
        }
    }
    public void f1_20(){
        choices[20] = 1;
        choice2 = findViewById(R.id.choice_no2);
        c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        choice2.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        mainText.setText(getString(R.string.f1_20));
        c21.setText(getString(R.string.f1_20c1)); c22.setText(getString(R.string.f1_20c2));
        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f1_19();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f1_9();
            }
        });
    }

    public void f1_21(){
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1);
        choice1.setVisibility(View.VISIBLE);
        if(choices[21] == 0) {
            choices[21] = 1;
            mainText = findViewById(R.id.main_text);
            character = findViewById(R.id.character);
            mainText.setText(getString(R.string.f1_21_1));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_21_2));
                    choice1.setVisibility(View.INVISIBLE);
                    f1_21();
                }
            });
        }else{
            choice1.setVisibility(View.INVISIBLE);
            if(itemlist[9] == 1 || itemlist[2] == 1){
                if(itemlist[9] == 1 && itemlist[2] == 1){
                    choice3 = findViewById(R.id.choice_no3); choice3.setVisibility(View.VISIBLE);
                    c31 = findViewById(R.id.choice3_1); c32 = findViewById(R.id.choice3_2); c33 = findViewById(R.id.choice3_3);
                    c31.setText(getString(R.string.f1_21c1_2)); c32.setText(getString(R.string.f1_21c2)); c33.setText(getString(R.string.f1_21c3));
                    c31.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            choice3.setVisibility(View.INVISIBLE);
                            f1_9();
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
                }else {
                    choice2 = findViewById(R.id.choice_no2); choice2.setVisibility(View.VISIBLE);
                    c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
                    c21.setText(getString(R.string.f1_21c1_2));
                    if(itemlist[9] == 1 ){c22.setText(getString(R.string.f1_21c2));}
                    else if(itemlist[2] == 1){c22.setText(getString(R.string.f1_21c3));}
                    c21.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            choice2.setVisibility(View.INVISIBLE);
                            f1_9();
                        }
                    });
                    c22.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //도망
                            mainText.setText("도망엔딩");
                            choice2.setVisibility(View.INVISIBLE);
                        }
                    });
                }
            }else{
                c11.setText(getString(R.string.f1_21c1_1));
                c11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mainText.setText(getString(R.string.f1_21_2));
                        choice1.setVisibility(View.INVISIBLE);
                        f1_9();
                    }
                });
            }
        }
    }
    public void f1_22(){
        choices[22] = 1;
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
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
        choices[23] = 1;
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
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
        choices[24] = 1;
        choice2 = findViewById(R.id.choice_no2);
        c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        choice2.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        mainText.setText(getString(R.string.f1_24));
        c21.setText(getString(R.string.f1_24c1)); c22.setText(getString(R.string.f1_24c2));
        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f1_38();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f1_39();
            }
        });
    }
    public void f1_25(){
        choices[25] = 1;
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        choice2 = findViewById(R.id.choice_no2);
        c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);

        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        mainText.setText(getString(R.string.f1_25_1));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                choice2.setVisibility(View.VISIBLE);
                mainText.setText(getString(R.string.f1_25_2));
            }
        });

        c21.setText(getString(R.string.f1_25c1)); c22.setText(getString(R.string.f1_25c2));
        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f1_41();
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice2.setVisibility(View.INVISIBLE);
                f1_39();
            }
        });
    }
    public void f1_26(){
        choices[26] = 1;
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        mainText.setText(getString(R.string.f1_26));
        c11.setText(getString(R.string.click));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemlist[12] = 0;
                mainText.setText("도망 엔딩"); //도망 엔딩
                choice1.setVisibility(View.INVISIBLE);
            }
        });
    }
    public void f1_27(){
        choices[27] = 1;
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        mainText.setText(getString(R.string.f1_27));
        c11.setText(getString(R.string.f1_27c1));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                f1_28();
            }
        });
    }

    public void f1_28(){
        choices[28] = 1;
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        mainText.setText(getString(R.string.f1_28));
        c11.setText(getString(R.string.f1_28c1));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                f1_9();
            }
        });
    }
    public void f1_29() {
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1);
        choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);
        if (choices[29] == 0) {
            choices[29] = 1;
            mainText.setText(getString(R.string.f1_29_1));
            choice1.setVisibility(View.VISIBLE);
            c11.setText(getString(R.string.click));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_29_2));
                    f1_29();
                }
            });
        } else if (mainText.getText().toString().equals(getString(R.string.f1_19_2))) {
            c11.setText(getString(R.string.click));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice1.setVisibility(View.INVISIBLE);
                    mainText.setText(getString(R.string.f1_29_3)); //베드엔딩
                }
            });
        }
    }

    public void f1_30(){
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        if(choices[30] == 0){
            choices[30] = 1;
            mainText.setText(getString(R.string.f1_30_1));
            c11.setText(getString(R.string.click));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_30_2));
                    f1_30();
                }
            });
        }else if(mainText.getText().toString().equals(getString(R.string.f1_30_2))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice1.setVisibility(View.INVISIBLE);
                    f1_9();
                }
            });
        }
    }
    public void f1_31(){
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        if(choices[31] == 0) {
            choices[31] = 1;
            mainText.setText(getString(R.string.f1_31_1));
            c11.setText(getString(R.string.click));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_31_2));
                    itemlist[4] = 1;
                    f1_31();
                }
            });
        }else if(mainText.getText().toString().equals(getString(R.string.f1_31_2))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice1.setVisibility(View.INVISIBLE);
                    f1_9();
                }
            });
        }
    }
    public void f1_32(){
        choices[32] = 1;
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
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
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1);
        choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        if(choices[33] == 0){
            choices[33] = 1;
            mainText.setText(getString(R.string.f1_33_1));
            c11.setText(getString(R.string.click));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_33_2));
                    f1_33();
                }
            });
        }else if(mainText.getText().toString().equals(getString(R.string.f1_33_2))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_33_3));
                    f1_33();
                }
            });
        }else if(mainText.getText().toString().equals(getString(R.string.f1_33_3))){
            c11.setText(getString(R.string.f1_33c1));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemlist[5] = 0;
                    choice1.setVisibility(View.INVISIBLE);
                    f1_9();
                }
            });
        }
    }
    public void f1_34(){
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);

        if(choices[34] == 0){
            choices[34] = 1;
            mainText.setText(getString(R.string.f1_34_1));
            choice1.setVisibility(View.VISIBLE);
            c11.setText(getString(R.string.click));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_34_2));
                    f1_34();
                }
            });
        }else if(mainText.getText().toString().equals(getString(R.string.f1_34_2))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_34_3));
                    f1_34();
                }
            });
        }else if(mainText.getText().toString().equals(getString(R.string.f1_34_3))) {
            c22 = findViewById(R.id.choice2_2);
            if(itemlist[5] == 1) {
                c21 = findViewById(R.id.choice2_1);
                choice1.setVisibility(View.INVISIBLE);
                choice2.setVisibility(View.VISIBLE);
                c21.setText(getString(R.string.f1_34c1));
                c22.setText(getString(R.string.f1_34c2));
            }else{
                c21 = findViewById(R.id.choice1_1);
                c21.setText(getString(R.string.f1_34c1));
            }
            c21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    f1_9();
                }
            });
            c22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice2.setVisibility(View.INVISIBLE);
                    f1_35();
                }
            });
        }
    }
    public void f1_35(){
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        if(choices[35] == 0){
            choices[35] = 1;
            mainText.setText(getString(R.string.f1_35_1));
            c11.setText(getString(R.string.click));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_35_2));
                    f1_35();
                }
            });
        }else if(mainText.getText().toString().equals(getString(R.string.f1_35_2))){
            c11.setText(getString(R.string.f1_35c1));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice1.setVisibility(View.INVISIBLE);
                    f1_9();
                }
            });
        }
    }
    public void f1_36(){
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        if(choices[36] == 0){
            choices[36] = 1;
            mainText.setText(getString(R.string.f1_36_1));
            c11.setText(getString(R.string.click));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_36_2));
                    f1_36();
                }
            });
        }else if(mainText.getText().toString().equals(getString(R.string.f1_36_2))){
            c11.setText(getString(R.string.f1_36c1));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice1.setVisibility(View.INVISIBLE);
                    f1_9();
                }
            });
        }
    }
    public void f1_37(){
        choices[37] = 1;
        choice1 = findViewById(R.id.choice_no1);
        c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        mainText.setText(getString(R.string.f1_37));
        c11.setText(getString(R.string.f1_37c1));
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice1.setVisibility(View.INVISIBLE);
                f1_9();
            }
        });
    }
    public void f1_38(){
        choices[38] = 1;
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        mainText.setText(getString(R.string.f1_38));

        c41 = findViewById(R.id.choice4_1);  c42 = findViewById(R.id.choice4_2);
        c43 = findViewById(R.id.choice4_3);  c44 = findViewById(R.id.choice4_4);
        c42.setText("_"); c43.setText("_"); c44.setText("_");

        int cook = 0, pill = 0, maid = 0, gold = 0, sumC = 0;
        if((choices[17] == 1 || choices[33] == 1 || choices[34] == 1 || choices[55] == 1) && choices[36] == 0 && choices[35] == 0){
            cook = 1;
        }
        if(itemlist[0] == 1){
            gold = 1;
        }
        //maid와 pill 확인용 임시 조건
        if(itemlist[3] == 1){
            maid = 1;
        }
        if(itemlist[4] == 1){
            pill = 1;
        }
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
            f1_32();
        } else  if(txt.equals(getString(R.string.f1_38c3))){
            //mainText.setText("maid");
            f1_44();
        } else  if(txt.equals(getString(R.string.f1_38c4))){
            //mainText.setText("pill");
            f1_43();
        } else  if(txt.equals(getString(R.string.f1_38c5))){
            //mainText.setText("cook");
            f1_42();
        } else {
            mainText.setText("error");
        }
   }
   public void f1_39(){
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
       choice2 = findViewById(R.id.choice_no1); c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
        c11.setText(getString(R.string.click));
        if(choices[39] == 0){
            choices[39] = 1;
            mainText.setText(getString(R.string.f1_39_1));
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_39_2));
                    f1_39();
                }
            });
        }else if(mainText.getText().toString().equals(getString(R.string.f1_39_2))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_39_3));
                    f1_39();
                }
            });
        } else if(mainText.getText().toString().equals(getString(R.string.f1_39_3))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_39_4));
                    f1_39();
                }
            });
        } else if(mainText.getText().toString().equals(getString(R.string.f1_39_4))){
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText(getString(R.string.f1_39_5));
                    f1_39();
                }
            });
        }else if(mainText.getText().toString().equals(getString(R.string.f1_39_5))){
            choice1.setVisibility(View.INVISIBLE);
            choice2.setVisibility(View.VISIBLE);
            c21.setText(getString(R.string.f1_39c1)); c22.setText(getString(R.string.f1_39c2));

            c21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(choices[24] == 1 && choices[25] == 0){
                        f1_38();
                    }else if(choices[24] == 0 && choices[25] == 1){
                        f1_41();
                    }
                }
            });
            c22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(choices[57] == 1 || choices[19] == 1){
                        f1_9();
                    }else if(choices[2] == 1 && choices[5] == 0 && itemlist[1] == 0){
                        f1_19();
                    }else if(choices[2] == 1 && choices[5] == 0 && itemlist[1] == 1){
                        f1_20();
                    }else{
                        f1_9();
                    }
                }
            });
        }
   }
   public void f1_40(){
        choices[40] = 1;
        mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
        mainText.setText(getString(R.string.f1_40));
        choice2 = findViewById(R.id.choice_no2); choice2.setVisibility(View.VISIBLE);
        c21 = findViewById(R.id.choice2_1); c22 =findViewById(R.id.choice2_2);
        c21.setText(getString(R.string.f1_40c1)); c21.setText(getString(R.string.f1_40c2));
       c21.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              f1_38();
           }
       });
       c21.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              f1_9();
           }
       });
   }
   public void f1_41(){
       choice1 = findViewById(R.id.choice_no1); c11 = findViewById(R.id.choice1_1);
       mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);

       if(choices[41] == 0){
           choices[41] = 1;
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
       }else if(mainText.getText().toString().equals(getString(R.string.f1_41_2))) {
           c22 = findViewById(R.id.choice2_2);
           if(itemlist[12] == 1) {
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
                   f1_9();
               }
           });
           c22.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   choice2.setVisibility(View.INVISIBLE);
                   f1_26();
               }
           });
       }
   }
   public void f1_42(){
       choices[42] = 1;
       choice1 = findViewById(R.id.choice_no1);
       c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
       mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
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
       choices[43] = 1;
       choice1 = findViewById(R.id.choice_no1);
       c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
       mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
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
       choice1 = findViewById(R.id.choice_no1);
       c11 = findViewById(R.id.choice1_1); choice1.setVisibility(View.VISIBLE);
       mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
       if(choices[44] == 0) {
           choices[44] = 1;
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
       choices[45] = 1;
       mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
       mainText.setText(getString(R.string.f1_45));
       if(itemlist[0] == 1){
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
               choice2.setVisibility(View.INVISIBLE);
               f1_15();
           }
       });
       c22.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               choice2.setVisibility(View.INVISIBLE);
               f1_46();
           }
       });
   }
   public void f1_46(){
       choices[46] = 1;
       mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
       mainText.setText(getString(R.string.f1_46));

       choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.VISIBLE);
       c11 = findViewById(R.id.choice1_1); c11.setText(getString(R.string.f1_46c1));

       c11.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               choice1.setVisibility(View.INVISIBLE);
               f1_9();
           }
       });
   }
   public void f1_47(){
       choices[47] = 1;
       mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
       mainText.setText(getString(R.string.f1_47));

       choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.VISIBLE);
       c11 = findViewById(R.id.choice1_1); c11.setText(getString(R.string.f1_47c1));

       c11.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               choice1.setVisibility(View.INVISIBLE);
               f1_9();
           }
       });
   }
   public void f1_48(){
       choices[48] = 1;
       mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
       mainText.setText(getString(R.string.f1_48));

       choice1 = findViewById(R.id.choice_no1); choice1.setVisibility(View.VISIBLE);
       c11 = findViewById(R.id.choice1_1); c11.setText(getString(R.string.f1_48c1));

       c11.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               choice1.setVisibility(View.INVISIBLE);
               f1_9();
           }
       });
   }
   public void f1_49(){
       choices[49] = 1;
       mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
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
       choice1 = findViewById(R.id.choice_no1);
       c11 = findViewById(R.id.choice1_1);
       choice1.setVisibility(View.VISIBLE);
       mainText = findViewById(R.id.main_text);
       character = findViewById(R.id.character);
       if (choices[50] == 0) {
           choices[50] = 1;
           mainText.setText(getString(R.string.f1_50_1));
           c11.setText(getString(R.string.click));
           c11.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   mainText.setText(getString(R.string.f1_50_2));
                   f1_44();
               }
           });
       } else {
           c11.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   choice1.setVisibility(View.INVISIBLE);
                   f1_9();
               }
           });
       }
   }
   public void f1_62(){
       choices[62] = 1;
       choice2 = findViewById(R.id.choice_no2);
       c21 = findViewById(R.id.choice2_1); c22 = findViewById(R.id.choice2_2);
       choice2.setVisibility(View.VISIBLE);
       mainText = findViewById(R.id.main_text); character = findViewById(R.id.character);
       mainText.setText(getString(R.string.f1_62));
       c21.setText(getString(R.string.f1_62c1)); c22.setText(getString(R.string.f1_62c2));
       c21.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               choice2.setVisibility(View.INVISIBLE);
               f1_9();
           }
       });
       c22.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               choice2.setVisibility(View.INVISIBLE);
               if(itemlist[4] == 1){
                   if(choices[25] == 1){
                       f1_40();
                   }else if(choices[25] == 0){
                       f1_38();
                   }
               } else if(itemlist[4] == 0){
                   f1_41();
               }
           }
       });
   }
   public void f1_100(){
        mainText = findViewById(R.id.main_text);
        mainText.setText(getString(R.string.f1_100));
   }
}