import java.io.*;
import java.util.*;

public class nodeToRootPath{

    /**
    1. You are given a partially written BinaryTree class.
    2. You are given an element.
    3. You are required to complete the body of find and nodeToRoot function. The functions are expected to 
        3.1. find -> return true or false depending on if the data is found in binary tree.
        3.2. nodeToRoot -> returns the path from node (correspoding to data) to root in form of an arraylist (root being the last element)
    4. Input iand Output is managed for you. 
    */

    public static class Node{

        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static ArrayList<Integer> getRootPath(Node node, int target){
        if(node == null){
            return new ArrayList<Integer>();
        }

        if(node.data == target){
            ArrayList<Integer> bans = new ArrayList<>();
            bans.add(node.data);
            return bans;
        }

        ArrayList<Integer> lans = getRootPath(node.left, target);
        if(lans.size() > 0){
            lans.add(node.data);
            return lans;
        }

        ArrayList<Integer> rans = getRootPath(node.right, target);
        if(rans.size() > 0){
            rans.add(node.data);
            return rans;
        }

        return new ArrayList<>();
    }
    public static void main(String[] args){
        int[] arr = {50, 25, 12, null, null,37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        int target = 87;
        
        Node root = construct(arr);
        ArrayList<Integer> ans = getRootPath(root, target)
        System.out.println(ans.size() > 0 ? true: false);
        System.out.println(ans);
    }
}