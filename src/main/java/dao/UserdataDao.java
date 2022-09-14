package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;

public class UserdataDao {

	private final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private final String USER = "testuser";
	private final String PASSWORD = "P@ssw0rd";

	// 入力値登録
	public void insertData(String userName, String password) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;

		con = DriverManager.getConnection(URL, USER, PASSWORD);
		String sql = "Insert into userdata (userName,password) values ('" + userName + "','" + password + "');";

		ps = con.prepareStatement(sql);
		ps.executeUpdate();

		try {
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	// 登録ユーザー検索
	public User selectUser(String userName, String password) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		User user = new User();

		try {

			con = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "select * from userdata where userName='" + userName + "' AND password='" + password + "'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return user;
	}

}
