import java.util.Scanner;
import java.util.HashMap;

public class Chess {

    String[][] board = new String[8][8];
    HashMap<String, String> players = new HashMap<>();

    Chess(Scanner menu) {

        // message d'accueil
        System.out.println(("=== JAVA Chess ==="));
        System.out.println(("Hello Chess"));     

        // variables
        int loop = 0;
        gameLoop(menu, loop);
    }

    // main game loop
    public void gameLoop(Scanner menu, int loop) {
        if (loop == 0) {
            eraseBoard();
            setupBoard();
            updateBoard();
            printBoard();
        } else {
            eraseBoard();
            updateBoard();
            printBoard();
        }

        loop++;
        getUserInput(menu, loop);
        gameLoop(menu, loop);
    }

    // place les pièces dans leur position de départ
    public void setupBoard() {

        // pièces noires
        players.put("BR1" , "a8");
        players.put("BR2" , "h8");
        players.put("BC1" , "b8");
        players.put("BC2" , "g8");
        players.put("BB1" , "c8");
        players.put("BB2" , "f8");
        players.put("BQ1" , "d8");
        players.put("BK1" , "e8");
        players.put("BP1" , "a7");
        players.put("BP2" , "b7");
        players.put("BP3" , "c7");
        players.put("BP4" , "d7");
        players.put("BP5" , "e7");
        players.put("BP6" , "f7");
        players.put("BP7" , "g7");
        players.put("BP8" , "h7");

        // pièces blanches
        players.put("WR1" , "a1");
        players.put("WR2" , "h1");
        players.put("WC1" , "b1");
        players.put("WC2" , "g1");
        players.put("WB1" , "c1");
        players.put("WB2" , "f1");
        players.put("WQ1" , "d1");
        players.put("WK1" , "e1");
        players.put("WP1" , "a2");
        players.put("WP2" , "b2");
        players.put("WP3" , "c2");
        players.put("WP4" , "d2");
        players.put("WP5" , "e2");
        players.put("WP6" , "f2");
        players.put("WP7" , "g2");
        players.put("WP8" , "h2");
    }

    // récupère les coordonnées de la pièce à partir de son string de coordonnée
    public int[] getCoordinates(String coordinates_string) {
        int[] coordinates = new int[2];

        char raw_y = coordinates_string.charAt(0);
        char raw_x = coordinates_string.charAt(1);

        coordinates[0] = getX(raw_x);
        coordinates[1] = getY(raw_y);

        return coordinates;
    }

    // traduit le char x des coordonnées en int x via un switch
    public int getX(char raw_x){
        int x = 0;

        switch (raw_x) {
            case '8':
                x=0;
                break;
            
            case '7':
                x=1;
                break;

            case '6':
                x=2;
                break;

            case '5':
                x=3;
                break;

            case '4':
                x=4;
                break;

            case '3':
                x=5;
                break;

            case '2':
                x=6;
                break;
        
            case '1':
                x=7;
                break;

            default:
                break;
        }

        return x;
    }

    // traduit le char y des coordonnées en int y via un switch
    public int getY(char raw_y){
        int y = 0;

        switch (raw_y) {
            case 'a':
                y=0;
                break;
            
            case 'b':
                y=1;
                break;

            case 'c':
                y=2;
                break;

            case 'd':
                y=3;
                break;

            case 'e':
                y=4;
                break;

            case 'f':
                y=5;
                break;

            case 'g':
                y=6;
                break;
        
            case 'h':
                y=7;
                break;

            default:
                break;
        }

        return y;
    }

    // TODO: met à jour les positions des pièces dans la logique
    public void updateBoard() {
    
        // pour chaque pièce, créé un tableau et récupère les coordonnées dans la tableau
        for (String i : players.keySet()) { 
            int[] c = new int[2]; 
            c = getCoordinates(players.get(i)); 
            board[c[0]][c[1]] = i; 
        }
    }

    // met le plateau logique à 0
    public void eraseBoard() {
        for (int r=0; r<8; r++) {
            for (int c=0; c<8; c++) {
                board[r][c] = "   ";
            }
        }
    }
    
    // print le plateau
    public void printBoard() {
        System.out.println("  =================================================");

        for (int r=0; r<8; r++) {
                        
            System.out.println(""+(board.length-r)+" | "+board[r][0]+" | "+board[r][1]+" | "+board[r][2]+" | "+board[r][3]+" | "+board[r][4]+" | "+board[r][5]+" | "+board[r][6]+" | "+board[r][7]+" |");
            
            if (r!=7) { 
                System.out.println("  |-----|-----|-----|-----|-----|-----|-----|-----|"); 
            }
            
        }

        System.out.println("  =================================================");
        System.out.println("     a     b     c     d     e     f     g     h  ");
    } 

    // récupère les inputs du joueur
    public void getUserInput(Scanner menu, int loop) {

        // Alterne le joueur
        String active_player = "";
        if (loop % 2 > 0) {
            active_player = "Blanc";
        } else {
            active_player = "Noir";
        }

        System.out.println("Tour n°: "+loop+ ". C'est au joueur "+active_player+" de jouer.");
        System.out.println("Sélectionner la pièce à jouer.");
        
        // récupère l'input du joueur, quelle pièce veut-il jouer
        String userInput = menu.nextLine();
        userInput = userInput.toUpperCase();
        boolean input_is_valid = isChessPieceValid(userInput);

        // si l'input ou son format sont invalides, on redemande
        while (userInput.length() != 3 || !input_is_valid) {
            System.out.println("Pièce introuvable ! Sélectionner la pièce à jouer. 3 caractères maximum.(ex: WP1)");
            userInput = menu.nextLine();
            userInput = userInput.toUpperCase();
            input_is_valid = isChessPieceValid(userInput);
        }

        // récupère la pièce dans une variable
        String piece = userInput;

        // on récupère les coordonnées de la destination de la pièce
        System.out.println("Sélectionner où placer la pièce.");
        userInput = menu.nextLine();
        userInput = userInput.toLowerCase();
        boolean input_2_is_valid = areCoordinatesValid(userInput);

        // si l'input ou sont format sont invalides, on redemande
        while (userInput.length() != 2 || !input_2_is_valid) {
            System.out.println("Coordonnées erronées ! Sélectionner où placer la pièce. (ex: A3)");
            userInput = menu.nextLine();
            userInput = userInput.toLowerCase();
            input_2_is_valid = areCoordinatesValid(userInput);
        }

        // assigne les coordonnées à des variables et bouge la pièce à son emplacement
        String point_B = userInput;
        players.put(piece, point_B);
    }

    // vérifie que l'input correspond à une pièce valide 
    public boolean isChessPieceValid(String piece_string) {
        
        if (players.get(piece_string) != null) {
            return true;
        } else {
            return false;
        }
    }
    
    // vérifie que l'input correspond à une coordonnée valide
    public boolean areCoordinatesValid(String coordinates) {
        char raw_char_1 = coordinates.charAt(0);
        char x = Character.toLowerCase(raw_char_1);
        char raw_char_2 = coordinates.charAt(1);
        int y = raw_char_2 - '0';

        if (x != 'a' && x != 'b' && x != 'c' && x != 'd' && x != 'e' && x != 'f' && x != 'g' && x != 'h') {
            return false;
        } 

        if (y != 1 & y != 2 && y != 3 && y != 4 && y != 5 && y != 6 && y != 7 && y != 8) {
            return false;
        } 

        return true;
    }
}
