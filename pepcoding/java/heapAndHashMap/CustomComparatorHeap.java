import java.io.*;
import java.util.*;
 
public class CustomComparatorHeap {
    
    public static class Student implements Comparable<Student>{
        String name;
        int ht;
        int wt;
        int marks;
        
        public Student(String name, int ht, int wt, int marks){
            this.name = name;
            this.ht = ht;
            this.wt = wt;
            this.marks = marks;
        }
        
        public int compareTo(Student o){
            return this.ht - o.ht;
        }
        
        public String toString(){
            return "[" + this.name + "] " + "ht -> " + this.ht + " wt -> " + this.wt + " marks -> " + this.marks + " .";
        }
    }
 
  public static class MyPriorityQueue<T> {
    ArrayList<T> data;
    Comparator comp;
 
    public MyPriorityQueue() {
      data = new ArrayList<>();
      comp = null;
    }
    
    public MyPriorityQueue(Comparator comp){
        data = new ArrayList<>();
        this.comp = comp;   
    }
 
    public void add(T val) {
      data.add(val);
      upheapify(data.size() - 1);
    }
    
    public boolean isSmaller(int i, int j){
        if(comp == null){
            Comparable ith = (Comparable)data.get(i);
            Comparable jth = (Comparable)data.get(j);
            
            if(ith.compareTo(jth) < 0){
                return true;
            }else{
                return false;
            }
        }else{
            T ith = data.get(i);
            T jth = data.get(j);
            if(comp.compare(ith, jth) < 0){
                return true;
            }else{
                return false;
            }
        }
        
    }
    
    public void upheapify(int ci){
        if(ci == 0){
            return;
        }
        int pi = (ci - 1) / 2;
        if(isSmaller(ci, pi) == true){
            swap(ci, pi);
            upheapify(pi);
        }
    }
    
    public void swap(int i, int j){
        T ith = data.get(i);
        T jth = data.get(j);
        data.set(i, jth);
        data.set(j, ith);
    }
 
    public T remove() {
      if(data.size() == 0){
          System.out.println("Underflow");
          return null;
      }
      
      swap(0, data.size() - 1);
      T ans = data.remove(data.size() - 1);
      downheapify(0);
      return ans;
    }
    
    public void downheapify(int pi){
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;
        int minidx = pi;
        if(lci < data.size() && isSmaller(lci, minidx)){
            minidx = lci;
        }
        
        if(rci < data.size() && isSmaller(rci, minidx)){
            minidx = rci;
        }
        
        if(minidx != pi){
            swap(pi, minidx);
            downheapify(minidx);
        }
    }
 
    public T peek() {
      if(data.size() == 0){
          System.out.println("Underflow");
          return null;
      }else{
          return data.get(0);
      }
    }
 
    public int size() {
      return data.size();
    }
  }
  
  public static class StudentMarksComparator implements Comparator<Student>{
      public int compare(Student s1, Student s2){
          return s2.marks - s1.marks;
      }
  }
  
   public static class StudentWtComparator implements Comparator<Student>{
      public int compare(Student s1, Student s2){
          return s1.wt - s2.wt;
      }
  }
 
  public static void main(String[] args) throws Exception {
   MyPriorityQueue<Student> mpq = new MyPriorityQueue<>();
   mpq.add(new Student("A", 179, 80, 82));
   mpq.add(new Student("B", 161, 72, 91));
   mpq.add(new Student("C", 182, 90, 75));
   mpq.add(new Student("D", 175, 83, 78));
   
   
   while(mpq.size() != 0){
       System.out.println(mpq.remove());
   }
   System.out.println("----------------------");
   
  MyPriorityQueue<Student> mpq1 = new MyPriorityQueue<>(new StudentMarksComparator());
   mpq1.add(new Student("A", 179, 80, 82));
   mpq1.add(new Student("B", 161, 72, 91));
   mpq1.add(new Student("C", 182, 90, 75));
   mpq1.add(new Student("D", 175, 83, 78));
   mpq1.add(new Student("E", 167, 78, 90));
   
   while(mpq1.size() != 0){
       System.out.println(mpq1.remove());
   }
   
   System.out.println("----------------------");
   
  mpq1 = new MyPriorityQueue<>(new StudentMarksComparator());
   mpq1.add(new Student("A", 179, 80, 82));
   mpq1.add(new Student("B", 161, 72, 91));
   mpq1.add(new Student("C", 182, 90, 75));
   mpq1.add(new Student("D", 175, 83, 78));
   mpq1.add(new Student("E", 167, 78, 90));
   
   while(mpq1.size() != 0){
       System.out.println(mpq1.remove());
   }
  }
}
