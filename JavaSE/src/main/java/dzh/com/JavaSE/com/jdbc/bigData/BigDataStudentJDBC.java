package dzh.com.JavaSE.com.jdbc.bigData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//  静态工具类，用于创建数据库连接对象和释放资源，方便调用
public class BigDataStudentJDBC {
    //    导入驱动jar包或添加Maven依赖
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //  获取数据库连接对象
    public static Connection getConn() throws SQLException {
        Connection conn = null;
        try {
            //  rewriteBatchedStatements=true 一次插入多条数据，只插入一次
            conn = DriverManager.getConnection("jdbc:mysql://192.168.136.10:3306/javase?rewriteBatchedStatements=true&useSSL=false", "root", "159735");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    //  释放资源
    public static void closeAll(AutoCloseable... autoCloseables) {
        for (AutoCloseable autoCloseable : autoCloseables) {
            if (autoCloseable != null) {
                try {
                    autoCloseable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}