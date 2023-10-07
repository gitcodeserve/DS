package com.learning.ds.linkedlist;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

public class LinkedListTest {
    private static LinkedList customLinkedList = null;

    @BeforeAll
    public static void setup() {
        customLinkedList = new LinkedList();
        customLinkedList.insert(5);
        customLinkedList.insert(10);
        customLinkedList.insert(15);
        customLinkedList.insert(20);
    }

    @Test
    public void testSize() {
        Assert.assertEquals(4, customLinkedList.getSize());
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("I am done with test cases...");
    }

}
