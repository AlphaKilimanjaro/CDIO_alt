package DTU.Gruppe40;

import gui_fields.GUI_Player;
import gui_main.GUI;

public class DiceGame {
    private GUI gui;
    private Boolean gameHasEnded;
    private Player player1, player2;
    private GUI_Player guiPlayer1, guiPlayer2;
    private Board board;

    public DiceGame() {
        gui = new GUI();

        gui.showMessage("Welcome to HyperDice, earthlings! :-D");

        player1 = new Player(gui.getUserString("Player 1: What is your name?"));
        player2 = new Player(gui.getUserString("Player 2: What is your name?"));

        gui.addPlayer(guiPlayer1 = new GUI_Player(player1.getName(), 0));
        gui.addPlayer(guiPlayer2 = new GUI_Player(player2.getName(), 0));

        gui.showMessage("Alright, let's get started...");

        createBoard();
    }

    public void createBoard(){
        board = new Board(12);
        board.addTile("theBlackHole", "Man kan ikke slå 1 med to terninger", 0);
        board.addTile("Tower", "The TwinTowers have been destroyed", 250);
        board.addTile("Crater", "The Crater smells bad, but looks great", -100);
        board.addTile("Palace gates", "The Palace gates looks good but it is not", 100);
        board.addTile("Cold Desert", "The Cold Desert is not cold it is warm", -20);
        board.addTile("Walled City", "Walled City is not very walled", 180);
        board.addTile("Monastery", "Monastery is full of bad boys", 0);
        board.addTile("Black Cave", "Black caves are good ;)", -70);
        board.addTile("Huts in the mountain", "Huts in the mountain sucks!", 60);
        board.addTile("The Warewall", "The werewolf-walls are full of monkeys", -80); //ekstratur
        board.addTile("The Pit", "Let's have beer!", -50);
        board.addTile("Goldmine", "No gold in the mine, sorry!", 650);

    }

    public void playDiceGame() {
        gameHasEnded = false;

        while (!gameHasEnded) {
            Boolean nextPlayer = false;
            while(!nextPlayer) {
                gui.getUserString(player1.askThrow());
                int roll = player1.rollDice();
                Tile tile = board.getTile(roll);
                updatePoints(player1);
                gui.setDice(player1.getDieValue1(), player1.getDieValue2());
                gui.showMessage(tile.getName() + ": " + tile.getText());
                nextPlayer = doPlayerConditions(player1);
            }
            if(gameHasEnded) continue;
            nextPlayer = false;
            while(!nextPlayer) {
                gui.getUserString(player2.askThrow());
                int roll = player2.rollDice();
                Tile tile = board.getTile(roll);
                updatePoints(player2);
                gui.setDice(player2.getDieValue1(), player2.getDieValue2());
                gui.showMessage(tile.getName() + ": " + tile.getText());
                nextPlayer = doPlayerConditions(player2);
            }
        }
    }

    private Boolean doPlayerConditions(Player player) {
        if (player.hasWon()) {
            gui.showMessage(player.getName() + " has won the game!");
            gameHasEnded = true;
            return true;
        } else if (player.hasLost()){
            gui.showMessage(player.getName() + " has lost the game!");
            gameHasEnded = true;
            return true;
        } else if (player.getCurrentTile() == 9) {
            gui.showMessage(player.getName() + " has won an extra throw! :-D");
            return false;
        }
        return true;
    }

    private void updatePoints(Player player) {
        guiPlayer1.setBalance(player1.addPoints(board.getTile(player1.getCurrentTile()).getMoney()));
        guiPlayer2.setBalance(player2.addPoints(board.getTile(player2.getCurrentTile()).getMoney()));
    }
}
