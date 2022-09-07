package backingbean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import bean.Data;
import service.DaoInterfaceService;
import service.validaton.ValidatorInterface;

@Named
@RequestScoped
public class Edit implements Serializable {

	@Inject
	DaoInterfaceService daoInterfaceService;

	@Inject
	ValidatorInterface validatorInterface;

	private List<Data> dataList;

	private Data data;
	private String inputData;
	private int inputDataId;

	private String errorMessage;
	
	@PostConstruct
	public void init() {
		setDataList(daoInterfaceService.allAcquisition());
	}

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

	public int getInputDataId() {
		return inputDataId;

	}

	public void setInputDataId(int inputDataId) {
		this.inputDataId = inputDataId;

	}

	public String sendToIndexScreen() throws SQLException {

		setInputDataId(Integer.parseInt(
				FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectDataId")));
		setErrorMessage(validatorInterface.dataLengthCheck(getInputData()));

		if (getErrorMessage() != null) {
			return "/edit.xhtml";
		}

		daoInterfaceService.update(getInputDataId(), getInputData());
		setDataList(daoInterfaceService.allAcquisition());

		return "/index.xhtml?faces-redirect=true";
	}

}
