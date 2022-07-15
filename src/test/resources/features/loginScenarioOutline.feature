Feature: Login feature

  @Librarian
  Scenario Outline: Login as a <userType>
    Given I am on the login page
    When I login as a "<userType>"
    Then "<url>" should be displayed
    Examples:
      | userType  | url       |
      | librarian | dashboard |
      | student   | books     |

