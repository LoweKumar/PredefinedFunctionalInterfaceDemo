import java.util.ArrayList;
import java.util.function.Predicate;

public class EmployeeTest 
{
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Alice", 50000, "IT"));
        employees.add(new Employee("Bob", 60000, "HR"));
        employees.add(new Employee("ABC", 200000, "Finance"));
        employees.add(new Employee("John", 150000, "IT"));
        employees.add(new Employee("Jane", 120000, "Marketing"));
        employees.add(new Employee("Doe", 80000, "Sales"));     


        // without using lambda expression
        Predicate<Employee> salaryPredicate = new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee){
                return employee.salary > 150000 ;
            }
        };

        //using lambda expression
        Predicate<Employee> salaryPredicateLambda = (employee)->{
            return employee.salary < 100000;
        };

        Predicate<Employee> departmentFinancePredicate = (employee)->{
            return employee.department.equals("Finance");
        };

        for(Employee e1:employees){
            if(salaryPredicate.test(e1)){
                System.out.println("Employee with salary greater than 100000: " + e1.name + ", Salary: " + e1.salary);
            }
            if(salaryPredicateLambda.test(e1)){
                System.out.println("Employee with salary less than 100000: " + e1.name + ", Salary: " + e1.salary);
            }
        }

        
        for(Employee e1:employees){
            if(salaryPredicate.or(salaryPredicateLambda).test(e1)){
                System.out.println("Employee with salary greater than 150000 or less than 100000: " + e1.name + ", Salary: " + e1.salary);
            }
        }

        for (Employee financeDeptEmployee :employees) {
            if (salaryPredicate.and(departmentFinancePredicate).test(financeDeptEmployee)){
                System.out.println("Employee with salary greater than 150000 in Finance department: " + financeDeptEmployee.name + ", Salary: " + financeDeptEmployee.salary);
            }

        }


        

       
    }

    
}
