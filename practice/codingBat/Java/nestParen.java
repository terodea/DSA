public class nestParen{

    public static void main(String[] args){
        System.out.println(nestParen("(())")); // true
        System.out.println(nestParen("((()))")); //true
        System.out.println(nestParen("((())")); //false
        System.out.println(nestParen("(((x))")); //false
    }

    public static boolean nestParen(String str){

        if(str.length() == 0) return true;
        // if(str.charAt(0) != '(' || str.charAt(str.length()-1) != ')') return false; Single condition replace all three
        if(str.charAt(0) == '(' && str.charAt(str.length()-1) != ')') return false;
        if(str.charAt(0) == ')' && str.charAt(str.length()-1) != '(') return false;
        if(str.charAt(0) != '(' && str.charAt(str.length()-1) != ')') return false;

        return true && nestParen(str.substring(1, str.length()-1));
    }
}