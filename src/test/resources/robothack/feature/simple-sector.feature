Feature: Simple Sector definition

  In order to simplify our requirement writing
  As a specifier
  I want some predefined and shared definition of sector

  Scenario: Very simple sector

#    1   2
#  +---+---+
#  |   |   | 1
#  +---+---+
#  |   |   | 2
#  +---+---+

    Given a very simple 2x2 sector
    Then the block at (1,1) should be empty and not corrupted

  Scenario Outline: Very simple sector

    Given a very simple 2x2 sector
    Then the block at (<x>,<y>) should be empty and not corrupted

  Examples:
    | x | y |
    | 1 | 1 |
    | 1 | 2 |
    | 2 | 1 |
    | 2 | 2 |

  Scenario: Simple sector

# [ditaa]
# ----
#
#  +---+
#  |   |
#  +---+
#  |   |
#  +---+---+
#  |   |   |
#  +---+---+
#      |   |
#  +---+---+
#  |   |   |
#  +---+---+
#  |   |
#  +---+
#  |   |
#  +---+
#
# ----

    Given a very simple 2x2 sector
    Then the block at (1,1) should be empty and not corrupted
