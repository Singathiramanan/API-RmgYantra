package Deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClasses.employeeDetails;

public class Deserialization {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		//create Object for ObjectMapper
		ObjectMapper obj=new ObjectMapper();
		
		//read the value
		employeeDetails e1 = obj.readValue(new File("./JsonFormat/EmployeeDetails.json"), employeeDetails.class);
		
		//fatch value from class
		System.out.println(e1.getEname());
		System.out.println(e1.getEid());
		System.out.println(e1.getPhoneNo());
		System.out.println(e1.getEmail());

	
	}
}
