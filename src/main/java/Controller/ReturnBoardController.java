package Controller;

import TikTakToe.PlayerInterface;
import TikTakToe.Server;
import htmll.PageRenderer;
import spark.Request;
import spark.Response;
import spark.Route;

public class ReturnBoardController implements Route {

    PlayerInterface playerInterface;

    PageRenderer pageRenderer;

    Server server;

    public ReturnBoardController(PlayerInterface playerInterface, PageRenderer pageRenderer, Server server) {
        this.pageRenderer = pageRenderer;
        this.playerInterface = playerInterface;
        this.server = server;
    }


    @Override
    public Object handle(Request request, Response response) throws Exception {
        return PageRenderer.BOARD;
    }
}
