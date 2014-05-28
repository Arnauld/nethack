package robothack.feature.ui;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import robothack.core.Document;
import robothack.core.Sector;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class SectorUIStepdefs {

    @Given("^a new level with (\\d+) documents$")
    public void createNewSector(int nbDocuments) throws Throwable {
        System.out.println("SectorUIStepdefs.createNewSector");
    }

    @When("^I hack one document$")
    public void hackOneDocument() throws Throwable {
        System.out.println("SectorUIStepdefs.hackOneDocument");
    }

    @Then("^the level should not be won$")
    public void assertSectorNotWon() throws Throwable {
        System.out.println("SectorUIStepdefs.assertSectorNotWon");
    }
}
