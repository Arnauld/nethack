package robothack.core;

import java.util.stream.Stream;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class BlockAllocationTableGrid implements BlockAllocationTable {

    private final Block[][] blocks;
    private final int width;
    private final int height;

    public BlockAllocationTableGrid(int width, int height) {
        this.width = width;
        this.height = height;
        blocks = new Block[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                blocks[x][y] = new Block();
            }
        }
    }

    @Override
    public Block blockAt(int x, int y) {
        return blocks[x - 1][y - 1];
    }

    @Override
    public boolean exists(Location location) {
        return location.x > 0
                && location.x <= width
                && location.y > 0
                && location.y <= height;
    }

    @Override
    public Stream<Block> blocks() {
        Stream.Builder<Block> builder = Stream.builder();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                builder.add(blocks[x][y]);
            }
        }
        return builder.build();
    }
}
