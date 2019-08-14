package com.vytrack.pages.fleet;

import com.vytrack.utilities.BasePage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class VehiclesPage extends BasePage {

    @FindBy (xpath = "//label[text()='Page:']/following-sibling::ul//input")
    public WebElement pageNumber;

    @FindBy (xpath = "//table//tbody//tr")
    public WebElement carInfo;

    @FindBy (xpath ="//span[contains(text(),'General Information')]")
    public WebElement getInfo;

    @FindBy (xpath = "//a[@class='btn icons-holder-text no-hash']")
    public WebElement AddEventButton;

    @FindBy (id = "oro_calendar_event_form_title-uid-5d51cdc2836f7")
    public WebElement Titlebox;

    @FindBy (id = "tinymce")
    public WebElement Description;

    @FindBy (xpath = "//button[contains(text(),'Save')]")
    public WebElement SaveButton;

    @FindBy (xpath = "//a[contains(text(),'Activity')]")
    public WebElement ActivityTab;

    @FindBy (xpath = "//a[contains(text(),'Activity')]")
    public WebElement FirstRow;

    public Integer getPageNumber(){
        return  Integer.valueOf(pageNumber.getAttribute("value"));
    }


    public void gridCLick() {

      carInfo.click();
        SeleniumUtils.waitPlease(2);


    }

    public String getPageTitle(){

        return getInfo.getText();
    }

    public String description(){

        AddEventButton.click();
        SeleniumUtils.waitPlease(2);
        Titlebox.sendKeys("driver");
        Description.sendKeys("hello");
        SaveButton.click();
        ActivityTab.click();

        WebElement message= Driver.getDriver().findElements(By.xpath("//div[@class='message-item message']")).get(0);
        System.out.println("message = " + message.getText());




        return "";
    }


}
