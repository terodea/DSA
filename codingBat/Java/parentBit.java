public class parentBit{

    public static void main(String[] args){
        System.out.println(parentBit("xyz(abc)123")); //"(abc)"
        System.out.println(parentBit("")); //""
    }

    public static String parentBit(String str){

        // baseCase1
        if(str.length() == 0) return "";
        
        //baseCase2: "(abc)"
        if(str.charAt(0) == '(' && str.charAt(str.length()-1) == ')') return str; 
        
        //"(abc)def"
        if(str.charAt(0) == '(') return parentBit(str.substring(0, str.length() - 1));
        
        //"123(abc)"
        if(str.charAt(str.length()-1) == ')') return parentBit(str.substring(1));

        return parentBit(str.substring(1, str.length() - 1));
    }
}