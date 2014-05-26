package nethack.core.instr;

import nethack.core.Direction;
import nethack.core.ExecutionEnvironment;
import nethack.core.Instr;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Rotr implements Instr {
    @Override
    public void applyOn(ExecutionEnvironment execEnv) {
        Direction oldDir = execEnv.getDirection();
        Direction newDir = rotr(oldDir);
        execEnv.lookAt(newDir);
    }

    private Direction rotr(Direction direction) {
        switch (direction) {
            case North:
                return Direction.East;
            case East:
                return Direction.South;
            case South:
                return Direction.West;
            case West:
                return Direction.North;
        }
        throw new IllegalArgumentException("Unsupported direction '" + direction + "'");
    }
}
