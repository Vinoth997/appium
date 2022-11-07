Feature: Bookcart Application Testing

  @positive
  Scenario Outline: Bookcart Application Positive Testing
    Given I navigates to the Bookcart application
    And I click on login user
    And I enter the "<UserName>" and "<Password>"
    When I click on login button
    Then Login should be successful
    Then I verify the profile name as "<ProfileName>"
    And I can see list of books available
    Then I close the browser

    Examples: 
      | UserName   | Password | ProfileName |
      | brucewayne | Bruce000 | brucewayne  |

  @negative
  Scenario Outline: Bookcart Application Negative Testing
    Given I navigates to the Bookcart application
    And I click on login user
    And I enter wrong "<UserName>" and "<Password>"
    When I click on login button
    Then Login should fail
    Then I verify the error message contains "<Error Message>"

    Examples: 
      | UserName   | Password | ProfileName | Error Message                      |
      | brucewayne | Bruce001 | brucewayne  | Username or Password is incorrect. |
