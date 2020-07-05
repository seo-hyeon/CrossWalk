package org.techtown.edc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class subActivity_f3<player> extends AppCompatActivity {

    ConstraintLayout choice1, choice2, choice3, choice4, choice5, choice6;
    TextView character, mainText;
    Button c11, c21, c22, c31, c32, c33, c41, c42, c43, c44, c51, c52, c53, c54, c55, c61, c62, c63, c64, c65, c66;
    Button b42, b41;

    Princess player;

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
                startActivity(new Intent(subActivity_f3.this, map.class));
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

        f3_0();

    }

    public void f3_0() {
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
                //나중에 구현 2층으로 이동
            }
        });
    }

    public void f3_1() {
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
            }
        });
    }

    public void f3_8() {
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
            }
        });
    }

    public void f3_9() {
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
            }
        });
    }

    public void f3_10() {
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
            }
        });
    }

    public void f3_18() {
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
            }
        });
    }

    public void f3_19() {
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
            }
        });
    }

    public void f3_23() {
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
            }
        });
    }

    public void f3_24() {
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
            }
        });
    }

    public void f3_25() {
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
            }
        });
    }

    public void f3_26() {
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

                //end07
            }
        });
    }
}
