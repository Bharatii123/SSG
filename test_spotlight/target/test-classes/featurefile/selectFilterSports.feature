@regressionTesting
Feature: Select Analysis Tab

  Scenario: Valid Sports Filter
    Given I am on "https://www.pickswise.com/"
    Then I Select the Analysis from Next Up Sports Tab
    And I Validate the Analysis Page