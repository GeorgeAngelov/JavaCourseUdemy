package com.timbuckalka;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team<T>>  {

    private String name;
    public ArrayList<Team<T>> leagueTable;

    public League(String name) {
        this.name = name;
        leagueTable = new ArrayList<>();
    }

    public void addTeam(Team<T> team){
        leagueTable.add(team);
    }
     public void sort(){
         Collections.sort(leagueTable);
     }

     public void printLeagueTable(){
         System.out.println(this.name + ": ");
        for (Team<T> team : leagueTable){
            System.out.println(leagueTable.indexOf(team)+1 + ". " + team.getName() + " score: " + team.getScore());
        }
     }
}
