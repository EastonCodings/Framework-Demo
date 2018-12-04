package batch;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.Test;

import utils.JdbcUtils;

/**
 * @ClassName: JdbcBatchHandleByStatement
 * @Description: 使用Statement实现JDBC批处理操作
 *
 */
public class JdbcBatchHandleByStatement {

//    @Test
    public void testJdbcBatchHandleByStatement() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql1 = "insert into server(warehouse_name, slack_group, recipient_slackId, email_address, state, created_at, created_by, modified_at, modified_by, delete_flag) values('111', 'rs-eng_bot-hl', 'UAMF5LQCE', 'nantian_test@groundinc.co.jp/nantian01', '0', '2018-09-18 17:16:49', '1', '2018-09-18 17:16:49', '1', '0')";
            String sql2 = "insert into server(warehouse_name, slack_group, recipient_slackId, email_address, state, created_at, created_by, modified_at, modified_by, delete_flag) values('222', 'rs-eng_bot-hl', 'UAMF5LQCE', 'nantian_test@groundinc.co.jp/nantian01', '0', '2018-09-18 17:16:49', '1', '2018-09-18 17:16:49', '1', '0')";
            String sql3 = "insert into server(warehouse_name, slack_group, recipient_slackId, email_address, state, created_at, created_by, modified_at, modified_by, delete_flag) values('333', 'rs-eng_bot-hl', 'UAMF5LQCE', 'nantian_test@groundinc.co.jp/nantian01', '0', '2018-09-18 17:16:49', '1', '2018-09-18 17:16:49', '1', '0')";
            String sql4 = "insert into server(warehouse_name, slack_group, recipient_slackId, email_address, state, created_at, created_by, modified_at, modified_by, delete_flag) values('444', 'rs-eng_bot-hl', 'UAMF5LQCE', 'nantian_test@groundinc.co.jp/nantian01', '0', '2018-09-18 17:16:49', '1', '2018-09-18 17:16:49', '1', '0')";
            String sql5 = "update server set warehouse_name = '222' where id = 24";
            String sql6 = "insert into server(warehouse_name, slack_group, recipient_slackId, email_address, state, created_at, created_by, modified_at, modified_by, delete_flag) values('555', 'rs-eng_bot-hl', 'UAMF5LQCE', 'nantian_test@groundinc.co.jp/nantian01', '0', '2018-09-18 17:16:49', '1', '2018-09-18 17:16:49', '1', '0')";
            String sql7 = "delete from server where id = 25";
            st = conn.createStatement();
            // 添加要批量执行的SQL
            st.addBatch(sql1);
            st.addBatch(sql2);
            st.addBatch(sql3);
            st.addBatch(sql4);
            st.addBatch(sql5);
            st.addBatch(sql6);
            st.addBatch(sql7);
            // 执行批处理SQL语句
            st.executeBatch();
            // 清除批处理命令
            st.clearBatch();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}
