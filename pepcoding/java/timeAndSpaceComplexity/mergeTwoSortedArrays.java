public class mergeTwoSortedArrays{
    public static void main(String[] args){

        int[] a = {-2, 5, 9, 11};
        int[] b = {4, 6, 8};
        int[] mergedArray = mergeTwoSortedArrays(a, b);
        print(mergedArray);
    }

    public static void print(int[] arr){
        for(int i = 0 ; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static int[] mergeTwoSortedArrays(int[] a, int[] b){

        int aIndex = 0;
        int bIndex = 0;
        int superIndex = 0;
        int[] ans = new int[a.length + b.length];
        
        while(aIndex < a.length && bIndex < b.length){
            if(a[aIndex] > b[bIndex]){
                ans[superIndex] = b[bIndex];
                bIndex++;
                superIndex++;
            }
            else{
                ans[superIndex] = a[aIndex];
                aIndex++;
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
            superIndex++;
            bIndex++;
        }
        return ans;
    }

}