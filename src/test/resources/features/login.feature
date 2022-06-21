Feature: Login Test

  Scenario: Successful Login
    Given Open website "http://the-internet.herokuapp.com/login"
    Then User enters  login "tomsmith" and password "SuperSecretPassword!"
    Then Press button LOGIN
    And Web page open with URL "http://the-internet.herokuapp.com/secure"

  Scenario: Unsuccessful login with correct login and incorrect password
    Given Open website "http://the-internet.herokuapp.com/login"
    Then User enters  login "tomsmith" and password "password1"
    Then Press button LOGIN
    And Web page don`t open with URL "http://the-internet.herokuapp.com/secure"

  Scenario: Unsuccessful login with incorrect correct login and correct password
    Given Open website "http://the-internet.herokuapp.com/login"
    Then User enters  login "login1" and password "SuperSecretPassword!"
    Then Press button LOGIN
    And Web page don`t open with URL "http://the-internet.herokuapp.com/secure"

  Scenario: Unsuccessful login with incorrect correct login and incorrect password
    Given Open website "http://the-internet.herokuapp.com/login"
    Then User enters  login "login1" and password "password1"
    Then Press button LOGIN
    And Web page don`t open with URL "http://the-internet.herokuapp.com/secure"
