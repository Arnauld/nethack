package nethack.core;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class WinningConditions {

    public boolean isSatisfied(Sector sector) {
        return sector.blocks().noneMatch((block) -> !block.document().hasBeenHacked());
    }
}
