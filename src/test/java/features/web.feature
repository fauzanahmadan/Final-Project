Feature: Test Automation Web

  @web
  Scenario:Test web sign up normal
    Given user go to Product Store page
    And user click menu Sign up
    When user input sign up username "Michio1245890"
    And  user input sign up password "Michio1"
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
    When user input username "Michio1245"
    And user input password "Michio1"
    And user click login button
    Then User login successfully with welcome message "Welcome Michio1245"

  @web
  Scenario:Test web logout
    Given user go to Product Store page
    And user has been log in
    When User click menu Log out
    Then User Log out Successfully and display menu "Sign up"

  @web
  Scenario:Play Video in About us Menu
    Given user go to Product Store page
    And user click menu About Us
    When user click button video
    Then Video played successfully

  @web
  Scenario:Send Message in Contact Menu case Normal
    Given user go to Product Store page
    And user click menu Contact
    When user input Contact Email "fauzan@yahoo.com"
    And user input Contact Name "Fauzan"
    And user input Message "Hello World"
    And user click button Send Message
    Then validation display message "Thanks for the message!!"

   @web
  Scenario: order Product Normal
  Given user go to Product Store page
  And user has been log in
  When user order product item
  And User click Add to chart
  Then validation display message "Product added."
  And validation the Cart Page

   @web
   Scenario: Place order on cart menu normal
   Given user go to Product Store page
   And user has been log in
   And user go to cart page
   When user click button Place Order
   And user input Name "Fauzan Ahmad"
   And user input Country "Indonesia"
   And user input City "Cianjur"
   And user input Credit Card "12345"
   And user input Moth "8"
   And user input Year "2024"
   And user click button Purchase
   Then Order process successfully