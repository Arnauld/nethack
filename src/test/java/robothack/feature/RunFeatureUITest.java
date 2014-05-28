package robothack.feature;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
        glue = "robothack.feature.ui",
        tags = "@ui")
public class RunFeatureUITest {
}
