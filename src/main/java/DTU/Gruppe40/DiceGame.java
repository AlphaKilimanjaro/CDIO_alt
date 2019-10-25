package DTU.Gruppe40;

import gui_fields.GUI_Player;
import gui_main.GUI;

public class DiceGame {
    private GUI gui;
    private Boolean gameHasEnded;
    private Player player1, player2;
    private GUI_Player guiPlayer1, guiPlayer2;

    public DiceGame() {
        gui = new GUI();

        gui.showMessage("Welcome to HyperDice, earthlings! :-D");

        player1 = new Player(gui.getUserString("Player 1: What is your name?"));
        player2 = new Player(gui.getUserString("Player 2: What is your name?"));

        gui.addPlayer(guiPlayer1 = new GUI_Player(player1.getName(), 0));
        gui.addPlayer(guiPlayer2 = new GUI_Player(player2.getName(), 0));

        gui.showMessage("Alright, let's get started...");
    }

    public void playDiceGame() {
        gameHasEnded = false;

        while (!gameHasEnded) {
            Boolean nextPlayer = false;
            while(!nextPlayer) {
                gui.getUserString(player1.askThrow());
                gui.showMessage(player1.rollDice());
                gui.setDice(player1.getDieValue1(), player1.getDieValue2());
                nextPlayer = doPlayerConditions(player1);
                updatePoints(player1);
            }
            if(gameHasEnded) continue;
            nextPlayer = false;
            while(!nextPlayer) {
                gui.getUserString(player2.askThrow());
                gui.showMessage(player2.rollDice());
                gui.setDice(player2.getDieValue1(), player2.getDieValue2());
                nextPlayer = doPlayerConditions(player2);
                updatePoints(player2);
            }
        }
    }

    private Boolean doPlayerConditions(Player player) {
        if (player.hasWon()) {
            gui.showMessage(player.getName() + " has won the game!");
            gameHasEnded = true;
            return true;
        } else if (player.hasDoubles()) {
            if (player.hasDoubleOne()) {
                gui.showMessage(player.getName() + " has lost his points :(.");
                player.setPoints(0);
                return false;
            }
            gui.showMessage(player.getName() + " has earned an extra throw! :-D");
            return false;
        }
        return true;
    }

    private void updatePoints(Player player) {
        if(!player.hasDoubleOne())
            player.addPoints();
        guiPlayer1.setBalance(player1.getPoints());
        guiPlayer2.setBalance(player2.getPoints());
    }
}
