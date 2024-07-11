//import Student;

import java.util.function.*;

public class Test {
    public static void main(String[] args){
        Function<Student, String> f = s-> {
            int marks = s.marks;
            String grade = " ";
            if (marks>=80) grade = "A grade";
            else if (marks>=60) grade = "B grade";
            else grade = "Fail";
            return grade;
        };
        Predicate<Student> p = s-> s.marks >=60;

        Consumer<Student> c = s1-> {
            System.out.println("StudentName = "+ s1.name);
            System.out.println("StudentMarks = "+ s1.marks);
            System.out.println("StudentGrade = "+ f.apply(s1));
            System.out.println();
        };


        Student[] s = {new Student("Durga", 95),
                        new Student("Ravi", 65),
                        new Student("Sam", 55)
                        };

        for(Student s1 : s){
            if(p.test(s1)){
                c.accept(s1);
            }
        }

        // adding code to demonstrate supplier functional interface
        System.out.println("Supplier Functional Interface Demooooo");
        System.out.println("Supplier Functional Interface Demooooo");
        System.out.println("Supplier Functional Interface Demooooo");
        System.out.println("Supplier Functional Interface Demooooo");
        System.out.println("Supplier Functional Interface Demooooo");


    }
}
