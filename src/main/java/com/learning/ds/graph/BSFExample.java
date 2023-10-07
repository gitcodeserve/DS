package com.learning.ds.graph;

/*The Breadth First Traversal or BFS traversal of a graph
is similar to that of the Level Order Traversal of Trees.

The BFS traversal of Graphs also traverses the graph in levels.
It starts the traversal with a given vertex, visits all of the
vertices adjacent to the initially given vertex and pushes them
all to a queue in order of visiting. Then it pops an element
from the front of the queue, visits all of its neighbours and
pushes the neighbours which are not already visited into the
queue and repeats the process until the queue is empty or all of the vertices are visited.

 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BSFExample {
    public static void main(String[] args) {
        // Creating a graph with 6 vertices
        int V = 6;
        ArrayList<ArrayList<Integer> > adj
                = new ArrayList<ArrayList<Integer> >(V+1);

        for (int i = 0; i < V+1; i++)
            adj.add(new ArrayList<Integer>());

        System.out.println(adj);
        // Adding edges one by one
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 2, 5);
        addEdge(adj, 3, 5);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 6);
        addEdge(adj, 5, 6);

        BFS(adj, V);
    }

    //Create undirectional edge (that's why connected from u to v and v to u.
    private static void addEdge(ArrayList<ArrayList<Integer> > adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

     // Function to perform BFS traversal of a Graph
    private static void BFS(ArrayList<ArrayList<Integer> > adj, int V) {
        // Initialize a boolean array
        // to keep track of visited vertices
        boolean visited[] =  new boolean[V+1];

        // Mark all vertices not-visited initially
        for (int i = 1; i <= V; i++)
            visited[i] = false;

        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<Integer>();

        // The start vertex or source vertex is 1
        int s = 1;

        // Mark the current node as
        // visited and enqueue it
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");

            // Traverse the nodes adjacent to the currently
            // popped element and push those elements to the
            // queue which are not already visited
            for (int i = 0; i < adj.get(s).size(); i++) {

                // Fetch adjacent node
                int newNode = adj.get(s).get(i);

                // Check if it is not visited
                if(visited[newNode] == false)
                {
                    // Mark it visited
                    visited[newNode] = true;
                    // Add it to queue
                    queue.add(newNode);
                }
            }
        }
    }
}
