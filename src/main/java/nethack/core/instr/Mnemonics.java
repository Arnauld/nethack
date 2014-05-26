package nethack.core.instr;

import nethack.core.Instr;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Mnemonics {

    public Instr parse(String mnemonic) {
        if (mnemonic.equalsIgnoreCase("rotl"))
            return new Rotl();
        else if (mnemonic.equalsIgnoreCase("rotr"))
            return new Rotr();
        else if (mnemonic.equalsIgnoreCase("mov"))
            return new Mov();

        throw new IllegalArgumentException("Unknown instruction mnemonic '" + mnemonic + "'");
    }
}
