package robothack.core;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Mov implements Instr {

    @Override
    public void applyOn(ExecutionUnit executionUnit) {
        Direction direction = executionUnit.getDirection();
        Location location = executionUnit.getLocation();
        executionUnit.setLocation(direction.move(location));
    }
}
