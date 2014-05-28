package robothack.feature.service;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import robothack.core.*;
import robothack.feature.World;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class SectorStepdefs {

    private World world;
    private ProgramExecutionException executionException;

    public SectorStepdefs(World world) {
        this.world = world;
    }

    private Sector getSector() {
        return world.getSector();
    }

    @When("^I hack one document$")
    public void hackOneDocument() throws Throwable {
        try {
            world.getExecutionUnit().execute(new Hack());
        } catch (ProgramExecutionException pe) {
            executionException = pe;
        }
    }

    @When("^I(?: still)? hack an other one$")
    public void i_hack_an_other_one() throws Throwable {
        hackOneDocument();
    }

    @Then("^the level should be won$")
    public void assertSectorWon() throws Throwable {
        assertThat(getSector().isFinished()).isTrue();
    }

    @Then("^the level should not be won$")
    public void assertSectorNotWon() throws Throwable {
        assertThat(getSector().isFinished()).isFalse();
    }

    @Then("^the block at \\((\\d+),(\\d+)\\) should be empty and not corrupted$")
    public void assertBlockIsEmptyAndNotCorrupted(int x, int y) throws Throwable {
        Block block = getSector().blockAt(x, y);
        assertThat(block.isEmpty()).isTrue();
        assertThat(block.isCorrupted()).isFalse();
    }

    @Given("^my location is \\((\\d+),(\\d+)\\), headed (.+)")
    public void defineLocationAndDirection(int x, int y, Direction direction) throws Throwable {
        Location location = new Location(x, y);
        ExecutionUnit unit = world.getExecutionUnit();
        unit.setLocation(location);
        unit.setDirection(direction);
    }

    @When("^I move forward$")
    public void move_forward() throws Throwable {
        try {
            world.getExecutionUnit().execute(new Mov());
        } catch (ProgramExecutionException pe) {
            executionException = pe;
        }
    }


    @Then("^my location should be \\((\\d+),(\\d+)\\)$")
    public void assertLocation(int x, int y) throws Throwable {
        assertThat(world.getExecutionUnit().getLocation()).isEqualTo(new Location(x, y));
    }

    @Then("^my program should crash$")
    public void assertProgramHasCrashed() throws Throwable {
        assertThat(this.executionException).isNotNull();
    }

    @Given("^a document located at \\((\\d+),(\\d+)\\)$")
    public void placeDocumentAt(int x, int y) throws Throwable {
        world.getSector().declareDocument(x, y, new Document());
    }
}
