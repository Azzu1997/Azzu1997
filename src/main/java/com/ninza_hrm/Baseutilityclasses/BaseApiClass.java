package com.ninza_hrm.Baseutilityclasses;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.ninza_hrm.utilityclasses.Databaseutility;
import com.ninza_hrm.utilityclasses.Fileutility;
import com.ninza_hrm.utilityclasses.RestAssuredutility;
import com.ninza_hrm.utilityclasses.javautility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
     import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseApiClass 
{
	//we are making global so that we can acess all over the class
	public static RequestSpecification specReqobj;
	public static ResponseSpecification specResobj;
	 public Databaseutility d= new Databaseutility();
	 public javautility j = new javautility();
	 public Fileutility f = new Fileutility();
	 public RestAssuredutility r= new RestAssuredutility();

	@BeforeSuite
public void configbs() throws IOException, SQLException
{
		 d.createDBRegister();
		 System.out.println("=======connecttoDB=====");
	RequestSpecBuilder reqbuilder= new RequestSpecBuilder();
	reqbuilder.setBaseUri(f.ReadTheDataFromThePropertyFile("BaseURI"));
	reqbuilder.setContentType(ContentType.JSON);
	//reqbuilder.addHeader("Authentication", "Bearer"+ r.getBearerToken());
	specReqobj =  reqbuilder.build();
	
	
	ResponseSpecBuilder resbuilder= new ResponseSpecBuilder();
			resbuilder.expectContentType(ContentType.JSON);
			 specResobj = resbuilder.build();
	}
	
	@AfterSuite
	public void configAs() throws SQLException
	{    
		d.disconnectionDB();
	  System.out.println("=======DIscountToDB======");
	}
	
	
	
	
	
	
	
}
