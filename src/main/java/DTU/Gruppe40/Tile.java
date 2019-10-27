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
//    String text [] = new String[] {"test1","test2","test3","test4","test5","test6","test7","test8", "test9","test10","test11","test12"};
//    int money [] = new int[] {250,100,100,-20,180,0,-70,60,-80,-50,650};


//    public void setText(String _text, int placement) {text[placement] = _text; }
//    public void setMoney(int _money, int placement) { money[placement] = _money; }
//
//    public String getText(int placement) { return text[placement]; }
//    public int getMoney(int placement) { return money[placement]; }

    public String getName() { return name; }
    public String getText() { return text; }
    public int getMoney() { return money; }
}
