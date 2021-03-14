Feature: Data Table Practice

  Scenario: Type of Data Tables
    Given the user print product titles
      | Product:*      |
      | Quantity:*     |
      | Price per unit |
      | Discount:      |
      | Total          |
    Then the user print credentials
      | username | Tester |
      | password | test   |
    And the user print product info
      | MyMoney     | 4 | Techtorial | 2200 E Devon | Chicago |
      | FamilyAlbum | 2 | Academy    | 2200 E Devon | Austin  |
    * the user print product details
      | ProductName | Q | Name       | Street       | City    |
      | MyMoney     | 4 | Techtorial | 2200 E Devon | Chicago |
      | FamilyAlbum | 2 | Academy    | 2200 E Devon | Austin  |