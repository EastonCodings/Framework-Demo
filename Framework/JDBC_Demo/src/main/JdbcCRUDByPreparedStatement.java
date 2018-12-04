package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import utils.JdbcUtils;

public class JdbcCRUDByPreparedStatement {

    // @Test
    public void insert() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            // 获取一个数据库连接
            conn = JdbcUtils.getConnection();
            // 要执行的SQL命令，SQL中的参数使用?作为占位符
            String sql = "" + "insert into server"
                    + "(warehouse_name, slack_group, recipient_slackId, email_address, state, created_at, created_by, modified_at, modified_by, delete_flag) "
                    + "values" + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            System.out.println(sql);
            // 通过conn对象获取负责执行SQL命令的prepareStatement对象
            st = conn.prepareStatement(sql);
            // 为SQL语句中的参数赋值，注意，索引是从1开始的
            st.setString(1, "hl_ibaraki");
            st.setString(2, "rs-eng_bot-hl");
            st.setString(3, "UAMF5LQCE");
            st.setString(4, "nantian_test@groundinc.co.jp/nantian01");
            st.setString(5, "0");
            st.setString(6, "2018-09-18 17:16:49");
            st.setString(7, "1");
            st.setString(8, "2018-09-18 17:16:49");
            st.setString(9, "1");
            st.setString(10, "0");
            // 执行插入操作，executeUpdate方法返回成功的条数
            int num = st.executeUpdate();
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

    // @Test
    public void delete() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from server where id = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1, 20);
            int num = st.executeUpdate();
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
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update server set warehouse_name = ?, email_address = ? where id = ?";
            st = conn.prepareStatement(sql);
            st.setString(1, "DDDDD");
            st.setString(2, "nantian_FFFFFF@groundinc.co.jp/nantian01");
            st.setInt(3, 21);
            int num = st.executeUpdate();
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
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from server where id = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1, 21);
            rs = st.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("warehouse_name"));
            }
        } catch (Exception e) {

        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}
