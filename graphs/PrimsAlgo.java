package graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
    static class Edge {
        int src;
        int dst;
        int wt;

        Edge(int src, int dst, int wt) {
            this.src = src;
            this.dst = dst;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // Add edges to the graph (modify as needed)
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[1].add(new Edge(1, 2, 5));
        graph[1].add(new Edge(1, 3, 10));
        graph[2].add(new Edge(2, 3, 5));
        graph[3].add(new Edge(3, 4, 10));
    }

    public static class Pair implements Comparable<Pair> {
        int node;
        int cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost; // Ascending order
        }
    }

    // e log e time complexity
    public static void primsAlgo(ArrayList<Edge>[] graph, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[V];
        int mstCost = 0;

        // Start from an arbitrary node (here, node 0)
        pq.add(new Pair(0, 0)); // Node 0 with cost 0

        while (!pq.isEmpty()) {
            Pair current = pq.remove();

            if (!vis[current.node]) {
                vis[current.node] = true;
                mstCost += current.cost;

                for (Edge e : graph[current.node]) {
                    if (!vis[e.dst]) {
                        pq.add(new Pair(e.dst, e.wt));
                    }
                }
            }
        }

        System.out.println("Minimum Spanning Tree Cost: " + mstCost);
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        ArrayList<Edge>[] graph = new ArrayList[V];

        // Create the graph
        createGraph(graph);

        // Apply Prims algorithm
        primsAlgo(graph, V);
    }
}