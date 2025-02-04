package graphs;
import java.util.ArrayList;

public class TarzanAlgo {
    static class Edge {
        int src;
        int dest;

        //parameterized constructor
        public Edge(int src, int dest){
            this.src=src;
            this.dest=dest;
        }//Edge class over
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        //looping through each index of the graph inorder to replace the `null` with 'empty ArrayList'
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        //if we don't write above code null pointer exception occurs
        //after performing above loop operation there will be empty arrayList at every
        //place in the graph

        //adding edges
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,5));
        graph[4].add(new Edge(4,3));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
    }// CreateGraph function over

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean[] vis, int[] dt,
                           int[] low, int time, int par){
        vis[curr]=true;
        dt[curr]=low[curr]=++time;

        for (int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if (e.dest == par){
                continue;
            } else if (!vis[e.dest]) {
                dfs(graph, e.dest, vis, dt, low, time, curr);
                low[curr]=Math.min(low[curr], low[e.dest]);
                if (dt[curr]<low[e.dest]){
                    System.out.println("Bridge is : "+curr+" -> "+e.dest);
                }
            } else {
                low[curr]=Math.min(low[curr], dt[e.dest]);
            }
        }
    }

    public static void getBridge(ArrayList<Edge> graph[], int V){
        int[] dt = new int[V];
        int[] low = new int[V];
        boolean[] vis = new boolean[V];
        int time=0;

        for (int i=0;i<V;i++){
            if (!vis[i]){
                dfs(graph, i, vis, dt, low, time, -1);
            }
        }
    }
    public static void main(String[] args){
        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];

        // Step 1: Create the graph
        createGraph(graph);

        getBridge(graph, v);
    }
}