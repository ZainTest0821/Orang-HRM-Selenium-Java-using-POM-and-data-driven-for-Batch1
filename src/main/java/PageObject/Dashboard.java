package PageObject;

import Action.ActionClass;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard extends BaseClass {

    //Initializing the constructor

    public Dashboard(){
        PageFactory.initElements(driver,this);
    }



    @FindBy(xpath = "//i[@class='oxd-icon bi-gear-fill orangehrm-leave-card-icon']")
    WebElement employeeonleavesettingbtn;


    //Validate the popup is appeared
    @FindBy(xpath = "//*[@class='oxd-text oxd-text--p oxd-text--card-body']")
    WebElement popupappeartext;


    //Closebtn on the popup
    @FindBy(xpath = "//button[@class='oxd-dialog-close-button oxd-dialog-close-button-position']")
    WebElement closebtnonpopup;








    // Perform some user Actions

    //Get the URL of the Page
    public String getthepageurl(){
     return driver.getCurrentUrl();

    }

    public void clickonemployeeonleavesettingbtn()  {
        ActionClass.JSClick(driver,employeeonleavesettingbtn);
    }

    public String validatethepopup(){
        ActionClass.waitForElementToBeVisible(popupappeartext);
        return popupappeartext.getText();
    }

    //Close the popup message


    public AdminPage closebtnofpopup(){
        ActionClass.waitForElementToBeVisible(closebtnonpopup);

        ActionClass.JSClick(driver,closebtnonpopup);
        return new AdminPage();

    }






}
