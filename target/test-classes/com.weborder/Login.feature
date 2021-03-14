@login
Feature: Login Functionality for WebOrder Page

  @tc5 @regression
  Scenario: Validation of WebOrder Login Positive Scenario
    Given the user navigates to the WebOrder
    When the user provides the credentials
    Then the user is on the home page
