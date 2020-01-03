
public class Command {
    private char commadType;
    private int rowNumber;
    private int columnNumber;

    Command(char commadType, int rowNumber, int columnNumber) {
        this.columnNumber = columnNumber;
        this.commadType = commadType;
        this.rowNumber = rowNumber;
    }

    int getRowNumber() {
        return this.rowNumber;
    }

    int getColumnNumber() {
        return this.columnNumber;
    }

    char getCommadType() {
        return this.commadType;
    }
}
