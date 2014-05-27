package nethack.feature;

import nethack.core.Document;
import nethack.core.ExecutionEnvironment;
import nethack.core.RectangularSector;
import nethack.core.Sector;

import java.util.Iterator;
import java.util.List;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Context {
    private Sector sector;
    private ExecutionEnvironment executionEnvironment;

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
        syncSector();
    }

    public ExecutionEnvironment getExecutionEnvironment() {
        return executionEnvironment;
    }

    public ExecutionEnvironment getOrInitExecutionEnvironment() {
        if (executionEnvironment == null) {
            executionEnvironment = new ExecutionEnvironment();
            syncSector();
        }
        return executionEnvironment;
    }

    private void syncSector() {
        if (executionEnvironment != null)
            executionEnvironment.sector(sector);
    }

    public Document newDocument() {
        return new Document();
    }

    public Sector newSector(List<Document> documents) {
        Iterator<Document> it = documents.iterator();

        RectangularSector sector = new RectangularSector(documents.size(), 1);
        sector.blocks().forEach((block) -> block.placeDocument(it.next()));
        return sector;
    }
}
