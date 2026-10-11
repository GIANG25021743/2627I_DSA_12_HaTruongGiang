import java.util.Comparator;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        
        
        List<Student> studentList = new ArrayList<Student>();
        
        
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();
            
            
            Student st = new Student(id, fname, cgpa);
            studentList.add(st);
            
            testCases--;
        }
        
        
        Collections.sort(studentList, new StudentComparator());
      
        
        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student x, Student y) {
        
        if (x.getCgpa() != y.getCgpa()) {
            return Double.compare(y.getCgpa(), x.getCgpa());
        }
        
        if (!x.getFname().equals(y.getFname())) {
            return x.getFname().compareTo(y.getFname());
        }
        
        return Integer.compare(x.getId(), y.getId());
    }
}

class Student {
    private int id;
    private String fname;
    private double cgpa;

    // Constructor (Hàm khởi tạo)
    public Student(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}