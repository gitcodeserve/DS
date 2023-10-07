package com.learning.ds.tree;

public class Tree {
    Tree left;
    Tree right;
    int data;

    Tree(int data) {
        this.data = data;
        left = right = null;
    }
}
