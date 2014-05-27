package nethack.core;

import java.util.Arrays;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class ProgramExecutionException extends RuntimeException {
    public ProgramExecutionException(ErrorCode errorCode, Object... args) {
        super(errorCode + ": " + Arrays.toString(args));
    }
}
