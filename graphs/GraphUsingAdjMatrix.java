package graphs;

import java.util.*;

public class GraphUsingAdjMatrix {
    //declare a function to add edges to graph
    public static void addEdge(int[][] graph, int u, int v){
        graph[u][v]=1;
        graph[v][u]=1;
    }
    public static void printAdjMatrix(int[][] graph, int vertices){
        for (int i=0;i<vertices;i++){
            for (int j=0;j<vertices;j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void BFS (int[][] adjacencyMatrix, int startingNode){
        //figure out total number of nodes in graph
        int numberOfNodes = adjacencyMatrix.length;

        //create boolean array which will keep track of visited nodes
        boolean[] visited = new boolean[numberOfNodes];

        //creating queue for BFS traversal
        Queue<Integer> queue = new LinkedList<>();

        //inserting starting node into queue for traversal purpose
        //also marking it as visited
        visited[startingNode] = true;
        queue.offer(startingNode);

        System.out.println("We've started traversing(BFS) graph by node: "+startingNode);

        while (!queue.isEmpty()){
            //poll the front node from queue & print it
            int currentNode = queue.poll();

            System.out.print(currentNode+" ");

            //check for all of its neighbors are visited or not
            for (int neighbor=0;neighbor<numberOfNodes;neighbor++){

                //check if its neighbors are visited & there is edge existing between
                //neighbor & current node
                if (!visited[neighbor] && adjacencyMatrix[currentNode][neighbor] == 1){

                    //mark neighbor as visited & push it into stack
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }
    public static void DFS(int[][] adjacencyMatrix, boolean[] visited, int currentNode){
        //mark the current node as true
        visited[currentNode] = true;
        System.out.print(currentNode+" ");

        //check for all its neighbors
        for (int neighbor=0;neighbor<visited.length;neighbor++){

            //if neighbor is not visited plus the edge exits then mark it visited
            //& print it
            if (!visited[neighbor] && adjacencyMatrix[currentNode][neighbor] == 1){
                DFS(adjacencyMatrix,visited,neighbor);
            }
        }
    }
    public static void main(String[] args) {
        //define number of vertices in our graph
        //we will have 0,1,2,3
        int vertices = 4;

        //initialize 4*4 matrix with 0s
        int[][] adjMatrix = new int[vertices][vertices];

        //adding 4 edges
        addEdge(adjMatrix, 0, 1);
        addEdge(adjMatrix, 0, 2);
        addEdge(adjMatrix, 1, 2);
        addEdge(adjMatrix, 1, 3);

        //print adjacency matrix
        printAdjMatrix(adjMatrix,vertices);

        BFS(adjMatrix, 0);

        System.out.println();
        System.out.println("Performing DFS starting from node 0:");

        //creating boolean array called visited specifically for DFS traversal
        boolean[] visited = new boolean[adjMatrix.length];

        DFS(adjMatrix, visited, 0);
    }
}