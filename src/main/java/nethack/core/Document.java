package nethack.core;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Document {
    private boolean hacked;

    public void hack() {
        hacked = true;
    }

    public boolean hasBeenHacked() {
        return hacked;
    }
}
