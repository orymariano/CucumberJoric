package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //this methodorder works for hardcodes testing
public class HardCodedExamples {

 String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api" ;
 String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2OTIwMzE1OTEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY5MjA3NDc5MSwidXNlcklkIjoiNTgzNyJ9.9L86MTUlCnITTVBYBaXBI8-uiWD9OTMfjaIcwhC3qlM";
 static String employee_id;

 @Test
  public void acreateEmployee(){
    //prepare the request
  RequestSpecification preparedRequest = given().
          header("Content-Type","application/json").
          header("Authorization",token).body("{\n" +
                  "    \"emp_firstname\": \"Trafalgar\",\n" +
                  "    \"emp_lastname\": \"Law\",\n" +
                  "    \"emp_middle_name\": \"D\",\n" +
                  "    \"emp_gender\": \"M\",\n" +
                  "    \"emp_birthday\": \"2023-08-08\",\n" +
                  "    \"emp_status\": \"Confirmed\",\n" +
                  "    \"emp_job_title\": \"Doctor\"\n" +
                  "}");


    //hitting the endpoint / send the request
  Response response = preparedRequest.when().post("/createEmployee.php");

  response.prettyPrint();

    //verifying the assertions / get response
  response.then().assertThat().statusCode(201);

  //we are capturing employee id from the response
  employee_id=response.jsonPath().getString("Employee.employee_id");
  System.out.println(employee_id);

  //verifying the first name and last name in the response body
  response.then().assertThat().
          body("Employee.emp_firstname", equalTo("Trafalgar"));
   response.then().assertThat().
          body("Employee.emp_lastname", equalTo("Law"));

   //verifying header
  response.then().assertThat().header("Content-Type","application/json");
  System.out.println("My test case is passed");

 }
 @Test
 public void bgetCreatedEmployee() {
     RequestSpecification preparedRequest = given().
             header("Content-Type", "application/json").
             header("Authorization", token).
             queryParam("employee_id", employee_id);

     //hitting the endpoint
     Response response = preparedRequest.when().get("/getOneEmployee.php");
     response.prettyPrint();

     //verify the response
     response.then().assertThat().statusCode(200);

     String tempEmpID = response.jsonPath().getString("employee.employee_id");

     //we have 2 employee id, one global and one local
     Assert.assertEquals(employee_id, tempEmpID);
 }

       //HOMEWORK ------ CREATE A METHOD TO GET ALL EMPLOYEE STATUS AND JOB TITLE

    @Test
     public void cupdateEmployee(){
         RequestSpecification preparedRequest = given().
                 header("Content-Type", "application/json").
                 header("Authorization", token).
                 body("{\n" +
                         "  \"employee_id\": \""+employee_id+"\",\n" +
                         "  \"emp_firstname\": \"Santoru\",\n" +
                         "  \"emp_lastname\": \"Gojo\",\n" +
                         "  \"emp_middle_name\": \"Kaizen\",\n" +
                         "  \"emp_gender\": \"M\",\n" +
                         "  \"emp_birthday\": \"2000-08-08\",\n" +
                         "  \"emp_status\": \"probation\",\n" +
                         "  \"emp_job_title\": \"Jujutsu\"\n" +
                         "}");

         //hitting the endpoint
         Response response = preparedRequest.when().put("/updateEmployee.php");
         response.then().assertThat().statusCode(200);

         //for verification
         response.then().assertThat().body("Message",equalTo("Employee record Updated"));

     }

     @Test
     public void dgetUpdatedEmployee (){
         RequestSpecification preparedRequest = given().
                 header("Content-Type", "application/json").
                 header("Authorization", token).
                 queryParam("employee_id", employee_id);

         Response response = preparedRequest.when().get("/getOneEmployee.php");
         response.prettyPrint();

         response.then().assertThat().statusCode(200);
         //if you want to verify the body of the response, you can do that using hamcrest matchers

     }


 }
