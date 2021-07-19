Feature: Login with parameters

  Scenario: Login as librarian 11
    Given I am on the login page
    When I enter username "librarian11@library"
    And I enter password 'I61FFPPf'
    And click the sign in button
    Then dashboard should be displayed

  Scenario: Login as librarian 12
    Given I am on the login page
    When I enter username "librarian12@library"
    And I enter password 'AOYKYTMJ'
    And click the sign in button
    Then there should be 5568 users
    And dashboard should be displayed

  Scenario: Login as student 10
    Given I am on the login page
    When I enter username "student16@library"
    And I enter password 'VNKw282v'
    And click the sign in button
    And dashboard should be displayed

  Scenario: Login as librarian same line
    Given I am on the login page
    When I login using "librarian12@library" and "AOYKYTMJ"
    Then there should be 5568 users
    Then dashboard should be displayed

  Scenario: Login as student same line
    Given I am on the login page
    When I login using "student16@library" and "VNKw282v"
    Then dashboard should be displayed



