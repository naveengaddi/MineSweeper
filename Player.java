import java.util.Scanner;

public class Player {
    private String name;

    public Player(String player_name) {
        this.name = player_name;
    }

    private Command openCell(String command) {
        char commadType = command.charAt(0);
        String[] locations = command.substring(2, command.length() - 1).split(",");
        return new Command(commadType, Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
    }

    private Command flagCell(String command) {
        char commadType = command.charAt(0);
        String[] locations = command.substring(2, command.length() - 1).split(",");
        return new Command(commadType, Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
    }

    public Command command() {
        System.out.println("Commands : o(x,y) | f(x,y) ; where 1<=(x,y)<=size of minefield");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Option ");
        String command = input.nextLine();
        switch(command.charAt(0)) {
        case 'f':
            return this.flagCell(command);
        case 'o':
            return this.openCell(command);
        default:
            System.out.println("Unknown Command");
            return null;
        }
    }
}
