package edu.nyu.cs.codinginterview.chapter06;

/**
 * @author shenli
 * <p>
 * There are 100 closed lockers in a hallway. A man begins by opening all 100 lockers. Next, he closes every 
 * second locker. Then, on his third pass, he toggles every third locker (closes it if it is open or opens it 
 * if it is closed). This process continues for 100 passes, such that on each pass i, the man toggles every 
 * ith locker. After his 100th pass in the hallway, in which he toggles only locker #100, how many lockers 
 * are open?
 */
public class LocksSolution {
    private boolean[] sig;
    
    public LocksSolution(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        
        sig = new boolean[n];
    }
    
    /**
     * time complexity O(n^2)
     * space complexity O(n)
     */
    public int numberOfOpens() {
        process();
        int count = 0;
        for (int i = 0; i < sig.length; i++) {
            if (sig[i]) {
                count++;
            }
        }
        return count;
    }
    
    private void process() {
        for (int i = 1; i <= sig.length; i++) {
            for (int j = 1; j * i <= sig.length; j++) {
                sig[j * i - 1] = !sig[j * i - 1];
            }
        }
    }

}
