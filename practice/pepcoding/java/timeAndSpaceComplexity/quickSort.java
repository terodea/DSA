public class quickSort{

    public static void main(String[] args){
        int n = 5;
        int[] arr = { 7, -2, 4, 1, 3 };
        quickSort(arr, 0, arr.length - 1);
        print(arr);
    }

    public static void quickSort(int[] arr, int low, int high){

        if(low <= high){
            int pivotIndex = partitionAnArray(arr, arr[high], low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex+1, high);
        }
    }

    public static int partitionAnArray(int[] arr, int pivot, int low, int high){
        System.out.println("pivot -> " + pivot);
        int i = low, j = low;
        while (i <= high) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            } 
            else{
                i++;
            }
        }
        System.out.println("pivot index -> " + (j - 1));
        return (j - 1);
    }

    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}