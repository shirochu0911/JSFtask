package backingbean;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import bean.Data;
import service.DaoInterfaceService;

@Named
@RequestScoped
public class Main {

	@Inject
	DaoInterfaceService daoInterfaceService;

	private List<Data> dataList;
	private String inputData;

	public List<Data> getDataList() {
		return dataList;
	}

	public void setDataList(List<Data> dataList) {
		this.dataList = dataList;
	}

	public String getInputData() {
		return inputData;
	}

	public void setInputData(String inputData) {
		this.inputData = inputData;
	}

	public String retry() throws SQLException {

		daoInterfaceService.Insert(getInputData());

		setDataList(daoInterfaceService.allAcquisition());

		return "/index.xhtml";
	}

}
