package nethack.feature;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import nethack.core.Block;
import nethack.core.Color;
import nethack.core.RectangularSector;
import nethack.core.Sector;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class SectorSteps {

    private Sector sector;

    @Given("^a simple (\\d+)x(\\d+) sector$")
    public void createRectangularSector(int width, int height) throws Throwable {
        sector = new RectangularSector(width, height);
    }

    @Then("^the block at \\((\\d+),(\\d+)\\) is grey and empty$")
    public void assertBlockIsGreyAndEmpty(int x, int y) throws Throwable {
        Block block = sector.blockAt(x, y);
        assertThat(block.isEmpty()).isTrue();
        assertThat(block.color()).isEqualTo(Color.Grey);
    }

}
