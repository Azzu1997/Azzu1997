package Employee;

import static  io.restassured.RestAssured.*;

import java.io.File;

import org.junit.Test;

public class UploadProject
{
	@org.testng.annotations.Test
public void uploadImage()
{
	given()
	.multiPart(new File("C:\\Users\\shaik\\OneDrive\\Pictures\\majjor.png"))
	.when().post("https://postman-echo.com/post")
	.then().log().all();
}
}
