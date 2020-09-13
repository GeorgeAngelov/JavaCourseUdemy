package com.timbuckalka;

public class EnhancedPlayer {

    private String name;
    private int hitpints = 100;
    private String weapon;

    public EnhancedPlayer(String name, int health, String weapon) {
        this.name = name;
        if(health>0 && health <= 100) {
            this.hitpints = health;
        }
        this.weapon = weapon;
    }

    public void loseHealth(int damage){
        this.hitpints = this.hitpints - damage;
        if (this.hitpints <=0){
            System.out.println("Player knocked out");
            //Reduce number of lives
        }
    }

    public int getHealth() {
        return hitpints;
    }
}
