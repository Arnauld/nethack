package nethack.core.instr;

import nethack.core.Direction;
import nethack.core.ExecutionEnvironment;
import nethack.core.Instr;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Rotl implements Instr {
    @Override
    public void applyOn(ExecutionEnvironment execEnv) {
        Direction oldDir = execEnv.getDirection();
        Direction newDir = rotl(oldDir);
        execEnv.lookAt(newDir);
    }

    private Direction rotl(Direction direction) {
        switch (direction) {
            case North:
                return Direction.West;
            case East:
                return Direction.North;
            case South:
                return Direction.East;
            case West:
                return Direction.South;
        }
        throw new IllegalArgumentException("Unsupported direction '" + direction + "'");
    }
}
