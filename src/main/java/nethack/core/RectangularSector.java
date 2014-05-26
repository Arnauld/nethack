package nethack.core;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class RectangularSector implements Sector {
    private final Block[][] blocks;

    public RectangularSector(int width, int height) {
        Block[][] blocks = new Block[height][width];
        for(int y=0;y<height;y++) {
            for(int x=0;x<width;x++) {
                blocks[y][x] = new Block();
            }
        }
        //
        this.blocks = blocks;
    }

    @Override
    public Block blockAt(int x, int y) {
        return blocks[y-1][x-1];
    }
}
