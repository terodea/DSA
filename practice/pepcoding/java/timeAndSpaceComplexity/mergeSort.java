public class mergeSort{

    public static void main(String[] args){

        int n = 5;
        int[] arr = { 7, -2, 4, 1, 3 };

        int[] finalArray = mergeSort(arr, 0, arr.length-1);
        print(finalArray);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) System.out.print(arr[i]+ " ");
        System.out.println();
    }

    public static int[] mergeTwoSortedArrays(int[] a, int[] b){
        System.out.println("Merging these two arrays ");
        System.out.print("left array -> ");
        print(a);
        System.out.print("right array -> ");
        print(b);

        int aIndex = 0;
        int bIndex = 0;
        int superIndex = 0;
        int[] ans = new int[a.length + b.length];

        while(aIndex < a.length && bIndex < b.length){
            if(a[aIndex] <= b[bIndex]){
                ans[superIndex] = a[aIndex];
                aIndex++;
                superIndex++;
            }
            else{
                ans[superIndex] = b[bIndex];
                bIndex++;
                superIndex++;
            }
        }

        while(aIndex < a.length){
            ans[superIndex] = a[aIndex];
            superIndex++;
            aIndex++;
        }

        while(bIndex < b.length){
            ans[superIndex] = b[bIndex];
            bIndex++;
            superIndex++;
        }
        return ans;
    }

    public static int[] mergeSort(int[] arr, int lowIndex, int highIndex){

        if(lowIndex == highIndex){
            int[] baseAns = new int[1];
            baseAns[0] = arr[lowIndex];
            return baseAns;
        }
        int[] leftArray = mergeSort(arr, lowIndex, (lowIndex + highIndex) / 2);
        int[] rightArray = mergeSort(arr, ((lowIndex + highIndex) / 2) + 1, highIndex);
        int[] mergedArray = mergeTwoSortedArrays(leftArray, rightArray);
        return mergedArray;
    }
}