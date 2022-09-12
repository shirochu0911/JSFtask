package model;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import bean.Data;

public class DataModel extends ListDataModel<Data> implements SelectableDataModel<Data> {

	public DataModel(List<Data> data) {
		super(data);
	}

	@Override
	public Data getRowData(String rowKey) {
		// TODO Auto-generated method stub
		List<Data> datas = (List<Data>) getWrappedData();

		for (Data data : datas) {
			Integer i = data.getId();
			if (i.toString().equals(rowKey)) {
				return data;
			}
		}
		return null;
	}

	@Override
	public String getRowKey(Data data) {
		// TODO Auto-generated method stub
		Integer i = data.getId();

		return i.toString();
	}

}
