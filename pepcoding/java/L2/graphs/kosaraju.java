import java.io.*;
import java.util.*;

public class kosaraju {
    /**
    Strongly connected components.
    You are given a graph with N nodes and M directed edges. Find the number of Strongly connected components in the graph.
     */
    
    private static void dfsStack(ArrayList<ArrayList<Integer>> graph, int src, boolean[] vis, Stack<Integer> st){
        vis[src] = true;
        for(int nbr: graph.get(src)){
            if(vis[nbr] == false){
                dfsStack(graph, nbr, vis, st);
            }
        }
        st.push(src);
    }

    private static void dfsCount(ArrayList<ArrayList<Integer>> graph, int src, boolean[] vis){
        vis[src] = true;
        for(int nbr: graph.get(src)){
            if(vis[nbr] == false){
                dfsCount(graph, nbr, vis);
            }
        }
    }
    private static int stronglyConnectedComponents(ArrayList<ArrayList<Integer>> graph){

        // STEP 1: Iterate on vertex and add vertex in stack while backtracking.
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[graph.size()];
        for(int v=0; v<graph.size(); v++){
            if(vis[v] == false){
                dfsStack(graph, v, vis, st);
            }
        }
        // STEP 2: Reverse all edge
        ArrayList<ArrayList<Integer>> revGraph = new ArrayList<>();
        for(int i=0; i<graph.size(); i++){
            revGraph.add(new ArrayList<>());
        }

        for(int v=0; v<graph.size(); v++){
            for(int u: graph.get(v)){
                revGraph.get(u).add(v);
            }
        }

        // STEP 3: Iterate on vertex in order of stack and count no of calls
        int count = 0;
        vis = new boolean[graph.size()];

        while(st.size() > 0){
            int v = st.pop();
            if(vis[v] == false){
                count++;
                dfsCount(revGraph, v, vis);
            }
        }


        return count;
    }

    public static void main(String args[]) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            int v1 = scn.nextInt() - 1;
            int v2 = scn.nextInt() - 1;

            // add directed edge
            graph.get(v1).add(v2);
        }

        System.out.println(stronglyConnectedComponents(graph));
    }

}
