package graphs;
import java.util.*;

public class Graph_Adjacency_Weighted_Undirected {
    static class Edge {
        int src;
        int dest;
        int wt;

        //parameterized constructor
        public Edge(int src, int dest, int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
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
        graph[0].add(new Edge(0,2,2));

        graph[1].add(new Edge(1,2,10));
        graph[1].add(new Edge(2,3,0));

        graph[2].add(new Edge(2,0,2));
        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,-1));

        graph[3].add(new Edge(3,1, -1));
        graph[3].add(new Edge(3,2,0));
    }
    public static void main(String[] args){
        int v=4;
        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);
        //print 2's neighbours
        for(int i=0;i<graph[2].size();i++){
            Edge e = graph[2].get(i);
            System.out.println("("+e.dest+" ,"+e.wt+")");
        }
    }
}