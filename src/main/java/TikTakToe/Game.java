package TikTakToe;

public class Game {

    Player playerOne;
    Player playerTwo;
    TikTakToe startGame = new TikTakToe();



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


