import java.io.*;
import java.util.*;

public class bstTargetSumPair {
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
  
  public static boolean find(Node node, int data){
      if(node == null){
          return false;
      }
      
      if(node.data == data){
          return true;
      }
      
      if(node.data > data){
          return find(node.left,data);
      }
      else{
          return find(node.right, data);
      }
  }
  
  public static void targetSumPair(Node root, Node node, int target){
      if(node == null){
          return;
      }
      targetSumPair(root, node.left, target);

      int compliment = target - node.data;
      if(compliment > node.data && find(root, compliment)){
          System.out.println(node.data + " " + compliment);
      }
      targetSumPair(root, node.right, target);
  }
  
  public static void solution(Node node, ArrayList<Integer> al){
      if(node == null){
          return;
      }
      
      solution(node.left, al);
      al.add(node.data);
      solution(node.right, al);
  }

  public static void main(String[] args) throws Exception {
      int n = 23;
      Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, 40, null, null, 75, 62, 60, null, null, 70, null, null, 87, null, null};
      int data = 61;
      
      Node root = construct(arr);
      // write your code here
      // targetSumPair(root, root, data);
      ArrayList<Integer> al = new ArrayList<>();
      solution(root, al);
      int right = al.size() - 1;
      int left = 0;
      
      while(left < right){
        int sumVal = al.get(left) + al.get(right);
        if(sumVal == data){
            System.out.println(al.get(left) + " " + al.get(right));
            left++;
            right--;
            }
        else if( sumVal < data){
            left++;
        }
        else if( sumVal > data){
            right--;
        }
    }
  }
}