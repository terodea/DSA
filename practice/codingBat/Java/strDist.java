public class strDist{

    public static void main(String[] args){
        String str = "catcowcat";
        String sub = "cat";
        System.out.println(strDist(str, sub)); // 9

        str = "cccatcowcatxx";
        sub = "cat";
        System.out.println(strDist(str, sub)); // 9

        str = "xyx";
        sub = "x";
        System.out.println(strDist(str, sub)); // 3

        str = "";
        sub = "z";
        System.out.println(strDist(str, sub)); // 0


    }
    public static int strDist(String str, String sub) {
        if(str.length() == 0){
            return 0;
        }
        if(str.length() >= sub.length()){
            String first = str.substring(0, sub.length());
            String second = str.substring(str.length() - sub.length(), str.length());
            if(sub.equals(first) && sub.equals(second)){
                return (str.length() - 0); // returns the actual length.
            }
            if(sub.equals(first) && !(sub.equals(second))){
                return strDist(str.substring(0,str.length() - 1), sub); // reduces string from right.
            }
    
            if(!(sub.equals(first)) && (sub.equals(second))){
            return strDist(str.substring(1), sub); // reduces string from left.
            }
        }
        return strDist(str.substring(1), sub);
    }
}