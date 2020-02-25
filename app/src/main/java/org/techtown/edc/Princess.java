package org.techtown.edc;
import java.util.ArrayList;

public class Princess {
    private int heart = 5;
    private int type = -1; //0황금, 1별, 2호랑이

    ArrayList<Integer> inventory = new ArrayList<>(); //0황금주머니, 1수정구슬, 2육감티아라, 3새장열쇠, 4하녀옷, 5우유, 7후추, 8지랫대, 9바늘, 10밧줄, 11맛있는 스튜, 12허가증

    private int f1_choices[] = new int[70]; //1층 다녀간 선택지 표시용.

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
        inventory.remove(item);
    }


    public void setF1_choices(int c){
        this.f1_choices[c] = 1;
    }
    public Boolean getF1_choices(int c){
        if(this.f1_choices[c] == 1){
            return true;
        } else{
            return false;
        }
    }


}