package pushpak50Grapha;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Edge{
        int src;
        int dest;
        public Edge(int s ,int d) {
            this.src = s;
            this.dest =d;
        }

    }
    public static void creatgraph(ArrayList<Edge> graph[]){
        for(int i =0;i<graph.length;i++){
            graph[i] =new ArrayList<Edge>(); //arrray list consist null value assing an array to null
        }
        graph[0].add(new Edge(0,2));
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



    }
    public static void printGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (Edge edge : graph[i]) {
                System.out.print(edge.dest + " ");
            }
            System.out.println();
        }
    }
    public static void bfs(ArrayList<Edge> graph[], int v) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[v];

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");


            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);

                if (!vis[e.dest]) {
                    q.add(e.dest);
                    vis[e.dest] = true;
                }
            }
        }
    }
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visited[]) {
        System.out.print(curr + " ");
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(visited[e.dest]==false) {
                dfs(graph, e.dest, visited);
            }

        }
    }


    public static void main(String[] args) {
        int v =7;
        ArrayList<Edge> graph[] =new ArrayList[v];
        creatgraph(graph);

        printGraph(graph);

        // print 2 neighbours
            System.out.print("neighbour of 2 :");
        for(int i =0; i<graph[2].size(); i++){
            Edge e =graph[2].get(i);
            System.out.print(e.dest+" ");
        }
        //BFS
        System.out.println();
        System.out.println("BFS traversal starting from vertex 0:");
        bfs(graph,v);

       //DFS
        System.out.println();
        System.out.println("DFS :");
        boolean vis[] = new boolean[v];
        dfs(graph,0,vis);

    }
}
