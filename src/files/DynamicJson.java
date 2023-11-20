package files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


public class DynamicJson {
	
	@Test(dataProvider="BooksData")
	public void addBook(String isbn, String aisle)
	
	{
		
		/* RestAssured.baseURI="http://216.10.245.166";
		String response = given().log().all().header("Content-Type", "application/json").
		body(Payload.Addbook()).
		when().
		post("/Library/Addbook.php").
		then().assertThat().statusCode(200).
		extract().response().asString();
		
		 JsonPath js = ReUsableMethods.rawToJson(response);
		 String id  = js.get("ID");
		 System.out.println(id);
		 
		 */
		 
		 
		 //Dynamically  adding the Testdata 
		 
		 
		/*  RestAssured.baseURI="http://216.10.245.166";
		String response = given().log().all().header("Content-Type", "application/json").
		body(Payload.Addbook1("adrre", "3444")).
		when().
		post("/Library/Addbook.php").
		then().assertThat().statusCode(200).
		extract().response().asString();
		
		 JsonPath js = ReUsableMethods.rawToJson(response);
		 String id  = js.get("ID");
		 System.out.println(id);
		 
			 */
		
		RestAssured.baseURI="http://216.10.245.166";
		String response = given().log().all().header("Content-Type", "application/json").
		body(Payload.Addbook1(isbn,aisle)).
		when().
		post("/Library/Addbook.php").
		then().assertThat().statusCode(200).
		extract().response().asString();
		
		 JsonPath js = ReUsableMethods.rawToJson(response);
		 String id  = js.get("ID");
		 System.out.println(id);
		
	}
	
	
	@DataProvider(name="BooksData")
	public Object[][] getdata()
	
	{
		
	return new Object[][] {{"ghft", "897"} , {"Trhsd", "674"}, {"vhas" , "8978" }   };
	
		
		
	}
		
		
	}
	


