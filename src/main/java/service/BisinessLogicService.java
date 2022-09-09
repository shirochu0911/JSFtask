package service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.Dependent;

import bean.Data;
import dao.Dao;

@Dependent
public class BisinessLogicService implements DaoInterfaceService, Serializable {

	Dao dao = new Dao();

	@Override
	public void insert(String data) throws SQLException {
		// TODO Auto-generated method stub
		dao.insertData(data);
	}

	@Override
	public void update(int id, String data) throws SQLException {
		// TODO Auto-generated method stub
		dao.updateData(id, data);
	}

	@Override
	public List<Data> allAcquisition() {
		// TODO Auto-generated method stub
		return dao.allAcquisition();
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		dao.deleteData(id);
	}

}
