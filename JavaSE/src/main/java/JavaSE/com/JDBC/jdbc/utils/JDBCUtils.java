package JavaSE.com.JDBC.jdbc.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public final class JDBCUtils {
    private static Connection con=null;
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    private JDBCUtils() {
    }

    static {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        InputStream is = systemClassLoader.getResourceAsStream("druid/properties.properties");
        Properties prop=new Properties();

        try {
            prop.load(is);
            is.close();

             driver= prop.getProperty("driver");
             url = prop.getProperty("url");
             user = prop.getProperty("use");
             password= prop.getProperty("password");

            Class.forName(driver);
             con = DriverManager.getConnection(url, user, password);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        if (con!=null){
            return con;
        }else {
            //制造一个运行时异常，编译时不用处理
            throw new RuntimeException("连接对象为null");
        }


    }
}
