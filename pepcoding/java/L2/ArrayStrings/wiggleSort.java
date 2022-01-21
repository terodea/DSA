public class wiggleSort{
    public static void wiggleSort(int[] arr) {
        for(int i=0; i<arr.length - 1; i++){
            if(i % 2 == 0){
                if(arr[i] > arr[i+1]){
                    swap(arr, i, i+1);
                }
            }
            else{
                if(arr[i] < arr[i+1]){
                    swap(arr, i, i+1);
                }
            }
        }
    }
    
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int[] arr = {3,5,2,1,6,4};
        wiggleSort(arr).toString()
    }
}
