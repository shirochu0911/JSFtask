package service;

import java.sql.SQLException;

import bean.User;

public interface UserDaoInterfaceService {

	//ユーザーを追加する
	public void insert(String userName, String password) throws SQLException;

	//登録されているユーザーを検索する
	public User selectUser(String userName, String password) throws SQLException;
}
