import java.util.*;
import java.io.*;

public class nextGreaterToRight{

    public static void main(String[] args){

        int[] arr = {5, 3, 8, -2, 7}; // {8, 8, -1, 7, -1}

        int[] nge = leftToRight(arr);
        display(nge);
        nge = rightToLeft(arr);
        display(nge);

    }

    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int val : a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static int[] leftToRight(int[] arr){

        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for(int i=1; i<arr.length; i++){
            while(st.size() != 0 && arr[st.peek()] < arr[i]){
                ans[st.pop()] = arr[i];
            }
            st.push(i);
        }
        
        while(st.size() != 0){
            ans[st.pop()] = -1;
        }
        return ans;
    }

    public static int[] rightToLeft(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i=arr.length-1; i>=0; i--){

            while(st.size() != 0 && arr[st.peek()] < arr[i]){
                st.pop();
            }
            if(st.size() == 0){
                ans[i] = -1;
            }
            else{
                ans[i] = arr[st.peek()];
            }
            st.push(i);
        }
        return ans;
    }
}