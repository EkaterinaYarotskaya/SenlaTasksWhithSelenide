Feature: Login Test

  Scenario: Successful login
    Given Open website "http://the-internet.herokuapp.com/login"
    Then Add text "tomsmith" to field "username"
    Then Add text "SuperSecretPassword!" to field "password"
    Then Click on "loginButton"
    Then Is there "logoutButton" on the web page

  Scenario: Unsuccessful login
    Given Open website "http://the-internet.herokuapp.com/login"
    Then Add text "tomsmith" to field "username"
    Then Add text "Super" to field "password"
    Then Click on "loginButton"
    Then Is there "loginButton" on the web page

  Scenario: Successful logout
    Given Open website "http://the-internet.herokuapp.com/login"
    Then Add text "tomsmith" to field "username"
    Then Add text "SuperSecretPassword!" to field "password"
    Then Click on "loginButton"
    Then Click on "logoutButton"
    And Is there "loginButton" on the web page

    
