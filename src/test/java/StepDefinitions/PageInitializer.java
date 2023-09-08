package StepDefinitions;


import Pages.AddEmployeePage;
import Pages.LoginPage;

//THIS CLASS WILL MANAGE THE OBJECT CREATION OF DIFFERENT PAGE OBJECTS IN OUR FRAMEWORK
//INSTEAD OF CALLING THE PAGE OBJECTS AGAIN AND AGAIN.
public class PageInitializer {

    public static LoginPage login;
    public static AddEmployeePage addEmployeePage;

    public static void initializePageObjects(){

        login = new LoginPage();
        addEmployeePage=new AddEmployeePage();

    }


}
