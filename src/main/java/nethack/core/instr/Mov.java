package nethack.core.instr;

import nethack.core.Direction;
import nethack.core.ExecutionEnvironment;
import nethack.core.Instr;
import nethack.core.Location;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Mov implements Instr {
    @Override
    public void applyOn(ExecutionEnvironment execEnv) {
        Direction dir = execEnv.getDirection();
        Location oldLoc = execEnv.getLocation();
        Location newLoc = mov(oldLoc, dir);
        execEnv.locateAt(newLoc);
    }

    private Location mov(Location location, Direction direction) {
        switch (direction) {
            case North:
                return location.translate(0, -1);
            case East:
                return location.translate(+1, 0);
            case South:
                return location.translate(0, +1);
            case West:
                return location.translate(-1, 0);
        }
        throw new IllegalArgumentException("Unsupported direction '" + direction + "'");
    }
}
