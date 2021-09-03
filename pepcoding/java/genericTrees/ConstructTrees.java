import java.util.*;

public class ConstructTrees{

    public static class Node{
        int data;
        ArrayList<Node> children;

        public Node(){
            children = new ArrayList<>();
        }
    }

    public static Node construct(int[] arr){
        Node rootnode = new Node();
        rootnode.data = arr[0];

        Stack<Node> st = new Stack<>();
        st.push(rootnode);
        for(int i=1; i<arr.length; i++){
            if(arr[i] == -1){
                st.pop();
            }
            else{
                Node n = new Node();
                n.data = arr[i];
                st.peek().children.add(n);
                st.push(n);
            }
        }
        return rootnode;
    }

    /**
    OBJECTIVE: Display tree in following pattern strictily using recursion.
        10 -> 20 30 40 
        20 -> 50 60 
        50 -> 
        60 -> 
        30 -> 70 80 90 
        70 -> 
        80 -> 
        90 -> 
        40 -> 100 
        100 ->
     */
    public static void display(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data + " -> ");
        for(int i=0; i<node.children.size(); i++){
            System.out.print(node.children.get(i).data + " ");    
        }
        System.out.println();
        for(int i=0; i<node.children.size(); i++){
            display(node.children.get(i));
        }
        
    }
    public static void main(String[] args){

        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        Node root = construct(arr);
        display(root);
    }
}
