package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import utils.JdbcUtils;

public class JdbcCRUDByStatement {

    // @Test
    public void insert() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            // 获取一个数据库连接
            conn = JdbcUtils.getConnection();
            // 通过conn对象获取负责执行SQL命令的Statement对象
            st = conn.createStatement();
            // 要执行的SQL命令
            String sql = "" + "insert into server"
                    + "(warehouse_name, slack_group, recipient_slackId, email_address, state, created_at, created_by, modified_at, modified_by, delete_flag) "
                    + "values"
                    + "('hl_ibaraki', 'rs-eng_bot-hl', 'UAMF5LQCE', 'nantian_test@groundinc.co.jp/nantian01', '0', '2018-09-18 17:16:49', '1', '2018-09-18 17:16:49', '1', '0')";
            System.out.println(sql);

            // 执行插入操作，executeUpdate方法返回成功的条数
            int num = st.executeUpdate(sql);
            if (num > 0) {
                System.out.println("插入成功！！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // SQL执行完成之后释放相关资源
            JdbcUtils.release(conn, st, rs);
        }
    }

//    @Test
    public void delete() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from server where id = 22";
            st = conn.createStatement();
            int num = st.executeUpdate(sql);
            if (num > 0) {
                System.out.println("删除成功！！");
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }

    // @Test
    public void update() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update server set warehouse_name = 'EEEEE', email_address = 'nantian_EEEEE@groundinc.co.jp/nantian01' where id = 22";
            st = conn.createStatement();
            int num = st.executeUpdate(sql);
            if (num > 0) {
                System.out.println("更新成功！！");
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }

    // @Test
    public void find() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from server where id = 22";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                System.out.println(rs.getString("warehouse_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}
