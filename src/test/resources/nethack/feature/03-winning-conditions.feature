Feature: RobotHack winning conditions

  Scenario: Sector is not won if there is still non-hacked document

    Given a new sector with 3 documents
    When I hack one document
    Then the sector should not be won

  Scenario: Sector is won when there is no more document to hack

    Given a new sector with 3 documents
    When I hack one document
    And I hack an other one
    And I still hack an other one
    Then the sector should be won