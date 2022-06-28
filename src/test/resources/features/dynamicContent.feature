Feature : Dynamic Content Test

  Scenario:
   Given Open website "http://the-internet.herokuapp.com/dynamic_content?with_content=static"
    Then  Save information from  the page
    Then Click on  "click here" with selector "#content > div > p:nth-child(3) > a"
    Then Save information from  the page
    And Checking for dynamic content
