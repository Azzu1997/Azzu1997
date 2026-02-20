package com.ninza_hrm.utilityclasses;

import org.json.simple.JSONObject;

import com.jayway.jsonpath.JsonPath;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.List;

public class RestAssuredutility 
{
public String  getBearerToken()
{
	  JSONObject j= new JSONObject();
	  j.put("email", "azmat12@gmail.com");
	  j.put("pasword", "azmat@999");
	  j.put("role", "SHOPPER");
	Response res = given().body(j).contentType(ContentType.JSON)
	 .when().post("http://49.249.28.218:8091/generateToken");
	 res.then().log().all();
	 
	 //to get the token from the response
String 	BearerToken= res.jsonPath().get("data.jwtToken");
return BearerToken;
}


//if we dont want the return type as object we use "toString()"
//to get the jsonpath     
public String  getjsonpath(Response res, String jsonpath)
{
	return res.jsonPath().get(jsonpath).toString();
	}


public String GetDataOnjsonxPath(Response res, String jsonXpath)
{
	List<Object> list= JsonPath.read(res.asString(), jsonXpath);
	String value = list.get(0).toString(); //index 0 mean it it will fetch latest one 1st
	return value;
	}

//veriofy
public Boolean verifyDataonJsonpath(Response res, String jsonxpath, String ExpectedDate)
{

List<String> list=JsonPath.read(res.asString(), jsonxpath);
boolean flag= false;
for(String str: list)
{
	if(str.equals(ExpectedDate))
	{
		System.out.println(ExpectedDate + "is available == pass");
		flag= true;
	}
}
if (flag==false)
{
	System.out.println(ExpectedDate + "is available == fail");
}
return flag;    
}

public String getauth2Acccess() throws IOException
{
	Fileutility f= new Fileutility();
Response res =given()
.formParam("cilent_id", f.ReadTheDataFromThePropertyFile("cilent_id"))
.formParam("cilent_secret", f.ReadTheDataFromThePropertyFile("cilent_secrate"))
.formParam("grand_type", "client_credentials")
.when().post(f.ReadTheDataFromThePropertyFile("Auth_url"));
String  token = res.jsonPath().get("access_token");
return token;
}

 
}


