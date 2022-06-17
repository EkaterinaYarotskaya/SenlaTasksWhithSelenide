Feature: Login Test
  Scenario: Successful Login
    Given Open website http://the-internet.herokuapp.com/login
    Then User enters  login "tomsmith" and password "SuperSecretPassword!"
    Then Press button LOGIN
    And Web page open with URL "http://the-internet.herokuapp.com/secure"
