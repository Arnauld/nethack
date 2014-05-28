package robothack.core;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class ExecutionUnit {
    private Location location;
    private Direction direction;
    private Sector sector;
    private ProgramExecutionException crash;

    public ExecutionUnit() {
    }

    public void defineSector(Sector sector) {
        checkNotCrashed();
        this.sector = sector;
    }

    public void setLocation(Location location) {
        checkNotCrashed();
        try {
            if (!sector.isValid(location))
                throw new ProgramExecutionException("Invalid location");
            this.location = location;
        } catch (ProgramExecutionException e) {
            crash = e;
            throw e;
        }
    }

    public Location getLocation() {
        checkNotCrashed();
        return location;
    }

    public void setDirection(Direction direction) {
        checkNotCrashed();
        this.direction = direction;
    }

    public Direction getDirection() {
        checkNotCrashed();
        return direction;
    }

    public void execute(Instr instr) {
        checkNotCrashed();
        try {
            instr.applyOn(this);
        } catch (ProgramExecutionException e) {
            crash = e;
            throw e;
        }
    }

    public Sector getSector() {
        checkNotCrashed();
        return sector;
    }

    public Block getBlockAtCurrentLocation() {
        checkNotCrashed();
        Location location = getLocation();
        Sector sector = getSector();

        return sector.blockAt(location.x, location.y);
    }

    private void checkNotCrashed() {
        if(crash!=null)
            throw new ProgramCrashed(crash);
    }
}
