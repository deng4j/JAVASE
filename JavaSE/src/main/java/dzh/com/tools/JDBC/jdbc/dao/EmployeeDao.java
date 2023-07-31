package dzh.com.tools.JDBC.jdbc.dao;

import dzh.com.tools.JDBC.jdbc.utils.JDBC;
import dzh.com.tools.JDBC.jdbc.pojo.Employee;
import dzh.com.tools.JDBC.jdbc.pojo.Section;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * Connection（数据库连接对象）作用：
 * 1.获取执行 SQL 的对象。
 * 2.管理事务：
 *      Statement createStatement()
 *      PreparedStatement  prepareStatement(sql)
 *      CallableStatement prepareCall(sql)。
 */
public class EmployeeDao {
    public static void main(String[] args) throws SQLException {
        Connection conn = JDBC.getConnection();
        Statement st = conn.createStatement();

        select(st);

        st.close();
        conn.close();
    }

    private static void update(Statement st) throws SQLException {
        // DMl语句,DDl操作数据库返回0
        String update="UPDATE employee set salary=salary+500 WHERE ename='张三'";
        int i = st.executeUpdate(update);
        //oracle更新操作要commit不然事务堵塞执行不成功
        //conn.commit();
        System.out.println(i);
    }

    private static void transaction(Connection conn, Statement st) throws SQLException {
        String sql1="UPDATE employee set salary=salary-500 WHERE ename='王五'";
        String sql2="UPDATE employee set salary=salary+500 WHERE ename='张三'";

        try {
            //开始事务，设置自动提交为false
            conn.setAutoCommit(false);

            int i = st.executeUpdate(sql1);

            int a=1/0;

            int i1 = st.executeUpdate(sql2);

            conn.commit();
            System.out.println(i+i1);
        } catch (Exception e) {
            //捕捉到异常，事务回滚
            System.out.println("回滚");
            conn.rollback();
        }
    }

    private static void select( Statement st) throws SQLException {
        //不能交替使用statement对象
        //DQL语句方法
        //这种statement有被sql注入。" 'or'1'='1' "
        String sql="SELECT ename ,sname \n" +
                "FROM employee e join section s\n" +
                "on e.sid=s.sid";

        ResultSet result = st.executeQuery(sql);

        Map<Employee, Section> map=new HashMap<>();

       /* while (result.next()){
            Employee e=new Employee();
            Section s=new Section();
            e.setEname(  result.getString(1));
            s.setSname(result.getString(2));
            map.put(e,s);
        }*/

        while (result.next()){
            Employee e=new Employee();
            Section s=new Section();
            e.setEname(  result.getString("ename"));
            s.setSname(result.getString("sname"));
            map.put(e,s);
        }

        Set<Map.Entry<Employee, Section>> entries = map.entrySet();
        Iterator<Map.Entry<Employee, Section>> itr = entries.iterator();
        while (itr.hasNext()){
            Map.Entry<Employee, Section> next = itr.next();
            System.out.println(next.getKey().getEname()+" "+next.getValue().getSname());
        }
        result.close();
    }


}
