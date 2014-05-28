package nethack.core;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Toggle {
    private final Door door;

    public Toggle(Door door) {
        this.door = door;
    }

    public void toggle() {
        System.out.println("Toggle.toggle ~~> " + door.isOpened());
        if(door.isOpened())
            door.close();
        else
            door.open();
    }
}
