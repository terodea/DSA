public class lastIndex{

    public static void main(String[] args){

        int[] arr = {15, 11, 40, 4, 4, 7};
        int x = 4;
        System.out.println(getLastIndex(arr, arr.length-1, x));
    }

    public static int getLastIndex(int[] arr, int idx, int target){

        if(idx < 0){
            return -1;
        }

        return (arr[idx] == target) ? idx : getLastIndex(arr, idx-1, target);
    }
}