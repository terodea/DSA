import java.io.*;
import java.util.*;

public class diagnonalWaveTraversal {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        /*
        0. Count all diagonals in the matrix and run loop till no.of diagonals.
        1. Traverse Array in Bottom-left to top-left then to top-right.
        2. Store all diagonals into hashmap. or. Store one diagonal at a time in ArrayList
        3. While printing print according to the index of diagonals.
        */
        Scanner scn = new Scanner(System.in);
        int n = 4;
        // int n = scn.nextInt();

        // int[][] arr = new int[n][n];
        // for(int i=0; i<n; i++){
        //     for(int j =0; j<n; j++){
        //         arr[i][j] = scn.nextInt();
        //     }
        // }
        boolean visited[][] = new boolean[n][n];
        int[][] arr = {
            {10, 11, 12 ,13},
            {20, 21, 22, 23},
            {30, 31, 32, 33},
            {40, 41, 42, 43}
        };
        
        waveTraversal(arr, visited, n-1, 0, 0, n-1);
    }
    
    public static void waveTraversal(int[][] arr, boolean[][] visited, int sr, int sc, int dr, int dc){

        if(sr <= dc && sc <= dc && !(visited[sr][sc])){
            System.out.println(arr[sr][sc]);
            visited[sr][sc] = true;
        }
        
        if(sr > dc || sc > dr || sc < 0 || sr < 0 ){
            return;
        }
        
        waveTraversal(arr, visited, sr+1, sc+1, dr, dc); // wave 0
        // System.out.println("SR:"+sr+"\tSC:"+sc);
        waveTraversal(arr, visited, sr, sc+1, dr, dc); // wave 1
        System.out.println("SR:"+sr+"\tSC:"+sc);
        waveTraversal(arr, visited, sr-1, sc, dr, dc); // wave  1
        waveTraversal(arr, visited, sr-1, sc, dr, dc);
        // System.out.println("SR:"+sr+"\tSC:"+sc);
        // System.out.println(arr[sr][sc]);
    }
}