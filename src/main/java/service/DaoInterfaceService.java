package service;

import java.sql.SQLException;
import java.util.List;

import bean.Data;

public interface DaoInterfaceService {

	// データを追加する
	public void insert(String data) throws SQLException;
	
	//データを編集する
	public void update(int id,String data) throws SQLException;

	// 全件数取得する
	public List<Data> allAcquisition();
}
