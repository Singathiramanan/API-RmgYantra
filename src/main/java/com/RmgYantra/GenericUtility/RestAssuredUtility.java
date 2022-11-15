package com.RmgYantra.GenericUtility;

import io.restassured.response.Response;

public class RestAssuredUtility {
	/**
	 * This method will return json data with corresponding response body
	 * @param response
	 * @param path
	 * @return
	 */
	public String getJsonData(Response response,String path){
		String jsonData = response.jsonPath().get(path);
		return jsonData;
	}
}
