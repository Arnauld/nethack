Feature: Defaults

  Scenario: Simple Sector

    Given a simple 2x2 sector
    Then the block at (1,1) is grey and empty
    And the block at (1,2) is grey and empty
    And the block at (2,1) is grey and empty
    And the block at (2,2) is grey and empty

