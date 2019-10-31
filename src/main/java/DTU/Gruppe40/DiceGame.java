package DTU.Gruppe40;

import gui_codebehind.GUI_FieldFactory;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.awt.*;

public class DiceGame {

    private Boolean gameHasEnded;
    private Player[] players;
    private final int MAX_PLAYERS = 2;
    private GUI_Player[] guiPlayers;
    private Board board;
    private final int TILES_COUNT = 12;
    private GUI_Field[] guiFields;
    private GUI gui;

    public DiceGame() {
        createBoard();

        guiFields = new GUI_Field[TILES_COUNT];
        for(int i = 0; i < TILES_COUNT; i++){
            Tile tile = board.getTile(i);
            guiFields[i] = new GUI_Street(tile.getTitle(),"", tile.getFlavourText(),"" + tile.getGoldValue(), Color.WHITE, Color.BLACK);
        }

        gui = new GUI(guiFields);


        gui.showMessage("Welcome to HyperDice, earthlings! :-D");

        players = new Player[MAX_PLAYERS];
        guiPlayers = new GUI_Player[MAX_PLAYERS];
        for (int p = 0; p < MAX_PLAYERS; p++) {
            String playerName = gui.getUserString("Player " + (p + 1) + ": What is your name?");
            players[p] = new Player(playerName, 1000);
            gui.addPlayer(guiPlayers[p] = new GUI_Player(playerName, 1000));
        }

        gui.showMessage("Alright, let's get started...");
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
            for(int currentPlayer = 0; currentPlayer < MAX_PLAYERS && !gameHasEnded; currentPlayer++) {
                Boolean nextPlayer = false;
                while (!nextPlayer) {
                    gui.getUserString(players[currentPlayer].getName() + ": Will you roll your dice?...");

                    int roll = players[currentPlayer].rollDice();
                    Tile tile = board.getTile(roll-1);
                    System.out.println(currentPlayer);
                    players[currentPlayer].addPoints(tile.getGoldValue());

                    updateGui(currentPlayer);
                    showTileMessage(tile);

                    nextPlayer = doPlayerConditions(players[currentPlayer]);
                }
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

    private void updateGui(int currentPlayer) {
        //update all cars
        for(int f = 0; f < TILES_COUNT; f++) {
            guiFields[f].removeAllCars();
        }

        for (int p = 0; p < MAX_PLAYERS; p++) {
            guiFields[players[p].getCurrentTile()].setCar(guiPlayers[p], true);
        }

        guiPlayers[currentPlayer].setBalance(players[currentPlayer].getPoints());
        gui.setDice(players[currentPlayer].getDieValue1(), players[currentPlayer].getDieValue2());
    }

    private void showTileMessage(Tile tile) {
        String message = "You have hit " + tile.getTitle() + ": " + tile.getFlavourText() + ". ";
        int gold = tile.getGoldValue();
        if(gold > 0)
            message += "You get " + gold + " points! :-D";
        else if(gold < 0)
            message += "You loose " + gold + " points... :(";
        gui.showMessage(message);
    }
}
