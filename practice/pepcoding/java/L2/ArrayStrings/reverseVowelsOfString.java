public class reverseVowelsOfString{
    private static boolean isVowel(char ch){
        String vowels = "aeiouAEIOU";
        return vowels.contains(ch + "");
    }
    
    public static String reverseVowels(String s){
        
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        
        while(left < right){
            
            while(left < right && isVowel(arr[left]) == false){
                left++;
            }
            
            while(left < right && isVowel(arr[right]) == false){
                right--;
            }
            
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left++;
            right--;
        }
        
        return String.valueOf(arr);
    }

    public static void main(String[] args){
        String str = "hello";
        System.out.println(reverseVowels(str));
    }
}
