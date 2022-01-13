import java.util.*;
import java.io.*;

public class firstBadVersion{
    public static int firstBadVersion(int n) {
        //write your code here
        int ans = -1;
        int low = 0;
        int high = n;
    
        while(low <= high){
            int mid = low+(high-low)/2;
            if(isBadVersion(mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    
    static int bad = 0;
    public static boolean isBadVersion(int val) {
        if (val >= bad) return true;
        else return false;
    }
    
    public static void solve(int n, int fbv) {
        bad = fbv;
        System.out.println(firstBadVersion(n));
    }
    
    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = 10;
        int fbv = 3;
        solve(n, fbv);
    }
}