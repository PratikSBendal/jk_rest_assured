package APITest;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import httpmethod.DefaultMethod;
import io.restassured.response.Response;
import utils.JsonReader;

public class DefaultTest {
	DefaultMethod defaultmethod = new DefaultMethod();
	Response response = null;
	
	@Test(description = "Health Check")

	public void testGetHealth() {
		try {
			response = defaultmethod.getHealth();
			Assert.assertEquals(response.getStatusCode(), 200, "Health Check failed!");
			System.out.println("Health Check successfully.");
		} catch (Exception e) {
			System.out.println("Exception in testGetHealth: " + e.getMessage());
			if (response != null) {
				System.out.println("Response: " + response.asString());
			}
			Assert.fail("Health Check test failed due to exception.");
		}
	}
	
	@Test(description = "Signup Test")

	public void testSignUp() {
		try {
			Map<String, Object> userData = JsonReader.getJsonData("JsonData/userdata.json");
			response = defaultmethod.signUp(userData);
			Assert.assertEquals(response.getStatusCode(), 200, "SignUp failed!");
			System.out.println("Signup successfully.");
		} catch (Exception e) {
			System.out.println("Exception in testSignUp: " + e.getMessage());
			if (response != null) {
				System.out.println("Response: " + response.asString());
			}
			Assert.fail("Signup test failed due to exception.");
		}
	}
	
	@Test(description = "Token Gen SignIn")

	public void testSignTokengen() {
		try {
			Map<String, Object> userData = JsonReader.getJsonData("JsonData/userdata.json");
			response = defaultmethod.userLogin(userData);
			Assert.assertEquals(response.getStatusCode(), 200, "SignTokengen failed!");
			System.out.println("Sign Token Genrate successfully.");
		} catch (Exception e) {
			System.out.println("Exception in testSignTokengen: " + e.getMessage());
			if (response != null) {
				System.out.println("Response: " + response.asString());
			}
			Assert.fail("SigngenToken test failed due to exception.");
		}
	}

}
