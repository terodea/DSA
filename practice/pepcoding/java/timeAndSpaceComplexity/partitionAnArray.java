public class partitionAnArray{

    public static void main(String[] args){
        /*
        *Swapping -2 and 7 
        *Swapping 1 and 7
        *Swapping 3 and 4
        *-2 1 3 7 4
        */
        int n = 5;
        int[] arr = { 7, -2, 4, 1, 3 };
        int pivot = 3;
        
        solution(arr, pivot);
        print(arr);
    }

    public static void solution(int[] arr, int pivot){
        int i = 0;
        int j = 0;
        while(i < arr.length){
            if(arr[i] <= pivot){
                swap(arr, i, j);
                j++;
                i++;
            }
            else{
                i++;
            }
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

}