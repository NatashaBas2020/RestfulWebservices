package controller;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import constants.SearchDataConstants;

public class InternetHelper {

	private final CloseableHttpClient httpClient = HttpClients.createDefault();

	public String connectToInternet(String term, String location) {

		String result = "";
		HttpGet request = new HttpGet(
				SearchDataConstants.REST_URL + term + SearchDataConstants.REST_PARAM + location);

		// add request headers
		request.addHeader(SearchDataConstants.HEADER_1_NAME,SearchDataConstants.HEADER_1_VALUE);

		try (CloseableHttpResponse response = httpClient.execute(request)) {

			HttpEntity entity = response.getEntity();

			if (entity != null) {
				// return it as a String
				result = EntityUtils.toString(entity);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
