package Deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClasses.playerArray;

public class PlayerArray {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper obj=new ObjectMapper();
		playerArray csk = obj.readValue(new File("./JsonFormat/playetArray.json"), playerArray.class);
		System.out.println(csk.getTeam());
		
	}
	

}
