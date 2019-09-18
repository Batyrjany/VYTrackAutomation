@vehicles
Feature: Vehicles

  As truck driver should be able to see all Vehicle information once navigate to Vehicle page

  Scenario: Login as a driver and navigate to the Vehicles
    Given user is on the landing page
    Then user logs in as a "driver"
    Then user navigates to "Fleet" and "Vehicles"
    And user verifies that "Cars" page name is displayed
    And user verifies that default page number is 1
    Then user verifies that "General Information" about the car is displayed
    Then user adds an event by clicking Add Event Button and passing "driver" to title and "hello" to description
    Then user verifies that an added event with "hello" message is displayed


