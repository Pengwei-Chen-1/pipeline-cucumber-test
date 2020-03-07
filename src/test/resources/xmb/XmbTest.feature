Feature: Test common xMB service logic

  Scenario: Test create xMB service
    When I create a xMB service
    Then I should get the correct response with status code 200

  Scenario: Test get xMB service by ID
    Given I create a xMB service
    And I get a service ID
    When I get xMB service with service ID
    Then I should get the correct response with status code 200

  Scenario Outline: Test access xMB different path
    When I access xMB service with "<path>" url
    Then I get the correct response "<statusCode>"
  Examples:
      | path     | statusCode |
      | services | 200        |
      | hello    | 404        |