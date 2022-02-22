import java.io.*;

import java.util.*;



public class KPC {







  public static void main(String[] args) throws Exception {

    Scanner scn = new Scanner(System.in);



    String str = scn.nextLine();



    System.out.println(getKPC(str));



  }



  static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};



  public static ArrayList<String> getKPC(String str) {



    if (str.length() == 0) {

      ArrayList<String> baseAns = new ArrayList<>();

      baseAns.add(str);

      return baseAns;

    }



    char initChar = str.charAt(0);

    String ros = str.substring(1);

    ArrayList<String> rr = getKPC(ros);
    ArrayList<String> mr = new ArrayList<>();

    String code = codes[initChar - '0'];



    for (int i = 0; i < code.length(); i++) {

      for (int j = 0; j < rr.size(); j++) {

        char c = code.charAt(i);

        mr.add(c + rr.get(j));

      }



    }



    return mr;

  }



}
