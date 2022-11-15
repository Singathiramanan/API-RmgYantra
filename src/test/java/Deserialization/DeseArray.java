package Deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClasses.employeeDetailsWithArray;

public class DeseArray {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper obj=new ObjectMapper();
		
		//read the value
		employeeDetailsWithArray e1 = obj.readValue(new File("./JsonFormat/Array.json"), employeeDetailsWithArray.class);
		
		//fatch value from class
		System.out.println(e1.getEname());
		System.out.println(e1.getEmail());
		int[] i1 = e1.getPhoneNo();
		System.out.println(i1[0]);
	}

}
