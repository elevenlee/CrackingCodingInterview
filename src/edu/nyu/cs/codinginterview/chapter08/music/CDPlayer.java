package edu.nyu.cs.codinginterview.chapter08.music;

import edu.nyu.cs.codinginterview.util.Check;

public class CDPlayer {
    private PlayList p;
    private CD c;
    
    public CDPlayer(CD c) {
        Check.nullCheck(c, "cd");
        
        this.c = c;
    }
    
    public CDPlayer(PlayList p) {
        Check.nullCheck(p, "playlist");
        
        this.p = p;
    }
    
    public CDPlayer(PlayList p, CD c) {
        Check.nullCheck(p, "playlist");
        Check.nullCheck(c, "cd");
        
        this.p = p;
        this.c = c;
    }
    
    public void playSong(Song s) {
        // TODO Auto-generated method stub
    }
    
    public PlayList getPlayList() {
        return p;
    }
    
    public void setPlayList(PlayList p) {
        Check.nullCheck(p, "play list");
        
        this.p = p;
    }
    
    public CD getCD() {
        return c;
    }
    
    public void setCD(CD c) {
        Check.nullCheck(c, "cd");
        
        this.c = c;
    }

}
