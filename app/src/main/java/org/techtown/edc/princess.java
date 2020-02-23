package org.techtown.edc;
import java.util.ArrayList;

public class princess {
    private int heart = 5;
    private int type = -1;
    ArrayList<Integer> inventory = new ArrayList<>();

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
}