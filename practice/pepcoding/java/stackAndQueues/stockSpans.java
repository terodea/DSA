import java.util.*;
import java.io.*;

public class stockSpans{

    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int val : a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args){
        int[] arr = {2, 5, 9, 3, 1, 12, 6, 8, 7};
        int[] ans = run(arr);
        display(ans);
    }

    public static int[] run(int[] arr){

        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        ans[0] = 1;

        for(int i=1; i<arr.length; i++){

            while(st.size() !=0 && arr[st.peek()] < arr[i] ){
                st.pop();
            }
            if(st.size() == 0){
                ans[i] = i + 1;
            }
            else{
                ans[i] = i - st.peek();
            }
            st.push(i);
        }
        return ans;
    }
}