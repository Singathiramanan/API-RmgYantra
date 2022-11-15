package Deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClasses.contacts;

public class DeseContacts {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper obj=new ObjectMapper();
		
		//read the value
		contacts e1 = obj.readValue(new File("./JsonFormat/contacts.json"), contacts.class);
		
		//fatch value from class
		System.out.println(e1.getFirstName());
		int[] i1 = e1.getPhoneNo();
		System.out.println(i1[1]);
	}

}
