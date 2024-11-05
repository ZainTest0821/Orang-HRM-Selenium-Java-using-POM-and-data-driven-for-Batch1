package testcases;

import Base.BaseClass;
import PageObject.AdminPage;
import PageObject.Dashboard;
import PageObject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dashboardtest extends BaseClass {
    Dashboard dashboard;
    LoginPage loginPage;
    AdminPage adminPage;

    public Dashboardtest(){
        super();
    }

    @BeforeMethod
    public void loginpage() {
        launchApp();
        loginPage = new LoginPage();
        adminPage= new AdminPage();
        dashboard = loginPage.loginaction(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void validatethepagetitle()  {
        // Validate URL after successfully reaching the Dashboard page
        String url = dashboard.getthepageurl(); // Get the current URL directly
        String expectedurl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        Assert.assertEquals(url, expectedurl);
    }

    @Test(priority = 2)
    public void employeeonleavesetting() throws InterruptedException {
        dashboard.clickonemployeeonleavesettingbtn();
    }

    @Test(priority = 3)
    public void verifythepopup() throws InterruptedException {
        employeeonleavesetting();
        String verifythepopup = dashboard.validatethepopup();
        Assert.assertEquals(verifythepopup, "Employees on Leave Today");
    }

    @Test(priority = 4) 
    public void clickonclosebtn() throws InterruptedException {
        employeeonleavesetting();
         adminPage=dashboard.closebtnofpopup();
    }
}
