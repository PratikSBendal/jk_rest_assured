REST API Automation Framework (RestAssured + TestNG + Allure)

This project is a REST API Automation Framework built with RestAssured, TestNG, and Allure Reports using the Page Object Model (POM) design pattern.
It provides reusable components for testing APIs such as Books API and Default APIs (Health, Signup, Login).

🚀 Tools & Libraries

Java 11+

Maven

RestAssured – HTTP client for API testing

TestNG – Test runner & reporting

Allure Reports – Rich HTML reports with request/response logs

Jackson / Gson – JSON parsing utilities

✨ Features

✅ Follows Page Object Model (POM) for APIs

✅ Reusable Request Builder with Bearer Token support

✅ Centralized Endpoints management

✅ Token Management for authenticated requests

✅ JSON Test Data Driven

✅ Allure Integration (request & response attachments)

✅ Supports TestNG suite execution via testng.xml

🧪 Test Cases

Positive Test Cases

Default API

Health Check 

User Signup (Valid Data) 

User Login (Valid Credentials)

Books API

Create Book (Valid Data)

Get All Books 

Get Book by ID (Valid ID)

Update Book (Valid ID & Data) 

Delete Book (Valid ID) 


📊 Reporting

Allure captures:

Request body

Response body

Test status (pass/fail)

After execution, reports are available in:

target/allure-results

Negative Test Cases
Default API

Health Check (Invalid Endpoint) 

User Signup (Missing Field)

User Login (Wrong Password) → Invalid password should return 401 Unauthorized.

Books API

Get All Book Unauthrized Token 

Create Book (Missing Field) 

Get Book by ID (Invalid ID)

Update Book (Invalid ID)  


To generate the report:

allure serve target/allure-results

🔮 Future Enhancements

Add DataProvider for multiple book/user test cases

Add Parallel Execution support with TestNG

Integrate with CI/CD pipelines (Jenkins/GitHub Actions)

Extend framework for additional APIs
