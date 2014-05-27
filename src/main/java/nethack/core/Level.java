package nethack.core;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Level {
    private final List<Document> documents;

    public Level(List<Document> documents) {
        this.documents = documents;
    }

    public Stream<Document> documents() {
        return documents.stream();
    }

    public boolean isWon() {
        return documents().noneMatch((d) -> !d.hasBeenHacked());
    }
}
