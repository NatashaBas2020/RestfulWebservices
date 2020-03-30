package model;

import java.util.List;

import model.Business;

public class SearchDataModel {
	
	private List<String> errorsList = null;
       
	public List<String> getErrorsList() {
		return errorsList;
	}

	public void setErrorsList(List<String> errorsList) {
		this.errorsList = errorsList;
	}

	@Override
	public String toString() {
		return "SearchDataModel [errorsList=" + errorsList + "]";
	}
}
