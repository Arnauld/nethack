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

  @acceptance
  Scenario Outline: Turn right for all direction

    Given a simple 2x2 sector
    And my program is located on cell (1,1) looking in <before> direction
    When the next instruction executed is ROTR
    Then my program should be looking in <after> direction

  Examples:
    | before | after |
    | EAST   | SOUTH |
    | SOUTH  | WEST  |
    | WEST   | NORTH |
    | NORTH  | EAST  |

  @acceptance
  Scenario Outline: Turn left for all direction

    Given a simple 2x2 sector
    And my program is located on cell (1,1) looking in <before> direction
    When the next instruction executed is ROTL
    Then my program should be looking in <after> direction

  Examples:
    | before | after |
    | EAST   | NORTH |
    | NORTH  | WEST  |
    | WEST   | SOUTH |
    | SOUTH  | EAST  |

  Scenario: Move forward in the looking direction

    Given a simple 4x4 sector
    And my program is located on cell (1,1) looking in east direction
    When the next instruction executed is MOV
    Then my program should be located on cell (2, 1)


  @acceptance
  Scenario Outline: Move forward in the looking direction

    Given a simple 3x3 grid
    And my program is located on cell (2,2) looking in <direction> direction
    When the next instruction executed is MOV
    Then my program should be located on cell <new-position>

  Examples:
    | direction | new-position |
    | east      | (3,2)        |
    | west      | (1,2)        |
    | north     | (2,1)        |
    | south     | (2,3)        |
