Feature: Toggle and door

    #
    # +-------+-------+
    # | (1,1) | (2,1) |
    # +-------+-------+
    # | (1,2) | (2,2) |
    # +-------+-------+
    #


  Scenario: By default a door is closed

    Given a simple 2x2 sector
    And the block at (2,1) has been sealed by a door with a toggle at (1,2)
    Then the door at (2,1) should be closed

  Scenario: Cannot move to a closed door

    Given a simple 2x2 sector
    And the block at (2,1) has been sealed by a door with a toggle at (1,2)
    And my program is located on cell (1,1) looking in EAST direction
    When the next instruction executed is MOV
    Then my program should crash

  Scenario: Move to a toggle opens its associated closed door

    Given a simple 2x2 sector
    And the block at (2,1) has been sealed by a door with a toggle at (1,2)
    And my program is located on cell (1,1) looking in SOUTH direction
    When the next instruction executed is MOV
    Then the door at (2,1) should be opened

  Scenario: Move to a toggle closes its associated opened door

    Given a simple 2x2 sector
    And the block at (2,1) has been sealed by a door with a toggle at (1,2)
    And the door at (2,1) has been opened
    And my program is located on cell (1,1) looking in SOUTH direction
    When the next instruction executed is MOV
    Then the door at (2,1) should be closed