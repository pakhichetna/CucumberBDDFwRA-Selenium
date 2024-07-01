package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;
//import io.restassured.

public class restAssuredSteps {

	Response res = null;
	
	@Given("User does pre set up")
	public void user_does_pre_set_up() {
		System.out.println("-----I'm am in Given---");
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
	}

	@When("user hits get call")
	public void user_hits_get_call() {
		System.out.println("-----I'm am in When---");
		
		String payload = "{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";
		
		RequestSpecification httpsrequest = RestAssured
				.given();
		
		httpsrequest.header("Content-Type","application/json");
		
		res = httpsrequest.body(payload).post("/auth");
		
			System.out.println("-----below is response---");
			System.out.println(res.asPrettyString());
			System.out.println("-----Above is response---");
			
			int statusCode = res.getStatusCode();
			System.out.println("-----below is Status code---");
			System.out.println(statusCode);
			System.out.println("-----Above is Status code---");
			
			System.out.println("-----Checking for Assertion Starts---");
			Assert.assertEquals(res.getStatusCode(), 200);
			System.out.println("-----Checking for Assertion Ends---");
			
	}

	@Then("verify result")
	public void verify_result() {
		System.out.println("-----I'm am in Then---");
		String str = res.jsonPath().getString("token");
	    System.out.println(str);
	}
	
}
