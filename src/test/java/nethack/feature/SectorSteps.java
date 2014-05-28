package nethack.feature;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nethack.core.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class SectorSteps {

    private final Context context;

    public SectorSteps(Context context) {
        this.context = context;
    }

    private Sector currentSector() {
        return context.getSector();
    }


    private Sector currentSectorOrFail() {
        Sector sector = context.getSector();
        assertThat(sector).describedAs("No sector defined").isNotNull();
        return sector;
    }

    @Given("^a simple (\\d+)x(\\d+) sector$")
    public void createRectangularSector(int width, int height) throws Throwable {
        Sector sector = new RectangularSector(width, height);
        context.setSector(sector);
    }


    @Given("^the block at \\((\\d+),(\\d+)\\) has been corrupted$")
    public void corruptBlock(int x, int y) throws Throwable {
        Block block = currentSector().blockAt(x, y);
        block.corrupt();
    }

    @Given("^the block at \\((\\d+),(\\d+)\\) has been sealed by a door with a toggle at \\((\\d+),(\\d+)\\)$")
    public void placeDoorAndToggle(int doorX, int doorY, int toggleX, int toggleY) throws Throwable {
        Door door = new Door();
        Block doorBlock = currentSector().blockAt(doorX, doorY);
        doorBlock.placeDoor(door);

        Toggle toggle = new Toggle(door);
        Block toggleBlock = currentSector().blockAt(doorX, doorY);
        toggleBlock.placeToggle(toggle);

    }

    @Given("^a new sector with (\\d+) documents$")
    public void defineLevel(int nbDocuments) throws Throwable {
        List<Document> documents = new ArrayList<>();
        for (int i = 0; i < nbDocuments; i++)
            documents.add(context.newDocument());
        Sector sector = context.newSector(documents);
        context.setSector(sector);
    }

    @When("^I hack one document$")
    public void hackDocument() throws Throwable {
        Sector sector = currentSectorOrFail();
        Optional<Block> first =
                sector.blocks()
                        .filter((block) -> !block.document().hasBeenHacked())
                        .findFirst();
        assertThat(first.isPresent()).describedAs("No more non-hacked document").isTrue();
        first.get().document().hack();
    }

    @When("^I(?: still)? hack an other one$")
    public void hackAnOtherDocument() throws Throwable {
        hackDocument();
    }

    @Then("^the sector should not be won$")
    public void assertLevelNotWon() throws Throwable {
        Sector level = currentSectorOrFail();
        assertThat(new WinningConditions().isSatisfied(level)).isFalse();
    }

    @Then("^the sector should be won$")
    public void assertLevelWon() throws Throwable {
        Sector level = currentSectorOrFail();
        assertThat(new WinningConditions().isSatisfied(level)).isTrue();
    }

    @Then("^the block at \\((\\d+),(\\d+)\\) is grey and empty$")
    public void assertBlockIsGreyAndEmpty(int x, int y) throws Throwable {
        Block block = currentSector().blockAt(x, y);
        assertThat(block.isEmpty()).isTrue();
        assertThat(block.color()).isEqualTo(Color.Grey);
    }

    @Then("^the door at \\((\\d+),(\\d+)\\) should be closed$")
    public void assertDoorIsClosed(int x, int y) throws Throwable {
        Block block = currentSector().blockAt(x, y);
        assertThat(block.door()).isNotNull();
        assertThat(block.door().isOpened()).isFalse();
    }

    @Then("^the door at \\((\\d+),(\\d+)\\) should be opened$")
    public void assertDoorIsOpened(int x, int y) throws Throwable {
        Block block = currentSector().blockAt(x, y);
        assertThat(block.door()).isNotNull();
        assertThat(block.door().isOpened()).isTrue();
    }

}
