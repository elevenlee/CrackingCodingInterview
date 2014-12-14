package edu.nyu.cs.codinginterview.chapter08.music;

import java.util.Set;

import edu.nyu.cs.codinginterview.util.Check;

public class JukeBox {
    @SuppressWarnings("unused")
    private CDPlayer cdPlayer;
    @SuppressWarnings("unused")
    private User user;
    @SuppressWarnings("unused")
    private Set<CD> cdCollection;
    private SongSelector ts;
    
    public JukeBox(CDPlayer cdPlayer, User user, Set<CD> cdCollection, SongSelector ts) {
        Check.nullCheck(cdPlayer, "CD Player");
        Check.nullCheck(user, "user");
        Check.nullCheck(cdCollection, "CD Collection");
        Check.nullCheck(ts, "Song Selector");
        for (CD c : cdCollection) {
            Check.nullCheck(c, "cd");
        }
        
        this.cdPlayer = cdPlayer;
        this.user = user;
        this.cdCollection = cdCollection;
        this.ts = ts;
    }
    
    public Song getCurrentSong() {
        return ts.getCurrentSong();
    }
    
    public void setUser(User user) {
        Check.nullCheck(user, "user");
        
        this.user = user;
    }
    
}
