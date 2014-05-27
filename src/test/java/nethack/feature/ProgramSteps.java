package nethack.feature;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nethack.core.Direction;
import nethack.core.ExecutionEnvironment;
import nethack.core.Instr;
import nethack.core.Location;
import nethack.core.instr.Mnemonics;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class ProgramSteps {
    private final Context context;

    public ProgramSteps(Context context) {
        this.context = context;
    }

    @Given("^my program is located on cell \\((\\d+),(\\d+)\\) looking in (.+) direction$")
    public void locateProgramAndLookAt(int x, int y, String dir) throws Throwable {
        ExecutionEnvironment execEnv = context.getOrInitExecutionEnvironment();
        execEnv.locateAt(new Location(x, y));
        execEnv.lookAt(Direction.lookup(dir));
    }

    @When("^the next instruction executed is (.+)$")
    public void forceInstruction(String mnemonic) throws Throwable {
        ExecutionEnvironment execEnv = context.getExecutionEnvironment();
        assertThat(execEnv).describedAs("No execution environement defined").isNotNull();

        Instr instr = new Mnemonics().parse(mnemonic);
        execEnv.execute(instr);
    }

    @Then("^my program should be looking in (.+) direction$")
    public void assertProgramLookInDirection(String dir) throws Throwable {
        Direction expectedDir = Direction.lookup(dir);

        ExecutionEnvironment execEnv = context.getExecutionEnvironment();
        assertThat(execEnv.getDirection()).isEqualTo(expectedDir);
    }

    @Then("^my program should be located on cell \\((\\d+),\\s*(\\d+)\\)$")
    public void assertProgramIsLocatedAt(int x, int y) throws Throwable {
        ExecutionEnvironment execEnv = context.getExecutionEnvironment();
        assertThat(execEnv.getLocation()).isEqualTo(new Location(x, y));
    }
}
