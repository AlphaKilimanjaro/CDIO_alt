package DTU.Gruppe40;

public class Tile {


    String name = "";
    String text = "";
    int money = 0;


    public Tile(String _name, String _text, int _money)
    {
        name = _name;
        text = _text;
        money = _money;
    }

    public String getTitle() { return name; }
    public String getFlavourText() { return text; }
    public int getGoldValue() { return money; }
}
