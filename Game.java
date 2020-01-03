
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
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Mine Field Layout : ");
        String mineFieldLayout = input.nextLine();
        this.mineField.initializeMineField(mineFieldLayout);
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
        boolean flg = false;
        while(!this.gameOver()) {
            this.mineField.displayMineField();
            Command command = this.player.command();
            if (command != null) {
                String message = this.mineField.runCommand(command.getCommadType(), command.getRowNumber(), command.getColumnNumber());
                if (message.equalsIgnoreCase("mine")) {
                    this.endGame("Oops, you stepped on a mine");
                    flg = true;
                    break;
                }
            }else{
                System.out.println("Entered Wrong Command Format ");
            }
        }
        if(!flg)
            this.endGame("Wow, you cleared the minefield");
    }
}
