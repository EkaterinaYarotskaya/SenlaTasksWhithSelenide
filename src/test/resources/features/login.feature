Feature: Login Test

  Scenario: check
    Given Open website "http://the-internet.herokuapp.com/login"
    Then Add text "tomsmith" to field "username"
    Then Add text "SuperSecretPassword!" to field "password"
    Then Click on "loginButton"
    Then Is there "logoutButton" on the web page


