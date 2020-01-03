
import java.util.Scanner;

public class Game {
    private Player player;
    private MineField mineField;
    private String gameOverMessage = " ! Game Over !";

    Game(String playerName, int sizeOfMineField) {
        this.player = new Player(playerName);
        this.mineField = new MineField(sizeOfMineField);
    }

    private void initializeMineField() {
        new Scanner(System.in);
        System.out.println("Enter Mine Field Layout : ");
        this.mineField.initializeMineField("xxm,xmx,xxx");
    }

    private boolean gameOver() {
        return this.mineField.hasNoCellToOpen();
    }

    private void endGame(String message) {
        this.mineField.displayMineField();
        System.out.println(message + this.gameOverMessage);
    }

    public void startGame() {
        this.initializeMineField();

        while(!this.gameOver()) {
            this.mineField.displayMineField();
            Command command = this.player.command();
            if (command != null) {
                String message = this.mineField.runCommand(command.getCommadType(), command.getRowNumber(), command.getColumnNumber());
                if (message.equalsIgnoreCase("mine")) {
                    this.endGame("Oops, you stepped on a mine");
                    break;
                }
            }
        }

        this.endGame("Wow, you cleared the minefield");
    }
}
