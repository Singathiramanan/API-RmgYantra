package serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClasses.player;
import pojoClasses.playerArray;

public class playerseri {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		player pl[]={new player("fgh","rftghj"),new player("rtyu","dfghj")};
		playerArray pa=new playerArray("csk", pl);
		ObjectMapper obj=new ObjectMapper();
		obj.writeValue(new File("./JsonFormat/playetArray.json"), pa);

		
	}
}
