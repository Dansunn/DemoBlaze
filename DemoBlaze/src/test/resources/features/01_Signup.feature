Feature: Register New Account

  @Register @Positive
  Scenario: Successful user registration
    Given User is on the signup page
    When User enters "Prometheus10" and "SQA@Hadir12345" as username and password
    And User clicks the sign-up button
    Then User will see "Sign up successful." as an alert successful message

  @Register @Negative
  Scenario: Register with same username
    Given User enters "Prometheus10" and "SQA@Hadir12345" as username and password again
    When User clicks the sign-up button again
    Then User will see "This user already exist." as an error alert message