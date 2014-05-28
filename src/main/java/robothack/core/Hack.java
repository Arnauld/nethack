package robothack.core;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Hack implements Instr {
    @Override
    public void applyOn(ExecutionUnit executionUnit) {
        Block block = executionUnit.getBlockAtCurrentLocation();
        Document document = block.getDocument();
        if (document.hasBeenHacked())
            throw new ProgramExecutionException("Document already hacked");

        document.hack();
    }
}
