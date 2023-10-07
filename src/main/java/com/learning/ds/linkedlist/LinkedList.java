package com.learning.ds.linkedlist;

public class LinkedList {
    public static class Node {
        private Node node;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNextNode() {
            return node;
        }

        public void setNextNode(Node node) {
            this.node = node;
        }
    }

    private Node head;
    private int size=0;

    // Inserting value at the end.
    public void insert(int value){
        Node newNode = new Node(value);
        if(this.head == null){
            head = newNode;
            size++;
        } else {
            Node currentNode = head;

            while(currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
            size++;
        }
    }

    public void insertHead(int value) {
        Node newNode = new Node(value);
        newNode.setNextNode(head);
        head = newNode;
        size++;
    }

    public void insertAt(int index, int value) {
        Node newNode = new Node(value);
        Node node = head;
        for (int i = 0; i < index - 1; i++) {
            node = node.getNextNode();
        }
        newNode.setNextNode(node.getNextNode());
        node.setNextNode(newNode);
        size++;
    }

    // Deleting value from the end.
    public void deleteNodeAt(int index) {
        Node node = head;
        for (int i=0; i<index-1; i++){
            node = node.getNextNode();
        }
        node.setNextNode(node.getNextNode().getNextNode());
        size--;
    }

    // Deleting value from the beginning.
    public void deleteNodeAtFirst() {
        Node node = head;
        head = head.getNextNode();
        node.setNextNode(null);
        size--;
    }

    public void display(){
        if(head != null) {
            Node currentNode = head;
            while(currentNode.getNextNode() != null){
                System.out.println(currentNode.getValue());
                currentNode = currentNode.getNextNode();
            }
            System.out.println(currentNode.getValue());
        }
    }

    /*To reverse a linked list, we need 3 pointers - previous, current and next.
    Initially, current pointer points to the head node and in each iteration,
     the next node of current node points to the previous node and we shift
     all the pointers one step ahead, meaning the previous pointer now points
     to the current node and current pointer points to the next node.
     */

    public Node reverse(){
        Node previous = null;
        Node current = head;
        Node next;
        while (current != null){
            next = current.getNextNode();
            current.setNextNode(previous);
            previous = current;
            current = next;
        }
        this.head = previous;
        return previous;
    }

    public int getSize(){
        return size;
    }

    public void deleteLoop() {

        Node f_pointer = head;
        Node s_pointer = head;

        boolean loopDetected = false;

        while(s_pointer != null && f_pointer != null && f_pointer.node != null) {
            s_pointer = s_pointer.node;
            f_pointer = f_pointer.node.node;

            if (s_pointer == f_pointer) {
                loopDetected = true;
                removeLoop(s_pointer, head);
                break;
            }
        }

        if(loopDetected){
            System.out.println("Loop Detected..");
        }
        else
            System.out.println("No loop");

    }

    // Function to remove loop
    private static void removeLoop(Node loop, Node head)
    {
        Node ptr1 = head;
        Node ptr2 = loop;

        // Count the number of nodes in loop
        int k = 1, i;
        while (ptr1.node != ptr2.node) {
            // keeping track beforeing moving next
            ptr1 = ptr1.node;
            ptr2 = ptr2.node;
            k++;
        }
        System.out.println("Loop deletected at " + k);
        ptr1.node = null;
    }


    public static void main(String [] args) {
        LinkedList customLinkedList = new LinkedList();
        customLinkedList.insert(5);
        customLinkedList.insert(10);
        customLinkedList.insert(15);
        customLinkedList.insert(20);
        customLinkedList.display();
        customLinkedList.insertAt(2, 100);
        System.out.println("********");
        customLinkedList.display();
        System.out.println("********");
        customLinkedList.deleteNodeAt(2);
        customLinkedList.display();
        System.out.println("********");
        customLinkedList.insertHead(50);
        customLinkedList.display();
        System.out.println("********");
        customLinkedList.reverse();
        customLinkedList.display();
        System.out.println("********");
        customLinkedList.deleteNodeAtFirst();
        customLinkedList.display();
        System.out.println("********");
        System.out.println("Linked list size "+ customLinkedList.getSize());

        customLinkedList.head.node.node.node = customLinkedList.head;

        customLinkedList.deleteLoop();

        System.out.println("Linked list after detecting and removing loop ");
        customLinkedList.display();

    }

}
