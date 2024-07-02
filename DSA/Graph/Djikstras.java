import java.security.Permissions;
import java.util.*;

public class Djikstras {
    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    public static int[] Djikstras(ArrayList<Edge> graph[], int src){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[graph.length];
        boolean[] vis = new boolean[graph.length];
        for(int i =0 ; i<graph.length;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
                if(!vis[curr.n]){
                    vis[curr.n] = true;
                    for(int i=0 ; i<graph[curr.n].size() ; i++){
                        Edge e = graph[curr.n].get(i);
                        int u= e.src;
                        int v = e.dest;
                        if(dist[v]>dist[u]+e.wt){
                            dist[v] = dist[u]+e.wt;
                            pq.add(new Pair(v, dist[v]));
                        }
                    }
            }
        }
        return dist ;
    }
    public static void main(String[] args){
        ArrayList<Edge> graph[] = new ArrayList[6];
        createGraph(graph);
        int dist[] = Djikstras(graph,0);
        for(int i=0 ; i<dist.length ; i++){
            System.out.print(dist[i]+" ");
        }
    }
}
