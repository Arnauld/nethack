package robothack.feature;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.contrib.formatter.pdf.PdfFormatter;
import gherkin.formatter.model.Scenario;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
        glue = "robothack.feature.service",
        format = {"html:target/nethack"}
        //, tags = {"@in-dev"}
        //,format = {"robothack.feature.RunFeatureServiceTest$ConfiguredFormatter:target/pdf"}
)
public class RunFeatureServiceTest {

    public static class ConfiguredFormatter extends PdfFormatter {
        public ConfiguredFormatter(File reportDir) throws FileNotFoundException {
            super(reportDir, defaultConfiguration()
                            .withReportFilename("nethack-specs.pdf")
                            .withAuthor("Arnauld")
                            .withTitle("Nethack Specification")
                            .withDocumentMargin(10, 40)
                            .withDescriptionMargin(0, 0, 5, 5)
                            .withScenarioMargin(0, 0, 2, 5)
                            .displayUri(false)
                            .displayTags(false)
            );
        }

        @Override
        public void startOfScenarioLifeCycle(Scenario scenario) {
        }

        @Override
        public void endOfScenarioLifeCycle(Scenario scenario) {
        }
    }

}
