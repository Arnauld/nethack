package robothack.core;

import java.util.stream.Stream;

import static robothack.core.Predicates.blockWithNonHackedDocument;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Sector {

    private final BlockAllocationTable blockAllocationTable;

    public Sector(BlockAllocationTable blockAllocationTable) {
        this.blockAllocationTable = blockAllocationTable;
    }

    public void declareDocument(int x, int y, Document document) {
        Block block = blockAllocationTable.blockAt(x, y);
        if (block.hasDocument())
            throw new ProgramExecutionException("Document already present at location (" + x + ", " + y + ")");
        block.setDocument(document);
    }

    public boolean isFinished() {
        return blocks().noneMatch(blockWithNonHackedDocument());
    }

    public Block blockAt(int x, int y) {
        return blockAllocationTable.blockAt(x, y);
    }

    public boolean isValid(Location location) {
        return blockAllocationTable.exists(location);
    }

    public Stream<Block> blocks() {
        return blockAllocationTable.blocks();
    }
}
