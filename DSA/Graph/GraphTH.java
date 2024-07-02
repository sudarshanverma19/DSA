import java.util.*;

public class GraphTH{
    static class Edge{
        int src, dest ;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d ;
        }
    }
    static void createGraph(ArrayList<Integer> graph[]){
        for(int i=0; i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5,6));
    }

    public static void bfs(ArrayList<Edge> graph[] , int V){  // V is size of array
        boolean vis[] = new boolean[V];         // bool hai, toh sirf true and false hi store hoga.
        Queue<Integer> q = new LinkedList<>();
        q.add(0);  // considering 0 as our first node.

        while(!q.isEmpty()){
            int curr = q.remove();     // curr is refering to the value removed from the queue.
            if(vis[curr]==false){     // uss index ki value check kar rhe hai, jisko curr refer kar rha hai.
                System.out.print(curr+" ");
                vis[curr] = true ;
            }                            // as a conclusion, yaha par hum array ko poora traverse karne ke baad arrayList par move kar rhe hai.

            for(int i=0; i<graph[curr].size();i++){    // graph[curr] gives the neighbours, i.e array me jo arrayList hai, vo saar values, uss index ke liye jisko curr refer kar rha hai.
                Edge e = graph[curr].get(i);
                q.add(e.dest);
            }
        }
    }
    public static void dfs(ArrayList<Edge> graph[],int curr,int V){            // curr is working as a pointer that will refer array.
        boolean vis[] = new boolean[V];
        if(!vis[curr]){
            System.out.print(curr+" ");
            vis[curr] = true ;
        }
        for(int i=0; i<graph[curr].size();i++){      // yaha par hum array ke ek index ko traverse karke uski arraylist ko poora traverse karenge, then will move to next index.
            Edge e = graph[curr].get(i);
            dfs(graph,e.dest,V);
        }
    }
    public static void printAllPaths(ArrayList<Edge> graph[], int src, int tar, String path, boolean vis[]){
        if(tar==src){                                                           //String path  ka kaam hai sirf -> add karna.
            System.out.println(path+src);
            return ;
        }
        for(int i=0; i<graph[src].size();i++){      // src ke neighbours ko traverse karrhe hai.
            Edge e = graph[src].get(i);
            if(!vis[src]){
                vis[src] = true ;
                printAllPaths(graph, e.dest, tar, path + "->" + e.dest, vis);
                vis[e.dest] = false ;    //If you do not unmark vis[e.dest], then future recursive calls could incorrectly think that the vertex e.dest has already been visited in the current path, potentially missing valid paths.
            }                    //Consider a graph where you have multiple paths between the source and target vertices. Without unmarking, once a vertex is visited, it cannot be used in any other path, leading to incomplete path exploration.
        }
    }

    public static boolean isCyclicUtilDir(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]){
        vis[curr] = true ;
        stack[curr] = true ;

        for(int i=0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(stack[curr]==false){
                if(isCyclicUtilDir(graph, e.dest, vis, stack)){
                    return true ;
                } else if(stack[curr]==true){
                    return true ;
                }
            }
        }
        stack[curr] = false ;
        return false ;
    }

    public static boolean isCyclicDir(ArrayList<Edge> graph[]){
        boolean vis = new boolean(graph.length);

        for(int i=0; i<graph.length; i++){
            if(isCyclicUtilDir(graph,i,vis,boolean[vis.length])){
                return true ;
            }
        }
        return false ;
    }

    public static boolean cyclicUtilUnDir(ArrayList<Edge> graph[], int par, int curr, boolean vis[]){
        vis[curr] = true ;

        for(int i=0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(vis[curr] && e.dest!=par){
                return true ;
            } else if(e.dest==par){
                continue ;
            } else{
                return true ;
            }
        }
        return false ;
    }

    public static boolean cyclicUnDir(ArrayList<Edge> graph[], boolean vis[]){
        for(int i=0; i<graph.length; i++){
            if(cyclicUtilUnDir(graph, -1, i, vis)){
                return true ;
            }
        }
        return false; 
    }

    public static void topoSortUtil(ArrayList<Edge> graph[],int curr, boolean vis[], Stack<Integer> s){
        vis[curr] = true ;

        for(int i=0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topoSortUtil(graph,e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void topoSort(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                topoSortUtil(graph, i, vis, s);
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }
    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[7];
        createGraph(graph);
        int src = 0 ;
        int tar = 6 ;
        boolean vis[] = new boolean[7];
        vis[src] = true ;
        printAllPaths(graph, src, tar, ""+src, vis);
    }

    
}