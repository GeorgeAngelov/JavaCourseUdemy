package com.timbuckalka;

public class Main {

    public static void main(String[] args) {
	    FootballPlayer joe = new FootballPlayer("Joe");
	    BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer becham = new SoccerPlayer("Becham");

        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        adelaideCrows.addPlayer(joe);
        //adelaideCrows.addPlayer(pat);
        //adelaideCrows.addPlayer(becham);

        System.out.println(adelaideCrows.numPlayers());

        Team<BaseballPlayer> baseballPlayerTeam = new Team<>("Chicago Cubs");
        baseballPlayerTeam.addPlayer(pat);

        Team<SoccerPlayer> brokenTeam = new Team<>("Broken team");
        brokenTeam.addPlayer(becham);

        Team<FootballPlayer> melborn = new Team<>("Melborn");
        FootballPlayer banks = new FootballPlayer("Banks");
        melborn.addPlayer(banks);

        Team<FootballPlayer> hawton = new Team<>("Hawton");
        Team<FootballPlayer> fremantel = new Team<>("Fremantel");

        hawton.matchResult(fremantel,1,0);
        hawton.matchResult(adelaideCrows,3,8);

        adelaideCrows.matchResult(fremantel,2,1);
       // adelaideCrows.matchResult(baseballPlayerTeam,1,1);

        System.out.println("Rankings ");
        System.out.println(adelaideCrows.getName() + ": " + adelaideCrows.ranking());
        System.out.println(melborn.getName() + ": " + melborn.ranking());
        System.out.println(fremantel.getName() + ": " + fremantel.ranking());
        System.out.println(hawton.getName() + ": " + hawton.ranking());

        System.out.println(adelaideCrows.compareTo(melborn));
        System.out.println(adelaideCrows.compareTo(hawton));
        System.out.println(hawton.compareTo(adelaideCrows));
        System.out.println(melborn.compareTo(fremantel));
    }
}
