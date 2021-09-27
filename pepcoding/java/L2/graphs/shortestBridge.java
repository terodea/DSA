import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class shortestBridge {
    private static class Pair{
        int x;
        int y;
        
        public Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static int[] xdir = {-1,0,1,0};
    public static int[] ydir = {0,-1,0,1};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }
        System.out.println(shortestBridge(arr));
    }
  
    private static void dfsShortestBridge(int[][] grid, int x, int y, Queue<Pair> qu){
        grid[x][y] = -1;
        qu.add(new Pair(x,y));
        for(int d=0; d<4; d++){
            int r = x + xdir[d];
            int c = y + ydir[d];
            
            if(r >=0 && c >= 0 && c < grid[0].length && r < grid.length && grid[r][c] == 1){
                dfsShortestBridge(grid,r,c,qu);
            }
        }
    }
    public static int shortestBridge(int[][] grid) {
        Queue<Pair> qu = new LinkedList<>();
        int level = -1;
        
        // break parent loop using label.
        parentLoop: for(int i=0; i<grid.length; i++){
            boolean flag = true;
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    dfsShortestBridge(grid, i, j, qu);
                    //   flag = false;
                    break parentLoop;
                }
            }
            //   if(flag == false) break;
        }
        while(qu.size() > 0){
            int size = qu.size();
            level++;
            while(size-- > 0){
                Pair rm = qu.remove();
                for(int d=0; d<4; d++){
                    int r = rm.x + xdir[d];
                    int c = rm.y + ydir[d];
                    
                    if(r >=0 && c >= 0 && c < grid[0].length && r < grid.length && grid[r][c] != -1){
                        if(grid[r][c] == 1){
                            return level;
                        }
                        grid[r][c] = -1;
                        qu.add(new Pair(r,c));
                    }
                }
            }
        }
        return -1;
    }
}