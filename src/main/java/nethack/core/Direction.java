package nethack.core;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public enum Direction {
    North,
    East,
    South,
    West;

    public static Direction lookup(String dir) {
        for (Direction direction : values()) {
            if (direction.name().equalsIgnoreCase(dir))
                return direction;
        }
        throw new IllegalArgumentException("Unknown direction '" + dir + "'");
    }
}
