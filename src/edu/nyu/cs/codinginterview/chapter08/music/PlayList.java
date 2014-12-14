package edu.nyu.cs.codinginterview.chapter08.music;

import java.util.Queue;

public class PlayList {
    @SuppressWarnings("unused")
    private Song song;
    private Queue<Song> queue;
    
    public PlayList(Song song, Queue<Song> queue) {
        
    }
    
    public Song getNextSongToPlay() {
        return queue.peek();
    }
    
    public void queueUpSong(Song s) {
        queue.add(s);
    }

}
