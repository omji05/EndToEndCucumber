Feature: Login into application
  Validating the log in functionality of the application

  Background: 
    Given user navigates to the your logo website
    Then user in on the your logo landing page

  @tag1
  Scenario: Login using the valid credentials
    When user click on the Sign in button
    Then user is navigated to login page
    When user enters "omjisaini25@gmail.com" in username field
    And enters "testwebsite" in password field
    And clicks on Sign in button
    Then user is successfully signed in with name "Omji Saini"
