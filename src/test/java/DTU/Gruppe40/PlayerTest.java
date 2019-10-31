package DTU.Gruppe40;
import DTU.Gruppe40.Player;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

class PlayerTest {
    int initpoint;
    String name;
    Player player;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        name  = "Putin";
        initpoint = 1000;
        player =new Player(name, initpoint);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getPoints() {
        assertEquals(initpoint,player.getPoints());
    }

    @org.junit.jupiter.api.Test
    void setPoints() {
        int p = 2000;
        player.setPoints(p);
        assertEquals(p, player.getPoints());
    }

    @org.junit.jupiter.api.Test
    void addPoints() {
        int p1 = 200;
        int p2 =player.getPoints();
        player.addPoints(p1);
        assertEquals(p1+p2,player.getPoints());
        player.addPoints(-p2);
        assertEquals(p1,player.getPoints());
    }

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals(name,player.getName());
    }

    @org.junit.jupiter.api.Test
    void hasWon() {
        int p1 = -1;
        int p2 = 0;
        int p3 = 500;
        int p4 = 3000;
        int p5 = 3001;
        player.setPoints(p1);
        assertEquals(false, player.hasWon());
        player.setPoints(p2);
        assertEquals(false, player.hasWon());
        player.setPoints(p3);
        assertEquals(false, player.hasWon());
        player.setPoints(p4);
        assertEquals(true, player.hasWon());
        player.setPoints(p5);
        assertEquals(true, player.hasWon());
    }

    @org.junit.jupiter.api.Test
    void hasLost() {
        int p1 = -1;
        int p2 = 0;
        int p3 = 500;
        int p4 = 3000;
        int p5 = 3001;
        player.setPoints(p1);
        assertEquals(true, player.hasLost());
        player.setPoints(p2);
        assertEquals(false, player.hasLost());
        player.setPoints(p3);
        assertEquals(false, player.hasLost());
        player.setPoints(p4);
        assertEquals(false, player.hasLost());
        player.setPoints(p5);
        assertEquals(false, player.hasLost());
    }
}