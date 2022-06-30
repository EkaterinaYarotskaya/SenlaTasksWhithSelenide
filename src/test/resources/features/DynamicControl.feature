Feature: check the health of dynamic content on the page

  Scenario: check the health of checkbox
    Given Open website "http://the-internet.herokuapp.com/dynamic_controls"
    Then Check whether "checkbox" is "displayed" on a web page. Expect "true"
    Then Click on "checkbox"
    Then Check whether "checkbox" is "selected" on a web page. Expect "true"
    Then Click on "checkbox"
    Then Check whether "checkbox" is "displayed" on a web page. Expect "true"

  Scenario: check the health of remove/add button
    Given Open website "http://the-internet.herokuapp.com/dynamic_controls"
    And Check whether "checkbox" is exist and visible
    Then Click on "remove/add button"
    And Check whether "checkbox" is hidden
    Then Click on "remove/add button"

  Scenario: enter text in the field
    Given Open website "http://the-internet.herokuapp.com/dynamic_controls"
    And Check whether "inputField" is disabled
    Then Click on "enable/disable button"
    And Check whether "inputField" is exist and visible
    Then Add text "УРА!" to field "inputField"
    Then Whether the text "УРА!" was introduced in the field "inputField"
    Then Click on "enable/disable button"
    And Check whether "inputField" is disabled