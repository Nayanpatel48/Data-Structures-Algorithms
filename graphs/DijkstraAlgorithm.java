package graphs;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class DijkstraAlgorithm {
    static class Edge{
        int src;
        int dst;
        int wt;

        Edge(int src, int dst, int wt){
            this.src=src;
            this.dst=dst;
            this.wt=wt;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));

        graph[2].add(new Edge(2,4,3));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }
    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(@NotNull Pair p2){
            return this.dist-p2.dist; //ascending
            //descending
            //return p2.dist-this.dist;
        }
    }
    //O((v + E).logV) time complexity
    public static void dijkstra(ArrayList<Edge>[] graph, int src, int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        //creating distance array
        int[] dist = new int[V];

        //initializing distance array
        for (int i=0;i<V;i++){
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        //creating boolean array of size v
        boolean[] vis = new boolean[V];

        pq.add(new Pair(0,0));

        //using BFS approach
        while (!pq.isEmpty()){
            //delete first pair from priority queue
            Pair current = pq.remove();

            if (!vis[current.node]){
                //mark the current node as visited
                vis[current.node]=true;

                //now looping for all neighbors of current node
                for (int i=0;i<graph[current.node].size();i++){
                    Edge e = graph[current.node].get(i);
                    int u = e.src;
                    int v = e.dst;

                    //relaxation
                    if (dist[u] + e.wt < dist[v]){
                        dist[v] = dist[u]+ e.wt;
                        pq.add(new Pair(v,dist[v]));
                    }
                }
            }
        }
        for (int i=0;i<V;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int v=6;
        ArrayList[] graph = new ArrayList[v];

        createGraph(graph);

        dijkstra(graph,0,v);
    }
}