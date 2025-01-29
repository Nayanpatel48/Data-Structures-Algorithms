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
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(1, 2));
        graph[1].add(new Edge(2, 3));
        graph[2].add(new Edge(3, 0));
        graph[3].add(new Edge(4, 5));
        graph[3].add(new Edge(5, 4));
    }

    public static void topSort(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s){
        vis[curr]=true;

        for (int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dst]){
                topSort(graph, e.dst, vis, s);
            }
        }

        s.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
        vis[curr]=true;
        System.out.print(curr+" ");

        for (int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dst]){
                dfs(graph, e.dst, vis);
            }
        }
    }

    public static void kosarajuAlgo(ArrayList<Edge> graph[], int V){
        //step1 : push nodes into stack according to topSort order
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[V];
        for (int i=0; i<V; i++){
            if (!vis[i]){
                topSort(graph, i, vis, s);
            }
        }


        //step2 : create  clone graph
        ArrayList<Edge>[] transposeGraph = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            vis[i]=false;
            transposeGraph[i] = new ArrayList<Edge>();
        }

        for (int i=0;i<V;i++){
            for (int j=0;j<graph[i].size();j++){
                Edge e = graph[i].get(j);//e.src(i) -> e.dst
                transposeGraph[e.dst].add(new Edge(e.dst, e.src));
            }
        }

        //step3 :
        while (!s.empty()){
            int curr = s.pop();
            dfs(graph, curr, vis);
            System.out.println();
        }
    }

    public static void main(String[] args){
        int V=6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        kosarajuAlgo(graph, graph.length);
    }
}