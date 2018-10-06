package com.dim.datastructure;

import com.sun.prism.impl.ps.BaseShaderFactory;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BST {

    Node root;

    public Node get(int value) {

        if (root == null) {
            return null;
        }

        Node currentNode = root;

        while (true) {

            if (currentNode.data == value) return currentNode;
            if (value > currentNode.data) {
                if (currentNode.right != null) {
                    currentNode = currentNode.right;
                } else {
                    return null;
                }
            } else {
                if (currentNode.left != null) {
                    currentNode = currentNode.left;
                } else {
                    return null;
                }
            }
        }
    }

    public void add(int entry) {

        Node currentNode = root;

        //If there is no root -> add it first
        if (root == null) {
            root = new Node(null, null, entry);
            return;
        }

        //iterate through the tree till a empty position is found
        while (true) {
            if (currentNode.data < entry) {
                if (currentNode.right != null) {
                    currentNode = currentNode.right;
                } else {
                    currentNode.right = new Node(null, null, entry);
                    return;
                }
            } else {
                if (currentNode.left != null) {
                    currentNode = currentNode.left;
                } else {
                    currentNode.left = new Node(null, null, entry);
                    return;
                }
            }
        }
    }

    public Node max() {

        if (root == null) {
            return null;
        }
        Node currentNode = root;
        while (true) {

            if (currentNode.right != null) {
                currentNode = currentNode.right;
            } else return currentNode;
        }
    }

    public Node max(Node node) {

        if (node == null) {
            return null;
        }
        Node currentNode = node;
        while (true) {

            if (currentNode.right != null) {
                currentNode = currentNode.right;
            } else return currentNode;
        }
    }


    public Node min() {

        if (root == null) {
            return null;
        }
        Node currentNode = root;
        while (true) {

            if (currentNode.left != null) {
                currentNode = currentNode.left;
            } else return currentNode;
        }
    }

    public int height() {

        if (root == null) return -1;

        return heightOfNode(root);

    }

    public int heightOfNode(Node node) { //O(n) ,since every node is visited at once

        int leftHight = 0;
        int rightHight = 0;

        if (node.left != null) {
            leftHight = heightOfNode(node.left) + 1;
        }
        if (node.right != null) {
            rightHight = heightOfNode(node.right) + 1;
        }

        return leftHight > rightHight ? leftHight : rightHight;

    }

    public void DFS() {
        if (root == null) {
            System.out.println("");
            return;
        }
        DFS(root);
    }

    public void DFS(Node node) { //time complexity O(n) , memory complexity O(h)

        if (node.left != null) {
            DFS(node.left);
        }
        System.out.print(node.data + ",");
        if (node.right != null) {
            DFS(node.right);
        }

    }

    public void BFS() {
        System.out.print(" \n BFS is : ");
        if (root != null)
            BFS(root, new LinkedList());
    }


    private void BFS(Node node, Queue<Node> queue) { //Level order traversal. The queue keep discovered nodes queue. o(n),  space  - worst O(n) , best o(1)

        System.out.print(node.data + ",");

        if (node.left != null)
            queue.add(node.left);

        if (node.right != null)
            queue.add(node.right);

        if (!queue.isEmpty())
            BFS(queue.poll(), queue);

    }

    /**
     * Check if a given tree is a BST(for every node, left subtree values should be less or equal or right sub tree values should be greater)
     */

    public boolean isBST() {
        if (root == null) return true;
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    //solution 1 for iSSBT -> check if node value is in a range
    //solution 2 -> in order traversal -> check if the values are in ascending order (If not -> then not BST)
    public boolean isBST(Node node, int minLimit, int maxLimit) {  //o(n)

        if (node.data < minLimit) {
            return false;
        }
        if (node.data > maxLimit) {
            return false;
        }

        if (node.left != null) {
            if (!isBST(node.left, minLimit, node.data)) {
                return false;
            }
        }

        if (node.right != null) {
            if (!isBST(node.right, node.data + 1, maxLimit)) {
                return false;
            }
        }
        return true;
    }

    public void delete(int value) {

        delete(root, value);

    }

    private Node delete(Node node, int value) {

        if (node == null) {
            return null;
        }

        if (value < node.data) {
            node.left = delete(node.left, value);
            return node;
        } else if (value > node.data) {
            node.right = delete(node.right, value);
            return node;
        } else { //the correct node to delete is found

            //If its leaf node -> just delete
            if (node.right == null && node.left == null) {
                return null;
            } else if (node.right != null && node.left == null) { //deleting node has a right child
                return node.right;
            } else if (node.right == null && node.left != null) { //deleting node has a left child
                return node.left;
            } else {
                /**both left and right child is not null.
                 * take the max value from left subtree and replace into this node. Then delete max value from left sub tree
                 *
                 * */
                node.data = max(node.left).data; //first copy the value from left subtree max value to current node
                node.left = delete(node.left, node.data); //delete left subtree max value. This means -> now we are deleting a note which does not have a right child(node.right == null)
                return node;
            }
        }
    }

    public int nextSuccessor(int value) {

        return nextSuccessor(root,value);
    }


        private int nextSuccessor(Node node, int value) {
        /**
         * If the matching node has a right child -> then that is the sucessor
         * -> if not -> the closest left bound ancestor
         * */

        Node current = node;
        while (true) {

            if (current.data == value) {
                if (current.right != null) {  //If there is right child for this node -> then it is the successor
                    return current.right.data;
                } else { //this case most closet, left bound ancestor is the successor. Come from root and check.

                    Node current1 = root;
                    Node recentLeftNode = null;
                    while (true) {

                        if (value > current1.data) {
                            current1 = current1.right;
                        } else if (value < current1.data) {
                            recentLeftNode = current1;
                            current1 = current1.left;
                        } else {
                            return recentLeftNode.data;
                        }
                    }
                }
            }
            if (value > current.data) {
                current = current.right;

            } else {
                current = current.left;

            }
        }
    }


}

class Node {
    Node left;
    Node right;
    int data;

    public Node(Node left, Node right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }
}
