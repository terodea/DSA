public class strCopies{

    public static void main(String[] args){
        System.out.println(strCopies("catcowcat", "cat", 2)); // true
        System.out.println(strCopies("catcowcat", "cow", 2)); // false
        System.out.println(strCopies("catcowcat", "cow", 1)); // true
        System.out.println(strCopies("iiiiij", "iii", 4)); // false
        System.out.println(strCopies("iiiiij", "iii", 3)); // true
    }

    public static boolean strCopies(String str, String sub, int n) {
        if( str.length() == 0 && n == 0 ){
            return true;
        }
  
        if(str.length() == 0 && n !=0){
            return false;
        }
        
        boolean isSubPresent = false;
        
        if(str.length() >= sub.length()){
            String checkString = str.substring(0, sub.length());
            
            if(checkString.equals(sub)){
            n -= 1;
            isSubPresent = true;
            }
        }
        return strCopies(str.substring(1), sub, n); // Overlapping allowed hence, sliding by 1
    }
}