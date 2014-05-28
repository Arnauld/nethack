package robothack.feature;

import robothack.core.BlockAllocationTableGrid;
import robothack.core.ExecutionUnit;
import robothack.core.Sector;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class World {
    private Sector sector;
    private ExecutionUnit executionUnit = new ExecutionUnit();

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
        executionUnit.defineSector(sector);
    }

    public Sector newSector() {
        return new Sector(new BlockAllocationTableGrid(1, 1));
    }

    public ExecutionUnit getExecutionUnit() {
        return executionUnit;
    }
}
