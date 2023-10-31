package Controller;

import TikTakToe.Game;
import TikTakToe.Player;
import TikTakToe.PlayerInterface;
import TikTakToe.Server;
import htmll.PageRenderer;
import spark.Request;
import spark.Response;
import spark.Route;

public class LeaveGameController implements Route {

    PlayerInterface playerInterface;
    PageRenderer pageRenderer;
    Server server;

    public LeaveGameController(PlayerInterface playerInterface, PageRenderer pageRenderer, Server server) {
        this.playerInterface = playerInterface;
        this.pageRenderer = pageRenderer;
        this.server = server;
    }


    @Override
    public Object handle(Request request, Response response) throws Exception {

        String playerName = request.cookie("name");

        Player player = playerInterface.getPlayer(playerName);

        Game game = server.getGame(player);

        server.leaveGame(player);

        if (game.isGameOver()) {
            return "You've left the game" + "<div> <a href=\"http://localhost//Login?name=" + playerName + "\">" + "Go back to homepage </a> </div>";
        }

        return "Leaving during a game is bad sportsmanship, you may get banned" + "<div> <a href=\"http://localhost//Login?name=" + playerName + "\">" + "Go back to homepage </a> </div>";

    }




}
