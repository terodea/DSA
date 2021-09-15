import java.util.*;
import java.io.*;

public class mergeTwoBST{

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

    public static void inOrder(Node node, ArrayList<Integer> al){
        if(node == null){
            return;
        }

        inOrder(node.left, al);
        al.add(node.data);
        inOrder(node.right, al);
    }

    public static void main(String[] args){

        Integer[] nodeOne = {5, 3, 2, null, null, 4, null, null, 6, null, null};
        Integer[] nodeTwo = {2, 1, null, null, 3, null, 7, 6, null, null, null};

        Node treeOne = construct(nodeOne);
        Node treeTwo = construct(nodeTwo);

        ArrayList<Integer> treeOneAL = new ArrayList<>();
        ArrayList<Integer> treeTwoAL = new ArrayList<>();

        inOrder(treeOne, treeOneAL);
        inOrder(treeTwo, treeTwoAL);

        merge(treeOne, treeTwo, treeOneAL, treeTwoAL);    
    }

    public static void merge(Node treeOne, Node treeTwo, ArrayList<Integer> treeOneAL, ArrayList<Integer> treeTwoAL){
        ArrayList<Integer> ans = new ArrayList<>();

        int t1 = 0; // treeOneAL pointer
        int t2 = 0; // treeOneAL pointer

        // [2,3,4,5,6] t1
        // [1,2,3,6,7] t2
        while(t1 != treeOneAL.size() && t2 != treeTwoAL.size()){
            int num1 = treeOneAL.get(t1);
            int num2 = treeTwoAL.get(t2);

            if(num1 > num2){
                ans.add(num2);
                t2++;
            }
            else{
                ans.add(num1);
                t1++;
            }
        }
        while(t1 != treeOneAL.size()){
            ans.add(treeOneAL.get(t1));
            t1++;
        }
        while(t2 != treeTwoAL.size()){
            ans.add(treeTwoAL.get(t2));
            t2++;
        }
        
        System.out.println(ans);
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
}