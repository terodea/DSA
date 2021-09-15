import java.util.*;
import java.io.*;

public class preToPost{

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
    
    public static Node construct(Node node, int num) {
        if(node == null ){
            Node nNode = new Node(num, null, null);
            return nNode;
        }

        if(num > node.data){
            node.right = construct(node.right, num);
            return node;
        }
        else{
            node.left = construct(node.left, num);
            return node;
        }
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

    public static void preToPostOrder(Node node){
        if(node == null){
            return;
        }
        preToPostOrder(node.left);
        preToPostOrder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args){
        
        int[] nodeOne = {40,30,32,35,80,90,100,120};
        int[] nodeTwo = {40, 30, 35, 80, 100};
        test(nodeOne);
        System.out.println();
        test(nodeTwo);
        System.out.println();
    }

    public static void test(int[] nodes){

        Node nn = new Node(nodes[0], null, null);
        
        for(int i=1; i<nodes.length; i++){
            nn = construct(nn, nodes[i]);
        }

        preToPostOrder(nn);
    }
}