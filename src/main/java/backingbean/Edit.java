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
public class Edit {

	@Inject
	DaoInterfaceService daoInterfaceService;

	@Inject
	ValidatorInterface validatorInterface;

	private List<Data> dataList;

	private Data data;
	private String inputData;

	private String errorMessage;

	public Data getData() {
		return data;

	}

	public void setData(Data data) {
		this.data = data;

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

	public List<Data> getDataList() {
		return dataList;

	}

	public void setDataList(List<Data> dataList) {
		this.dataList = dataList;

	}

	public String sendToIndexScreen() throws SQLException {

		setErrorMessage(validatorInterface.dataLengthCheck(getInputData()));
		setDataList(daoInterfaceService.allAcquisition());

		if (getErrorMessage() != null) {
			return "/edit.xhtml";
		}

		daoInterfaceService.update(getData().getId(), getInputData());

		return "/index.xhtml";
	}

}
