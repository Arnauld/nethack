package robothack.core;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Document {
    private boolean hacked = false;

    public void hack() {
        hacked = true;
    }

    public boolean hasBeenHacked() {
        return hacked;
    }
}
