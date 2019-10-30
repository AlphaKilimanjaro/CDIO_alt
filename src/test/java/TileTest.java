import DTU.Gruppe40.Tile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    Tile tile;
    @BeforeEach
    void setUp() {
        this.tile = new Tile("test1",  "test1+1",  500);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getName() {

        assertEquals("test1", tile.getTitle());
    }

    @Test
    void getText() {
        assertEquals("test1+1", tile.getFlavourText());
    }

    @Test
    void getMoney() {
        assertEquals(500, tile.getGoldValue());
    }
}