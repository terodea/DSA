import java.io.*;
import java.util.*;

public class constructBinaryTree{
    public static class Pair{
        Node node;
        int state;

        public Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(){

        }

        public Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static Node construct(Integer[] arr){

        Node root = new Node(arr[0], null, null);
        Stack<Pair> st = new Stack<>();

        st.push(new Pair(root, 0));

        for(int i=1; i<arr.length; i++){

            if(arr[i] == null){
                st.peek().state++;
                if(st.peek().state == 2){
                    st.pop();
                }
            }
            else{
                Node nn = new Node(arr[i], null, null);
                Pair tos = st.peek();

                if(tos.state == 0){
                    tos.node.left = nn;
                }
                else if(tos.state == 1){
                    tos.node.right = nn;
                }
                tos.state++;
                if(tos.state == 2){
                    st.pop();
                }
                st.push(new Pair(nn, 0));
            }
        }
        return root;
    }

    public static void display(Node node){
        if(node == null){
            return;
        }
        String s = "";
        s+= (node.left == null ? ". ": node.left.data) + " <- ";
        s+= node.data + " -> ";
        s+= node.right == null ? ". " : node.right.data;
        System.out.println(s);

        display(node.left);
        display(node.right);
    }

    public static void main(String[] args){

        Integer[] arr = {10, 20, 40, null, 80, null, null, 50, null, null,30, null, 60, 70, null, null, null};
        Node root = construct(arr);
        display(root);
    }
}