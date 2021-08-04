public class countHi2{
    public static void main(String[] args){
        String str = "ahixhi";
        System.out.println("" + str + " --> " + countHi2("ahixhi")); // 1
        str = "ahibhi";
        System.out.println("" + str + " --> " + countHi2("ahibhi")); // 2
        str = "";
        System.out.println("" + str + " --> " + countHi2("")); //0
        str = "hihihix";
        System.out.println("" + str + " --> " + countHi2("hihihix")); //3
    }

    public static int countHi2(String str){

        if(str.length()==0) return 0;

        char ch = str.charAt(0);
        int count = 0;

        if(ch != 'x' && str.length() >= 2 && (ch == 'h' || str.charAt(1) == 'h') && (str.charAt(1) == 'i' || str.charAt(2) == 'i')){
            count += 1;
            return count + countHi2(str.substring(2));
        }

        if(ch == 'x'&& str.length() >= 3 && str.charAt(1) == 'h' && str.charAt(2) == 'i') return countHi2(str.substring(3));

        return countHi2(str.substring(1));
    }
}