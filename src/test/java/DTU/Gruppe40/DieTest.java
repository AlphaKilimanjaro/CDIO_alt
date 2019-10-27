package DTU.Gruppe40;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

class DieTest {
    private Die die1, die2;

    private double[] probs = {
            0.0, //0
            0.0, //1
            0.0278,
            0.0556,
            0.0833,
            0.1111,
            0.1389,
            0.1667,
            0.1389,
            0.1111,
            0.0833,
            0.0556,
            0.0278
    };

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        die1 = new Die(0);
        die2 = new Die(0);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void roll() {
        final int testRolls = 1000000;

        //T03: boundary-test
        for(int i=0; i<testRolls; i++)
            assertEquals(3.5, die1.roll(), 2.5);

        //T02: distributions-test
        int[] counter = new int[13]; //11+2
        for(int i=0; i<testRolls; i++) {
            counter[die1.roll()+die2.roll()]++;
        }
        for(int i=0; i<13; i++) {
            assertEquals(probs[i], (double)counter[i]/testRolls, 0.01);
        }
    }

    @org.junit.jupiter.api.Test
    void getFaceValue() {
        for(int i = 0; i < 7; i++) {
            die1 = new Die(i);
            assertEquals(i, die1.getFaceValue());
        }
    }
}