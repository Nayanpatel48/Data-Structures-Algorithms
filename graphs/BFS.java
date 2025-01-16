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
    // Helper function to perform DFS and populate the stack with vertices in topological order
    public static void topSortUntil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> stack) {
        // Mark the current node as visited
        vis[curr] = true;

        // Traverse all neighbors of the current node
        for (int i = 0; i < graph[curr].size(); i++) {
            // Get the current edge
            Edge e = graph[curr].get(i);

            // If the destination node is not visited, perform DFS on it
            if (!vis[e.dest]) {
                topSortUntil(graph, e.dest, vis, stack);
            }
        }

        // Push the current node to the stack after all its neighbors are processed
        stack.push(curr);
    }

    // Function to perform Topological Sorting on a Directed Acyclic Graph (DAG)
    public static void topSort(ArrayList<Edge>[] graph, int v) {
        // Create a boolean array to track visited nodes
        boolean[] vis = new boolean[v];

        // Stack to store the topological order of vertices
        Stack<Integer> stack = new Stack<>();

        // Perform DFS on all unvisited nodes to process the entire graph
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                topSortUntil(graph, i, vis, stack);
            }
        }

        // Pop elements from the stack to print the topological order
        System.out.print("Topological Order: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    public static boolean isCycleExistUndirected(ArrayList<Edge>[] graph, boolean[] vis, int curr, int parent){
        //mark the current node as visited
        vis[curr]=true;

        //traverse all the neighbors of the current node
        for(int i=0;i<graph[curr].size();i++){
            //Get the current edge
            Edge e = graph[curr].get(i);

            // condition 1 : if the current node is visited, but it's parent not then return true
            if (vis[e.dest] && e.dest != parent){
                return true;
            } else if (!vis[e.dest]){
                if(isCycleExistUndirected(graph,vis, e.dest, curr)) {
                    //condition 3 :
                    return true;
                }
            }
        }

        //if cycle does not exist
        return false;
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

        //Topological sorting
        topSort(graph, v);

        vis = new boolean[v]; // Reset the visited array
        //is cycle exits
        System.out.print(isCycleExistUndirected(graph, vis, 0,-1));

    }//main function over
}