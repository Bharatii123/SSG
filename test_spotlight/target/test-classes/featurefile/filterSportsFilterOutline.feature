@regressionTesting
Feature: Picks wise Sports Filter Outline

  Scenario Outline: Valid Sports Filter with Outline
    Given I am on "https://www.pickswise.com/"
    When I Select the Next Up Sports Filter
    Then I can see an available list of valid Sports to filter by "<filterName>"
    Examples:
      | filterName |
     # | KBO        |
      #| Esports    |

      | MLB        |
      #| Soccer     |
      #| Lacrosse   |
