Feature: Verify Contact Form Submission


  @Contact @Positive
  Scenario: Submit a contact form with valid details
    Given User is on the contact page again
    When User fills in "Ngawi123@gmail.com", "Alip_Ba_Ta", and "Jago bermain gitar"
    And User submits the form
    Then User should see a success message "Thanks for the message!!"
    And User clicks home menu button

  @Contact @Negative
  Scenario: Submit an empty contact form
    Given User is on the contact page
    When User not fill the form and click the send message
    Then User should see "Please fill the contact form" as an error alert message
    And User clicks home menu button again




