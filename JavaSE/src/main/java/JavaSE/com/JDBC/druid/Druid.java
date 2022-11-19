package JavaSE.com.JDBC.druid;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库连接池
 */
public class Druid {
    public static void main(String[] args) throws Exception {
        Connection conn = getConnection();

        select(conn);
        //insert(conn);

        conn.close();

    }

    private static void insert(Connection conn) throws SQLException {
        String sql="INSERT into employee(eid,ename,sid,salary,joinDate,bonus)\n" +
                "VALUES(null,?,?,?,?,?)";

        PreparedStatement prep = conn.prepareStatement(sql);
        prep.setString(1,"李四");
        prep.setInt(2,2);
        prep.setInt(3,15313);
        prep.setString(4,"2004-5-9");
        prep.setDouble(5,1564.2);
        int i = prep.executeUpdate();
        System.out.println(i);

        prep.close();
    }

    private static void select(Connection conn) throws SQLException {
        String sql="SELECT ename,sid FROM employee WHERE ename=? and sid=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,"张三");
        ps.setInt(2,3);

        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString(1)+" "+resultSet.getInt(2));
        }
        resultSet.close();
        ps.close();
    }

    public static Connection getConnection() throws Exception {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid/druid.properties");

        Properties prop=new Properties();

        prop.load(is);
        is.close();
        //数据库连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        return dataSource.getConnection();
    }
}
