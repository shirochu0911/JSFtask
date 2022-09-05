package service;

import java.sql.SQLException;
import java.util.List;

import bean.Data;

public interface DaoInterfaceService {

	// データを追加する
	public void Insert(String data) throws SQLException;

	// 全件数取得する
	public List<Data> allAcquisition();
}
