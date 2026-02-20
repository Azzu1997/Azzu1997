package Project;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ninza_hrm.Baseutilityclasses.BaseApiClass;
import com.ninza_hrm.IEndpoint.IEndpoints;
import com.ninza_hrm.Pojoutility.ProjectPojo;

public class DuplicateProject
{
	public class AddProject extends BaseApiClass
	{
		
		String Pname="infy"+j.getRandomno();
		@Test
		
		public void addproject() throws SQLException 
	    {
		
	 
		ProjectPojo p = new ProjectPojo("intern", Pname, "Created", 0);
		given().spec(specReqobj).body(p)
		.when().post(IEndpoints.AddPROJ1)
		.then().statusCode(201).spec(specResobj).log().all();
		
//		boolean flag = d.ExecuteQueryVerfyAndGetData("select * from project", 4, Pname);
//		Assert.assertEquals(flag, true);
	}

	}
}
