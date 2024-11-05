package PageObject;

import Action.ActionClass;
import Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;

import static Action.ActionClass.waitForElementToBeVisible;

public class AdminPage extends BaseClass {

    //Initializing as constructor
    public AdminPage(){
        PageFactory.initElements(driver,this);
    }

    // Click on Admin button

    @FindBy(xpath = "//span[text()='Admin']")
    WebElement Adminbutton;

    //Click on 'Add'  button
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement Addbutton;

    //Click on 'User Role' dropdown button
    @FindBy(xpath = "//*[@class='oxd-select-text oxd-select-text--active']")
    WebElement Userrolebutton;



    //Click on 'Status' dropdown
    @FindBy(xpath = ("(//*[@class='oxd-select-text-input'])[2]"))
    WebElement Statusbutton;

    // UserName
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement Usernametextbox;

    // Password
    @FindBy(xpath = "//input[@type='password']")
    WebElement enterpassword;

    //Confirm Password
    @FindBy(xpath = "(//input[@type='password'])[2]")
    WebElement confirmpassword;

    // The given xpath is use for locating the dropdown element for UserRole dropdown

    private String dropdownoptionsofuserrole = "//span[text()='%s']";// Placeholder for dropdown options of UserRole, and we can enter the text of options that is available in dropdown


    //The given xpath is use for locating the dropdown element for Status dropdown options, and we can enter the text of options that is available in dropdown
    private String dropdownoptionsofstatus ="//span[text()= '%s']";

    //Save button on Add user page

    @FindBy(xpath ="//*[@type='submit']")
    WebElement Savebtn;






    // Perform some user actions

    public void clickonadminbutton(){
        waitForElementToBeVisible(Adminbutton);
        ActionClass.click(Adminbutton);
    }

    // First Validate the URL of Admin Page

    public  String gettheurlofadminpage(){
        return driver.getCurrentUrl();
    }

    // Click on 'Add button'
    public void clickonaddbtn(){
        waitForElementToBeVisible(Addbutton);
        ActionClass.JSClick(driver,Addbutton);

    }

    // Validate the User Add Page

    public String gettheurlofaddinguserpage(){
        return driver.getCurrentUrl();


    }


    // Select value in UserRole, We use another approach to locate the dropdown options, because that options become hide/unfocused and we can't interact with them normally
    public void selectthevalueofuserrole(String optionText) {

            // Make the dropdown visible using JavaScript
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.display='block';", Userrolebutton);

            // Click the dropdown to reveal options
            Userrolebutton.click();

            // Construct the full XPath for the desired option
            String finalXPath = String.format(dropdownoptionsofuserrole, optionText);

            // Wait for the option to be visible (make sure to create a wait method)
            WebElement option = driver.findElement(By.xpath(finalXPath));
            ActionClass.waitForElementToBeVisible(option); // Ensure this method waits until the element is interactable

            // Click the option
            option.click();
        }







    //Select value of Status dropdown options'

    public void selectvalueofstatus(String optiontext){
        // Make the dropdown visible using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display='block';", Statusbutton);

        // Click the dropdown to reveal options
       Statusbutton.click();

        // Construct the full XPath for the desired option
        String finalXPath = String.format(dropdownoptionsofstatus, optiontext);

        // Wait for the option to be visible (make sure to create a wait method)
        WebElement option = driver.findElement(By.xpath(finalXPath));
        ActionClass.waitForElementToBeVisible(option); // Ensure this method waits until the element is interactable

        // Click the option
        option.click();



    }

    // Getting username, password and confirm Password
    public void creds(String user, String paswrd, String confrm){
        ActionClass.type(Usernametextbox, user);
        ActionClass.type(enterpassword, paswrd);
        ActionClass.type(confirmpassword, confrm);

    }

    //Click on Save btn
    public void clickonsavebtn(){
        ActionClass.click(Savebtn);
    }



    }

