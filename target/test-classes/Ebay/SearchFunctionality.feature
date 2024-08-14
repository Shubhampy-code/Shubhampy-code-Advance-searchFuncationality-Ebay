
@tag
Feature: Search Fuctionality

  @tag1
  Scenario: To velidate the search functionality.
    Given Open browser, enter ebay url
    And select the Advanced link
    When user enter all the details in advanced search
    And click on using advanced search option 
    Then Enter the input
    And click on search button
    And assert search result

  #@tag2
  #Scenario Outline: Title of your scenario outline
   # Given I want to write a step with <name>
  #  When I check for the <value> in step
  #  Then I verify the <status> in step

  #  Examples: 
  #    | name  | value | status  |
  #    | name1 |     5 | success |
  #    | name2 |     7 | Fail    |
