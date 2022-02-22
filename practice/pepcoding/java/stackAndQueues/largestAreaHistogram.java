import java.util.*;
import java.io.*;

public class largestAreaHistogram{

    public static void main(String[] args){
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        // nsr  1 5 3 5 5 7 7
        // nsl -1 -1 1 1 3 -1 5
        System.out.println(run(arr));
    }

    public static int run(int[] arr){
        int[] nsr = new int[arr.length];    
        int[] nsl = new int[arr.length]; 

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<arr.length; i++){
            while(st.size() !=0 && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            if(st.size() == 0){
                nsl[i] = -1;
            }
            else{
                nsl[i] = st.peek();
            }
            st.push(i);
        }

        st = new Stack<>();

        for(int i=arr.length - 1; i>=0 ;i--){
            while(st.size() != 0 && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            if(st.size() == 0){
                nsr[i] = arr.length;
            }
            else{
                nsr[i] = st.peek();
            }
            st.push(i);
        }

        int area = 0;
        for(int i=0; i<arr.length; i++){
            area = Math.max(area, arr[i] * (nsr[i] - nsl[i] - 1));
        }
        return area;
    }
}