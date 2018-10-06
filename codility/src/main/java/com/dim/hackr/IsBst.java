package com.dim.hackr;

public class IsBst {

    public static void main(String[] args){

        Node root = insert(null,3);
        insert(root,2);
        insert(root,6);

        insert(root,1);
        insert(root,4);

        insert(root,5);
        insert(root,5);


        checkBST(root);

    }


    static  boolean checkBST(Node root) {
        return checkBSTLimit(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean checkBSTLimit(Node node, int minLimit, int maxLimit) {
        if (node.data <= minLimit || node.data >= maxLimit) {
            return false;
        }
        if (node.left != null) {
            if(!checkBSTLimit(node.left, minLimit, node.data))
            return false;
        }
        if (node.right != null) {
            if(!checkBSTLimit(node.right, node.data, maxLimit))
            return false;
        }
        return true;
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


}
