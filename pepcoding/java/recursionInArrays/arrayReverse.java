public class arrayReverse{

    public static void main(String[] args){
        int[] arr = {3, 1, 0, 7, 5};
        int n = 5;
        display(arr, n-1);
    }

    public static void display(int[] arr, int idx){
        if(idx < 0){
            return;
        }

        System.out.println(arr[idx]);
        display(arr, idx-1);
    }
}