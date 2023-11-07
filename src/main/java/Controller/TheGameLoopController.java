package Controller;

import TikTakToe.Player;
import TikTakToe.PlayerInterface;
import TikTakToe.Server;
import htmll.PageRenderer;
import spark.Request;
import spark.Response;
import spark.Route;
import TikTakToe.Game;

public class TheGameLoopController implements Route {


    PlayerInterface playerInterface;

    PageRenderer pageRenderer;

    Server server;

    public TheGameLoopController(PlayerInterface playerInterface, Server server, PageRenderer pageRenderer) {
        this.server = server;
        this.playerInterface = playerInterface;
        this.pageRenderer = pageRenderer;
    }


    @Override
    public Object handle(Request request, Response response) throws Exception {

        String playerName = request.cookie("name");

        Player player = playerInterface.getPlayer(playerName);

        Game game = server.getGame(player);

        if (game.getBoard() == null) {
            return PageRenderer.BOARD;
        }

        if (game.isGameOver()) {
            return pageRenderer.renderBoard(game, player);
        }

        return pageRenderer.RefreshBoard(game, player);

    }
}
