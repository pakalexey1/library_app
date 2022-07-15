Feature: Login with parameters

  @libraryParam
  Scenario: Login as librarian 49
    Given I am on the login page
    When I enter username "librarian22@library"
    And I enter password "JUXl6dnx"
    And click the sign in button
    And there should be 144 users
    Then dashboard should be displayed
#    number can be whatever is there
