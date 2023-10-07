package com.learning.ds.graph;

import java.util.ArrayList;

public class DFSExample {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V=9;

        for(int i=0; i<=V+1; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdges(adj, 0, 1);
        addEdges(adj, 0, 2);
        addEdges(adj, 1, 2);
        addEdges(adj, 2, 3);
        addEdges(adj, 2, 5);
        addEdges(adj, 6, 7);
        addEdges(adj, 7, 8);

        printDFS(adj, V, 5);


        System.out.println("\n");

        System.out.println(0%3);
        System.out.println(0/3);

        System.out.println(1%3);
        System.out.println(1/3);

        System.out.println(2%3);
        System.out.println(2/3);

        System.out.println(3%3);
        System.out.println(3/3);


    }

    private static void printDFS(ArrayList<ArrayList<Integer>> adj, int V, int source) {
        boolean[] visited = new boolean[V];

        //Added following check in a loop for disconnected graph
        for (int i=0; i<V; i++) {
            if(visited[i] == false)
                DFSRec(adj, i, visited);
        }

    }

    private static void DFSRec(ArrayList<ArrayList<Integer>> adj, int source, boolean[] visited) {
        visited[source] = true;
        System.out.print(source + " ");

        for(int u: adj.get(source)) {
            if(visited[u] == false){
                DFSRec(adj, u, visited);
            }
        }
    }

    private static void addEdges(ArrayList<ArrayList<Integer>> adj, int i, int j) {

        adj.get(i).add(j);
        adj.get(j).add(i);
    }
}
