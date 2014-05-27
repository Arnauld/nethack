package nethack.core;

/**
* @author <a href="http://twitter.com/aloyer">@aloyer</a>
*/
public enum ErrorCode {
    None,
    InvalidDirection,
    SectorCorrupted, SectorNonEmpty, UndefinedDirection, UndefinedLocation, CannotLeaveNonOccupiedBlock, LocationOutsideSector
}
