package com.vytrack.step_definitions;
import com.vytrack.utilities.Pages;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class VehiclesStepDefinitions {
    Pages pages = new Pages();
    @Then("user verifies that default page number is {int}")
    public void user_verifies_that_default_page_number_is(Integer expected) {
        Assert.assertEquals(expected, pages.vehiclesPage().getPageNumber());
    }

    @Then("user verifies that {string} about the car is displayed")
    public void user_verifies_that_general_information_about_the_car_is_displayed(String expected) {

        pages.vehiclesPage().gridCLick();

        Assert.assertEquals(expected, pages.vehiclesPage().getPageTitle());


    }

    @Then("user adds an event by clicking Add Event Button and passing {string} to title and {string} to description")
    public void userAddsAnEventByClickingAddEventButtonAndPassingToTitleAndToDescription(String title, String description) {
        pages.vehiclesPage().addEvent(title,description);
    }


    @Then("user verifies that an added event with {string} message is displayed")
    public void userVerifiesThatAnAddedEventWithMessageIsDisplayed(String msg) {

     Assert.assertEquals(msg,pages.vehiclesPage().description());


    }


}
