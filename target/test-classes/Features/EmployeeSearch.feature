Feature: Searching the Employee

  Background:
    When  user enters valid email and valid password
    And click on login button
    When user clicks on PIM option

  @smoke
  Scenario: Search Employee by ID
   # Given open the browser and launch HRMS application
   # When  user enters valid email and valid password
   # And click on login button
   #  When user clicks on PIM option
    When user enters valid employee id
    And Clicks on search button
    And user see employee information displayed
    #And Close the browser

    @smoke
  Scenario: Search Employee by Job Title
    #Given open the browser and launch HRMS application
    # When  user enters valid email and valid password
    # And click on login button
    # When user clicks on PIM option
    When user selects Job Title
    And Clicks on search button
    And user see employee information displayed
    #  And Close the browser

  #background: this is used to define all the common steps that multiple SCENARIOS in the SAME FEATURE file
  #             till the time flow is not broken