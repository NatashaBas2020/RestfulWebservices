package view;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import constants.SearchDataConstants;
import controller.InputFormValidator;
import controller.InternetHelper;
import model.DataModel;
import model.SearchDataModel;

@WebServlet("/paramsearch")
public class YelpSearchResponseProcessor extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		HttpSession session = request.getSession(true);
		String param1 = request.getParameter(SearchDataConstants.FIELD1_VALUE);
        String param2 = request.getParameter(SearchDataConstants.FIELD2_VALUE);
        
        InputFormValidator inputVal = new InputFormValidator();
        List<String> errorList = inputVal.validate(param1,param2);
        
        SearchDataModel formData = new SearchDataModel();
        
        if(errorList.size()>0) {
        	formData.setErrorsList(errorList);
        	session.setAttribute( "errorData", formData);
        	RequestDispatcher req = request.getRequestDispatcher("takeInputs.jsp");
			req.include(request, response);
        }else {
        
        YelpSearchResponseProcessor yelpObj = new YelpSearchResponseProcessor();
        DataModel dataModel;
        
	        if (param1!=null && param2!=null) {
	        	dataModel = yelpObj.getDataFromServer(param1,param2);
	        	
	        	session.setAttribute( "userBean", dataModel);
	        	 
		        if (dataModel != null) {
		            response.sendRedirect("showOutput.jsp");
		            return;
		        } else {
		            response.sendRedirect("error.html");
		            return;
		        }
	        }
        }
    }

	public DataModel getDataFromServer(String parameter1,String parameter2){

		// Call server api
		InternetHelper intObject = new InternetHelper();
		
		String jsonData = intObject.connectToInternet(parameter1, parameter2);
		// Return json data
		Gson gson = new Gson();

		DataModel dataModel = gson.fromJson(jsonData, DataModel.class);

		return dataModel;
	}

}
