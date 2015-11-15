package com.example.mark.beerandbottle;


import android.util.Log;
import android.widget.TextView;

public class Person {
    private int drink;
    private int bottle;
    private int lid;
    private int beer;
    private int rmb;

    public Person(int rmb) {
        this.rmb = rmb;
    }

    public int getDrink() {
        return drink;
    }

    public void setDrink(int drink) {
        this.drink = drink;
    }

    public int getBottle() {
        return bottle;
    }

    public void setBottle(int bottle) {
        this.bottle = bottle;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getBeer() {
        return beer;
    }

    public void setBeer(int beer) {
        this.beer = beer;
    }

    public int getRmb() {
        return rmb;
    }

    public void setRmb(int rmb) {
        this.rmb = rmb;
    }

    public void addBear() {
        beer++;
    }

    public void removeBottle(int bottle) {
        this.bottle -= bottle;
    }

    public void removeLid(int lid) {
        this.lid -= lid;
    }

    public void drinking() {
        while (beer > 0) {
            drink++;
            bottle++;
            lid++;
            beer--;
        }
    }

    public boolean buy(Saler saler) {
        boolean hasBuy = false;

        while (rmb >= saler.getBeerValue()) {
            beer++;
            rmb -= saler.getBeerValue();
            hasBuy = true;
        }
        return hasBuy;
    }

    public void play(Saler s, TextView text) {
        StringBuffer sb = new StringBuffer();
        while (beer > 0) {
            text.setText("");
            drinking();

            sb.append("喝 ");
            sb.append(toString());
            sb.append("\n");

            Log.d("喝 ", toString());

            s.exchange(this);

            sb.append("换 ");
            sb.append(toString());
            sb.append("\n");

            Log.d("换 ", toString());
        }
        text.setText(sb.toString());
    }

    @Override
    public String toString() {
        return "Person{" +
                "drink=" + drink +
                ", bottle=" + bottle +
                ", lid=" + lid +
                ", beer=" + beer +
                ", rmb=" + rmb +
                '}';
    }


}
