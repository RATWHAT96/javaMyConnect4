public class Board {
    public char [][] board;// 2d character array that will be used to represent the game board

    public Board(int i, int j){// method to set the size of the game board
        board = new char[i][j];
    }

    public void printBoard(){// method used to print the game board in the command terminal
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == 'r'){
                    System.out.print("| r ");
                }
                else if(board[i][j] == 'y'){
                    System.out.print("| y ");
                }
                else{
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  1   2   3   4   5   6   7");
    }

    public char[][] board(){// method used to get the 2d character array that represents the board
        return board;
    }

}
