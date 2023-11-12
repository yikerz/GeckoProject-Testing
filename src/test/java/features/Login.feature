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
      
	@LogInThenRefreshWhileLoading
	Scenario Outline: Login with correct email and password and press refresh button when loading
		Given A user access to the login page
		When A "<email>" and "<password>" are inserted
		And The sign in button is clicked
		And the refresh button is clicked while the page is loading
		Then Redirect back to login page
		
		Examples: 
      | email                | password   |
      | almaqdad55@gmail.com | Password@1 |
  
  @LogInWithBothEmptyFields
  Scenario: Click on the login button with empty fields
		Given A user access to the login page
		When The sign in button is clicked
		Then Alert with "Missing required parameter USERNAME" is displayed for empty fields
	
	@LogInWithEmptyUsernameAndAPassword
	Scenario: Login with empty username field and a password (correct or incorrect)
		Given A user access to the login page
		When A "<password>" is inserted
		And The sign in button is clicked
		Then Alert with "Missing required parameter USERNAME" is displayed for empty fields
	
	@LogInWithUsernameAndEmptyPassword
	Scenario: Login with username (correct or incorrect) and empty password
		Given A user access to the login page
		When A "<email>" is inserted
		And The sign in button is clicked
		Then Alert with "Missing required parameter PASSWORD" is displayed for empty fields
		
#	only use scenario outline if you have a table to pass in, otherwise use Scenario	
