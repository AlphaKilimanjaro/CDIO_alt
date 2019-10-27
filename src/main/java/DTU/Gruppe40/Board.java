package DTU.Gruppe40;

public class Board {

    Tile tile = new Tile();
    Board(int num)
    {
        tile.getMoney(num);
        tile.getText(num);
    }
}
