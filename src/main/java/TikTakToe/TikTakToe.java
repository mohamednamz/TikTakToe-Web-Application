package TikTakToe;

import java.util.Arrays;

public class TikTakToe {

    static String playerBoard = "";

    static boolean gameOver;
    public String getPlayerBoard() {
        return playerBoard;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    static char Cross = 'X';
    static char Circle = 'O';

    public char[][] getBoard() {
        return board;
    }

    public char[][] playMove(int yCoordinate, int xCoordinate, Player player) {

        if (board[yCoordinate][xCoordinate] != ' ') {
            System.out.println("your opponent is occupying this space, try another move");
            return board;
        }
        board[yCoordinate][xCoordinate] = player.character;

        checkHorizontal(board, player);
        if (player.winner) {
            print(player);
            printBoard(board);
            return board;
        }

        checkVertical(board, player);
        if (player.winner) {
            print(player);
            printBoard(board);
            return board;
        }

        checkDiagonal(board, player);
        if (player.winner) {
            print(player);
            printBoard(board);
            return board;
        }

        printBoard(board);

        return board;
    }

    public static Player checkHorizontal(char[][] board, Player player) {

        for (int i = 0; i < board.length; i++) {
            int counter = 0;

            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != player.character) {
                    break;
                } else {
                    counter++;
                    if (counter == 3) {
                        player.winner = true;
                    }
                }
            }
        }
        return player;
    }

    public static Player checkVertical(char[][] board, Player player) {

        int j = 0;

        for (int i = 0; i < board.length; ) {
            if (j == 3) {
                return player;
            }
            int breakPoint = 0;

            while (breakPoint < board.length) {
                if (board[i][j] != player.character) {
                    j++;
                    break;
                } else {
                    i++;
                    if (i == 3) {
                        player.winner = true;
                    }
                }
                breakPoint++;
            }
        }
        return player;
    }

    public static Player checkDiagonal(char[][] board, Player player) {

        int j = 0;
        int i = 0;
        int x = 2;

        int breakPoint = 0;
        int counterOne = 0;
        int counterTwo = 0;

        while (breakPoint < board.length) {
            if (board[i][j] == player.character) {
                i++;
                j++;
                counterOne++;
            } else {
                if (board[i][x] == player.character) {
                    i++;
                    x--;
                    counterTwo++;
                }
            }
            if (counterOne == 3 || counterTwo == 3) {
                player.winner = true;
                return player;
            }
            breakPoint++;
        }
        return player;
    }

    public static void main(String[] args) {

        TikTakToe exercise = new TikTakToe();
        Player mohamed = new Player();
        mohamed.character = 'X';
        mohamed.name = "Mohamed";

        Player lina = new Player();
        lina.character = 'O';
        lina.name = "Lina";


        exercise.playMove(0, 0, mohamed);
        exercise.playMove(1, 0, mohamed);
        exercise.playMove(2, 0, mohamed);


    }

    public static void print(Player player) {
        gameOver = true;
        System.out.println("TikTakToe.TikTakToe.Game over, " + player.name + " has won the game");
    }

    public static String printBoard(char[][] board) {



        String gridBorder = "------------------------";
        int spaceBetweenEachBarrier = (gridBorder.length() / 4);
        char[] cell = new char[spaceBetweenEachBarrier + 1];
        Arrays.fill(cell, ' ');

        String firstRow = "|" + addPieceToCell(cell, board[0][0]) + "|" + addPieceToCell(cell, board[0][1]) + "|" + addPieceToCell(cell, board[0][2]) + "|";
        String secondRow = "|" + addPieceToCell(cell, board[1][0]) + "|" + addPieceToCell(cell, board[1][1]) + "|" + addPieceToCell(cell, board[1][2]) + "|";
        String thirdRow = "|" + addPieceToCell(cell, board[2][0]) + "|" + addPieceToCell(cell, board[2][1]) + "|" + addPieceToCell(cell, board[2][2]) + "|";

        String renderedBoard = gridBorder + "\n" +
                firstRow + "\n" +
                gridBorder + "\n" +
                secondRow + "\n" +
                gridBorder + "\n" +
                thirdRow + "\n" +
                gridBorder;

        System.out.println(renderedBoard);

        playerBoard = renderedBoard;

        return playerBoard;
    }

    public static String addPieceToCell(char[] cell, char piece) {
        cell[cell.length / 2] = piece;
        return new String(cell);
    }



}
