package robothack.core;

import java.util.function.Predicate;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Predicates {
    public static Predicate<? super Block> blockWithNonHackedDocument() {
        return (block) -> block.hasDocument() && !block.getDocument().hasBeenHacked();
    }

}
