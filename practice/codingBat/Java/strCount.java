public class strCount{

    public static void main(String[] args){
        System.out.println(strCount("catcowcat", "cat")); // 2
        System.out.println(strCount("catcowcat", "cow")); // 1
        System.out.println(strCount("catcowcat", "dog")); // 0
        System.out.println(strCount("iiiijj", "ii")); // 2

    }

    public static int strCount(String str, String sub) {
        if(str.length() == 0){
            return 0;
        }
        boolean isSubPresent = false;
        int count = 0;
        if(str.length() >= sub.length()){ // "catcowcat", "cat"
            String checkString = str.substring(0, sub.length());
            
            if(checkString.equals(sub)){
            isSubPresent = true;
            count += 1;
            }
        }
        
        if(isSubPresent && str.length() >= sub.length()){
            return count + strCount(str.substring(sub.length()), sub);
        }
        else{
            return strCount(str.substring(1), sub);
        }
    }

}