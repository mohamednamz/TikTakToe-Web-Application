package htmll;

import Controller.Routes;
import TikTakToe.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PageRenderer {

    char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public String BOARD = """

                     <script src="/JavaScript.js"></script>
                   </head>
            <div id="board">
                   <div>
                       <button>
                           <type="button" id="1", data-y="0", data-x="0" onclick="myFunction(this)">[<INSERT00>]</button>
                       <button>
                           <type="button" id="2", data-y="0", data-x="1" onclick="myFunction(this)">[<INSERT01>]</button>
                       <button>
                           <type="button" id="3", data-y="0", data-x="2" onclick="myFunction(this)">[<INSERT02>]</button>
                   <div>
                   <div>
                       <button>
                           <type="button" id="4", data-y="1", data-x="0" onclick="myFunction(this)">[<INSERT10>]</button>
                       <button>
                           <type="button" id="5", data-y="1", data-x="1" onclick="myFunction(this)">[<INSERT11>]</button>
                       <button>
                           <type="button" id="6", data-y="1", data-x="2" onclick="myFunction(this)">[<INSERT12>]</button>
                   <div>
                   <div>
                       <button>
                           <type="button" id="7", data-y="2", data-x="0" onclick="myFunction(this)">[<INSERT20>]</button>
                       <button>
                           <type="button" id="8", data-y="2", data-x="1" onclick="myFunction(this)">[<INSERT21>]</button>
                       <button>
                           <type="button" id="9", data-y="2", data-x="2" onclick="myFunction(this)">[<INSERT22>]</button>
                   <div>
                   </div>""";

    public static String FAKEBOARD = """
                    
            <div>
                    <div>
                        <button>
                            <type="button" onclick="myFunction(this)">[X]</button>
                        <button>
                            <type="button" onclick="myFunction(this)">[0]</button>
                        <button>
                            <type="button" onclick="myFunction(this)">[ ]</button>
                    <div>
                    <div>
                        <button>
                            <type="button" onclick="myFunction(this)">[ ]</button>
                        <button>
                            <type="button" onclick="myFunction(this)">[ ]</button>
                        <button>
                            <type="button" onclick="myFunction(this)">[ ]</button>
                    <div>
                    <div>
                        <button>
                            <type="button" onclick="myFunction(this)">[ ]</button>
                        <button>
                            <type="button" onclick="myFunction(this)">[ ]</button>
                        <button>
                            <type="button" onclick="myFunction(this)">[ ]</button>
                    <div>
                    </div>""";


    public static String HTML = "<html>\n" +
            "\n" +
            "    <head>\n" +
            "        <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" +
            "        <script src=\"hello.js\"></script>\n" +
            "    </head>\n" +
            "\n" +
            "\n" +
            "    <body>\n" +
            "    <div class=\"container flex-container\">\n" +
            "\n" +
            "        <div class=\"flex-container\">\n" +
            "            <div class=\"icon\">\n" +
            "                <svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 100 100\" width=\"100px\" height=\"100px\" baseProfile=\"basic\"><circle cx=\"13\" cy=\"29\" r=\"2\" fill=\"#ee3e54\"/><circle cx=\"77\" cy=\"13\" r=\"1\" fill=\"#f1bc19\"/><circle cx=\"50\" cy=\"50\" r=\"37\" fill=\"#fce0a2\"/><circle cx=\"83\" cy=\"15\" r=\"4\" fill=\"#f1bc19\"/><circle cx=\"87\" cy=\"24\" r=\"2\" fill=\"#ee3e54\"/><circle cx=\"81\" cy=\"76\" r=\"2\" fill=\"#fbcd59\"/><circle cx=\"15\" cy=\"63\" r=\"4\" fill=\"#fbcd59\"/><circle cx=\"25\" cy=\"87\" r=\"2\" fill=\"#ee3e54\"/><circle cx=\"18.5\" cy=\"53.5\" r=\"2.5\" fill=\"#fff\"/><circle cx=\"21\" cy=\"67\" r=\"1\" fill=\"#f1bc19\"/><circle cx=\"80\" cy=\"34\" r=\"1\" fill=\"#fff\"/><path fill=\"#fc5672\" d=\"M73.163,57.985l-0.004-0.011c-0.927-2.958-11.523-23.62-14.745-29.876 c-1.618-3.171-4.842-5.141-8.414-5.141s-6.795,1.97-8.411,5.134c-3.225,6.263-13.821,26.925-14.752,29.894 c-0.335,1.089-0.692,2.374-0.692,3.842c0,6.137,5.003,11.13,11.152,11.13c5.568,0,10.129-4.036,12.703-6.771 c2.574,2.735,7.135,6.771,12.702,6.771c6.149,0,11.152-4.993,11.152-11.13C73.855,60.359,73.498,59.074,73.163,57.985z M49.999,59.556c-2.648-3.515-4.166-6.914-4.166-9.329c0-2.4,1.869-4.353,4.167-4.353s4.167,1.953,4.167,4.353 C54.167,52.636,52.648,56.035,49.999,59.556z M62.702,68.79c-4.228,0-7.953-3.627-10.011-5.885l0.617-0.818 c2.293-3.041,5.025-7.567,5.025-11.86c0-4.698-3.738-8.52-8.333-8.52s-8.333,3.822-8.333,8.52c0,4.302,2.732,8.826,5.024,11.864 l0.616,0.816c-2.058,2.258-5.783,5.883-10.01,5.883c-3.851,0-6.985-3.123-6.985-6.963c0-0.89,0.251-1.782,0.505-2.607 c0.525-1.675,6.479-13.691,14.481-29.228c0.917-1.796,2.674-2.869,4.703-2.869s3.786,1.072,4.706,2.876 c7.991,15.514,13.939,27.521,14.476,29.215c0.256,0.835,0.507,1.724,0.507,2.612C69.688,65.666,66.554,68.79,62.702,68.79z\"/><path fill=\"#472b29\" d=\"M62.702,73.657c-4.229,0-8.499-2.173-12.701-6.46c-4.202,4.288-8.473,6.46-12.703,6.46 c-6.535,0-11.853-5.307-11.853-11.83c0-1.562,0.373-2.908,0.723-4.047c0.921-2.939,10.656-21.965,14.8-30.009 c1.735-3.4,5.196-5.514,9.032-5.514c3.835,0,7.298,2.116,9.037,5.523c4.142,8.042,13.876,27.066,14.79,29.985l0.005,0.016 c0.35,1.139,0.723,2.485,0.723,4.047C74.555,68.35,69.237,73.657,62.702,73.657z M50.001,65.164l0.51,0.542 c4.091,4.347,8.192,6.55,12.191,6.55c5.764,0,10.452-4.679,10.452-10.43c0-1.365-0.339-2.588-0.658-3.628 c-0.925-2.935-11.487-23.533-14.704-29.78c-1.5-2.938-4.485-4.761-7.792-4.761s-6.29,1.821-7.787,4.752 c-3.221,6.253-13.796,26.875-14.708,29.785c-0.318,1.038-0.659,2.264-0.659,3.632c0,5.751,4.688,10.43,10.452,10.43 c4,0,8.103-2.204,12.193-6.55L50.001,65.164z M62.702,69.49c-3.335,0-6.778-2-10.528-6.113l-0.391-0.429l0.967-1.282 c2.228-2.956,4.883-7.341,4.883-11.439c0-4.312-3.424-7.82-7.633-7.82s-7.633,3.508-7.633,7.82c0,4.107,2.655,8.489,4.882,11.442 l0.967,1.28l-0.392,0.43c-3.748,4.112-7.191,6.112-10.526,6.112c-4.237,0-7.686-3.438-7.686-7.664c0-0.985,0.265-1.93,0.535-2.812 c0.544-1.734,6.381-13.525,14.527-29.343c1.037-2.033,3.028-3.249,5.325-3.249s4.289,1.218,5.33,3.258 c8.129,15.783,13.964,27.567,14.519,29.322c0.273,0.892,0.539,1.839,0.539,2.823C70.388,66.052,66.939,69.49,62.702,69.49z M53.603,62.859c3.312,3.519,6.292,5.23,9.1,5.23c3.466,0,6.285-2.81,6.285-6.263c0-0.791-0.234-1.623-0.475-2.407 c-0.516-1.628-6.584-13.869-14.429-29.1c-0.798-1.564-2.324-2.496-4.084-2.496s-3.285,0.93-4.08,2.487 c-7.86,15.264-13.931,27.51-14.436,29.119c-0.238,0.777-0.472,1.605-0.472,2.397c0,3.454,2.819,6.263,6.285,6.263 c2.808,0,5.788-1.711,9.098-5.229l-0.264-0.349c-2.356-3.124-5.165-7.792-5.165-12.286c0-5.084,4.053-9.22,9.033-9.22 s9.033,4.136,9.033,9.22c0,4.485-2.81,9.155-5.166,12.282L53.603,62.859z M49.999,60.72l-0.56-0.743 c-2.736-3.634-4.307-7.188-4.307-9.75c0-2.787,2.184-5.054,4.867-5.054s4.867,2.267,4.867,5.054c0,2.557-1.57,6.11-4.309,9.75 L49.999,60.72z M50,46.573c-1.912,0-3.467,1.639-3.467,3.653c0,2.095,1.254,5.028,3.466,8.143c2.213-3.12,3.468-6.054,3.468-8.143 C53.467,48.212,51.912,46.573,50,46.573z\"/></svg>\n" +
            "            </div>\n" +
            "\n" +
            "            <div>\n" +
            "                <div class = \"search-bar\">\n" +
            "                    <span type=\"text\"> Start your search here </span>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "        <div>\n" +
            "            <span>Airbnb your home</span>\n" +
            "        </div>\n" +
            "\n" +
            "        <div>\n" +
            "\n" +
            "            <div>\n" +
            "                <svg viewBox=\"0 0 16 16\" xmlns=\"http://www.w3.org/2000/svg\" aria-hidden=\"true\" role=\"presentation\" focusable=\"false\" style=\"display: block; height: 16px; width: 16px; fill: currentcolor;\"><path d=\"m8.002.25a7.77 7.77 0 0 1 7.748 7.776 7.75 7.75 0 0 1 -7.521 7.72l-.246.004a7.75 7.75 0 0 1 -7.73-7.513l-.003-.245a7.75 7.75 0 0 1 7.752-7.742zm1.949 8.5h-3.903c.155 2.897 1.176 5.343 1.886 5.493l.068.007c.68-.002 1.72-2.365 1.932-5.23zm4.255 0h-2.752c-.091 1.96-.53 3.783-1.188 5.076a6.257 6.257 0 0 0 3.905-4.829zm-9.661 0h-2.75a6.257 6.257 0 0 0 3.934 5.075c-.615-1.208-1.036-2.875-1.162-4.686l-.022-.39zm1.188-6.576-.115.046a6.257 6.257 0 0 0 -3.823 5.03h2.75c.085-1.83.471-3.54 1.059-4.81zm2.262-.424c-.702.002-1.784 2.512-1.947 5.5h3.904c-.156-2.903-1.178-5.343-1.892-5.494l-.065-.007zm2.28.432.023.05c.643 1.288 1.069 3.084 1.157 5.018h2.748a6.275 6.275 0 0 0 -3.929-5.068z\"></path></svg>\n" +
            "            </div>\n" +
            "\n" +
            "        </div>\n" +
            "        <div>\n" +
            "            <span>Navigation thing</span>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "<INSERT>" + // PLACE WHERE I WANT TO INSERT
            "<div href=\"https://www.w3schools.com/\">Visit W3Schools.com!</div>\n" +
            "\n" +
            "\n" +
            "    </body>\n" +
            "</html>";


    public String RefreshBoard(Game game) {

        char Cross = 'X';
        char Circle = 'O';

        String renderBoard = BOARD;

        char[][] charBoard = game.getBoard();

        for (int i = 0; i < charBoard.length; i++) {
            for (int j = 0; j < charBoard[i].length; j++) {
                if (charBoard[i][j] == Circle || charBoard[i][j] == Cross) {
                    String object = String.valueOf(charBoard[i][j]);
                    board[i][j] = charBoard[i][j];
                    renderBoard = BOARD.replace("<INSERT" + i + j + ">", object);
                    BOARD = renderBoard;
                }
            }

        }

        BOARD = renderBoard;

        return renderBoard;
    }

    public String render(List<Routes> listOfRoutes) {

        String CARD_HTML = "<div>";

        for (int i = 0; i < listOfRoutes.size(); i++) {

            CARD_HTML += "<a href=\"http://localhost/" + listOfRoutes.get(i).getRoute() + "\">" + listOfRoutes.get(i).getRouteName() + "</a>";
            CARD_HTML += "</div>";
            CARD_HTML += "<div>";
        }

        CARD_HTML += "</div>";

        String renderHTML = HTML.replace("<INSERT>", CARD_HTML);

        return renderHTML;

    }

    public String renderBoard(Game game) {
        if (game.isGameOver()) {
           return BOARD += "<div>" + "Game Over, You Lost" + "</div>";
        }
        return BOARD;
    }

//    public String render(Book[] books) {
//        String CARD_HTML = "<div>";
//
//        for (Book book : books) {
//            CARD_HTML += "<div>" + book.getInfo() + "- " + book.getId();
//            CARD_HTML += "<a href=\"http://localhost/books/borrow?id=" + book.getId() + "\">" + " Borrow book</a>";
//            CARD_HTML += "</div>";
//        }
//
//        CARD_HTML += "<div>";
//        CARD_HTML += "<a href=\"http://localhost/returnToHomepage\">" + " Homepage </a>";
//        CARD_HTML += "</div>";
//
//        CARD_HTML += "</div>";
//
//        String renderedHTML = HTML.replace("<INSERT>", CARD_HTML);
//        return renderedHTML;
//    }
//
//    public String renderReservations(java.util.List<Book> books) {
//        String CARD_HTML = "<div>";
//
//        for (Book book : books) {
//            CARD_HTML += "<div>" + book.getInfo() + "- " + book.getId();
//            CARD_HTML += "<a href=\"http://localhost/books/reserve?id=" + book.getId() + "\">" + " Reserve book </a>";
//            CARD_HTML += "</div>";
//        }
//
//        CARD_HTML += "<div>";
//        CARD_HTML += "<a href=\"http://localhost/returnToHomepage\">" + " Homepage </a>";
//        CARD_HTML += "</div>";
//
//        CARD_HTML += "</div>";
//
//        String renderedHTML = HTML.replace("<INSERT>", CARD_HTML);
//        return renderedHTML;
//    }
//
//    public String renderYourReservations(java.util.List<Book> books) {
//        String CARD_HTML = "<div>";
//
//        for (Book book : books) {
//            CARD_HTML += "<div>" + book.getInfo() + "- " + book.getId();
//            CARD_HTML += "<a href=\"http://localhost/books/cancelReservation?id=" + book.getId() + "\">" + " cancel reservation </a>";
//            CARD_HTML += "</div>";
//        }
//
//        CARD_HTML += "<div>";
//        CARD_HTML += "<a href=\"http://localhost/returnToHomepage\">" + " Homepage </a>";
//        CARD_HTML += "</div>";
//
//        CARD_HTML += "</div>";
//
//        String renderedHTML = HTML.replace("<INSERT>", CARD_HTML);
//        return renderedHTML;
//    }
//
//    public String bookRender(Book book) {
//        String CARD_HTML = "<ul>";
//
//
//        CARD_HTML += "<li>" + book.getInfo() + "</li>";
//
//        CARD_HTML += "<div>";
//        CARD_HTML += "<a href=\"http://localhost/returnToHomepage\">" + " Homepage </a>";
//        CARD_HTML += "</div>";
//
//
//        CARD_HTML += "</ul>";
//
//        String renderedHTML = HTML.replace("<INSERT>", CARD_HTML);
//        return renderedHTML;
//    }
//
//    public String renderList(java.util.List<Book> books, java.util.List<Integer> ids) {
//
//        List convertedlist = new List();
//
//        for (Book book : books) {
//            convertedlist.add(book);
//        }
//
//        return renderList(convertedlist, ids);
//    }
//
//
//    public String renderList(List books, java.util.List<Integer> ids) {
//        String CARD_HTML = "<ul>";
//
//        for (int i = 0; i < books.size(); i++) {
//            CARD_HTML += "<li>" + books.get(i).getInfo() + books.get(i).getId() + "</li>";
//            CARD_HTML += "<a href=\"http://localhost/books/return?id=" + ids.get(i) + "\"> return </a>";
//        }
//
//        CARD_HTML += "</ul>";
//
//        CARD_HTML += "<div>";
//        CARD_HTML += "<a href=\"http://localhost/returnToHomepage\">" + " Homepage </a>";
//        CARD_HTML += "</div>";
//
//        String renderedHTML = HTML.replace("<INSERT>", CARD_HTML);
//        return renderedHTML;
//    }
//
//    public String renderYourListOfReservations(java.util.List<Book> books, java.util.List<Integer> ids) {
//
//        List convertedlist = new List();
//
//        for (Book book : books) {
//            convertedlist.add(book);
//        }
//
//        return renderYourReservations(convertedlist, ids);
//    }
//
//    public String renderYourReservations(List books, java.util.List<Integer> ids) {
//        String CARD_HTML = "<ul>";
//
//        for (int i = 0; i < books.size(); i++) {
//            CARD_HTML += "<li>" + books.get(i).getInfo() + books.get(i).getId() + "</li>";
//            CARD_HTML += "<a href=\"http://localhost/books/cancelReservation?id=" + ids.get(i) + "\"> cancel reservation </a>";
//        }
//
//        CARD_HTML += "</ul>";
//
//        CARD_HTML += "<div>";
//        CARD_HTML += "<a href=\"http://localhost/returnToHomepage\">" + " Homepage </a>";
//        CARD_HTML += "</div>";
//
//        String renderedHTML = HTML.replace("<INSERT>", CARD_HTML);
//        return renderedHTML;
//    }

    public String renderFine(int fine) {
        String CARD_HTML = "<div>";

        CARD_HTML += "<div>" + "You have an outstanding balance of £" + fine;
        CARD_HTML += "<a href=\"http://localhost/books/fines\">" + " pay fine </a>";
        CARD_HTML += "</div>";

        CARD_HTML += "<div>";
        CARD_HTML += "<a href=\"http://localhost/returnToHomepage\">" + " Homepage </a>";
        CARD_HTML += "</div>";

        CARD_HTML += "</div>";

        String renderedHTML = HTML.replace("<INSERT>", CARD_HTML);
        return renderedHTML;
    }

    public String renderMessage(String message) {
        String CARD_HTML = "<div>";

        CARD_HTML += "<div>" + message + "</div>";

        CARD_HTML += "<div>";
        CARD_HTML += "<a href=\"http://localhost/returnToHomepage\">" + " Homepage </a>";
        CARD_HTML += "</div>";

        CARD_HTML += "</div>";

        String renderedHTML = HTML.replace("<INSERT>", CARD_HTML);
        return renderedHTML;
    }


}
