package backingbean;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import bean.Data;
import service.DaoInterfaceService;
import service.validaton.ValidatorInterface;

@Named
@RequestScoped
public class Main {

	@Inject
	DaoInterfaceService daoInterfaceService;
	
	@Inject
	ValidatorInterface validatorInterface;

	private List<Data> dataList;
	private String inputData;
	
	private String errorMessage;

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

	public String getErrorMessage() {
		return errorMessage;

	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;

	}

	public String retry() throws SQLException {
		
		if (validatorInterface.dataLengthCheck(getInputData())) {
			setErrorMessage("指定文字数を超えています");
			return "index.html";
		}

		daoInterfaceService.Insert(getInputData());

		setDataList(daoInterfaceService.allAcquisition());

		return "/index.xhtml";
	}


}
