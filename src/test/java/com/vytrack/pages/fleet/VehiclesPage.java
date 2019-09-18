package com.vytrack.pages.fleet;

import com.vytrack.utilities.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;


public class VehiclesPage extends BasePage {





static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Long.valueOf(ConfigurationReader.getProperty("MEDIUM_WAIT")));

    @FindBy (xpath = "//label[text()='Page:']/following-sibling::ul//input")
    public WebElement pageNumber;

    @FindBy (xpath = "//table//tbody//tr[1]//td[1]")
    public WebElement carInfo;

    @FindBy (xpath ="//span[contains(text(),'General Information')]")
    public WebElement getInfo;

    @FindBy (xpath = "//a[@class='btn icons-holder-text no-hash']")
    public WebElement AddEventButton;

    @FindBy (name = "oro_calendar_event_form[title]")
    public WebElement Titlebox;

    @FindBy (xpath = "//body[@id='tinymce']")
    public WebElement Description;

    @FindBy (xpath = "//button[contains(text(),'Save')]")
    public WebElement SaveButton;

    @FindBy (xpath = "//a[contains(text(),'Activity')]")
    public WebElement ActivityTab;

    @FindBy (xpath = "//a[contains(text(),'Activity')]")
    public WebElement FirstRow;

    @FindBy (css = "iframe[id^='oro_calendar_event_form_description-uid-']")
    public WebElement iframe;

    @FindBy (css = "[id^='oro_calendar_event_form_title']" )
    public WebElement title;

    public Integer getPageNumber(){
        return  Integer.valueOf(pageNumber.getAttribute("value"));
    }


    public void gridCLick() {

    wait.until(ExpectedConditions.elementToBeClickable(carInfo));

        carInfo.click();
        SeleniumUtils.waitPlease(2);


    }

    public String getPageTitle(){

        return getInfo.getText();
    }



    public void addEvent(String message1, String message2){

        wait.until(ExpectedConditions.elementToBeClickable(AddEventButton));
        AddEventButton.click();
        SeleniumUtils.waitPlease(2);


        title.sendKeys(message1);

       Driver.getDriver().switchTo().frame(iframe);


        Description.sendKeys(message2);
        SeleniumUtils.waitPlease(2);

        Driver.getDriver().switchTo().defaultContent();

        wait.until(ExpectedConditions.elementToBeClickable(SaveButton));

        SaveButton.click();

    }

    public String description(){


        ActivityTab.click();

       WebElement message= Driver.getDriver().findElements(By.xpath("//div[@class='message-item message']")).get(0);
        String expectedmsg=message.getText();

        return expectedmsg;
    }


}
