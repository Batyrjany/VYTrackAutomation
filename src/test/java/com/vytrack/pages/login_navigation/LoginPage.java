package com.vytrack.pages.login_navigation;

//import com.sun.imageio.plugins.common.SingleTileRenderedImage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.SeleniumUtils;
import com.vytrack.utilities.VYTrackUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {


    private WebDriver driver = Driver.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver,Long.valueOf(ConfigurationReader.getProperty("explicitwait")));

    @FindBy( id = "prependedInput")
    public WebElement userNameElement;

    @FindBy( id = "prependedInput2")
    public WebElement passwordElement;

    @FindBy( id = "_submit")
    public WebElement loginButtonElement;

    @FindBy( className = "[@class='custom-checkbox__icon']")
    public WebElement rememberMeElement;

    @FindBy( partialLinkText = "Forgot your password")
    public WebElement forgotPasswordElement;

    @FindBy( tagName = "h2")
    public WebElement titleElement;

    @FindBy( css = "[class='alert alert-error']>div")
    public WebElement errorMessageElement;






    public LoginPage(){

        PageFactory.initElements(driver,this);


    }

    public void login(String username, String password){

        userNameElement.sendKeys(username);
        SeleniumUtils.waitPlease(2);
        passwordElement.sendKeys(password);
        SeleniumUtils.waitPlease(2);
        loginButtonElement.click();
      //  VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        SeleniumUtils.waitPlease(2);
      //  Assert.assertEquals(VYTrackUtils.getPageSubTitle(),"Dashboard");
    }


    public String getErrorMessage(){

        return errorMessageElement.getText();
    }


    public void clickRememberMe(){

        wait.until(ExpectedConditions.elementToBeClickable(rememberMeElement));
        if(!rememberMeElement.isDisplayed()){
            rememberMeElement.click();
            SeleniumUtils.waitPlease(2);
        }
    }
}
