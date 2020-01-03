public class Cell {
    private char value;

    Cell(char value) { 
    	this.value= value;
    }

    boolean hasMine() {
    	if(this.value == 'm'){
    		return true;
    	}else{
    		return false;
    	}
    }
    char getValue() { 
    	return this.value;
    }

    void setValue(char value) {
    	this.value = value;
    }
}