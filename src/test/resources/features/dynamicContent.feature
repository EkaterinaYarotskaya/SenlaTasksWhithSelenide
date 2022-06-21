Feature: Dynamic Content Test

  Scenario:
   Given Open website "http://the-internet.herokuapp.com/dynamic_content?with_content=static"
    Then  Save information from  the page before
    Then Click on button click here
    Then Save information from  the page after
    And Checking for dynamic content
