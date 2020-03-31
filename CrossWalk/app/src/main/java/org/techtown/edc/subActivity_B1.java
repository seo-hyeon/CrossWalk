package org.techtown.edc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class subActivity_B1<player> extends AppCompatActivity {
    ConstraintLayout choice1, choice2, choice3, choice4, choice5, choice6;
    TextView character, mainText;
    Button c11, c21, c22, c31, c32, c33, c41, c42, c43, c44, c51, c52, c53, c54, c55, c61, c62, c63, c64, c65, c66;
    Button b42, b41;

    //도박 구현때 필요한 변수
    int pr = -1, mo = -1, A = -1, B = -1;

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
        mainText = findViewById(R.id.main_text);
        character = findViewById(R.id.character);

        mainText.setText(R.string.b1_100);
    }
}