package controller;

import java.util.ArrayList;
import java.util.List;

public class InputFormValidator {
	
	public List validate(String param1,String param2) {
		
		List<String> errList = new ArrayList<String>();
		//Null check
		if(param1.isEmpty()) {
			errList.add("Param1 is empty");
		}
		if(param2.isEmpty()) {
			errList.add("Param2 is empty");
		}
		//Length check
		if(param1.length()>30) {
			errList.add("Param1 is more than 30 characters");
		}
		if(param2.length()>30) {
			errList.add("Param2 is more than 30 characters");
		}
		//Regular expression check
		return errList;
	}
}
