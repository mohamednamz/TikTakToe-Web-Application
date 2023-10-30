package Controller;

import TikTakToe.Game;
import TikTakToe.Player;
import TikTakToe.PlayerInterface;
import TikTakToe.Server;
import htmll.PageRenderer;
import spark.Request;
import spark.Response;
import spark.Route;

import java.awt.print.Pageable;

public class MakeMoveController implements Route {

    PlayerInterface playerInterface;

    Server server;

    PageRenderer pageRenderer;

    public MakeMoveController(PlayerInterface playerInterface, Server server, PageRenderer pageRenderer) {
        this.playerInterface = playerInterface;
        this.server = server;
        this.pageRenderer = pageRenderer;
    }


    @Override
    public Object handle(Request request, Response response) throws Exception {

        String playerName = request.cookie("name");

//        String yCor = request.cookie("y");
//        String xCor = request.cookie("x");

        String yCor = request.queryParams("y");
        String xCor = request.queryParams("x");

        Player player = playerInterface.getPlayer(playerName);

        Game game = server.getGame(player);

        if (game.isGameOver()) {
return pageRenderer.renderBoard(game);
        }

        game.getPlayMove(Integer.parseInt(yCor), Integer.parseInt(xCor), player);


        return pageRenderer.RefreshBoard(game);
    }
}
