import java.util.ArrayList;

public class EmployeeDB {
    private ArrayList<Employee> employees = new ArrayList<>();

    public EmployeeDB() {
        employees.add(new Employee("Jainil","jn498899@dal.ca",3569,20000,"Part-Time"));
    }
    public ArrayList<Employee> getEmployees(){
        return employees;
    }
}
