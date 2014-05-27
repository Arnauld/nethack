package nethack.feature;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nethack.core.Document;
import nethack.core.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class LevelSteps {

    private final Context context;

    public LevelSteps(Context context) {
        this.context = context;
    }

    private Level currentLevelOrFail() {
        Level level = context.getLevel();
        assertThat(level).describedAs("No level defined").isNotNull();
        return level;
    }

    @Given("^a new level with (\\d+) documents$")
    public void defineLevel(int nbDocuments) throws Throwable {
        List<Document> documents = new ArrayList<>();
        for (int i = 0; i < nbDocuments; i++)
            documents.add(context.newDocument());
        Level level = context.newLevel(documents);
        context.setLevel(level);
    }

    @When("^I hack one document$")
    public void hackDocument() throws Throwable {
        Level level = currentLevelOrFail();

        Optional<Document> first = level.documents()
                .filter((document) -> !document.hasBeenHacked())
                .findFirst();
        assertThat(first.isPresent()).describedAs("No more non-hacked document").isTrue();
        first.get().hack();
    }

    @When("^I(?: still)? hack an other one$")
    public void hackAnOtherDocument() throws Throwable {
        hackDocument();
    }

    @Then("^the level should not be won$")
    public void assertLevelNotWon() throws Throwable {
        Level level = currentLevelOrFail();
        assertThat(level.isWon()).isFalse();
    }

    @Then("^the level should be won$")
    public void assertLevelWon() throws Throwable {
        Level level = currentLevelOrFail();
        assertThat(level.isWon()).isTrue();
    }

}
