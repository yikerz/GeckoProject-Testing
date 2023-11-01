Feature: Reset Password functionalities

  @SignUpTest
  Scenario: Reset forgot password
    Given A user access to the login page
    When The link text "Don't have an account? Sign Up" is clicked
    Then The site should navigate to sign-up page
    When The user insert sign-up details
      | FirstName | LastName | Email           | Password  | ConfirmPassword |
      | Travis    | LunMong  | Yikerz.Testing+ | Testing@1 | Testing@1       |
    And Click the sign-up button
		Then The verify button should be displayed
		When The user open a new window and nagivate to Gmail
    And Login with the email and password
    Then The user should receive a new email with a "confirmation" code
    When The user insert the code
    And Click verify button
    Then The login page should be displayed