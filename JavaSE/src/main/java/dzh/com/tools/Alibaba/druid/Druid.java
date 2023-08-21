package dzh.com.tools.Alibaba.druid;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Druid连接池是阿里巴巴开源的数据库连接池项目
 * <p>
 * 之前我们代码中使用连接是没有使用都创建一个Connection对象，使用完毕就会将其销毁。这样重复创建销毁的过程是特别耗费计算机的性能的及消耗时间的。
 * <p>
 * 而数据库使用了数据库连接池后，就能达到Connection对象的复用。
 * 连接池是在一开始就创建好了一些连接（Connection）对象存储起来。用户需要连接数据库时，不需要自己创建连接，而只需要从连接池中获取一个连接进行使用，
 * 使用完毕后再将连接对象归还给连接池；这样就可以起到资源重用，也节省了频繁创建连接销毁连接所花费的时间，从而提升了系统响应的速度。
 * <p>
 * 官方(SUN) 提供的数据库连接池标准接口：DataSource
 */
public class Druid {
    public static void main(String[] args) throws Exception {
        Connection conn = getConnection();

        select(conn);
        //insert(conn);

        conn.close();

    }

    private static void insert(Connection conn) throws SQLException {
        String sql = "INSERT into employee(eid,ename,sid,salary,joinDate,bonus)\n" +
                "VALUES(null,?,?,?,?,?)";

        PreparedStatement prep = conn.prepareStatement(sql);
        prep.setString(1, "李四");
        prep.setInt(2, 2);
        prep.setInt(3, 15313);
        prep.setString(4, "2004-5-9");
        prep.setDouble(5, 1564.2);
        int i = prep.executeUpdate();
        System.out.println(i);

        prep.close();
    }

    private static void select(Connection conn) throws SQLException {
        String sql = "SELECT ename,sid FROM employee WHERE ename=? and sid=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "张三");
        ps.setInt(2, 3);

        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " + resultSet.getInt(2));
        }
        resultSet.close();
        ps.close();
    }

    public static Connection getConnection() throws Exception {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid/druid.properties");

        Properties prop = new Properties();

        prop.load(is);
        is.close();
        //数据库连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        return dataSource.getConnection();
    }
}
