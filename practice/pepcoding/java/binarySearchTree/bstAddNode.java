import java.io.*;
import java.util.*;

/**
    1. You are given a partially written BST class.
    2. You are required to complete the body of add function. "add" function is expected to add a new node with given data to the tree and return the new root.
*/

public class bstAddNode {

    public static class Node {
        int data;
        Node left;
        Node right;
        
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    
    public static class Pair {
        Node node;
        int state;
        
        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    
    public static Node construct(Integer[] arr) {
        
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);
        
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
        
        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }
        return root;
    }
    
    public static void display(Node node) {

        if (node == null) {
            return;
        }
        
        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);
        
        display(node.left);
        display(node.right);
    }
    
    public static Node add(Node node, int data) {

        if(node == null){
            return new Node(data, null, null);
        }

        if(node.data > data){
            node.left = add(node.left, data);
            return node;
        }
        else if(node.data < data){
            node.right = add(node.right, data);
            return node;
        }
        else{
            return node;
        }
    }
    
    public static void main(String[] args) throws Exception {

        int n = 23;
        Integer[] arr = {
            50, 25, 12, null, null, 37, 30, null, null, 40, null, null, 75, 62, 60, null, null, 70, null, null, 87, null, null
        };
        int data = 61;

        Node root = construct(arr);
        root = add(root, data);

        display(root);
    }
}