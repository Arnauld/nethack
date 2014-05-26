Feature: Invalid movements

  Scenario: Cannot move outside the sector

    Given a simple 2x2 sector
    And my program is located on cell (1,1) looking in WEST direction
    When the next instruction executed is MOV
    Then my program should crash

  @acceptance
  Scenario Outline: Cannot move outside the sector

    #
    # (1,1)  | (2,1) | (3,1)
    # (1,2)  | (2,2) | (3,2)
    # (1,3)  | (2,3) | (3,3)
    #

    Given a simple 3x3 sector
    And my program is located on cell <position> looking in <direction> direction
    When the next instruction executed is MOV
    Then my program should crash

  Examples:
    | position | direction |
    | (3,1)    | WEST      |
    | (1,2)    | EAST      |
    | (1,3)    | SOUTH     |
    | (2,1)    | NORTH     |

  Scenario: Cannot move to a corrupted block

    Given a simple 2x2 sector
    And the block at (2,1) has been corrupted
    And my program is located on cell (1,1) looking in EAST direction
    When the next instruction executed is MOV
    Then my program should crash
