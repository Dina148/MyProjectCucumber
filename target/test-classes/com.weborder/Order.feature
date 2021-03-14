@weborder
Feature: WebOrder Page Food Order

  @tc6 @regression
  Scenario: Validation of Food Order For Office
    Given the user is on weborder home page
    Then the user select "Office" options
    And the user is on the group order page
    Then the user send invitees note "Test"
    And the user send invite list
    |kushal@gmail.com |
    |priyanka@gmail.com |
    |patel@gmail.com |
    |naveen@gmail.com |
    |gopal@gmail.com  |
    |sandeep@gmail.com |
    |ajeesh@gmail.com  |
    |sameer@gmail.com  |
    And the user validate "View Group Order" text
    * the user validate total participant is 1
