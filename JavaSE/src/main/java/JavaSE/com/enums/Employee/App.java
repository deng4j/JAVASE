package JavaSE.com.enums.Employee;

public class App {

    public static void main(String[] args) throws Exception {
        String code = EmployeeDimissionStatus.getByMsg("同意申请").getCode();
        System.out.println(code);
    }
}
