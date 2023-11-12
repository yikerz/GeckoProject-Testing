Feature: ID Verification Functionalities
	
  Background: Login user
    Given A user access to the login page
    When A "Yikerz.Testing+11@gmail.com" and "Testing@1" are inserted
    And The sign in button is clicked
    
	@VerifyUserTest
  Scenario: Upload all document categories for verification
    Given A user is at the home page
    When Click the ID Verification on the NavBar
    Then The ID verification page should be displayed
    When Click the 1-th delete icon button
    Then The default row is not displayed
    When Add primary, secondary and tertiary documents
		And Click submit button
		Then The success page should be displayed
		And "Your Application Submitted Successfully" is displayed
		And The MySQL database should be updated with the document information
