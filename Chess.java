import java.util.Scanner;
import java.util.HashMap;

public class Chess {

    String[][] board = new String[8][8];
    HashMap<String, String> black_player = new HashMap<>();
    HashMap<String, String> white_player = new HashMap<>();

    Chess() {
        System.out.println(("=== JAVA Chess ==="));
        System.out.println(("Hello Chess"));

        Scanner userInterface = new Scanner(System.in);
        //String userInput = userInterface.nextLine();
        //userInterface.close(); // prevent memory leak

        

        // game loop
        // white player
        //updateBoard();
        //getUserInput(userInterface);
        setupBoard();
        eraseBoard();
        updateBoard();
        printBoard();

    }
    // place les pièces dans leur position de départ
    public void setupBoard() {
        black_player.put("BR1" , "a8");
        black_player.put("BR2" , "h8");
        black_player.put("BC1" , "b8");
        black_player.put("BC2" , "g8");
        black_player.put("BB1" , "c8");
        black_player.put("BB2" , "f8");
        black_player.put("BQ1" , "d8");
        black_player.put("BK1" , "e8");
        black_player.put("BP1" , "a7");
        black_player.put("BP2" , "b7");
        black_player.put("BP3" , "c7");
        black_player.put("BP4" , "d7");
        black_player.put("BP5" , "e7");
        black_player.put("BP6" , "f7");
        black_player.put("BP7" , "g7");
        black_player.put("BP8" , "h7");

        white_player.put("WR1" , "a1");
        white_player.put("WR2" , "h1");
        white_player.put("WC1" , "b1");
        white_player.put("WC2" , "g1");
        white_player.put("WB1" , "c1");
        white_player.put("WB2" , "f1");
        white_player.put("WQ1" , "d1");
        white_player.put("WK1" , "e1");
        white_player.put("WP1" , "a2");
        white_player.put("WP2" , "b2");
        white_player.put("WP3" , "c2");
        white_player.put("WP4" , "d2");
        white_player.put("WP5" , "e2");
        white_player.put("WP6" , "f2");
        white_player.put("WP7" , "g2");
        white_player.put("WP8" , "h2");
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
    
        // pour chaque pièce noire, créé un tableau et récupère les coordonnées dans la tableau, puis les 2 premières lettre de la pièce
        for (String i : black_player.keySet()) { 
            int[] c = new int[2]; 
            c = getCoordinates(black_player.get(i)); 
            String sub_string = i.substring(0, 2); 
            board[c[0]][c[1]] = sub_string; 
        }

        // pareil pour les blancs
        for (String i : white_player.keySet()) { 
            int[] c = new int[2]; 
            c = getCoordinates(white_player.get(i)); 
            String sub_string = i.substring(0, 2); 
            board[c[0]][c[1]] = sub_string; 
        }
        
        
    }

    // met le plateau logique à 0
    public void eraseBoard() {
        for (int r=0; r<8; r++) {
            for (int c=0; c<8; c++) {
                board[r][c] = "  ";
            }
        }
    }
    // print le plateau
    public void printBoard() {
        System.out.println("  =========================================");

        for (int r=0; r<8; r++) {
                        
            System.out.println(""+(board.length-r)+" | "+board[r][0]+" | "+board[r][1]+" | "+board[r][2]+" | "+board[r][3]+" | "+board[r][4]+" | "+board[r][5]+" | "+board[r][6]+" | "+board[r][7]+" |");
            
            if (r!=7) { 
                System.out.println("  |----|----|----|----|----|----|----|----|"); 
            }
            
        }

        System.out.println("  =========================================");
        System.out.println("    a    b    c    d    e    f    g    h  ");
    } 

    // TODO: récupère les inputs du joueur
    public static void getUserInput(Scanner userInterface) {

    }
}
