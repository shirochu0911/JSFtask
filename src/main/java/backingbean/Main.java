package backingbean;

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
public class Main {

	@Inject
	DaoInterfaceService daoInterfaceService;

	@Inject
	ValidatorInterface validatorInterface;

	private List<Data> dataList;
	private Data data;
	private String inputData;

	private String errorMessage;

	@PostConstruct
	public void init() {
		setDataList(daoInterfaceService.allAcquisition());
	}

	public List<Data> getDataList() {
		return dataList;
	}

	public void setDataList(List<Data> dataList) {
		this.dataList = dataList;
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

	public String sendToIndexScreen() throws SQLException {

		setErrorMessage(validatorInterface.dataLengthCheck(getInputData()));
		setDataList(daoInterfaceService.allAcquisition());

		if (getErrorMessage() != null) {
			return "/index.html";
		}

		daoInterfaceService.insert(getInputData());

		return "/index.xhtml";
	}

	public String sendToEditScreen() {
		setData((Data)FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("selectData"));
		System.out.println("最新状態");
		System.out.println(FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("test"));
//		setData(Transportation.dataTransportation("selectData"));
		System.out.println(getData());
		return "/edit.xhtml";
	}
	
	public String test() {
		System.out.println(FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("test"));
		return "/index.xhtml";
	}

}
