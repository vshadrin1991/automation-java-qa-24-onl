Feature: rw tests

  @regression
  Scenario Outline: Search tickets
    Given open home page
    When i enter from "<From>"
    And i enter to "<To>"
    And i click on search
    Then i check departure time great then 0
    Examples:
      | From    | To      |
      | Витебск | Минск   |
      | Минск   | Витебск |

  @smoke
  Scenario: Search data
    Given open home page
    When i search by "Минск"
    Then i check search results great then 0
