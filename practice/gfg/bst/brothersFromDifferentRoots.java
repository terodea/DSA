import java.util.*;
import java.io.*;

public class brothersFromDifferentRoots{

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

    public static void inOrder(Node node, ArrayList<Integer> al){
        if(node == null){
            return;
        }

        inOrder(node.left, al);
        al.add(node.data);
        inOrder(node.right, al);
    }

    public static void inOrderByHash(Node node, HashMap<Integer, Integer> hm){
        if(node == null){
            return;
        }

        inOrderByHash(node.left, hm);
        hm.put(node.data, 1);
        inOrderByHash(node.right, hm);
    }

    public static void main(String[] args){
        Integer[] bOne = {5, 3, 2, null, null, 4, null, null, 7, 6, null, null,8, null, null};
        Integer[] bTwo = {10, 6, 3, null, null, 8, null, null, 15, 11, null, null, 18, null, null};
        int target = 16;
        int pairCount = 0;
        ArrayList<Integer> oneAL = new ArrayList<>();
        HashMap<Integer, Integer> twoAL = new HashMap<Integer, Integer>();

        Node oneNode = construct(bOne);
        Node twoNode = construct(bTwo);

        inOrder(oneNode, oneAL);
        inOrderByHash(twoNode, twoAL);

        for(int i=0; i<oneAL.size(); i++){
            int fNum = oneAL.get(i);
            int toCheck = target - fNum;

            if(twoAL.containsKey(toCheck)){
                pairCount++;
            }
        }
        System.out.println(pairCount);
    }
}