package nethack.core;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class ExecutionEnvironment {
    private Location location;
    private Direction direction;

    public Location getLocation() {
        return location;
    }

    public void lookAt(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void execute(Instr instr) {
        instr.applyOn(this);
    }

    public void locateAt(Location newLocation) {
        this.location = newLocation;
    }
}
