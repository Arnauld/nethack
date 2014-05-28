package robothack.feature.service;

import cucumber.api.java.en.Given;
import robothack.core.BlockAllocationTableGrid;
import robothack.core.Sector;
import robothack.feature.World;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class SimpleSectorStepdefs {

    private World world;

    public SimpleSectorStepdefs(World world) {
        this.world = world;
    }

    @Given("^a very simple (\\d+)x(\\d+) sector$")
    public void verySimpleSector(int width, int height) throws Throwable {
        Sector sector = new Sector(new BlockAllocationTableGrid(width, height));
        world.setSector(sector);
    }
}
