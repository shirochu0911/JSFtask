package service;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.Dependent;

import bean.Data;
import dao.Dao;

@Dependent
public class BisinessLogicService implements DaoInterfaceService {

	Dao dao = new Dao();

	@Override
	public void Insert(String data) throws SQLException {
		// TODO Auto-generated method stub
		dao.insertData(data);
	}

	@Override
	public List<Data> allAcquisition() {
		// TODO Auto-generated method stub
		return dao.allAcquisition();
	}

}
