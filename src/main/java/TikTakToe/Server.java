package TikTakToe;

import java.util.ArrayList;
import java.util.List;

public class Server {

    public Queue<Player> playerQueue = new Queue<Player>();
    private List<Game> listOfGames = new ArrayList<>();

    public Game getFirstGame() {
        return listOfGames.get(0);

    }

    public Game getGame(Player player) {

        for (int i = 0; i < listOfGames.size(); i++) {
            if (listOfGames.get(i).playerOne == player || listOfGames.get(i).playerTwo == player) {
                return listOfGames.get(i);
            }
        }
        return null;
    }


    public synchronized Game joinGame(Player player) {

        if (player.numberOfQuits >= 5) {
            System.out.println("You've been banned for surpassing number of permitted quits");
            return null;
        }

        playerQueue.insertInQueue(player);

        //TODO do i have a list of games? and matches players to know what game is going on.
        if (playerQueue.getSize() == 2) {
            Game game = new Game();
            //game.setGameOver(false);
            game.playerOne = playerQueue.checkQueue(0);
            game.playerOne.character = 'X';
            game.playerOne.isInGame = true;

            game.playerTwo = playerQueue.checkQueue(1);
            game.playerTwo.character = 'O';
            game.playerTwo.isInGame = true;

            listOfGames.add(game);

            printStartGame(game.playerOne, game.playerTwo);

            playerQueue.remove(0);
            playerQueue.dequeue();


            return game;
        }

        return null;
    }

    public void leaveQueue(Player player) {

        playerQueue.removeFromQueue(player);

    }

    public int queueSize() {
        return playerQueue.getSize();
    }

    public void printStartGame(Player playerOne, Player playerTwo) {

        System.out.println(playerOne.name + " will play " + playerTwo.name + " as 'X', " + playerOne.name + " to start");

    }

    public boolean keepScore(int yCoord, int xCoord, Player player) {
        Game game = new Game();

        for (int i = 0; i < listOfGames.size(); i++) {
            if (listOfGames.get(i).playerOne == player || listOfGames.get(i).playerTwo == player) {
                game = listOfGames.get(i);
                break;
            }
        }

        if (game.playerOne.winner) {
            print(game.playerOne);
            return player.winner;
        }
        if (game.playerTwo.winner) {
            print(game.playerTwo);
            return player.winner;
        }

        game.startGame.playMove(yCoord, xCoord, player);

        return player.winner;

    }

    public synchronized Player leaveGame(Player player) {

        Player opponent = new Player();

        for (int i = 0; i < listOfGames.size(); i++) {
            if (listOfGames.get(i).playerOne == player || listOfGames.get(i).playerTwo == player) {
                player.isInGame = false;
                player.numberOfQuits++;
                if (player == listOfGames.get(i).playerOne) {
                    opponent = listOfGames.get(i).playerTwo;
                    listOfGames.get(i).playerOne = null;
                    player.winner = false;
                } else {
                    opponent = listOfGames.get(i).playerOne;
                    player.winner = false;
                    listOfGames.get(i).playerTwo = null;
                }

                if (opponent == null) {
                    listOfGames.remove(listOfGames.get(i));
                }
                break;
            }
        }

        return player;
    }

    private static void print(Player player) {
        System.out.println("TikTakToe.TikTakToe.Game over, " + player.name + " has won the game");
    }


}
