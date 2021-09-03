public class allIndicesOfAnArray{

    public static void main(String[] args){
        int[] arr = {15, 11, 40, 4, 4, 7};
        int x = 4;

        int[] iarr = getAllIndices(arr, 0, x, 0);

        for(int i=0; i<iarr.length; i++){
            System.out.print(iarr[i] + " ");
        }
    }

    public static int[] getAllIndices(int[] arr, int idx, int target, int targetCount){

        if(idx == arr.length - 1){
            return new int[targetCount];
        }
        targetCount = (arr[idx] == target) ? targetCount+1: targetCount;
        int[] indexArray = getAllIndices(arr, idx+1, target, targetCount);
        if(arr[idx] == target){
            indexArray[targetCount - 1] = idx;
        }
        return indexArray;
    }
}