Feature: RobotHack winning conditions

  Scenario: Level is not won if there is still non-hacked document

    Given a new level with 3 documents
    When I hack one document
    Then the level should not be won

  Scenario: Level is won when there is no more document to hack

    Given a new level with 3 documents
    When I hack one document
    And I hack an other one
    And I still hack an other one
    Then the level should be won