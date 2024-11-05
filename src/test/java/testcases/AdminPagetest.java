package testcases;

import Base.BaseClass;
import PageObject.AdminPage;
import PageObject.Dashboard;
import PageObject.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminPagetest extends BaseClass {

    Dashboard dashboard;
    LoginPage loginPage;
    AdminPage adminPage;

    public AdminPagetest(){
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
    public void clickonadmin(){
        adminPage.clickonadminbutton();
    }

    @Test(priority = 2)
    public void validatetheadminpageurl(){
        //We need to click on admin button then we can validate the URL,that's why we are using above method
        clickonadmin();
        String url= adminPage.gettheurlofadminpage();
        String expected= "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
        Assert.assertEquals(url,expected,"Admin page URL is not as expected.");
    }

    @Test(priority = 3)
    public void clickonaddbutton(){
        //We need to click on admin button then we can click on 'Add button'
        clickonadmin();
        adminPage.clickonaddbtn();
    }

    @Test(priority = 4)
    public void validatetheuseraddurl(){

        //We need to click on admin and then 'Add' button to validate the url
        clickonadmin();
        clickonaddbutton();

        String url= adminPage.gettheurlofaddinguserpage();
        String expected= "https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser";
        Assert.assertEquals(url,expected,"Add user page URL is not as expected.");

    }

    @Test(priority = 5)

    public void selectvaluefromuserrole(){

        // We need to click on Admin, Then Add button to reach out to page and select the value
        clickonadmin();
        clickonaddbutton();
        adminPage.selectthevalueofuserrole("ESS");
    }

    @Test(priority = 6)


    public void selectstatus(){
        // We need to click on 'Admin, then 'Add button to perform action
        clickonaddbutton();
        selectvaluefromuserrole();
        adminPage.selectvalueofstatus("Enabled");
    }

    @Test(priority = 7)
    public void enterusernamepassword(){
        // We need to click on Admin and then 'Add' button to perform actions
        clickonadmin();
        clickonaddbutton();
        selectvaluefromuserrole();
        selectstatus();
        adminPage.creds("Test","123456A","123456A");
        adminPage.clickonsavebtn();

    }

}
