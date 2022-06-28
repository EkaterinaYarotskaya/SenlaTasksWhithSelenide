Feature: check the health of dynamic content on the page

  Scenario: check the health of checkbox
    Given Open website "http://the-internet.herokuapp.com/dynamic_controls"
    Then Check whether "checkbox" is "displayed" on a web page
    Then Click on "checkbox"
    Then Check whether "checkbox" is "selected" on a web page
    Then Click on "checkbox"
    Then Check whether "checkbox" is "displayed" on a web page

  Scenario: check the health of remove/add button
    Given Open website "http://the-internet.herokuapp.com/dynamic_controls"
    Then Click on "remove/add button"
    Then Click on "remove/add button"

  Scenario: enter text in the field
    Given Open website "http://the-internet.herokuapp.com/dynamic_controls"
    Then Check whether "enable/disable button" is "enabled" on a web page
    Then Click on "enable/disable button"
