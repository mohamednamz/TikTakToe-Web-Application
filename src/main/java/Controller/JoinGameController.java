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

            return pageRenderer.RefreshBoard(game);

        }

        Game game = server.joinGame(player);

        if (game == null) {
            return "you have been put into a game, waiting for opponent to connect";
        }
        return pageRenderer.renderBoard(game);
    }


}
