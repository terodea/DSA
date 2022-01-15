import java.util.*;
import java.io.*;

public class findKClosest {

    /*find 'k' closest element to 'x' and return answer list*/
    /*elements in answer list should be in ascending order*/
    public static ArrayList<Integer> findClosest(int[]arr,int k,int x) {
        
        return null;
    }

    public static void main(String[]args) {

        //input work
        int n = 6;

        int[]arr = {10, 20, 30, 40, 50, 60};

        int k = 3;
        int x = 45;

        ArrayList<Integer>ans = findClosest(arr,k,x);

        for(int val : ans) {
            System.out.print(val + " ");
        }
    }
}