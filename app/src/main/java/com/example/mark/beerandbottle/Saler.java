package com.example.mark.beerandbottle;

/**
 * Created by Mark on 2015/11/15.
 */
public class Saler {
    private int bottle;
    private int lid;
    private int beerValue;

    public Saler(int bottle, int lid, int beerValue) {
        this.bottle = bottle;
        this.lid = lid;
        this.beerValue = beerValue;
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

    public int getBeerValue() {
        return beerValue;
    }

    public void setBeerValue(int beerValue) {
        this.beerValue = beerValue;
    }

    public boolean exchange(Person p){
        boolean hasExchange = false;

        if(bottle==0 && lid==0){
            return false;
        }


        while(p.getBottle()-bottle >=0){
            hasExchange = true;
            p.addBear();
            p.removeBottle(bottle);
        }

        while(p.getLid()-lid >=0){
            hasExchange = true;
            p.addBear();
            p.removeLid(lid);
        }


        return hasExchange;
    }



}
