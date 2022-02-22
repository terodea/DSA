import java.io.*;
import java.util.*;

public class graphUtil {
    
    public static class Pair{
        int src;
        int nbr;
        int wt;
        
        public Pair(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    
    public static void main(String[] args){
        ArrayList<Pair>[] graph = new ArrayList[7];
        for(int i = 0 ; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        
        graph[0].add(new Pair(0, 1, 10));
        graph[0].add(new Pair(0, 3, 40));
        
        graph[1].add(new Pair(1, 0, 10));
        graph[1].add(new Pair(1, 2, 10));
        
        graph[2].add(new Pair(2, 1, 10));
        graph[2].add(new Pair(2, 3, 10));
        
        graph[3].add(new Pair(3, 0, 40));
        graph[3].add(new Pair(3, 2, 10));
        graph[3].add(new Pair(3, 4, 3));
        
        graph[4].add(new Pair(4, 3, 3));
        graph[4].add(new Pair(4, 5, 2));
        graph[4].add(new Pair(4, 6, 7));
        
        graph[5].add(new Pair(5, 4, 2));
        graph[5].add(new Pair(5, 6, 3));
        
        graph[6].add(new Pair(6, 4, 7));
        graph[6].add(new Pair(6, 5, 3));

        printGraph(graph);       
    }

    public static void printGraph(ArrayList<Pair>[] graph){

        for(int i=0; i<graph.length; i++){
            ArrayList<ArrayList> temp = graph.get(i);
            
            System.out.print(i + "--->" + " ");

            for(int j=0; j<temp.size(); j++){
                Pair np = temp.get(j);
                System.out.print(np.src + "," + np.nbr + "," + np.wt);
            }
            System.out.println();
        }
    }
    
}