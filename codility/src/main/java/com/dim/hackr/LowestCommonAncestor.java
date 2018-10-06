package com.dim.hackr;

import java.util.*;
import java.io.*;



public class LowestCommonAncestor {


    public static Node lca(Node root, int v1, int v2) {

        if(root==null) return null;

        Node lcaNode = root;

        while(true){
            if(v1> lcaNode.data && v2 > lcaNode.data){ //if the both values are at right side -> go to right
                lcaNode = lcaNode.right;
            }
            else if(v1< lcaNode.data && v2< lcaNode.data){ //if both values are at left side -> go to left side
                lcaNode = lcaNode.left;
            }
            else{ //reached here means -> values are at either sides -> so this is the LCA
                return lcaNode;
            }
        }
    }


    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }






}

