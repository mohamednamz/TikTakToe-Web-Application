package Controller;

import TikTakToe.Player;
import TikTakToe.PlayerInterface;
import TikTakToe.Server;
import TikTakToe.TikTakToe;
import htmll.PageRenderer;
import spark.Request;
import spark.Response;
import spark.Route;
import TikTakToe.Game;
import TikTakToe.Queue;

public class JoinGameController implements Route {
    PlayerInterface playerInterface;
    Server server;
    PageRenderer pageRenderer;

    public JoinGameController(PlayerInterface playerInterface, Server server, PageRenderer pageRenderer) {
        this.playerInterface = playerInterface;
        this.server = server;
        this.pageRenderer = pageRenderer;
    }


    @Override
    public Object handle(Request request, Response response) throws Exception {

        String playerName = request.cookie("name");

        Player player = playerInterface.getPlayer(playerName);

        if (player.isInGame) {
            Game game = server.getGame(player);

            if (game.isGameOver()) {
                return pageRenderer.renderBoard(game, player);
            } else {

                return pageRenderer.RefreshBoard(game);
            }
        }

        Game game = server.joinGame(player);

        if (game == null) {
            if (player.hasBeenRemoved) {
                player.hasBeenRemoved = false;
                return "Your previous opponent quit, searching for new game";
            } else {
                return "you have been put into a game, waiting for opponent to connect" + "<div> <a href=\"http://localhost//Login?name=" + playerName + "\">" + "Go back to homepage </a> </div>";
            }
        }

        if (game.isNewGame()) {
            game.setNewGame(false);
            return pageRenderer.renderNewBoard();
        }

        return pageRenderer.renderBoard(game, player);
    }


}
