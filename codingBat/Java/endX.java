public class endX {
    public static void main(String[] args){

        String str = "xxre";
        System.out.println(computeEndX(str));
    }

    public static String computeEndX(String str) {
        if(str.length() == 0){
          return "";
        }
        char charCheck = 'x';
        int initCount = 0;
        for(int i=0; i< str.length(); i++){
        
          char ch = str.charAt(i);
          if (ch == charCheck){
            initCount = i;
            break;
          }
          else{
            initCount = i;
          }
        }
        if (initCount > str.length()){
          initCount -= 1;
        }
        int swapCount = initCount;
        
        for(int j = initCount; j < str.length(); j++){
          char ch = str.charAt(j);
          if (!(ch == charCheck)){
            swapCount = j;
            break;
          }
          else{
            swapCount = j;
          }
        }
        
        if (swapCount > str.length()){
          swapCount -= 1;
        }
        char replaceChar = str.charAt(swapCount); // "xxe"
        str = str.replaceFirst(""+replaceChar, ""+charCheck); //"xxx"
        str = str.replaceFirst(""+charCheck, ""+replaceChar); //"exx"
        
        return "" + str.charAt(0) + computeEndX(str.substring(1));
        
      }
      
}
