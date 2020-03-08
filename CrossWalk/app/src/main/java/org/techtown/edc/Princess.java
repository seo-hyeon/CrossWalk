package org.techtown.edc;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Princess implements Serializable {
    private int heart = 5;
    private int type = -1; //0황금, 1별, 2호랑이

    ArrayList<Integer> inventory = new ArrayList<>(); //0황금주머니, 1수정구슬, 2육감티아라, 3새장열쇠, 4하녀옷, 5우유,6 치즈 7후추,
    // 8지랫대, 9바늘, 10밧줄, 11맛있는 스튜, 12허가증, 13 수선된 드레스, 14 잠드는 약, 15 빵조각, 16 동물과 말하는 약, 17 고대 마법책, 18 장검
    // 19 보청기, 20 서랍열쇠, (하얀 약장~)22 갈색의 고운 가루, 23 파란색의 단단한 금속, 24 빨간색의 뜨거운 기름, 25 하얀색의 말랑한 고체, 26 초록색의 푹신한 섬유
    //(갈색 약장~)27울새의 깃털, 28 나비의 날개, 29 고양이의 수염, 30 송어의 비늘, 31 개구리 알
    private int f1_choices[] = new int[70]; //1층 다녀간 선택지 표시용.
    private int f2_choices[] = new int[100]; //2층 다녀간 선택지 표시용.
    private int b1_choices[] = new int[100]; //지하 1층 다녀간 선택지 표시용(2층 구현시 조건으로 너무 많이 나와서 내가 임의로 변수 진정해 둘께요;

    private int f2Recipe[] = new int[2]; //2층 14번 선택지 _ 사용한 레시피 저장용.
    private int cnt = 0; //2층 48번 선택지
    public void setHeart(int heart) {this.heart = heart;}
    public int getHeart() {return heart;}
    public void setType(int type) {this.type = type;}
    public int getType() {return type;}

    public void damage() {this.heart -= 1;}
    public void heal() {
        this.heart += 1;

        if (this.heart >= 5)
            this.heart = 5;
    }

    public void addInventory (int item) {
        inventory.add(item);
    }

    public boolean isInventory (int item) {
        for(int i: inventory)
        {
            if (i == item)
                return true;
        }

        return false;
    }

    public void removeInventory (int item) {
        Iterator it = inventory.iterator();

        while(it.hasNext()) {
            int value = (int)it.next();
            if(value == item)
            {
                it.remove();
                //invNum--;
                break;
            }
        }
    }

    public void setF2Recipe(int a, int b){
        f2Recipe[0] = a; f2Recipe[1] = b;
    }
    public int getF2Recipe(int n){
        if(n == 0){
            return f2Recipe[0];
        } else{
            return f2Recipe[1];
        }
    }
    public void setCnt() {cnt = cnt + 1;}
    public int getCnt() {return cnt;}

    public void setF1_choices(int c){
        this.f1_choices[c] = 1;
    }
    public Boolean getF1_choices(int c){ //if문에서 isInventory와 함께 수월하게 비교하기 위해, boolean 값으로 리턴.
        if(this.f1_choices[c] == 1){
            return true;
        } else{
            return false;
        }
    }

    public void setF2_choices(int c){
        this.f2_choices[c] = 1;
    }
    public Boolean getF2_choices(int c){
        if(this.f2_choices[c] == 1){
            return true;
        } else{
            return false;
        }
    }
    //마찬가지로 지하 1층 선택지 표시 제가 임의로 표시해 둘게요
    public void setB1_choices(int c){
        this.b1_choices[c] = 1;
    }
    public Boolean getB1_choices(int c){
        if(this.b1_choices[c] == 1){
            return true;
        } else{
            return false;
        }
    }


}