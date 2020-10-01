package com.timbuckalka;

public class Main {

    public static <Football extends Team<Football>, BascetBall> void main(String[] args) {

        Team<Football> manchester = new Team<>("manchester",10);
        Team<Football> ruse = new Team<>("ruse",8);
        Team<Football> varna = new Team<>("varna",9);
        Team<Football> sofia = new Team<>("sofia",3);
        Team<Football> plovdiv = new Team<>("plovdiv",5);
        Team<Football> devin = new Team<>("devin",4);


        Team<BascetBall> lakers = new Team<>("Lakers",2);
        Team<BascetBall> ruseB = new Team<>("ruse",6);
        Team<BascetBall> varnaB = new Team<>("varna",1);
        Team<BascetBall> sofiaB = new Team<>("sofia",7);
        Team<BascetBall> plovdivB = new Team<>("plovdiv",5);
        Team<BascetBall> devinB = new Team<>("devin",10);

        League<Football> footballLeague = new League<>("FOOTBALL");
        //footballLeague.addTeam(plovdivB);
        footballLeague.addTeam(manchester);
        footballLeague.addTeam(ruse);
        footballLeague.addTeam(varna);
        footballLeague.addTeam(sofia);
        footballLeague.addTeam(plovdiv);
        footballLeague.addTeam(devin);

        footballLeague.printLeagueTable();

        System.out.println();

        footballLeague.sort();
        footballLeague.printLeagueTable();
    }
}
