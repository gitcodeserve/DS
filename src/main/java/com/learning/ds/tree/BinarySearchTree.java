package com.learning.ds.tree;

public class BinarySearchTree {
    private Tree root;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new Tree(20);
        bst.root.left = new Tree(15);
        bst.root.left.left = new Tree(12);
        bst.root.left.right = new Tree(16);
        bst.root.right = new Tree(25);
        bst.root.right.left = new Tree(23);
        bst.root.right.right = new Tree(27);
        boolean isBST  = checkBSTTree(bst.root, Integer.MIN_VALUE,
                Integer.MAX_VALUE);
        System.out.println(isBST);

    }

    private static boolean checkBSTTree(Tree root, int min, int max) {

        if(root == null)
            return true;

        /* false if this node violates the min/max
         * constraints */
        if (root.data < min || root.data > max)
            return false;

      /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (
                checkBSTTree(root.left, min, root.data - 1)
                        && checkBSTTree(root.right, root.data + 1, max));
    }

}
