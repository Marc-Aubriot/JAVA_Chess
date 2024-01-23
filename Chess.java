import java.util.Scanner;

public class Chess {

    // attributs
    int turn;
    Board board;
    String active_player;
    boolean game;

    Chess(Scanner menu) {

        // message d'accueil
        System.out.println(("=== JAVA Chess ==="));
        System.out.println(("Hello Chess"));     

        // initie les variables
        game = true;
        board = new Board();
        active_player = "white";
        turn = 0;
        gameLoop(menu, board);
    }

    // main game loop
    public void gameLoop(Scanner menu, Board board) {
        nextTurn();
        getUserInput(menu, board);
        board.printInConsole();

        if (game = true) {
            gameLoop(menu, board);
        }
    }

    // récupère les inputs du joueur
    public void getUserInput(Scanner menu, Board board) {

        // récupère l'input du joueur, quelle pièce veut-il jouer
        System.out.println("Sélectionner la pièce à jouer.");
        String userInput = menu.nextLine();
        userInput = userInput.toUpperCase();
        boolean input_is_valid = board.isChessPieceValid(userInput, active_player);

        // si l'input ou son format sont invalides, on redemande
        while (userInput.length() != 3 || !input_is_valid) {
            System.out.println("Pièce introuvable ! Sélectionner la pièce à jouer. 3 caractères maximum.(ex: WP1)");
            userInput = menu.nextLine();
            userInput = userInput.toUpperCase();
            input_is_valid = board.isChessPieceValid(userInput, active_player);
        }

        // récupère la pièce dans une variable
        Piece piece = board.getPiece(userInput, active_player);

        // on récupère les coordonnées de la destination de la pièce
        System.out.println("Sélectionner où placer la pièce.");
        userInput = menu.nextLine();
        userInput = userInput.toLowerCase();
        boolean input_2_is_valid = board.areCoordinatesValid(userInput);

        // si l'input ou sont format sont invalides, on redemande
        while (userInput.length() != 2 || !input_2_is_valid) {
            System.out.println("Coordonnées erronées ! Sélectionner où placer la pièce. (ex: A3)");
            userInput = menu.nextLine();
            userInput = userInput.toLowerCase();
            input_2_is_valid = board.areCoordinatesValid(userInput);
        }

        // assigne les coordonnées à des variables et bouge la pièce à son emplacement
        String point_B = userInput;
        board.movePieceToPoint(piece, point_B);
    }

    // initie le tour suivant
    public void nextTurn() {

        // incremente le tour
        turn++;

        // Alterne le joueur
        if (turn % 2 > 0) {
            active_player = "white";
        } else {
            active_player = "black";
        }

        System.out.println("Tour n°: "+turn+ ". Joueur: "+active_player+".");
    }

}