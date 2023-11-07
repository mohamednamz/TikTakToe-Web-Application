package Controller;

import TikTakToe.Player;
import TikTakToe.PlayerInterface;
import TikTakToe.Queue;
import spark.Request;
import spark.Response;
import spark.Route;

public class AddPlayerController implements Route {

    PlayerInterface playerInterface;
    Player player;

    Queue<Player> queue;

    public AddPlayerController(PlayerInterface playerInterface, Player player, Queue<Player> queue) {
        this.playerInterface = playerInterface;
        this.player = player;
        this.queue = queue;
    }


    @Override
    public Object handle(Request request, Response response) throws Exception {

        //playerInterface.addPlayer(player.name);

        queue.insertInQueue(player);

        String message = "player has joined the server";

        return message += "<div> <a href=\"http://192.168.1.15/Lobby\">" + "Go to lobby </a> </div>";


    }
}
