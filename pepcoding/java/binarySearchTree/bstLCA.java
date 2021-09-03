import java.io.*;
import java.util.*;

/**
    1. You are given a partially written BST class.
    2. You are required to complete the body of lca function. "lca" function is expected to find the lowest commong ancestor of d1 and d2.
 */
public class bstLCA {
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

  public static int lca(Node node, int d1, int d2) {
      if(node.data < d1 && node.data < d2){
          return lca(node.right, d1, d2);
      }
      else if(node.data > d1 && node.data > d2){
          return lca(node.left, d1, d2);
      }
      else{
          return node.data;
      }
  }

  public static void main(String[] args) throws Exception {

    int n = 21;
    Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, 60, null, null, 70, null, null, 87, null, null};
    int d1 = 12;
    int d2 = 30;

    Node root = construct(arr);
    System.out.println(lca(root, d1, d2));
  }

}