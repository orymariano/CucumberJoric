package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmployeeSearch extends CommonMethods {
    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        WebElement empIDTextBox = driver.findElement(By.id("empsearch_id"));
        sendText(empIDTextBox, ConfigReader.getPropertyValue("empid"));
    }
    @When("Clicks on search button")
    public void clicks_on_search_button() {
        WebElement searchBtn = driver.findElement(By.id("searchBtn"));
        doClick(searchBtn);

    }
    @When("user see employee information displayed")
    public void user_see_employee_information_displayed() {
        System.out.println("The employee is Displayed");
    }

    @When("user selects Job Title")
    public void user_selects_job_title() {
       WebElement jobTitleDdl=driver.findElement(By.id("empsearch_job_title"));
       selectByOptions(jobTitleDdl, "Singer");

    //   WebElement EmpStatusDdl=driver.findElement(By.id("empsearch_employee_status"));
     //  selectByOptions(EmpStatusDdl, "Active");

     //  WebElement includeDdl=driver.findElement(By.id("empsearch_termination"));
     //  selectByOptions(includeDdl, "Current and Past Employees");
    }

}
