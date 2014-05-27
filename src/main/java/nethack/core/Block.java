package nethack.core;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Block {
    private Document document;
    private Object occupiedBy = null;
    private boolean corrupted;

    public void placeDocument(Document document) {
        this.document = document;
    }

    public Document document() {
        return document;
    }

    public Color color() {
        return Color.Grey;
    }

    public boolean isEmpty() {
        return occupiedBy == null;
    }

    public boolean isCorrupted() {
        return corrupted;
    }

    public void free() {
        this.occupiedBy = null;
    }

    public void enter(Object occupiedBy) {
        this.occupiedBy = occupiedBy;
    }

    public void corrupt() {
        this.corrupted = true;
    }

    public void repair() {
        this.corrupted = false;
    }

    public Object occupiedBy() {
        return occupiedBy;
    }

}
