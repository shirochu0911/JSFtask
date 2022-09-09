package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import bean.Data;

public class Dao {

	private final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private final String USER = "testuser";
	private final String PASSWORD = "P@ssw0rd";

	// 入力値登録
	public void insertData(String data) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;

		con = DriverManager.getConnection(URL, USER, PASSWORD);
		String sql = "Insert into datatable (data) values ('" + data + "');";

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

	// 入力値削除
	public void deleteData(int deleteId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;

		con = DriverManager.getConnection(URL, USER, PASSWORD);
		String sql = "delete from datatable where id = " + deleteId + ";";

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

	// 入力値更新
	public void updateData(int id, String data) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;

		Long datetime = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(datetime);

		con = DriverManager.getConnection(URL, USER, PASSWORD);
		String sql = "UPDATE datatable SET data='" + data + "',updateDate='" + timestamp + "' WHERE id = " + id + ";";

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

	// 全件取得
	public ArrayList<Data> allAcquisition() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<Data> dataList = new ArrayList<>();

		try {

			con = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "select * from datatable";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Data data = new Data();

				data.setId(rs.getInt("id"));
				data.setData(rs.getString("data"));
				data.setCreateDate(rs.getTimestamp("createDate"));
				data.setUpdateDate(rs.getTimestamp("updateDate"));
				dataList.add(data);

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

		return dataList;
	}
}
