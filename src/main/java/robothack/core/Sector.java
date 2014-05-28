package robothack.core;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Sector {

    private final List<Document> documents = Lists.newArrayList();

    public void declareDocument(Document document) {
        documents.add(document);
    }

    public void hackDocument() {
        Optional<Document> first =
                documents.stream()
                        .filter((doc) -> !doc.hasBeenHacked())
                        .findFirst();
        if (first.isPresent())
            first.get().hack();
        else
            throw new ProgramExecutionException("No document to hack");
    }

    public boolean isfinished() {
        return documents.stream().noneMatch((doc) -> !doc.hasBeenHacked());
    }
}
