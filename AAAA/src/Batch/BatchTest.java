package Batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.junit.Test;

import App.smis.util.JdbcUtil;

public class BatchTest {
	@Test
	public void testSingleBySt() throws Exception{
		String sql = "insert into test(name,age) values(?,?)";
		Connection conn = JdbcUtil.getConn();
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, "桐ヶ谷和人（きりがやかずと）");
		st.setInt(2, 18);
//		Statement st = conn.createStatement();
		for (int i = 0; i < 200; i++) {
//			st.addBatch(sql);
//			if (i%50 == 0) {
//				st.executeBatch();
//				st.clearBatch();
				st.executeUpdate();
//			}
//			st.executeUpdate(sql);
		}
		JdbcUtil.close(conn, st, null);
	}	
	@Test
	public void testSingleBySt1() throws Exception{
		String sql = "insert into test(name,age) values(?,?)";
		Connection conn = JdbcUtil.getConn();
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, "結城明日菜（ゆうきあすな）");
		st.setInt(2, 19);
//		Statement st = conn.createStatement();
		for (int i = 0; i < 2; i++) {
			st.addBatch();
//			if (i%50 == 0) {
				st.executeBatch();
				st.clearBatch();
//				st.executeUpdate();
//			}
//			st.executeUpdate(sql);
		}
		JdbcUtil.close(conn, st, null);
	}	
	@Test
	public void testSingleBySt2() throws Exception{
		String sql = "insert into test(name,age) values(?,?)";
		Connection conn = JdbcUtil.getConn();
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, "結城梨斗（ゆうきりと）");
		st.setInt(2, 19);
		for (int i = 0; i < 2; i++) {
			st.addBatch();
				st.executeBatch();
				st.clearBatch();
		}
		JdbcUtil.close(conn, st, null);
	}	
}
