Feature: Login functionalities
	
	@CorrectLoginTest
  Scenario Outline: Login with correct email and password
    Given A user access to the login page
    When A "<email>" and "<password>" are inserted
    And The sign in button is clicked
    Then The home page should be displayed
    And The logout button is displayed

    Examples: 
      | email                | password   |
      | almaqdad55@gmail.com | Password@1 |
	
	@IncorrectLoginTest
  Scenario Outline: Login with incorrect email or password
    Given A user access to the login page
    When A "<email>" and "<password>" are inserted
    And The sign in button is clicked
    Then Alert with "Incorrect username or password." is displayed

    Examples: 
      | email                 | password      |
      | almaqdad55@gmail.com  | wrongPassword |
      | wrong_email@gmail.com | Password@1    |
