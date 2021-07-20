Feature: Login with different users

  Scenario Outline: Verify user information
    Given I am on the login page
    When I am login using "<email>" and "<password>"
    Then account holder name should be "<name>"
    @Students
    Examples:
      | email             | password | name            |
      | student27@library | kkMksO2i | Test Student 27 |
      | student28@library | 19Ceq2sT | Test Student 28 |
      | student29@library | WyIUNpDI | Test Student 29 |
      | student30@library | IaT9YI0I | Test Student 30 |

    @Librarians
    Examples:
      | email               | password | name              |
      | librarian13@library | 9rf6axdD | Test Librarian 13 |
      | librarian14@library | 87x8afWY | Test Librarian 14 |
      | librarian15@library | S5Ejblg1 | Test Librarian 15 |
      | librarian16@library | 8BzUhhaU | Test Librarian 16 |
      | librarian17@library | tXqOoIOS | Test Librarian 17 |