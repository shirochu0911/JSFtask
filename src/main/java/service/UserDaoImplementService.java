package service;

import java.io.Serializable;
import java.sql.SQLException;

import javax.enterprise.context.Dependent;

import bean.User;
import dao.UserdataDao;

@Dependent
public class UserDaoImplementService implements UserDaoInterfaceService ,Serializable{

	UserdataDao userDao = new UserdataDao();

	@Override
	public void insert(String userName, String password) throws SQLException {
		// TODO Auto-generated method stub
		userDao.insertData(userName, password);
	}

	@Override
	public User selectUser(String userName, String password) throws SQLException {
		// TODO Auto-generated method stub
		return userDao.selectUser(userName, password);
	}

}
