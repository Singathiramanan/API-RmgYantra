package EndToEndTestingAPI;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.RmgYantra.GenericUtility.JavaUtility;
import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CreateProjectAndCheckInGuiAndDatabaseTest {
		@SuppressWarnings("unchecked")
		@Test
		public void createProjectTest() throws SQLException{
			JavaUtility ran=new JavaUtility();
			int random = ran.RandomNumber();
					
			JSONObject jobj=new JSONObject();
			jobj.put("createdBy", "Ramanan");
			jobj.put("projectName", "Singathicart"+random);
			jobj.put("status", "created");
			jobj.put("teamSize", 6);
			baseURI="http://localhost";
			port=8085;
			given()
				.body(jobj)
				.contentType(ContentType.JSON)
				.post("addProject");
			String pname = jobj.get("projectName").toString();
			System.out.println(pname);
			
			//GUI validation
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get("http://localhost:8084");
			driver.findElement(By.name("username")).sendKeys("rmgyantra");
			driver.findElement(By.name("password")).sendKeys("rmgy@9999");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			driver.findElement(By.xpath("//a[.='Projects']")).click();
			List<WebElement> names = driver.findElements(By.xpath("//tbody/tr/td[2]"));
			boolean flag = false;
			for(WebElement pn:names){
				if(pname.equals((pn.getText()))){
					flag=true;
				}
			}
			if(flag==true){
				System.out.println("project is created in GUI");
			}else{
				System.out.println("project is not created in GUI");
			}
			driver.findElement(By.xpath("//a[.='Logout']")).click();
			driver.close();
			
			//Database validation
			Driver dbDriver=new Driver();
			DriverManager.registerDriver(dbDriver);
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			Statement statement = connection.createStatement();
			String query="select * from project;";
			
			ResultSet result = statement.executeQuery(query);
			flag=false;
			SoftAssert sf=new SoftAssert();
			while(result.next()){
				String actData=result.getString(4);
				System.out.println(actData);
				if(actData!="NULL"){
					
					sf.assertTrue(actData.equals(pname));
					flag=true;
					
			}
			}
				if(flag==true){
					System.out.println("project is created in database");
				}else{
					System.out.println("project is not created in database");
				}
			connection.close();
			sf.assertAll();
						
		}
}
