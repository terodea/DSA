public class constructGraphs{

    public static class Edge{
        int nbr;
        int wt;

        public Edge(int nbr, int wt){
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int v1, int v2, int wt){
        graph[v1].add(new Edge(v2, wt));
        graph[v2].add(new Edge(v1, wt));
    }
    public static solve(){
        int n=7;
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        addEdge(graph, 0, 1, 10);
    }

    public static boolean dfs(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis, String psf){
        if(src == dest) {
            psf += src;
            System.out.println(psf);
            return true;
        }

        vis[src] = true;
        boolean pathFound = false;
        for(Edge e: graph[src]){
            if(vis[e.nbr] == false) pathFound = pathFound || dfs(graph, e.nbr, dst, vis, psf+src);
        }
        return pathFound;
    }
    public static class BPair{
        int vtx;
        String psf;
        int wsf;

        public BPair(int vtx, int wsf, String psf){
            this.vtx = vtx;
            this.psf = psf;
            this.wsf = wsf;
        }
    }

    public static boolean bfs(ArrayList<Edge>[] graph, int src, int dst, boolean[] vis){

        Queue<BPair> qu = new LinkedList<>();
        qu.add(new BPair(src, 0, ""+src));
        boolean res = false;

        while(qu.size() > 0){
            BPair rem = pq.remove();
            if(vis[rem.vtx] == true) continue;
            vis[rem.vtx] = true;
            System.out.println(rem.vtx + " " + rem.psf + " @ " + rem.wsf);

            if(src == dst){
                res = true;
                break;
            }

            for(Edge e:vis[rem.vtx]){
                if(vis[e.nbr] == false) qu.add(new BPair(e.nbr, rem.wsf+e.wt, rem.psf + e.nbr));
            }
        }
    }
}