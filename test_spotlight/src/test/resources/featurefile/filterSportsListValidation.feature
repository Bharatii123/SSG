@regressionTesting
Feature: Picks wise Sports Filter List

  Scenario: Valid Sports Filter
    Given I am on "https://www.pickswise.com/"
    When I Select the Next Up Sports Filter
    Then I can see an available list of valid Sports
