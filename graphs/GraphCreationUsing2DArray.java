package graphs;

import java.util.*;

public class GraphCreationUsing2DArray {
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        // Step 1: Build the graph using an adjacency list
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges to the adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);  // Since it's an undirected graph
        }

        // Step 2: Perform BFS to find a path from source to destination
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            // If we reach the destination, return true
            if (node == destination) {
                return true;
            }

            // Explore all unvisited neighbors of the current node
            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        // If BFS completes and we haven't found the destination, return false
        return false;
    }
    public static void main(String[] args){
        int[][] arr = {{0,1},{1,2},{2,0}};
        System.out.println(validPath(3, arr,0,2));
    }
}