public class Employee {
    private  String JobType;
    private int PIN;
    private int salary;
    protected String email_ID;
    protected String name;


    public Employee(){

    }
    public Employee(String name, String email_ID, int PIN, int salary, String JobType) {
        this.PIN = PIN;
        this.salary = salary;
        this.JobType = JobType;
        this.name = name;
        this.email_ID = email_ID;
    }

//    GETTER
    public String getJobType() {
        return JobType;
    }

    public int getPIN() {
        return PIN;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getEmail_ID() {
        return email_ID;
    }

    //    SETTER
    public boolean setJobType(String JobType) {
        if(JobType.length()==0){
            return false;
        }
        this.JobType = JobType;
        return true;
    }

    public boolean setName(String name) {
        if(name.length()==0){
            return false;
        }
        this.name = name;
        return true;
    }
    public boolean setEmail_ID(String email_ID) {
        if(email_ID.length() ==0){
            return false;
        }
        this.email_ID = email_ID;
        return true;
    }
    public boolean setPIN(int PIN) {
        if(PIN == 0){
            return false;
        }
        this.PIN = PIN;
        return true;
    }
    public boolean setSalary(int salary) {
        if(salary == 0){
            return false;
        }
        this.salary = salary;
        return true;
    }
    public boolean checkPIN(int PIN){
        if (PIN == 3569){
            return true;
        }
        else {
            return false;
        }
    }

    public Employee getEmployeeProfile(EmployeeDB profile){
        return profile.getEmployees().get(0);
    }
}
