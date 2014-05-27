package nethack.feature;

import nethack.core.Document;
import nethack.core.ExecutionEnvironment;
import nethack.core.Level;
import nethack.core.Sector;

import java.util.List;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Context {
    private Sector sector;
    private ExecutionEnvironment executionEnvironment;
    private Level level;

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public ExecutionEnvironment getExecutionEnvironment() {
        return executionEnvironment;
    }

    public void setExecutionEnvironment(ExecutionEnvironment executionEnvironment) {
        this.executionEnvironment = executionEnvironment;
    }

    public ExecutionEnvironment getOrInitExecutionEnvironment() {
        if (executionEnvironment == null)
            executionEnvironment = new ExecutionEnvironment();
        return executionEnvironment;
    }

    public Document newDocument() {
        return new Document();
    }

    public Level newLevel(List<Document> documents) {
        return new Level(documents);
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }
}
