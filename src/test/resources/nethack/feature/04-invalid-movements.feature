Feature: Invalid movements

  Scenario: Cannot move outside the sector

    Given a simple 2x2 sector
    And my program is located on cell (1,1) looking in WEST direction
    When the next instruction executed is MOV
    Then my program should crash

  Scenario: Cannot move to a corrupted block

    Given a simple 2x2 sector
    And the block at (2,1) has been corrupted
    And my program is located on cell (1,1) looking in EAST direction
    When the next instruction executed is MOV
    Then my program should crash
