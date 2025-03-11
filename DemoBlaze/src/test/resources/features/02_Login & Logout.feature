Feature: Login and Logout

  @Login @Negative
    Scenario: Login with invalid credentials
    Given User is on the login page
    When User enters "abcder" and "abc123" as an invalid username and password
    And User clicks the login button
    Then User should see "User does not exist." as an error message

  @Login @Negative
  Scenario: Login with invalid password
    Given User is on the login pages
    When User enters "Prometheus5" and "abc123" as an username and invalid password
    And User press the login button
    Then User should see "Wrong password." as an error messages

  @Login @Positive
  Scenario: Successful login with valid credentials
    Given User is on the login page again
    When User enters "Prometheus5" and "SQA@Hadir12345"
    And User clicks the login button again
    Then User should see "Welcome Prometheus5"

  @Logout @Positive
  Scenario: Logout from the application
    Given User is logged in
    When User clicks the logout button
    Then User should be logged out and redirected to the homepage