Feature:  Testing dynamic content on the page

  Scenario: Check box present and clickable
    When Open website "http://the-internet.herokuapp.com/dynamic_controls"
    Then Check whether an element is displayed on a web page
    Then Click on check box
    Then Check box is selected on the web page
    Then Click on check box
    And Check whether an element is displayed on a web page

  Scenario: Check remove/add button
    When Open website "http://the-internet.herokuapp.com/dynamic_controls"
    And Check whether an element is displayed on a web page
    Then Click on remove button
    Then Check box is hidden on the web page
    Then Click on add button
    Then Check box is visible and exist on the web page
