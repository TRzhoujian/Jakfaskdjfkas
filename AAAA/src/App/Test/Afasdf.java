package App.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Afasdf {

	public static void main(String[] args) throws Exception {
				for (int i = 0; i < 6; i++) {
//					insertInto("明日でも",3);	
//					deleteSQL(i + 40);
				}
//				insertInto("抜刀術 ",100);	
		//		deleteSQL(14);
		//		updateSQL("転生したらスライムだった件",36,15);
		//		updateSQL("信長の野望",32,16);
		//		updateSQL("ノブナガのやぼ",32,17);
//				updateSQL("抜刀術",100,46);
//				updateSQL("ばっとうじゅつ",100,47);
//		checkCountFromID();
		checkContextFromID(16);
		checkAll();
	}



	private static void checkAll() {
		// TODO Auto-generated method stub
		try {
			checkSQL("select * from user1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	private static void checkContextFromID(Integer id) {
		// TODO Auto-generated method stub
		try {
			checkSQL("select * from user1 where id = " + id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	private static void checkCountFromID() {
		// TODO Auto-generated method stub
		try {
			checkSQL("select count(id) from user1");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	private static ResultSet checkSQL(String sql) throws Exception {
		// TODO Auto-generated method stub
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mysql?&useSSL=false";

		String username = "root"; 
		String password = "Aa8617818";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,username,password);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		if (sql.indexOf("select count") != -1) {
			if (rs.next()) {
				Long count = rs.getLong("count(id)");
				System.out.println(count);
			}
		}else if (sql.indexOf("where id =") != -1) {
			if (rs.next()) {
				Long id1 = rs.getLong("id");
				String name = rs.getString("name");
				long age = rs.getLong("age");
				System.out.println("ID(アイディー):" + id1 + "  名前(なまえ):" + name + "  年齢(ねんれい):" + age);
			}
		}else if (sql.indexOf("select * from") != -1) {
			while (rs.next()) {
				Long id1 = rs.getLong("id");
				String name = rs.getString("name");
				long age = rs.getLong("age");
				System.out.println("ID(アイディー):" + id1 + "  名前(なまえ):" + name + "  年齢(ねんれい):" + age);
			}
		}
		rs.close();
		st.close();
		conn.close();
		return rs;
	}



	private static void deleteSQL(Integer ID) {
		// TODO Auto-generated method stub
		try {
			ChangeSQL("delete from user1 where id = " + ID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	private static void updateSQL(String name ,Integer age,Integer id) {
		// TODO Auto-generated method stub

		try {
			ChangeSQL("update user1 set name ='" + name + "', age =" + age + " where id =" + id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	private static void insertInto(String name ,Integer age) {
		try {
			ChangeSQL("insert into user1 value(NULL,'" + name + "'," + age + ")");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}



	private static void ChangeSQL(String sql) throws Exception {
		// TODO Auto-generated method stub
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mysql?&useSSL=false";

		String username = "root"; 
		String password = "Aa8617818";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,username,password);
		Statement st = conn.createStatement();
		st.executeUpdate(sql);
		st.close();
		conn.close();

	}

}
