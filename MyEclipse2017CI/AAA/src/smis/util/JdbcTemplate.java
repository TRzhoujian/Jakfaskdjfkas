package smis.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import smis.handler.IresultSetHandler;

public class JdbcTemplate {
	private JdbcTemplate() {}
	public static <T> T query(String sql,IresultSetHandler<T> rhs,Object...args){
		Connection  conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
			rs = ps.executeQuery();
			return rhs.handler(rs);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, rs);
		}
		return null;
	}
	public static void update(String sql,Object...args) {
		System.out.println(sql);
		Connection  conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
			ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, null);
		}
	}
	
	
}
