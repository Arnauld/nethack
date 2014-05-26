Feature: RobotHack movement

  Scenario: Turn left

    Given a simple 4x4 sector
    And my program is located on cell (1,1) looking in EAST direction
    When the next instruction executed is ROTL
    Then my program should be looking in NORTH direction

  Scenario: Turn right

    Given a simple 2x2 sector
    And my program is located on cell (1,1) looking in EAST direction
    When the next instruction executed is ROTR
    Then my program should be looking in SOUTH direction


  Scenario: Move forward in the looking direction

    Given a simple 4x4 grid
    And my program is located on cell (1,1) looking in east direction
    When the next instruction executed is MOV
    Then my program should be located on cell (2, 1)
