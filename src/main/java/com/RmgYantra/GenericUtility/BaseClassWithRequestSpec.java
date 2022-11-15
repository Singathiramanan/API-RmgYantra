package com.RmgYantra.GenericUtility;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClassWithRequestSpec {
	public DataBaseUtility dlib=new DataBaseUtility();
	public ExcelUtility elib=new ExcelUtility();
	public JavaUtility jlib=new JavaUtility();
	public RestAssuredUtility rlib=new RestAssuredUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public RequestSpecification reqspec;
	@SuppressWarnings("unused")
	@BeforeSuite
	public void bsConfig() throws SQLException{
		dlib.connectDB();
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setBaseUri("http://localhost");
		builder.setPort(8085);
		builder.setContentType(ContentType.JSON);
		RequestSpecification reqspec = builder.build();
	}
	
	@SuppressWarnings("unused")
	@AfterSuite
	public void asConfig() throws SQLException{
		dlib.closeDB();
		ResponseSpecBuilder builder=new ResponseSpecBuilder();
		ResponseSpecification resspec = builder.expectContentType(ContentType.JSON).build();
		
	}
}
