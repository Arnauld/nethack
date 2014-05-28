Feature: Move

  In order to change cell
  As a program
  I want to move

  Background:
    Given a very simple 2x2 sector

  Scenario: Move south to a valid cell

    Given my location is (1,1), headed south
    When I move forward
    Then my location should be (1,2)

  @acceptance-tests
  Scenario Outline: Move any direction to a valid cell

    Given my location is <location>, headed <direction>
    When I move forward
    Then my location should be <destination>

  Examples:
    | location | direction | destination |
    | (1,1)    | south     | (1,2)       |
    | (1,2)    | north     | (1,1)       |
    | (1,1)    | east      | (2,1)       |
    | (2,2)    | west      | (1,2)       |


  Scenario: Move outside sector

    Given my location is (1,1), headed north
    When I move forward
    Then my program should crash
