package com.learning.ds.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphExample {

    // Graph of
    // 1 -> 2 -> 3
    // 2 -> 1 -> 3
    // 1-> 3 -> 4
    // 3 ->4
    public static void main(String[] args) {
        //Represent graph in form of adjaceny metrix - List of List
        // Top level list is number of nodes
        // Inner list is refereneces to the node


        int vertices = 5;

        List<List<Integer>> adjacency = new ArrayList<List<Integer>>(5);
        System.out.println(adjacency.size());
        // Empty list of list created for graph
        for(int i=0; i< vertices; i++){
            adjacency.add(new ArrayList<>());
        }

        //Creating
        addEdge(adjacency, 0, 1);
        addEdge(adjacency, 0, 2);
        addEdge(adjacency, 1, 0);
        addEdge(adjacency, 1, 2);
        addEdge(adjacency, 1, 3);
        addEdge(adjacency, 1, 4);
        addEdge(adjacency, 2, 0);
        addEdge(adjacency, 2, 1);
        addEdge(adjacency, 2, 3);
        addEdge(adjacency, 3, 1);
        addEdge(adjacency, 3, 2);
        addEdge(adjacency, 3, 4);
        addEdge(adjacency, 4, 1);
        addEdge(adjacency, 4, 3);


        System.out.println(adjacency);

        printGraph(adjacency);


    }

    private static void printGraph(List<List<Integer>> adjacency) {
        for(int i=0; i<adjacency.size(); i++){
            for(int j=0; j<adjacency.get(i).size(); j++){
                System.out.print(adjacency.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static void addEdge(List<List<Integer>> adjacency, int u, int v) {
        adjacency.get(u).add(v);
    }
}
