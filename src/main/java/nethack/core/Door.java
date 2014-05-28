package nethack.core;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Door {
    private boolean opened;

    public boolean isOpened() {
        return opened;
    }

    public void close() {
        opened = false;
    }

    public void open() {
        opened = true;
    }
}
