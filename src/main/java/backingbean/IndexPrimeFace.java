package backingbean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.inject.Inject;
import javax.inject.Named;

import bean.Data;
import service.DaoInterfaceService;

@Named
@RequestScoped
public class IndexPrimeFace implements Serializable {

	@Inject
	DaoInterfaceService daoInterfaceService;

	// 一覧データ
	private DataModel<Data> dataModel;

	// チェックで選択されたDataリスト
	private List<Data> selectedDataList;

	@PostConstruct
	public void init() {
		dataModel = new model.DataModel(daoInterfaceService.allAcquisition());
	}

	public DataModel<Data> getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel<Data> dataModel) {
		this.dataModel = dataModel;
	}

	public List<Data> getSelectedDataList() {
		return selectedDataList;
	}

	public void setSelectedDataList(List<Data> selectedDataList) {
		this.selectedDataList = selectedDataList;
	}

	public String sendToIndexScreenActionBulkDelete() throws SQLException {

		for (Data data : selectedDataList) {
			daoInterfaceService.delete(data.getId());
		}

		dataModel = new model.DataModel(daoInterfaceService.allAcquisition());
		return "/indexPrimeFace.xhtml";
	}

	public String sendToIndexScreen() {
		return "/index.xhtml";
	}

}
