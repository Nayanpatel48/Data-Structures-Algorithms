package graphs;

import java.util.ArrayList;

public class EdgeConverter {
    static class Edge {
        int src;
        int dst;

        // parameterized constructor
        public Edge(int src, int dst) {
            this.src = src;
            this.dst = dst;
        }
    }

    public static ArrayList<Edge>[] convertToArrayList(int[][] graph) {
        int V = graph.length; // Assuming V is the number of vertices
        ArrayList<Edge>[] adjList = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : graph) {
            int src = edge[0];
            int dst = edge[1];
            adjList[src].add(new Edge(src, dst));
            adjList[dst].add(new Edge(dst, src)); // For undirected graph
        }

        return adjList;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {1, 3}, {2, 4}, {2, 5}};
        ArrayList<Edge>[] graph = convertToArrayList(edges);

        // Print the converted arraylist
        for (ArrayList<Edge> list : graph) {
            for (Edge e : list) {
                System.out.print(e.src + "->" + e.dst + " ");
            }
            System.out.println();
        }
    }
}