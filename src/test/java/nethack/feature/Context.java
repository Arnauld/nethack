package nethack.feature;

import nethack.core.ExecutionEnvironment;
import nethack.core.Sector;

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
    }

    public ExecutionEnvironment getExecutionEnvironment() {
        return executionEnvironment;
    }

    public void setExecutionEnvironment(ExecutionEnvironment executionEnvironment) {
        this.executionEnvironment = executionEnvironment;
    }

    public ExecutionEnvironment getOrInitExecutionEnvironment() {
        if(executionEnvironment == null)
            executionEnvironment = new ExecutionEnvironment();
        return executionEnvironment;
    }
}
