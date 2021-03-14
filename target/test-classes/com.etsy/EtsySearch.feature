@search
Feature: Etsy Search Functionality


  Background: Navigate to Etsy
    Given the user navigates to "https://www.etsy.com"

  @hat @tc1 @smoke @regression
  Scenario: Validation of etsy search Hat
    When the user search with "Hat"
    Then the user should see the title "Hat | Etsy"

  @key @tc2 @smoke @regression
  Scenario: Validation of etsy search Key
    When the user search with "Key"
    Then the user should see the title "Key | Etsy"

  @pin @tc3 @regression
  Scenario: Validation of etsy search Pin
    When the user search with "Pin"
    Then the user should see the title "Pin | Etsy"