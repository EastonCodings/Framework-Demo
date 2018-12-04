package batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.Test;

import utils.JdbcUtils;

/**
 * @ClassName: JdbcBatchHandleByStatement
 * @Description: 使用prepareStatement实现JDBC批处理操作
 *
 */
public class JdbcBatchHandleByPrepareStatement {

    @Test
    public void testJdbcBatchHandleByPrepareStatement() {
        long starttime = System.currentTimeMillis();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into server(warehouse_name, slack_group, recipient_slackId, email_address, state, created_at, created_by, modified_at, modified_by, delete_flag) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            st = conn.prepareStatement(sql);
            for (int i = 0; i < 10; i++) {
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
                st.addBatch();
                if (i % 10 == 0) {
                    st.executeBatch();
                    st.clearBatch();
                }
            }
            st.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        long endtime = System.currentTimeMillis();
        System.out.println("程序花费时间：" + (endtime - starttime) / 1000 + "秒！！");
    }
}
