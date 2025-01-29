package graphs;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajusAlgo {
    static class Edge {
        int src;
        int dst;

        Edge(int src, int dst) {
            this.src = src;
            this.dst = dst;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // Add edges to the graph (modify as needed)
        graph[0].add(new Edge(0, 3));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    public static void topSort(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s){
        vis[curr]=true;

        for (int i=0;i<graph[curr].size();i++){
            
        }
    }

    public static void kosarajuAlgo(ArrayList<Edge> graph[], int V){
        //step1
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[V];
        for (int i=0; i<V; i++){
            if (!vis[i]){
                topSort(graph, i, vis, s);
            }
        }

    }

    public static void main(String[] args){
        int V=5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);


    }
}