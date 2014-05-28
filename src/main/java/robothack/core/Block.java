package robothack.core;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Block {
    private boolean empty = true;
    private boolean corrupted;
    private Document document;


    public boolean isEmpty() {
        return empty;
    }

    public boolean isCorrupted() {
        return corrupted;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public boolean hasDocument() {
        return document != null;
    }
}
