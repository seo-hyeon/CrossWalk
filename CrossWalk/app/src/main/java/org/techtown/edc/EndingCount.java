package org.techtown.edc;

import java.io.Serializable;

public class EndingCount implements Serializable {
    private String title;
    private int count;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
