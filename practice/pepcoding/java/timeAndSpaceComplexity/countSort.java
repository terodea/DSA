public class countSort{

    public static void main(String[] args){

        int[] arr = {7, -2, 4, 1, 3};
        int minVal = -2;
        int maxVal = 7;
        countSort(arr, minVal, maxVal);
        print(arr);
    }

    // public static void countSort(int[] arr, int min, int max){

    //     // Step 1: Frequency Array
    //     int[] frequencyArray = new int[max - min + 1];

    //     for(int i=0; i<arr.length; i++){
    //         frequencyArray[arr[i]-min]++;
    //     }

    //     // Step 2: Prefix Sum
    //     for(int i=1; i<arr.length; i++){
    //         frequencyArray[i] += frequencyArray[i - 1];
    //     }

    //     // Step 3: Form ans Array
    //     int[] ans = new int[arr.length];
    //     for(int i=arr.length - 1; i>=0; i--){
    //         int position = frequencyArray[arr[i] - min];
    //         ans[position - 1] = arr[i];
    //         frequencyArray[arr[i] - min]--;
    //     }
    //     // Step 4: Place ans Array values in arr.
    //     for(int i=0; i<arr.length; i++){
    //         arr[i] = ans[i];
    //     }
    // }
      public static void countSort(int[] arr, int min, int max) {
    //write your code here

    int[] farr = new int[max - min + 1];

    // 1. Create frequency array
    for (int i = 0; i < arr.length; i++) {
      farr[arr[i] - min]++;
    }
    //2.Convert frequency array to prefix sum array
    for (int i = 1; i < farr.length; i++) {
      farr[i] += farr[i - 1];
    }

    //3.Create ans array
    int[] ans = new int[arr.length];

    for (int i = arr.length - 1; i >= 0; i--) {
      int pos = farr[arr[i] - min];
      ans[pos - 1] = arr[i];
      farr[arr[i] - min]--;
    }

    //4.Fill org array
    for (int i = 0; i < arr.length; i++) {
      arr[i] = ans[i];
    }

  }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}