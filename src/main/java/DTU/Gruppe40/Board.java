package DTU.Gruppe40;

public class Board {

//    Tile tile = new Tile();
    Tile tiles[];

    Board(int num)
    {
//        tile.getMoney();
//        tile.getText();
        tiles[num].getName();
        tiles[num].getText();
        tiles[num].getMoney();
    }



    public void AddTile(String _name, String _text, int _money)
    {
        for (int i = 0; i <= tiles.length; i++)
        {
            if (i > tiles.length)
                tiles[i] = new Tile(_name, _text, _money);
        }
    }
}