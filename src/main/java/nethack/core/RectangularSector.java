package nethack.core;

import java.util.stream.Stream;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class RectangularSector implements Sector {
    private final Block[][] blocks;
    private final int width;
    private final int height;

    public RectangularSector(int width, int height) {
        this.width = width;
        this.height = height;
        Block[][] blocks = new Block[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                blocks[y][x] = new Block();
            }
        }
        //
        this.blocks = blocks;
    }

    @Override
    public Block blockAt(int x, int y) {
        return blocks[y - 1][x - 1];
    }

    @Override
    public Stream<Block> blocks() {
        Stream.Builder<Block> builder =  Stream.builder();
        for (int y = 1; y <= height; y++) {
            for (int x = 1; x <= width; x++) {
                builder.add(blockAt(x,y));
            }
        }
        return builder.build();
    }

    @Override
    public boolean isInside(Location location) {
        if (location == null)
            throw new IllegalArgumentException();

        return location.x() > 0
                && location.x() <= width
                && location.y() > 0
                && location.y() <= height;
    }
}
