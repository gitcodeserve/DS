package com.learning.ds.tree;

import java.util.*;

public class BinaryTree {
    Tree root;

    BinaryTree() { root = null; }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(5);


        System.out.print("IN-ORDER TRAVESAL -- ");
        inOrder(tree.root);
        System.out.println("\n");
        System.out.print("PRE-ORDER TRAVESAL -- ");
        preOrder(tree.root);

        System.out.println("\n");
        System.out.print("POST-ORDER TRAVESAL -- ");
        postOrder(tree.root);
        System.out.println("\n");
        System.out.print("LEVEL-ORDER TRAVESAL -- ");
        printLevelOrder(tree.root);

        System.out.println("\n");
        System.out.print("LEVEL-ORDER TRAVESAL -- ");
        printLevelOrderUsingQueue(tree.root);

        System.out.println("\n");

        int height = heightOfTree(tree.root);
        System.out.println("Height of the tree " + height);

    }

    private static int heightOfTree(Tree root) {
        if (root == null)
            return 0;
        else {
            int leftHeight = heightOfTree(root.left);
            int rightHeight = heightOfTree(root.right);

            if(leftHeight > rightHeight) {
                return leftHeight+1;
            }
            else
                return rightHeight+1;
        }

    }

    private static void inOrder(Tree binaryTree) {
        if(binaryTree == null)
            return;
        // First recur on left child
        inOrder(binaryTree.left);

        //print the data
        System.out.print(binaryTree.data + " ");

        // then recur on right node
        inOrder(binaryTree.right);
    }

    private static void preOrder(Tree binaryTree) {
        if(binaryTree == null)
            return;
        //print the data
        System.out.print(binaryTree.data + " ");

        // First recur on left child
        preOrder(binaryTree.left);

        // then recur on right node
        preOrder(binaryTree.right);
    }

    private static void postOrder(Tree binaryTree) {
        if(binaryTree == null)
            return;

        // First recur on left child
        postOrder(binaryTree.left);

        // then recur on right node
        postOrder(binaryTree.right);

        //print the data
        System.out.print(binaryTree.data + " ");
    }

    // Function to print level order traversal of tree
    static void printLevelOrder(Tree root)
    {
        int h = heightOfTree(root);
        int i;
        for (i = 1; i <= h; i++)
            printCurrentLevel(root, i);
    }

    // Print nodes at the current level
    static void printCurrentLevel(Tree root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    // Given a binary tree. Print
    // its nodes in level order
    // using array for implementing queue
    static void printLevelOrderUsingQueue(Tree root)
    {
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            // poll() removes the present head.
            Tree tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            // Enqueue left child
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            // Enqueue right child
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
}
