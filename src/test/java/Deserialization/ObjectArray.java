package Deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClasses.employeeDetailsWithObjectArray;

public class ObjectArray {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper obj = new ObjectMapper();

		// read the value
		employeeDetailsWithObjectArray e1 = obj.readValue(new File("./JsonFormat/ObjectArray.json"),
				employeeDetailsWithObjectArray.class);

		// fatch value from class
		System.out.println(e1.getEname());
		System.out.println(e1.getEmail());
	}

}
