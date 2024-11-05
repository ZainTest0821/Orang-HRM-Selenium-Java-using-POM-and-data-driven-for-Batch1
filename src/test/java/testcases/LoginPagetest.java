package testcases;

import Base.BaseClass;
import PageObject.Dashboard;
import PageObject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPagetest extends BaseClass {

    // Intialize the 'LoginPage' constructor at class level so we can use all the methods of 'LoginPage' page.
    LoginPage loginPage;
    Dashboard dashboard;

    // Then we have to initialize the super method of baseclass so that every property of BaseClass can be access easily
    public LoginPagetest(){
        super();
    }

    @BeforeMethod
    public void loginpage() {


        launchApp();
        loginPage= new LoginPage();

    }

    @AfterMethod

    public void teardown() {
        if (driver != null) {
            driver.quit();


        }
    }


    @Test(priority = 1)

    public void login(){
        //Store this so we can use properly in assertion
        String title= loginPage.getpagetitle();
        Assert.assertEquals(title,"OrangeHRM");
    }

    @Test(priority = 2)
    public void validatelogotest(){

        boolean logo= loginPage.validatelogo();
        Assert.assertTrue(logo);

    }

    @Test(priority = 3)
    public void logintopagetest(){
        // We store it into dashboard because when we login then we will go to dashboard page
        dashboard=loginPage.loginaction(prop.getProperty("username"),prop.getProperty("password"));



    }
}
