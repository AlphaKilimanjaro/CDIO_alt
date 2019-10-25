package DTU.Gruppe40;

public class Die {
    private int faceValue;

    public Die(int value) {
        faceValue = value;
    }

    public Die() {
        faceValue = 0;
    }

    public int roll() {
        faceValue = (int)(Math.random() * 6.0 + 1.0);
        return faceValue;
    }

    public int getFaceValue() {
        return faceValue;
    }
}
