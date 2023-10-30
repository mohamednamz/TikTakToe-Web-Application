package Controller;

import TikTakToe.*;
import spark.Request;
import spark.Response;
import spark.Route;

public class AddPlayersToGameController implements Route {

    PlayerInterface playerInterface;
    Server server;

    Queue queue;


    public AddPlayersToGameController(PlayerInterface playerInterface, Server server, Queue<Player> queue) {
        this.playerInterface = playerInterface;
        this.server = server;
    }


    @Override
    public Object handle(Request request, Response response) throws Exception {

        String playerName = request.cookie("name");

        server.joinGame(playerInterface.getPlayer(playerName));


        return "players have joined";
    }
}
