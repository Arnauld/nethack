package nethack.core;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Block {
    private Object occupiedBy;

    public Color color() {
        return Color.Grey;
    }

    public boolean isEmpty() {
        return occupiedBy == null;
    }
}
