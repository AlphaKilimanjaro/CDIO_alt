import DTU.Gruppe40.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getTile() {
        Board board = new Board(8);

        board.addTile("test1","asdf",500);
        assertNotEquals(null, board.getTile(0));
    }


    @Test
    void addTile() {
    }
}