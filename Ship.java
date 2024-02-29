public class Ship
{
    private int row = -1;
    private int col = -1;
    private int length = -1;
    private int direction = -1;
    private boolean locSet = false;
    private boolean dirSet = false;
    
    // Direction constants
    private static final int UNSET = -1;
    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;
    
    // Constructor. Create a ship and set the length.
    public Ship(int len) {
        this.length = len;
    }

    // Has the location been initialized
    public boolean isLocationSet() {
        return locSet;
    }

    // Has the direction been initialized
    public boolean isDirectionSet() {
        return dirSet;
    }

    // Set the location of the ship 
    public void setLocation(int r, int column) {
        this.row = r;
        this.col = column;
        locSet = true;
    }

    // Set the direction of the ship
    public void setDirection(int dir) {
        this.direction = dir;
        dirSet = true;
    }

    // Getter for the row value
    public int getRow() {
        return row;
    }

    // Getter for the column value
    public int getCol() {
        return col;
    }

    // Getter for the length of the ship
    public int getLength() {
        return length;
    }

    // Getter for the direction
    public int getDirection() {
        return direction;
    }

    // Helper method to get a string value from the direction
    private String directionToString() {
        if (this.direction == 0) {
            return "horizontal";
        } else if (this.direction == 1) {
            return "vertical";
        } else {
            return "unset direction";
        }
    }

    // Helper method to get a (row, col) string value from the location
    private String locationToString() {
        if (locSet == true){
            return "(" + row + ", " + col + ")";
        } else {
            return "(unset location)";
        }
    }

    // toString value for this Ship
    public String toString() {
        return directionToString() + " ship of length " + length + " at " + locationToString();
    }
}
