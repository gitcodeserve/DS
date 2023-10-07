package com.learning.ds.linkedlist;

// Implementation of Floyd’s Cycle-Finding Algorithm:
public class DetectLoopExample {
    private Node head;

    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    public static void main(String args[])
    {
        DetectLoopExample llist = new DetectLoopExample();

        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);

        /*Create loop for testing */
        llist.head.next.next.next.next = llist.head;

        llist.detectLoop();
    }

    private void detectLoop() {
    }
}



/* Linked list Node*/
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
