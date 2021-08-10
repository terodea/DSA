import java.io.*;
import java.util.*;

public class genericTreeMaxNode{
    /**
    OBJECTIVE: Print The data for Node having maximum data property amongst all the nodes.
     */
    public static void main(String[] args){
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        Node root = construct(arr);
        System.out.println(maxNode(root));   
    }

    public static int maxNode(Node root){
        int maxVal = Integer.MIN_VALUE;
        for(Node child:node.children){
            maxVal = Math.max(maxVal, maxNode(child));
        }
        return Math.max(maxVal, root.data);
    }

    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node construct(int[] arr){
        Node root = new Node();
        Stack<Node> st = new Stack<>();

        root.data = arr[0];
        st.push(root);

        for(int i=1; i<arr.length; i++){
            if(arr[i] == -1){
                st.pop();
            }
            else{
                Node newNode = new Node();
                newNode.data = arr[i];
                st.peek().children.add(newNode);
                st.push(newNode);
            }
        }
        return root;
    }

    public static int size(Node root){

        int size = 0;
        for(Node child: root.children){
            size += size(child);
        }
        return 1 + size;
    }
    public static void display(Node root){
        String str = node.data + " -> ";
        for (Node child : node.children) {
        str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
        display(child);
        }
    }
}