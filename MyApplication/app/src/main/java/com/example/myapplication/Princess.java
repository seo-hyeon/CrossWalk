package com.example.myapplication;

import java.util.ArrayList;
import java.util.Iterator;

public class Princess {
    private int heart = 5;
    private int type = -1;
    ArrayList<Integer> inventory = new ArrayList<>();
    private int invNum = 0;

    public void setHeart(int heart) {this.heart = heart;}
    public int getHeart() {return heart;}
    public void setType(int type) {this.type = type;}
    public int getType() {return type;}
    public int getInvNum() {return invNum;}

    public void damage() {this.heart -= 1;}
    public void heal() {
        this.heart += 1;

        if (this.heart >= 5)
            this.heart = 5;
    }

    public void addInventory (int item) {
        inventory.add(item);
        invNum++;
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
                invNum--;
                break;
            }
        }
    }
}
