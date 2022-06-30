Feature : Dynamic Content Test

  Scenario:
   Given Open website "http://the-internet.herokuapp.com/dynamic_content?with_content=static"
    Then  Save information from  the page
    Then Click on "click here"
    Then Save information from  the page
    And Checking for dynamic content
