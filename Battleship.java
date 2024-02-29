public class Battleship extends ConsoleProgram
{
    Player p1 = new Player();
    Player p2 = new Player();
    int turn = 1;

    public void run()
    {
        
        System.out.println("NOW CHOOSING PLAYER 1'S SHIPS");
        p1.chooseShips();
        newScreen();
        System.out.println("NOW CHOOSING PLAYER 2'S SHIPS");
        p2.chooseShips();
        newScreen();
        System.out.println("BOTH PLAYERS HAVE PLACED THEIR SHIPS.");
        while(p1.getNum() > 0 && p2.getNum() > 0) {
            if(turn % 2 == 1) {
                System.out.println("PLAYER 1'S TURN:\nEnemy Grid");
                p2.printOpponentGuesses();
                while(guess(p1, p1.askRow(), p1.askCol()) == false) {
                    System.out.println("ALREADY GUESSED, CHOOSE AGAIN!");
                }
                p2.printOpponentGuesses();
                System.out.println("\nTotal Hits = " + (17-p2.getNum()) + " out of 17.\nHit enter for Player 2's Turn");
                p1.waitForEnter();
                newScreen();
                turn++;
            }
            else {
                System.out.println("PLAYER 2'S TURN:\nEnemy Grid");
                p1.printOpponentGuesses();
                while(guess(p2, p2.askRow(), p2.askCol()) == false) {
                    System.out.println("ALREADY GUESSED, CHOOSE AGAIN!");
                }
                p1.printOpponentGuesses();
                System.out.println("\nTotal Hits = " + (17-p1.getNum()) + " out of 17.\nHit enter for Player 1's Turn");
                p2.waitForEnter();
                newScreen();
                turn++;
            }
        }
        
        newScreen();
        if(p1.getNum() == 0) {
            System.out.println("PLAYER 2 WINS!");
        }
        else {
            System.out.println("PLAYER 1 WINS!");
        }
    }
    
    private boolean guess(Player p, int row, int col) {
        boolean hit;
        if(p == p1) {
            if(p2.checkSpot(row, col) == false) {
                hit = p2.recordOpponentGuess(row, col);
                if(hit) {
                    p1.addGuess(row, col, 1);
                    return true;
                }
                else {
                    p1.addGuess(row, col, 2);
                    return true;
                }
            }
            else {
                return false;
            }
        }
        else {
            System.out.println("CHECKING RIGHT SPOT");
            System.out.println(p1.checkSpot(row, col));
            if(p1.checkSpot(row, col)== false) {
                hit = p1.recordOpponentGuess(row, col);
                if(hit) {
                    p2.addGuess(row, col, 1);
                    return true;
                }
                else {
                    p2.addGuess(row, col, 2);
                    return true;
                }
            }
            else {
                return false;
            }
        }
        
    }
    
    private void newScreen() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    
}
