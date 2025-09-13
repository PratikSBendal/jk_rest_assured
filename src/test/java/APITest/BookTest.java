package APITest;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.AuthAPI;
import groovy.transform.Undefined.EXCEPTION;
import httpmethod.BookMethod;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.JsonReader;

public class BookTest {
	BookMethod bookmethod = new BookMethod();
	Response response = null;
	JsonPath getjson = null;
    int newcreated_bookid ;
    
	@BeforeTest
//Setup Auth And token
	public void setupAuth() { 
		try {
			Map<String, Object> userData = JsonReader.getJsonData("JsonData/userdata.json");
			AuthAPI.getOrCreateToken(userData);
			System.out.println("Auth setup completed.");
		} catch (Exception e) {
			System.out.println("Exception during setupAuth: " + e.getMessage());
			Assert.fail("Auth setup failed due to exception.");
		}
	}

	@Test(description = "Create a new book")

	public void testCreateBook() {
		try {
			Map<String, Object> bookData = JsonReader.getJsonData("JsonData/bookcreatedata.json");
			response = bookmethod.createBook(bookData);
			getjson = response.jsonPath();
			newcreated_bookid = getjson.getInt("id");
			Assert.assertEquals(response.getStatusCode(), 200, "Book creation failed!");
			System.out.println("Book created successfully.");
		} catch (Exception e) {
			System.out.println("Exception in testCreateBook: " + e.getMessage());
			if (response != null) {
				System.out.println("Response: " + response.asString());
			}
			Assert.fail("Book creation test failed due to exception.");
		}
	}

	@Test(description = "Fetch all books")

	public void testGetAllBooks() {
		try {
			response = bookmethod.getAllBook();
			Assert.assertEquals(response.getStatusCode(), 200, "Fetching books failed!");
			System.out.println("Get All Book successfully.");

		} catch (Exception e) {
			System.out.println("Exception in testGetAllBooks: " + e.getMessage());
			if (response != null) {
				System.out.println("Response: " + response.asString());
			}
			Assert.fail("Ger All Book test failed due to exception.");
		}

	}

	@Test(description = "Update Book")
	public void testUpdateBook() {
		try {
			Map<String, Object> bookData = JsonReader.getJsonData("JsonData/bookupdatadata.json");
			response = bookmethod.updateBook(newcreated_bookid, bookData);
			Assert.assertEquals(response.getStatusCode(), 200, "Book update failed!");
			System.out.println("Book updated successfully.");
		} catch (Exception e) {
			System.out.println("Exception in testUpdateBook: " + e.getMessage());
			if (response != null) {
				System.out.println("Response: " + response.asString());
			}
			Assert.fail("Book updation test failed due to exception.");
		}
	}

	@Test(priority = 5, description = "Delete Book")

	public void testDeleteBook() {
		try {
			response = bookmethod.deleteBook(45);
			Assert.assertEquals(response.getStatusCode(), 200, "Book delete failed!");
			System.out.println("Book delete successfully.");
		} catch (Exception e) {
			System.out.println("Exception in testDeleteBook: " + e.getMessage());
			if (response != null) {
				System.out.println("Response: " + response.asString());
			}
			Assert.fail("Book delete test failed due to exception.");
		}
	}

	@Test(description = "Get Book")

	public void testGetBook() {
		try {
			response = bookmethod.getBook(2);
			Assert.assertEquals(response.getStatusCode(), 200, "Book get failed!");
			System.out.println("Book delete successfully.");
		} catch (Exception e) {
			System.out.println("Exception in testGetBook: " + e.getMessage());
			if (response != null) {
				System.out.println("Response: " + response.asString());
			}
			Assert.fail("Book get test failed due to exception.");
		}
	}
}
