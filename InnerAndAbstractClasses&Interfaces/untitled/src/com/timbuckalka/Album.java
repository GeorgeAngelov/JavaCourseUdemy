package com.timbuckalka;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private SongList songs;


    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration){
      return this.songs.addSong(new Song(title,duration));
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist){
        Song checkedSond = this.songs.findSong(trackNumber);
        if (checkedSond != null) {
            playlist.add(checkedSond);
            return true;
        }
        System.out.println("this album does not have a track " + trackNumber);
        return false;
    }
    public boolean addToPlaylist(String title, LinkedList<Song> playlist){
        Song checkedSong = songs.findSong(title);
        if (checkedSong != null){
            songs.addSong(checkedSong);
            return true;
        }else {
            System.out.println("Song with " + title + " is not in the album");
            return false;
        }
    }
/*****************************************/
    private class SongList{
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<>();
        }

        public List<Song> getSongs() {
            return songs;
        }

        private Song findSong(String title){
            for (Song checkedSong : songs){
                if (checkedSong.getName().equals(title)){
                    return checkedSong;
                }
            }
            return null;
        }

        public boolean addSong(Song song){
            if (songs.contains(song)){ ;
                return false;
            }
            this.songs.add(song);
            return true;
        }

        public Song findSong(int trackNumber){
            int index = trackNumber - 1;
            if ((index > 0) && (index<songs.size())){
                return songs.get(index);
            }
            return null;
        }
    }
    /*******************************************************/
}
