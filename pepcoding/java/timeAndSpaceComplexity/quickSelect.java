public class quickSelect{

    public static void main(String[] args){

        int n = 5;
        int[] arr = {7, -2, 4, 1, 3};
        int k = 3;
        System.out.println(quickSelect(arr, 0, arr.length-1,k-1));

    }

    public static int quickSelect(int[] arr, int low, int high, int k){

        int pivotIndex = partition(arr, arr[high], low, high);

        if(pivotIndex == k) return arr[pivotIndex];

        else if(pivotIndex < k){
            return quickSelect(arr, pivotIndex + 1, high, k);
        }
        else{
            return quickSelect(arr, low, pivotIndex - 1, k);
        }
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

    public static int partition(int[] arr, int pivot, int lo, int hi) {
        System.out.println("pivot -> " + pivot);
        int i = lo, j = lo;
        while (i <= hi) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            } 
            else {
                i++;
            }
        }
        System.out.println("pivot index -> " + (j - 1));
        return (j - 1);
    }

}