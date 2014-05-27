package nethack.core;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class ExecutionEnvironment {

    private Location location;
    private Direction direction;
    private Sector sector;
    //
    private ProgramExecutionException lastProgramExecutionException;

    public ExecutionEnvironment() {
    }

    public ExecutionEnvironment sector(Sector sector) {
        this.sector = sector;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public void lookAt(Direction direction) {
        try {
            if (direction == null)
                crash(ErrorCode.UndefinedDirection);
            this.direction = direction;
        } catch (ProgramExecutionException pe) {
            lastProgramExecutionException = pe;
            throw pe;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void execute(Instr instr) {
        try {
            instr.applyOn(this);
        } catch (ProgramExecutionException pe) {
            lastProgramExecutionException = pe;
            throw pe;
        }
    }

    public void locateAt(Location newLocation) {
        try {
            checkLocation(newLocation);
            checkSectorRange(newLocation);
            checkAllowedBlock(newLocation);

            freeLocation(location);
            markOccupied(newLocation);
            this.location = newLocation;
        } catch (ProgramExecutionException pe) {
            lastProgramExecutionException = pe;
            throw pe;
        }
    }

    private void markOccupied(Location location) {
        Block block = sector.blockAt(location.x(), location.y());
        block.enter(this);
    }

    private void freeLocation(Location location) {
        if (location == null)
            return;

        Block block = sector.blockAt(location.x(), location.y());
        Object occupiedBy = block.occupiedBy();
        if (occupiedBy == null || !this.equals(occupiedBy)) {
            throw new ProgramExecutionException(ErrorCode.BlockNonOccupied, occupiedBy);
        }
        block.free();
    }

    private void checkLocation(Location newLocation) {
        if (newLocation == null) {
            crash(ErrorCode.UndefinedLocation);
        }
    }

    private void checkAllowedBlock(Location newLocation) {
        Block block = sector.blockAt(newLocation.x(), newLocation.y());
        if (block.isCorrupted()) {
            crash(ErrorCode.SectorCorrupted, newLocation);
        }
        if (!block.isEmpty()) {
            crash(ErrorCode.SectorNonEmpty, newLocation);
        }
    }

    private void checkSectorRange(Location newLocation) {
        if (!sector.isInside(newLocation)) {
            crash(ErrorCode.SectorOutOfRange, newLocation);
        }
    }

    public boolean hasCrashed() {
        return lastProgramExecutionException != null;
    }

    private static void crash(ErrorCode errorCode, Object... args) {
        throw new ProgramExecutionException(errorCode, args);
    }

}
