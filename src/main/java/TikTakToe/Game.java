package TikTakToe;

public class Game {

    Player playerOne;
    Player playerTwo;
    TikTakToe startGame = new TikTakToe();

    boolean newGame = true;


    public boolean isNewGame() {
        return newGame;
    }
    public void setNewGame(boolean newGame) {
        this.newGame = newGame;
    }

    public char getLastMove() {
        return startGame.lastMove;
    }

    public void setGameOver(boolean gameOver) {
        startGame.gameOver = gameOver;
    }


    public String getStartGame() {
        return startGame.getPlayerBoard();
    }

    public char[][] getPlayMove(int yCoordinate, int xCoordinate, Player player) {
        return startGame.playMove(yCoordinate,xCoordinate,player);
    }

    public char[][] getBoard() {
        return startGame.getBoard();
    }

    public boolean isGameOver() {
        return startGame.isGameOver();
    }


}


