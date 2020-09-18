package com.timbuckalka;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        // Create a program that implements a playlist for songs
        // Create a Song class having Title and Duration for a song.
        // The program will have an Album class containing a list of songs.
        // The albums will be stored in an ArrayList
        // Songs from different albums can be added to the playlist and will appear in the list in the order
        // they are added.
        // Once the songs have been added to the playlist, create a menu of options to:-
        // Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
        // List the songs in the playlist
        // A song must exist in an album before it can be added to the playlist (so you can only play songs that
        // you own).
        // Hint:  To replay a song, consider what happened when we went back and forth from a city before we
        // started tracking the direction we were going.
        // As an optional extra, provide an option to remove the current song from the playlist
        // (hint: listiterator.remove()

        Album album = new Album("Stormbringe","Deep purple");
        album.addSong("Strombringer",2.3);
        album.addSong("Soldier of fortune",4.6);
        album.addSong("High ball shooter",3.5);
        album.addSong("The gypsy",5.4);
        album.addSong("Lady double dealer",12); //
        album.addSong("Hold on",3.7);
        album.addSong("Holy man",2.8);
        album.addSong("Love",4.2);
        albums.add(album);

        album = new Album("For those who like to rock","AC/DC");
        album.addSong("Thunderstruck",3.3);
        album.addSong("Highway to hell ",5.6);
        album.addSong("Stairway to heaven",2.5);
        album.addSong("Lets go",5.4);
        album.addSong("Double your money",12);
        album.addSong("Breaking the rules ",3.7);
        album.addSong("C.O.D.",2.8);
        album.addSong("Night of the long knives",4.2);
        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<Song>();
        albums.get(0).addToPlaylist("Strombringer",playlist);
        albums.get(0).addToPlaylist("The gypsy",playlist);
        albums.get(0).addToPlaylist("Hell",playlist);  // not in album
        albums.get(0).addToPlaylist(4,playlist);
        albums.get(1).addToPlaylist(8,playlist);
        albums.get(1).addToPlaylist(4,playlist);
        albums.get(1).addToPlaylist(3,playlist);
        albums.get(1).addToPlaylist(7,playlist);
        albums.get(1).addToPlaylist(24,playlist); // no song 24

        play(playlist);
    }
    public static void play(LinkedList<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0){
            System.out.println("No songs in the playlist");
            return;
        }else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete!");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                        } else {
                            System.out.println("We have reached the edn of the playlist!");
                            forward = false;
                        }
                    break;
                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                    }else {
                        System.out.println("We are at the top of the playlist!");
                        forward=true;
                    }
                    break;
                case 3:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward=false;
                        }else {
                            System.out.println("We are at the start of the list!");
                        }
                    }else {
                        if (listIterator.hasNext()){
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward=true;
                        }else {
                            System.out.println("We have reached the end of the list!");
                        }
                    }
                    break;
                case 4:
                   printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size()>0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next());
                        }else if (listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
            }
        }
    }

    public static void printMenu(){
        System.out.println("Available actions: \n");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - to list songs in playlist\n" +
                "5 - to print available actions\n" +
                "6 - remove current song");
    }

    public static void printList(LinkedList<Song> playlist){
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("======================");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            System.out.println("======================");
        }
    }
}
