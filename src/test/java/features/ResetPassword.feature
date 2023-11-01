Feature: Reset Password functionalities

  @ResetPassTest
  Scenario: Reset forgot password
    Given A user access to the login page
    When The link text "Forgot password?" is clicked
    Then The site should navigate to reset-password page
    When The user insert "Yikerz.Testing@gmail.com" in the Email field
    And The Send Verification Code button is clicked
    Then The site should navigate to reset-password page
    And The Reset Password button should be displayed
    When The user open a new window and nagivate to Gmail
    And Login with the email and password
    Then The user should receive a new email with a "password reset" code
    When The user insert the code and new password "Testing@1"
    And Click Reset Password button
    Then The login page should be displayed
    
