package PageObject;

import Action.ActionClass;
import Base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    //Initialize the constructor first

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    //Login Page Logo locator
    @FindBy(xpath = "//*[@class='orangehrm-login-branding']")
    WebElement loginlogo;


    // Email textbox
    @FindBy(name = "username")
    WebElement username;


    //Password textbox
    @FindBy(name = "password")
    WebElement password;


    // LoginBtn
    @FindBy(xpath = "//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
    WebElement loginbtn;



    // Now performing some user actions on LoginPage

    // In the given method, the validation of logo will return boolean(true of false), that's why we have use boolean
    public boolean validatelogo(){
       return ActionClass.isDisplayed(driver,loginlogo);

    }

    public Dashboard loginaction(String user, String paswrd){

        ActionClass.type(username,user);
        ActionClass.type(password,paswrd);
        //Use the JS Click, because normal click is not working here
        ActionClass.JSClick(driver,loginbtn);
        return new Dashboard();

    }

    public String getpagetitle(){
       return driver.getTitle();

    }
}
