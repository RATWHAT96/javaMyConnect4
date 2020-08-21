import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;// used to generate random integer to be used as Player 2's move

public class MyConnectFour {

    private BufferedReader input;
    public Board b = new Board(6,7); // Creates new Board object b with 6 rows and 7 columns

    public void playGame(){ // method to call to start playing Connect Four

        input = new BufferedReader(new InputStreamReader(System.in));//used to receive input from the terminal

        //Instructions on how to play game
        System.out.println("Welcome to Connect 4");
        System.out.println("There are 2 players red and yellow");
        System.out.println("Player 1 is Red, Player 2 is Yellow. You are Player 1.");
        System.out.println("To play the game type in the number of the column you want to drop you counter in");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
        System.out.println("");


        b.printBoard();//Board.java method that prints empty game board


        boolean win = false;

        while(!win){//The main game loop

            // player 1
            boolean valid = false;
            while (!valid) {//This while loop is used to ensure that player1 enters a valid input
                // This try and catch is used to prevent invalid inputs from causing a Runtime Error
                try {
                    String userInput = getUserInput(); // getUserInput() is a method defined later on in this class
                    int move = Integer.parseInt(userInput);
                    placeCounter('r', move);//placeCounter is method defined later in this class
                    valid = true;
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid input. Please enter an integer within the range 0-7");
                }
            }
            boolean hasWon = false;

            int count = 0;// Used to check if there are four of the same counters in a row in the array
            for(int i=0; i<b.board().length; i++){// for loop to check for 4 'r' counters in a row horizontally. .board() is a Board.java method
                for(int j=0; j<b.board[i].length; j++){
                    if(b.board()[i][j] == 'r'){
                        count = count + 1;
                        if(count >= 4){// Used to check win condition of four in a row
                            hasWon = true;
                        }
                    }
                    else{
                        count = 0;
                    }
                }
            }

            count = 0;
            for(int i=0; i<b.board[0].length; i++){// for loop to check for 4 'r' counters in a row vertically
                for(int j=0; j<b.board.length; j++){
                    if(b.board[j][i] == 'r'){
                        count = count + 1;
                        if(count >= 4){// Used to check win condition of four in a row
                            hasWon = true;
                        }
                    }
                    else{
                        count = 0;
                    }
                }
            }
            // for loop to check for 4 'r' counters in a row diagonally down and to the right
            for(int i=0; i<3;i++){// loops through the top 3 rows
                for(int j=0; j<4; j++){// loops through the first 4 columns
                    if(b.board[i][j] == 'r' && b.board[i+1][j+1] == 'r' && b.board[i+2][j+2] == 'r' && b.board[i+3][j+3] == 'r'){// Used to check win condition of four in a row
                        hasWon = true;
                    }
                    else{
                        count = 0;
                    }
                }
            }

            // for loop to check for 4 'r' counters in a row diagonally to the left
            for(int i=0; i<3; i++){ // loops through the top 3 rows
                for(int j=b.board.length; j>=3; j--){// loops through the last 4 columns
                    if(b.board[i][j] == 'r' && b.board[i+1][j-1] == 'r' && b.board[i+2][j-2] == 'r' && b.board[i+3][j-3] == 'r'){// Used to check win condition of four in a row
                        hasWon = true;
                    }
                    else{
                        count = 0;
                    }
                }
            }

            b.printBoard();// prints game board to show player 1's move

            if(hasWon){
                win = true;// This will break the game loop
                System.out.println("Player 1 Have Won!!!");
            }

            else{

                //player 2
                Random rnd = new Random();// used to create a Random object
                int random = rnd.nextInt(5);// .nextInt method is used to generate a random integer from 0 to 5 (6 columns)
                placeCounter('y',(random + 1));// random + 1 is used as their 7 columns that the counter can be dropped in
                hasWon = false;

                count = 0;
                for(int i=0; i<b.board.length; i++){// for loop to check for 4 'y' counters in a row horizontally.
                    for(int j=0; j<b.board[i].length; j++){
                        if(b.board[i][j] == 'y'){
                            count = count + 1;
                            if(count >= 4){
                                hasWon = true;
                            }
                        }
                        else{
                            count = 0;
                        }
                    }

                }

                count = 0;
                for(int i=0; i<b.board[0].length; i++){// for loop to check for 4 'y' counters in a row vertically.
                    for(int j=0; j<b.board.length; j++) {
                        if (b.board[j][i] == 'y') {
                            count = count + 1;
                            if (count >= 4) {
                                hasWon = true;
                            }
                        } else {
                            count = 0;
                        }
                    }
                }

                // for loop to check for 4 'y' counters in a row diagonally down and to the right.
                for(int i=0; i<3;i++){
                    for(int j=0; j<4; j++){
                        if(b.board[i][j] == 'y' && b.board[i+1][j+1] == 'y' && b.board[i+2][j+2] == 'y' && b.board[i+3][j+3] == 'y'){
                            hasWon = true;
                        }
                        else{
                            count = 0;
                        }
                    }
                }

                // for loop to check for 4 'y' counters in a row diagonally down and to the left.
                for(int i=0; i<3; i++){
                    for(int j=b.board.length; j>=3; j--){
                        if(b.board[i][j] == 'y' && b.board[i+1][j-1] == 'y' && b.board[i+2][j-2] == 'y' && b.board[i+3][j-3] == 'y'){
                            hasWon = true;
                        }
                        else{
                            count = 0;
                        }
                    }
                }

                System.out.println(random+1);//this will print out the computers choice of column

                b.printBoard();// prints game board to show player 2's move

                if(hasWon){
                    win = true;// This will break the game loop
                    System.out.println("Player 2 has Won!!!");
                }
            }
        }

    }

    public String getUserInput(){// method used to get players 1's input
        String toReturn = null;
        try{
            toReturn = input.readLine();
        }
        catch(Exception e){

        }
        return toReturn;
    }

    public void placeCounter(char player, int position){//method used to place counter in the appropriate place in the game board
        boolean placed = false;

        if(player == 'r'){
            for(int i=b.board.length-1; i>=0; i--){// for loop to handle the placement of 'r' counters
                if(!placed){
                    if(b.board[i][position-1] == 'y'){
                        // skip
                    }
                    else if(b.board[i][position-1] != 'r'){
                        b.board[i][position-1] = 'r';
                        placed = true;
                    }
                }
            }
        }

        else{
            for(int i=b.board.length-1; i>=0; i--){// for loop to handle the placement of 'y' counters
                if(!placed){
                    if(b.board[i][position-1] == 'r'){
                        // skip
                    }
                    else if(b.board[i][position-1] != 'y'){
                        b.board[i][position-1] = 'y';
                        placed = true;
                    }
                }
            }
        }
    }
}
