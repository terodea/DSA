import java.util.*;

public class maximumSwap {
    private static void swap(char[] arr, int left, int right){
        
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        
    }
  // ~~~~~~~~~~User Section~~~~~~~~~~~
  public static String maximumSwap(String num) {
    // write your code here
    char[] arr = num.toCharArray();
    int[] lastIndexOfDIgit = new int[10];

    for (int i = 0; i < arr.length; i++) {
      lastIndexOfDIgit[arr[i] - '0'] = i;
    }

    for (int i = 0; i < arr.length; i++) {
      int digit = arr[i] - '0';
      int idx = i;
      for (int j = 9; j > digit; j--) {
        if (lastIndexOfDIgit[j] > i) {
          idx = lastIndexOfDIgit[j];
          break;
        }
      }

      if (idx != i) {
        swap(arr, i, idx);
        break;
      }
    }
    return String.valueOf(arr);
  }

  // ~~~~~~~~Input Management~~~~~~~~~
  public static void main(String[] args) {
    String str = "7236";
    String ans = maximumSwap(str);
    System.out.println(ans);
  }
}