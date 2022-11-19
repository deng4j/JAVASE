package JavaSE.com.JDBC.jdbc;


import java.sql.*;

public class PrepareStatement {
    public static void main(String[] args) {
        //禁用SSL警告提示,开启PrepareStatement预编译,防止sql注入，提高sql效率
        String url="jdbc:mysql://localhost:3306/employee?useSSL=false" +
                "&useServerPrepStmts=true&cachePrepStmts=true&prepStmtCacheSize=25&prepStmtCacheSqlLimit=256";
        String user="root";
        String password="159735";
        //占位符相当于（?）
        String sql="SELECT ename,sid FROM employee WHERE ename=? and sid=?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString( 1,"王五");
            prep.setInt(2,1);
            ResultSet resultSet = prep.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
            }
            conn.close();
            prep.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
