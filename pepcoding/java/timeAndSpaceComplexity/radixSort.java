public class radixSort{

    public static void main(String[] args){
        // int[] arr = {7, 2, 4, 1, 3};
        int[] arr = {99, 999, 989, 100, 0001, 23, 888988};
        radixSort(arr, 888988);
        print(arr);
    }

    public static void radixSort(int[] arr, int max){
        int exp = 1;
        while( max != 0){
            max /= 10;
            countSort(arr, exp);
            exp *= 10;
        }

    }

    public static void countSort(int[] arr, int exp){

        int[] farr = new int[10];

        for(int i=0; i<arr.length; i++){
            farr[(arr[i] / exp) % 10]++;
        }

        for(int i=1; i<farr.length; i++){
            farr[i] += farr[i - 1];
        }

        int[] ans = new int[arr.length];
        for(int i = arr.length-1; i >= 0; i--){
            int position = farr[(arr[i] / exp) % 10];
            ans[position - 1] = arr[i];
            farr[(arr[i] / exp) % 10]--;
        }

        for(int i=0; i<arr.length; i++){
            arr[i] = ans[i];
        }
        System.out.print("After sorting on " + exp + " place -> ");
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}