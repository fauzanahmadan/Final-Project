Feature: Test Automation Web

  @web
  Scenario:Test web sign up normal
    Given user go to Product Store page
    And user click menu Sign up
    When user input sign up username "Admin"
    And  user input sign up password "Admin123"
    And user click sign up button
    Then validation display message "Sign up successful."

  @web
  Scenario: Test web sign up for user already exist
    Given user go to Product Store page
    And user click menu Sign up
    When user input sign up username "Admin"
    And user input sign up password "Admin123"
    And user click sign up button
    Then validation display message "This user already exist."

  @web
  Scenario: Test web sign up with empty username
    Given user go to Product Store page
    And user click menu Sign up
    And user input sign up password "Test123!!"
    And user click sign up button
    Then validation display message "Please fill out Username and Password."

  @web
  Scenario: Test web sign up with empty password
    Given user go to Product Store page
    And user click menu Sign up
    And user input sign up username "Admin"
    And user click sign up button
    Then validation display message "Please fill out Username and Password."

  @web
  Scenario: Test web sign up with empty username and password
    Given user go to Product Store page
    And user click menu Sign up
    And user click sign up button
    Then validation display message "Please fill out Username and Password."

  @web
  Scenario:Test web login normal
    Given user go to Product Store page
    And user click menu Log in
    When user input username "fauzan"
    And user input password "fauzan123"
    And user click login button
    Then User login successfully with welcome message "Welcome fauzan"

  @web
  Scenario:Test web logout
    Given user go to Product Store page
    And user click menu Log in
    When user input username "fauzan"
    And user input password "fauzan123"
    And user click login button
    When User click menu Log out
    Then User Log out Successfully and display menu "Sign up"

  @web
  Scenario:Test web Play Video in About us Menu
    Given user go to Product Store page
    And user click menu About Us
    When user click button video
    Then Video played successfully

  @web
  Scenario:Test web Send Message in Contact Menu case Normal
    Given user go to Product Store page
    And user click menu Contact
    When user input Contact Email "fauzan@yahoo.com"
    And user input Contact Name "Fauzan"
    And user input Message "Hello World"
    And user click button Send Message
    Then validation display message "Thanks for the message!!"

