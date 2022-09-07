package general;

import javax.faces.context.FacesContext;

import bean.Data;

public class Transportation {

	public static String stringTransportation(String id) {
		// TODO Auto-generated method stub
		String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(id);
		return value;
	}

	public static int intTransportation(String id) {
		int value = (int) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(id);
		return value;

	}

	public static Data dataTransportation(String id) {
		Data value = (Data) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(id);
		return value;
	}

}
