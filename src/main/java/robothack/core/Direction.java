package robothack.core;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public enum Direction {
    south(0, +1),
    north(0, -1),
    east(+1, 0),
    west(-1, 0);


    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {

        this.dx = dx;
        this.dy = dy;
    }

    public Location move(Location location) {
        return new Location(location.x + dx, location.y + dy);
    }
}
