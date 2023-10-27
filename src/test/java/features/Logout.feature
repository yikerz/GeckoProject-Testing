Feature: Logout functionalities

  Background: Login user
    Given A user access to the login page
    When A "almaqdad55@gmail.com" and "Password@1" are inserted
    And The sign in button is clicked
	
	@LogoutTest
	Scenario: Logout from current user
		Given A user is at the home page
		When The logout button is clicked
		Then The login page should be displayed