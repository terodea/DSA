import java.util.*;
import java.io.*;

public class guessNoHigherOrLower {
    
    public static int guessNumber(int n) {
        int res=0;
        int low=1;
        int high=n;

        while(low <= high){
            int mid = low + (high-low) /2;
            if(guess(mid) == 0){
                res = mid;
                break;
            }
            else if(guess(mid) > 0){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return res;
    }
    
    static int pn = 0; //picked number
    public static int guess(int val) {
        if (val == pn) return 0;
        else if (val < pn) return 1;
        else return -1;
    }
    
    public static void solve(int n, int pick) {
        pn = pick;
        System.out.println(guessNumber(n));
    }
    
    
    public static void main(String[]args) {
        //input work
        int n = 10;
        int pick = 6;
        
        solve(n, pick);
    }
}