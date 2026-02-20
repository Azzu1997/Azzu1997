package Project;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.ninza_hrm.Baseutilityclasses.BaseApiClass;
import com.ninza_hrm.IEndpoint.IEndpoints;
import com.ninza_hrm.Pojoutility.ProjectPojo;
import com.ninza_hrm.utilityclasses.Databaseutility;
import com.ninza_hrm.utilityclasses.javautility;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

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
	
	boolean flag = d.ExecuteQueryVerfyAndGetData("select * from project", 4, Pname);
	Assert.assertEquals(flag, true);
    }
	
	//cout
	@Test
	public void countproject() 
	{
		ProjectPojo p = new ProjectPojo("fresher", Pname, "Completed", 0);
		given()
	.when().get(IEndpoints.Countproject)
	.then().statusCode(201).log().all();
	}
	
	@Test
	public void project()
	{
		ProjectPojo p = new ProjectPojo("fresher", Pname, "Completed", 0);
given()
.when().get(IEndpoints.Countproject)
.then().log().all();
}
	
	@Test
//in swagger if you see samplequery, we should do grapquery
	public void grapquery()
	{
		String Q= "{getAllProjects{ projectId projectName status}}";
ProjectPojo p = new ProjectPojo("fresher", Pname, "Completed", 0);
given().body(Q).contentType(ContentType.JSON)
.when().post("http://49.249.28.218:8091/getAll")
.then().log().all();
	}
	

}

