import Controller.*;
import TikTakToe.*;
import htmll.PageRenderer;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

public class Main {

    public static void setUpServer() {
        staticFiles.externalLocation("C:\\Users\\User\\Documents\\Coding Umar\\Teaching-main\\TikTakToe-Web-Application\\src\\Resources");
        port(80);

        exception(Exception.class, (exception, request, response) -> {
            String message = "<div>" + exception.toString() + "</div>";

            StackTraceElement[] trace = exception.getStackTrace();

            for(StackTraceElement stackTrace : trace) {
                message += "<div>" + stackTrace.toString()+ "</div>";
            }
            response.body(message);
        });

        //ArrayList<Integer> list = new ArrayList<>();
        //LinkedList<Integer>
        //Queue<Integer>

    }

    public static void main(String[] args) {

        setUpServer();

        PlayerInterface playerInterface = new PlayerInterface();
        Player player = new Player();

        player.name = "namz";
        player.userId = 1;

        Player player1 = new Player();

        player1.name = "james";
        player1.userId = 2;

        playerInterface.addPlayer("namz");
        playerInterface.addPlayer("umar");

        Queue<Player> queue = new Queue<Player>();

        PageRenderer pageRenderer = new PageRenderer();

        Server server = new Server();

        Game game = new Game();

        ListOfRoutes listOfRoutes = new ListOfRoutes();

        AddPlayerController AddPlayerController = new AddPlayerController(playerInterface,player,queue);

        LobbyController lobbyController = new LobbyController(playerInterface);

        MainPageController mainPageController = new MainPageController(playerInterface, pageRenderer,listOfRoutes);

        JoinGameController joinGameController = new JoinGameController(playerInterface,server, pageRenderer);

        LoginController loginController = new LoginController(playerInterface,mainPageController);

        MakeMoveController makeMoveController = new MakeMoveController(playerInterface,server,pageRenderer);

        get("/Players", AddPlayerController);

        get("/Lobby",lobbyController);

        get("/Login", loginController);

        get("/Login/JoinGame",joinGameController);

        get("/render", new TheGameLoopController(playerInterface,server, pageRenderer));

        get("/makeMove", makeMoveController);


    }

}
