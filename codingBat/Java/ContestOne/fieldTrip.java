import java.io.*;
import java.util.*;
/*
Question:
School students of different class(classes 1-9) are going on a field trip. 
Event coordinator Miss. Pepper wants to make (multiple groups) groups of students among each other ,
such that all students within a particular group must belong to the same class and 
all groups should have same number of students.
Miss. Pepper doesn't want any to be left alone in the group.
Will Miss. Pepper be able to make groups with such given constraints ?(true/false)

InputFormat
integer n , representing number of students
c1 c2 c3 .ci.. cn ,representing class number of the ith student

Constraints
n > 0 
1 <= ci <= 9

OutputFormat
print "true" is Miss. Pepper is able to make groups otherwise "false"

SampleInput
8
1 2 3 4 4 3 2 1

SampleOutput
true 

Explanation
valid groups [1,1],[2,2],[3,3],[4,4].

*/
public class fieldTrip{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }

        Arrays.sort(arr);
        if(arr.length == 2){
            System.out.println(arr[0] == arr[1]);
            return;
        }

        int count = 1;
        int first = arr[0];

        for(int i=1; i < arr.length; i++){
            int second = arr[i];
            if(first == second){
                count++;
                first = second;
            }
            else{
                break;
            }
        }
        int j = 0
        while(j < arr.length){
            if((arr.length - 1) - j  )
            for(int i=0; i<count; i++){

            }
        }



    }
}
