package com.dim.datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class BSTTest {

    @Test
    public void add() {

        BST bst = new BST();

        bst.add(20);
        bst.add(5);
        bst.add(1);
        bst.add(8);
        bst.add(25);
        bst.add(23);
        bst.add(27);

        assertEquals(bst.get(8).data, 8);
        assertEquals(bst.max().data, 27);
        assertEquals(bst.min().data, 1);


        System.out.println(bst.height());

        bst.DFS();

        bst.BFS();

        System.out.println(" \n isSBT : " + bst.isBST());

        //System.out.print(" \n isSBT_inOrder : ");  bst.isBST_inOrder();

       // bst.delete(5);

        System.out.println("Next Su : " + bst.nextSuccessor(20));



    }
}