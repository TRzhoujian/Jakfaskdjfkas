package smis.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;



public class JdbcUtil {
	private JdbcUtil() {}
	private static DataSource ds;
	
	static {
		try {
			Properties p = new Properties();
//			System.out.println(JdbcUtil.class.getClassLoader());
			System.out.println(JdbcUtil.class.getClassLoader().getResourceAsStream("resources/db.properties"));
			InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("resources/db.properties");
			p.load(in);
			in.close();
			ds = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConn() throws Exception {
		return ds.getConnection();
	}
	public static void close(Connection conn,Statement ps,ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e3) {
					e3.printStackTrace();
					// TODO: handle exception
				}
			}	
		}
	}
}
