import java.util.*;

public class bestMeetingPoint {
    public static int minTotalDistance(int[][] grid) {
        ArrayList<Integer> xcord = new ArrayList<>();
        ArrayList<Integer> ycord = new ArrayList<>();
        
        for(int r=0; r<grid.length; r++){
            for(int c = 0; c<grid[0].length; c++){
                
                if(grid[r][c] == 1) xcord.add(r);
                
            }
        }
        
        for(int c=0; c<grid[0].length; c++){
            for(int r = 0; r<grid.length; r++){
                
                if(grid[r][c] == 1) ycord.add(c);
                
            }
        }
        
        int x = xcord.get(xcord.size() / 2);
        int y = ycord.get(ycord.size() / 2);
        
        int dist = 0;
        
        for(int r=0; r<grid.length; r++){
            for(int c = 0; c<grid[0].length; c++){
                
                if(grid[r][c] == 1) dist+= Math.abs(x-r) + Math.abs(y-c);
                
            }
        }
        
        return dist;
    }

    // From github

    public int minTotalDistanceWMedian(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        List<Integer> rows = new ArrayList<Integer>();
        List<Integer> cols = new ArrayList<Integer>();
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        Collections.sort(cols);
        return getMinDistanceWMedian(rows, rows.get(rows.size() / 2)) + getMinDistanceWMedian(cols, cols.get(cols.size() / 2));
    }
    
    private int getMinDistanceWMedian(List<Integer> lst, int origin){
        int res = 0;
        for(int num : lst){
            res += Math.abs(num - origin);
        }
        return res;
    }


    // without the median
    public int minTotalDistanceWM(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        List<Integer> rows = new ArrayList<Integer>();
        List<Integer> cols = new ArrayList<Integer>();
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        Collections.sort(cols);
        return getMinDistanceWM(rows) + getMinDistanceWM(cols);
    }

    private int getMinDistanceWM(List<Integer> lst){
        int res = 0, left = 0, right = lst.size() - 1;
        while(left < right){
            res += lst.get(right--) - lst.get(left++);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1,0,0,0,1},
            {0,0,0,0,0},
            {0,0,1,0,0}
        }

        int dist = minTotalDistance(grid);
        System.out.println(dist);
    }
}
