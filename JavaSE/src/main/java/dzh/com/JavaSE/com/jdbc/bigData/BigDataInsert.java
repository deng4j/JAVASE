package dzh.com.JavaSE.com.jdbc.bigData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 插入一百万数据测试
 */
public class BigDataInsert {
    public static void main(String[] args) throws SQLException {
        System.out.println("开始保存");
        long startTime = System.currentTimeMillis();

        Connection conn = BigDataStudentJDBC.getConn();
        String sql = "INSERT INTO student (`name`, `number`) VALUES (?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);    //  获取PreparedStatement对象

            for (int i = 0; i < 1000000; i++) {
                ps.setString(1, "张三");
                ps.setString(2, String.valueOf(i));
                ps.addBatch();  //  将一组参数添加到此 PreparedStatement 对象的批处理命令中。
            }

            int[] ints = ps.executeBatch(); // 将一批命令提交给数据库来执行，如果全部命令执行成功，则返回更新计数组成的数组。
            // 如果数组长度不为0，则说明sql语句成功执行，即百万条数据添加成功！
            if (ints.length > 0) {
                System.out.println("已成功添加数据：1000000");
            }
            long endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BigDataStudentJDBC.closeAll(conn, ps);  //  调用刚刚写好的静态工具类释放资源
        }
    }
}
