Feature: Editing Organization Page

  @login
  Scenario Outline: Login to OrangrHRM
    Given I am on OrangrHRM page
    And I enter  "<username>" and  "<password>"
    And I click on the login button
    Then I navigate to Admin page
    And I navigate To "<menu>"

    Examples: 
      | username | password |menu|
      | Admin    | admin123 |Admin|
