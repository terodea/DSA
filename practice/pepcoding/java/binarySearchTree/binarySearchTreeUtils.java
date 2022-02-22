import java.io.*;
import java.util.*;
/**
    1. You are given a partially written BST class.
    2. You are required to complete the body of size, sum, max, min and find function. The functions are expected to:
        2.1. size - return the number of nodes in BST
        2.2. sum - return the sum of nodes in BST
        2.3. max - return the value of node with greatest value in BST
        2.4. min - return the value of node with smallest value in BST
        2.5. find - return true if there is node in the tree equal to "data"
 */
public class binarySearchTreeUtils {
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

  public static int size(Node node) {
      if(node == null){
          return 0;
      }

      return 1 + size(node.left) + size(node.right);
  }

  public static int sum(Node node) {
      if(node == null){
          return 0;
      }

      return node.data + sum(node.left) + sum(node.right);
  }

  public static int max(Node node) {
      if(node == null){
          return Integer.MIN_VALUE;
      }

      return Math.max(node.data, Math.max(max(node.left), max(node.right)));
  }

  public static int min(Node node) {
      if(node == null){
          return Integer.MAX_VALUE;
      }

      return Math.min(node.data, Math.min(min(node.left), min(node.right)));
  }

  public static boolean find(Node node, int data){
      if(node == null){
          return false;
      }

      if(node.data == data){
          return true;
      }
      
      return (node.data > data) ? find(node.left, data) : find(node.right, data);
  }  

  public static void main(String[] args) throws Exception {
    int n = 19;
    Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
    int data = 70;

    Node root = construct(arr);

    System.out.println("SIZE: " + size(root));
    System.out.println("SUM: " + sum(root));
    System.out.println("MAX: " + max(root));
    System.out.println("MIN: " + min(root));
    System.out.println("FOUND: " + find(root, data));
  }
}