package graphs;

import java.util.*;

public class BFS {
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

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }// CreateGraph function over
    public static void bfs(ArrayList<Edge>[] graph, int v, boolean[] vis, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (!vis[curr]) {
                System.out.print(curr + ", ");
                vis[curr] = true;

                if (graph[curr] != null) { // Check for null before accessing elements
                    for (int i = 0; i < graph[curr].size(); i++) {
                        Edge e = graph[curr].get(i);
                        q.add(e.dest);
                    }
                }
            }
        }
    }
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean[] vis ){
        System.out.print(curr + " ");
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }
    //O(V^V) time complexity
    public static void printAllPath(ArrayList<Edge> graph[], boolean vis[], int curr,  String path, int tar) {
        if (curr == tar) {
            System.out.println(path);
            return;
        }
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                vis[curr] = true; // Mark current node as visited
                printAllPath(graph, vis, e.dest, path + "->" + e.dest, tar);
                vis[curr] = false; // Backtrack: Unmark the current node
            }
        }
    }
    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];

        // Step 1: Create the graph
        createGraph(graph);

        // Step 2: Perform BFS or DFS (if needed)
        boolean[] vis = new boolean[v];
        System.out.println("BFS Traversal:");
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                bfs(graph, v, vis, i);
            }
        }
        System.out.println();

        // Step 3: Print all paths from source to target
        vis = new boolean[v]; // Reset the visited array
        int src = 0, tar = 5;
        System.out.println("All Paths from " + src + " to " + tar + ":");
        printAllPath(graph, vis, src, src + "", tar);
    }//main function over
}