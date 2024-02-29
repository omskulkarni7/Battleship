import java.util.*;

public class Player
{
    // These are the lengths of all of the ships.
    private static final int[] SHIP_LENGTHS = {2, 3, 3, 4, 5};
    private static final String[] chars = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private static final String letters = "ABCDEFGHIJ";
    private int numShips = 17;
    private int shipCount = 0; 
    private Grid playerBoard = new Grid();
    private Grid opponentGuesses = new Grid();
    private Scanner input = new Scanner(System.in);

    public void chooseShipLocation(Ship s, int row, int col, int direction){
        s.setLocation(row, col);
        s.setDirection(direction);
        if(shipCount < 5) {
            playerBoard.addShip(s);
            shipCount++;
        }
    }
    
    public int getNum() {
        return numShips;
    }
    
    public void waitForEnter() {
        input.nextLine();
    }
    
    // Print your ships on the grid
    public void printMyShips(){
        playerBoard.printShips();
    }
    
    // Print opponent guesses
    public void printOpponentGuesses(){
        playerBoard.printStatus();
    }
    
    // Print your guesses
    public void printMyGuesses(){
        opponentGuesses.printStatus();
    }
    
    // Record a guess from the opponent
    public boolean recordOpponentGuess(int row, int col){
        if(playerBoard.hasShip(row, col) == true) {
            playerBoard.setStatus(row, col, 1);
            numShips--;
            return true;
        }
        else {
            playerBoard.setStatus(row, col, 2);
            return false;
        }
    }
    
    public boolean checkSpot(int row, int col) {
        return playerBoard.alreadyGuessed(row, col);
    }
    
    public void addGuess(int row, int col, int stat) {
        opponentGuesses.setStatus(row, col, stat);
    }
    
    public void chooseShips() {
        String row;
        int col;
        String dir;
        System.out.println("First you need to choose the location of your ships.\nHit enter to place the next ship.");
        for(int i = 0; i < SHIP_LENGTHS.length; i++) {
            System.out.println("Your current grid of ships.");
            printMyShips();
            System.out.print("Now you need to place a ship of length " + SHIP_LENGTHS[i] + "\nWhich row? (A-J) ");
            row = input.nextLine();
            System.out.print("Which column? (1-10) ");
            col = input.nextInt();
            System.out.print("Horizontal or vertical? (H or V) ");
            input.nextLine();
            dir = input.nextLine();
            
            Ship s = new Ship(SHIP_LENGTHS[i]);
            s.setLocation(letters.indexOf(row), col-1);
            if(dir.equals("H")) {
                s.setDirection(0);
            }
            else {
                s.setDirection(1);
            }
            playerBoard.addShip(s);
            System.out.println();
            
        }
        System.out.println("FINAL BOARD:");
        printMyShips();
        System.out.print("Press Enter to continue");
        input.nextLine();
    }
    
    public int askRow() {
        System.out.print("Which row? (A-J) ");
        return letters.indexOf(input.nextLine());
    }
    
    public int askCol() {
        System.out.print("Which column? (1-10) ");
        return (Integer.valueOf(input.nextLine()))-1;
        
    }
}
