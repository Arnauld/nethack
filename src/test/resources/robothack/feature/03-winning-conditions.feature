@in-dev
Feature: RobotHack winning conditions

  Scenario: Level is not won if there is still non-hacked document
    Given a very simple 3x1 sector
    And a document located at (1,1)
    And a document located at (2,1)
    And a document located at (3,1)
    And my location is (1,1), headed east
    When I hack the document
    Then the level should not be won

  Scenario: Level is won when there is no more document to hack

    Given a very simple 3x1 sector
    And a document located at (1,1)
    And a document located at (2,1)
    And a document located at (3,1)
    And my location is (1,1), headed east
    When I hack the document
    And I move forward
    And I hack the document
    And I move forward
    And I hack the document
    Then the level should be won

  Scenario: Level is not won if there is still non-hacked document

    Given a new sector with 3 documents
    When I hack one document
    Then the level should not be won

  Scenario: Level is won when there is no more document to hack

    Given a new sector with 3 documents
    When I hack one document
    And I hack an other one
    And I still hack an other one
    Then the level should be won