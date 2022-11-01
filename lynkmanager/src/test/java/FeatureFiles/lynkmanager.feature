@sprint1
Feature: LynkManager Homepage 

  @T001
  Scenario: Navigate to Homepage and validate List
    Given User open LynkManager url "https://test-e10ce.firebaseapp.com/authentication/login" in browser
    And Wait for login page.
    When User enter mailid "demo@arlynk.com" and password "123456a" 
    And Click on SignIn button
    Then User should navigate to homepage
		And Validate the list of programs  

	@T002
	Scenario: Add a new Program
		Given User click addprogram button
		And User enters the program name
		And Enter the Price
		And Enter the lots number
		And Enter number of buildings
		Then Click save(safe guard) button 
		And Click close(X) button
		
	@T003
	Scenario: Search a program
		Given User enter program name in search box
		And Click Enter key
		Then Program list should be displayed