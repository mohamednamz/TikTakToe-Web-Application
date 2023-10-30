package Controller;

import TikTakToe.Player;
import TikTakToe.PlayerInterface;
import htmll.PageRenderer;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;

public class MainPageController implements Route {

    PlayerInterface playerInterface;

    PageRenderer pageRenderer;

    ListOfRoutes listOfRoutes;



    public MainPageController(PlayerInterface playerInterface, PageRenderer pageRenderer, ListOfRoutes listOfRoutes) {
        this.playerInterface = playerInterface;
        this.pageRenderer = pageRenderer;
        this.listOfRoutes = listOfRoutes;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {

        String playerName = request.queryParams("name");

        Player player = playerInterface.getPlayer(playerName);

        response.cookie("name",request.queryParams("name"));

        return pageRenderer.render(listOfRoutes.listOfRoutes());

    }
}
