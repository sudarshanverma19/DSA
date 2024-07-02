import java.util.*;

public class Prims {
    static class Pair implements Comparable<Pair> {
        int v;
        int wt;

        Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair P2) {
            return this.wt - P2.wt;
        }
    }

    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt) {
            this.src= src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }
    public static void primsAlgo(ArrayList<Edge> graph[]){
        boolean[] vis = new boolean[graph.length];
        int[] dest=  new int[graph.length];      // no use
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        int mstcost = 0;
        
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!vis[curr.v]){
                vis[curr.v]=true;
                mstcost+=curr.wt;
            }
            for(int i=0;i<graph[curr.v].size();i++){
              Edge e = graph[curr.v].get(i);
              if(!vis[e.dest]){
                pq.add(new Pair(e.dest,e.wt));
              }
            } 
            // for(Edge e: graph[curr.v]){          // tried different approach this time.
            //     if(!vis[e.dest]){
            //         pq.add(new Pair(e.dest, e.wt));
            //     }
            // }        
        }
        System.out.println(mstcost);
    }
    public static void main(String[] args){
        ArrayList<Edge> graph[] = new ArrayList[4];
        createGraph(graph);
        primsAlgo(graph);
    }
}
