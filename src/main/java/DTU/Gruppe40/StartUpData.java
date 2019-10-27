package DTU.Gruppe40;

public class StartUpData {


String name;
String text;
int money;
//    String name[] = new String[] {"1","2","3","4","5","6","7","8","9","10","11","12"};
//    String text [] = new String[] {"test1","test2","test3","test4","test5","test6","test7","test8", "test9","test10","test11","test12"};
//    int money [] = new int[] {250,100,100,-20,180,0,-70,60,-80,-50,650};
    Board board;


    private StartUpData(String _name, String _text, int _money) {
        this.name = _name;
        this.text = _text;
        this.money = _money;
    }

    StartUpData[] StartTile =
            {
                    new StartUpData("test","asdf", 250),
            };

    public void setup()
    {
        for (int i = 0; i <= StartTile.length; i++)
            board.tiles[i] = new Tile(StartTile[i].name, StartTile[i].text, StartTile[i].money);

    }

}
