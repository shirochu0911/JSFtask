package backingbean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
public class Main implements Serializable {

	@Inject
	DaoInterfaceService daoInterfaceService;

	@Inject
	ValidatorInterface validatorInterface;

	private List<Data> dataList;
	private Data data;
	private String inputData;
	private int dataId;

	private String errorMessage;

	@PostConstruct
	public void init() {
		System.out.println("状態19");
		setDataList(daoInterfaceService.allAcquisition());
	}

	public int getDataId() {
		return dataId;
	}

	public void setDataId(int dataId) {
		this.dataId = dataId;
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
			return "/index.xhtml";
		}

		daoInterfaceService.insert(getInputData());

		return "/index.xhtml";
	}

	public String sendToEditScreen() {
		Map<String, Object> map = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
		setData((Data) map.get("data"));
		return "/edit.xhtml";
	}

	public String sendToIndexScreenDeleteAction() {
		return "/index.xhtml";
	}

}
