public class EmployeeTest {

    Employee e = new Employee();

    public EmployeeTest() {
//        Validation Tests
        CheckPINTest();
        CheckIncorrectPINTest();
        getEmployeeProfileTest();

//        Setter Tests

            setEmployeeNameTest();
            setIncorrectEmployeeNameTest();
            setEmployeeEmail_IDTest();
            setEmployeeIncorrectEmail_IDTest();
            setEmployeePINTest();
            setEmployeeIncorrectPINTest();
            setEmployeeJobTypeTest();
            setEmployeeIncorrectJobTypeTest();
            setEmployeeSalaryTest();
            setEmployeeIncorrectSalaryTest();

//        Getter Tests
        getEmployeeNameTest();
        getEmployeeEmailIDTest();
        getEmployeeSalaryTest();
        getEmployeePINTest();
        getEmployeeJobTypeTest();
    }

    public void getEmployeeNameTest(){
        Employee e =new Employee("Jainil","jainilsev25@gmail.com",3569,10000,"Part-time");
        if (e.getName().equals("Jainil")){
            System.out.println("getEmployeeNameTest -- TEST PASS");
        }else{
            System.out.println("getEmployeeNameTest -- TEST FAIL");
        }
    }

    public void getEmployeeEmailIDTest(){
        Employee e =new Employee("Jainil","jainilsev25@gmail.com",3569,10000,"Part-time");
        if (e.getEmail_ID().equals("jainilsev25@gmail.com")){
            System.out.println("getEmployeeEmailIDTest -- TEST PASS");
        }else{
            System.out.println("getEmployeeEmailIDTest -- TEST FAIL");
        }
    }

    public void getEmployeeSalaryTest(){
        Employee e =new Employee("Jainil","jainilsev25@gmail.com",3569,10000,"Part-time");
        if (e.getSalary()==10000){
            System.out.println("getEmployeeSalaryTest -- TEST PASS");
        }else{
            System.out.println("getEmployeeSalaryTest -- TEST FAIL");
        }
    }

    public void getEmployeePINTest(){
        Employee e =new Employee("Jainil","jainilsev25@gmail.com",3569,10000,"Part-time");
        if (e.getPIN()==3569){
            System.out.println("getEmployeePINTest -- TEST PASS");
        }else{
            System.out.println("getEmployeePINTest -- TEST FAIL");
        }
    }

    public void getEmployeeJobTypeTest(){
        Employee e =new Employee("Jainil","jainilsev25@gmail.com",3569,10000,"Part-time");
        if (e.getJobType().equals("Part-time")){
            System.out.println("getEmployeeJobTypeTest -- TEST PASS");
        }else{
            System.out.println("getEmployeeJobTypeTest -- TEST FAIL");
        }
    }
    public void setEmployeeNameTest() {
        Employee e = new Employee("Jainil", "jn498899@dal.ca", 3569, 20000, "Part-Time");
        e.setName("Jill");
        if (e.getName().equals("Jill")) {
            System.out.println("setEmployeeNameTest - TEST PASS");
        } else {
            System.out.println("setEmployeeNameTest - TEST FAIL");
        }
    }

    public void setIncorrectEmployeeNameTest() {
        Employee e = new Employee("Jainil", "jn498899@dal.ca", 3569, 20000, "Part-Time");
        e.setName("");
        if (e.getName().equals("Jainil")) {
            System.out.println("setIncorrectEmployeeNameTest - TEST PASS");
        } else {
            System.out.println("setIncorrectEmployeeNameTest - TEST FAIL");
        }
    }

    public void setEmployeeEmail_IDTest() {
        Employee e = new Employee("Jainil", "jn498899@dal.ca", 3569, 20000, "Part-Time");
        e.setEmail_ID("jainilsev25@gmail.com");
        if (e.getEmail_ID().equals("jainilsev25@gmail.com")) {
            System.out.println("setEmployeeEmail_IDTest - TEST PASS");
        } else {
            System.out.println("setEmployeeEmail_IDTest - TEST FAIL");
        }
    }

    public void setEmployeeIncorrectEmail_IDTest() {
        Employee e = new Employee("Jainil", "jn498899@dal.ca", 3569, 20000, "Part-Time");
        e.setEmail_ID("");
        if (e.getEmail_ID().equals("jn498899@dal.ca")) {
            System.out.println("setIncorrectEmail_IDTest - TEST PASS");
        } else {
            System.out.println("setIncorrectEmail_IDTest - TEST FAIL");
        }
    }

    public void setEmployeePINTest() {
        Employee e = new Employee("Jainil", "jn498899@dal.ca", 3569, 20000, "Part-Time");
        e.setPIN(6325);
        if (e.getPIN() == 6325) {
            System.out.println("setEmployeePINTest - TEST PASS");
        } else {
            System.out.println("setEmployeePINTest - TEST FAIL");
        }
    }

    public void setEmployeeIncorrectPINTest() {
        Employee e = new Employee("Jainil", "jn498899@dal.ca", 3569, 20000, "Part-Time");
        e.setPIN(0);
        if (e.getPIN() == 3569) {
            System.out.println("setEmployeeIncorrectPINTest - TEST PASS");
        } else {
            System.out.println("setEmployeeIncorrectPINTest - TEST FAIL");
        }
    }
    public void setEmployeeJobTypeTest() {
        Employee e = new Employee("Jainil", "jn498899@dal.ca", 3569, 20000, "Part-Time");
        e.setJobType("Full-Time");
        if (e.getJobType() == "Full-Time") {
            System.out.println("setEmployeeJobTypeTest - TEST PASS");
        } else {
            System.out.println("setEmployeeJobTypeTest - TEST FAIL");
        }
    }
    public void setEmployeeIncorrectJobTypeTest() {
        Employee e = new Employee("Jainil", "jn498899@dal.ca", 3569, 20000, "Part-Time");
        e.setJobType("");
        if (e.getJobType() == "Part-Time") {
            System.out.println("setEmployeeIncorrectJobTypeTest - TEST PASS");
        } else {
            System.out.println("setEmployeeIncorrectJobTypeTest - TEST FAIL");
        }
    }
    public void setEmployeeSalaryTest(){
        Employee e = new Employee("Jainil", "jn498899@dal.ca", 3569, 20000, "Part-Time");
        e.setSalary(10000);
        if (e.getSalary()==10000){
            System.out.println("setEmployeeSalaryTest - TEST PASS");
        } else {
            System.out.println("setEmployeeSalaryTest - TEST FAIL");
        }
    }
    public void setEmployeeIncorrectSalaryTest(){
        Employee e = new Employee("Jainil", "jn498899@dal.ca", 3569, 20000, "Part-Time");
        e.setSalary(0000);
        if (e.getSalary()==20000){
            System.out.println("setEmployeeIncorrectSalaryTest - TEST PASS");
        } else {
            System.out.println("setEmployeeIncorrectSalaryTest - TEST FAIL");
        }
    }
    public void CheckPINTest(){
        Employee e = new Employee("Jainil", "jn498899@dal.ca", 3569, 20000, "Part-Time");
        boolean is_correct = e.checkPIN(3569);
        if(is_correct){
            System.out.println("CheckPINTest - TEST PASS");
        } else {
            System.out.println("CheckPINTest - TEST FAIL");
        }
    }
    public void CheckIncorrectPINTest(){
        Employee e = new Employee("Jainil", "jn498899@dal.ca", 3569, 20000, "Part-Time");
        boolean is_correct = e.checkPIN(6547);
        if(is_correct){
            System.out.println("CheckIncorrectPINTest - TEST FAIL");
        } else {
            System.out.println("CheckIncorrectPINTest - TEST PASS");
        }
    }

    public void getEmployeeProfileTest(){
//        Employee e =new Employee("Jainil","jainilsev25@gmail.com",3569,10000,"Part-time");
        EmployeeDB eDB = new EmployeeDB();
        Employee fEmployee = e.getEmployeeProfile(eDB);
        if (fEmployee.getName().equals("Jainil") && fEmployee.getEmail_ID().equals("jn498899@dal.ca") && fEmployee.getPIN()==3569 && fEmployee.getSalary()==20000 && fEmployee.getJobType().equals("Part-Time")){
            System.out.println("getEmployeeProfileTest -- TEST PASS");
        }else{
            System.out.println("getEmployeeProfileTest -- TEST FAIL");
        }
    }
}