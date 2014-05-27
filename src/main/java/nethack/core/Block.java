package nethack.core;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Block {
    private Object occupiedBy = null;
    private boolean corrupted;

    public Color color() {
        return Color.Grey;
    }

    public boolean isEmpty() {
        return occupiedBy == null;
    }

    public boolean isCorrupted() {
        return corrupted;
    }

    public void leave(Object occupiedBy) {
        if(this.occupiedBy==null || !this.occupiedBy.equals(occupiedBy)) {
            throw new ProgramExecutionException(ErrorCode.CannotLeaveNonOccupiedBlock, this.occupiedBy);
        }
        this.occupiedBy = null;
    }

    public void enter(Object occupiedBy) {
        this.occupiedBy = occupiedBy;
    }
}
