package robothack.core;

import java.util.stream.Stream;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public interface BlockAllocationTable {
    Block blockAt(int x, int y);

    boolean exists(Location location);

    Stream<Block> blocks();
}
