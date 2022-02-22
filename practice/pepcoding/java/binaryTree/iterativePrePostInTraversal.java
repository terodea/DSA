import java.io.*;
import java.util.*;

public class iterativePrePostInTraversal {
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
  /**
  50 25 12 37 30 75 62 70 87 Pre 
  12 25 30 37 50 62 70 75 87 In
  12 30 37 25 70 62 87 75 50 Post
   */
  public static void iterativePrePostInTraversal(Node node) {
      Stack<Pair> st = new Stack<>();
      
      String pre = "";
      String in = "";
      String post = "";

      st.push(new Pair(node, 0));

      while(st.size() > 0){
          Pair tos = st.peek();
          if(tos.state == 0){
              pre += tos.node.data + " ";
              tos.state++;

              if(tos.node.left != null){
                  st.push(new Pair(tos.node.left, 0));
              }
          }
          else if(tos.state == 1){
              in += tos.node.data+ " ";
              tos.state++;

              if(tos.node.right != null){
                  st.push(new Pair(tos.node.right, 0));
              }
          }
          else{
              post += tos.node.data +" ";
              tos.state++;
              st.pop();
          }
      }

      System.out.println(pre);
      System.out.println(in);
      System.out.println(post);
  }

  public static void main(String[] args) throws Exception {

      Integer[] arr = {50, 25, 12, null, null,37 ,30 ,null ,null ,null ,75 ,62 ,null ,70 ,null ,null ,87 ,null ,null};
    //   Integer[] arr = {10, 20, 40, null, 80, null, null, 50, null, null,30, null, 60, 70, null, null, null};

      Node root = construct(arr);

      iterativePrePostInTraversal(root);
  }

}