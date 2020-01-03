public class MineField {
    private int size;
    private Cell[][] cells;
    private Cell[][] cells_display_to_player;

    MineField(int size) {
        this.size = size;
        this.cells = new Cell[this.size][this.size];
        this.cells_display_to_player = new Cell[this.size][this.size];
        this.initializePlayerCells();
    }

    private void initializePlayerCells() {
        for(int i = 0; i < this.size; ++i) {
            for(int j = 0; j < this.size; ++j) {
                this.cells_display_to_player[i][j] = new Cell('x');
            }
        }

    }

    private boolean hasMine(int rowNumber, int columnNumber) {
        return this.cells[rowNumber][columnNumber].hasMine();
    }

    private void flagCell(int rowNumber, int columnNumber) {
        this.cells_display_to_player[rowNumber][columnNumber].setValue('f');
    }

    private void openCell(int rowNumber, int columnNumber) {
        this.cells_display_to_player[rowNumber][columnNumber].setValue('O');
    }

    private boolean checkCellOpened(int rowNumber, int columnNumber) {
        return this.cells_display_to_player[rowNumber][columnNumber].getValue() == 'O';
    }

    private boolean checkFlaggedMineCell(int rowNumber, int columnNumber) {
        if (this.cells[rowNumber][columnNumber].hasMine()) {
            return this.cells_display_to_player[rowNumber][columnNumber].getValue() == 'f';
        } else {
            return false;
        }
    }

    public void initializeMineField(String field) {
        String[] rows = field.split(",");
        for(int i = 0; i < rows.length; ++i) {
            for(int j = 0; j < rows[i].length(); ++j) {
                this.cells[i][j] = new Cell(rows[i].charAt(j));
            }
        }

    }

    public void displayMineField() {
        System.out.println("------Minefield------");
        for(int i = 0; i < this.size; ++i) {
            for(int j = 0; j < this.size; ++j) {
                System.out.print(this.cells_display_to_player[i][j].getValue());
            }

            System.out.println("");
        }

    }

    public boolean hasNoCellToOpen() {
        for(int rowNumber = 0; rowNumber < this.size; ++rowNumber) {
            for(int columnNumber = 0; columnNumber < this.size; ++columnNumber) {
                if (!this.checkCellOpened(rowNumber, columnNumber) && !this.checkFlaggedMineCell(rowNumber, columnNumber)) {
                    return false;
                }
            }
        }

        return true;
    }

    public String runCommand(char commadType, int rowNumber, int columnNumber) {
        switch(commadType) {
        case 'f':
            this.flagCell(rowNumber, columnNumber);
            return "flagged";
        case 'o':
            if (this.hasMine(rowNumber, columnNumber)) {
                return "mine";
            }

            this.openCell(rowNumber, columnNumber);
            return "safe";
        default:
            throw new IllegalStateException("Unexpected value: " + commadType);
        }
    }
}
