package graphs;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.*;

public class BellmanFord {
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

        graph[1].add(new Edge(1,2,-4));
        graph[1].add(new Edge(2,3,2));

        graph[2].add(new Edge(3,4,4));
        graph[3].add(new Edge(4,1,-1));
    }
    public static void bellmanFord(ArrayList<Edge>[] graph, int src, int V){
        int[] dist = new int[V];

        //initialize distance matrix
        for (int i=0;i<V;i++){
            if (i != src){
                dist[i]=Integer.MAX_VALUE;
            }
        }

        for (int k=0;k<V-1;k++){ //O(v)

            //O(E)
            for (int i=0;i<V;i++){
                for (int j=0;j<graph[i].size();j++){
                    Edge e= graph[i].get(j);
                    int u = e.src;
                    int v = e.dst;
                    if (dist[u] != Integer.MAX_VALUE && dist[u]+e.wt < dist[v]){
                        dist[v]=dist[u]+e.wt;
                    }
                }
            }
        }

        //printing all distances
        for (int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int v=5;
        ArrayList[] graph = new ArrayList[v];

        createGraph(graph);

        bellmanFord(graph, 0,v);
    }
}