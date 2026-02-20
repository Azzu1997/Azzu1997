package Employee;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ninza_hrm.Baseutilityclasses.BaseApiClass;
import com.ninza_hrm.IEndpoint.IEndpoints;
import com.ninza_hrm.Pojoutility.EmployeePojo;
import com.ninza_hrm.Pojoutility.ProjectPojo;
import com.ninza_hrm.utilityclasses.javautility;

import io.restassured.http.ContentType;

public class Employee
{
	public class AddProject extends BaseApiClass
	{
		
		javautility j = new javautility();
		String Pname="infy"+j.getRandomno();
		
		@Test
		
		public void addproject() throws SQLException 
	    {
		
	 EmployeePojo e= new EmployeePojo("QA", "12/1/2000", "basic123@gmail.com",  "Intern", 2, "7642809124", "TestEngineer", "Intern_254263");
		given().body(e).contentType(ContentType.JSON)
	// given().spec(specReqobj).body(e)
		.when().post(IEndpoints.AddEmp)
		.then().log().all();
		//.then().statusCode(201).spec(specResobj).log().all();
		
//		boolean flag = d.ExecuteQueryVerfyAndGetData("select * from project", 4, Pname);
//		Assert.assertEquals(flag, true);
	}
	}
}

