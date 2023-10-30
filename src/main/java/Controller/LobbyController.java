package Controller;

import TikTakToe.Player;
import TikTakToe.PlayerInterface;
import spark.Request;
import spark.Response;
import spark.Route;

public class LobbyController implements Route {

    PlayerInterface playerInterface;

    public LobbyController(PlayerInterface playerInterface) {
        this.playerInterface = playerInterface;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {

        String html = "";

        for (int i = 0; i < playerInterface.playerList.size(); i++) {
            if (playerInterface.playerList.get(i) != null) {
                String a = " <a href=\"/Login?name=";
                a += playerInterface.playerList.get(i).name + "\">" + "Login " + playerInterface.playerList.get(i).name + "</a>";
                html += a;
            }
        }

        return html;
    }
}
