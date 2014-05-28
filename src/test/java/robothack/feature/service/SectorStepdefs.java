package robothack.feature.service;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import robothack.core.Document;
import robothack.core.Sector;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class SectorStepdefs {


    private Sector sector;

    @Given("^a new level with (\\d+) documents$")
    public void createNewSector(int nbDocuments) throws Throwable {
        sector = new Sector();
        for (int i = 0; i < nbDocuments; i++)
            sector.declareDocument(new Document());
    }

    @When("^I hack one document$")
    public void hackOneDocument() throws Throwable {
        sector.hackDocument();
    }

    @When("^I(?: still)? hack an other one$")
    public void i_hack_an_other_one() throws Throwable {
        hackOneDocument();
    }

    @Then("^the level should (not )?be won$")
    public void assertSectorNotWon(String notOrNot) throws Throwable {
        assertSectorNotWon(notOrNot == null);
    }

    private void assertSectorNotWon(boolean hasWon) {
        assertThat(sector.isfinished()).isEqualTo(hasWon);
    }

    @Then("^the sector should (not )?be won$")
    public void assertSectorNotWon_2(String notOrNot) throws Throwable {
        assertSectorNotWon(notOrNot == null);
    }

}
