package com.vytrack.tests.components.login_navigation;

import com.vytrack.pages.login_navigation.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.SeleniumUtils;
import com.vytrack.utilities.TestBase;
import com.vytrack.utilities.VYTrackUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests  extends TestBase {


    @Test
    public void loginTest1() {
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");

        loginPage.login(username, password);
        SeleniumUtils.waitPlease(2);
    }


    @Test
    public void negativeLoginTest1() {

            LoginPage loginPage = new LoginPage();
            loginPage.login("wrongusername", "wrongpassword");
            //SeleniumUtils.waitForVisibility(loginPage.errorMessageElement, 10);
            Assert.assertEquals(loginPage.getErrorMessage(), "Invalid user name or password.");
            SeleniumUtils.waitPlease(2);
        }

    }
