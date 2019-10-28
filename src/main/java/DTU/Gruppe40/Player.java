package DTU.Gruppe40;

public class Player {
    private int points;
    private String name;
    private Die die1;
    private Die die2;
    private int currentTile;



    public Player(String name) {
        die1 = new Die();
        die2 = new Die();
        points = 0;
        this.name = name;
        //didDouble6 = false;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int p) {
        points = p;
    }

    public int addPoints(int points) {
        return this.points += points;
    }

    public String getName() {
        return this.name;
    }

    public String askThrow() {
        return "Will you roll your dice, " + name + "?";
    }

    public int rollDice() {
        int value1 = die1.roll();
        int value2 = die2.roll();

        return currentTile = value1 + value2;
    }

    public int getCurrentTile() {
        return currentTile;
    }

    public int getDieValue1() {
        return die1.getFaceValue();
    }

    public int getDieValue2() {
        return die2.getFaceValue();
    }

    public Boolean hasDoubles() {
        return die1.getFaceValue() == die2.getFaceValue();
    }

    public Boolean hasWon() {
        return points >= 3000 /*&& hasDoubleSix()*/;
    }

    public Boolean hasLost(){
        return points < 0;
    }

    public Boolean hasDoubleOne() {
        return hasDoubles() && die1.getFaceValue() == 1;
    }

    public Boolean hasDoubleSix() {
        //didDouble6 = true;
        return hasDoubles() && die1.getFaceValue() == 6;
    }
}
