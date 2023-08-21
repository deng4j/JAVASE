package dzh.com.JavaSE.com.jdbc.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    private  static   Connection conn=null;
    static {
        //禁用SSL警告提示,开启PrepareStatement预编译
        String url="jdbc:mysql://localhost:3306/employee?useSSL=false";
        String user="root";
        String password="159735";
        try {
            //注册驱动,jdk1.5后可以省略注册,有一个Driver配置文件
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return conn;
    }
}
