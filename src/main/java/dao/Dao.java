package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Data;


public class Dao {

	private final String URL ="jdbc:postgresql://localhost:5432/postgres";
	private final String USER = "testuser";
	private final String PASSWORD = "P@ssw0rd";
	//入力値登録
	public void insertData(String data) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		con = DriverManager.getConnection(URL, USER, PASSWORD);
		String sql = "Insert into datatable (data) values ('"+data+"');";
		
		ps = con.prepareStatement(sql);
		ps.executeUpdate();
		
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			}
			catch (SQLException se) {
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
			Class.forName("org.postgresql.Driver");
			
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "select * from datatable";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Data data = new Data();
				
				data.setId(rs.getInt("id"));
				data.setData(rs.getString("data"));
				data.setCreateDate(rs.getTimestamp("createDate"));
				dataList.add(data);

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
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
			}
			catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return dataList;
	}
}
