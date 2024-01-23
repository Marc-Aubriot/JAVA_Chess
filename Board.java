import java.util.HashMap;

public class Board {

    String[][] Board = new String[8][8];
    HashMap<String, String> players = new HashMap<>();

    Piece[] white_pieces = new Piece[16];
    Piece[] black_pieces = new Piece[16];


    Board() {
        setup();
        printInConsole();
    }
    
    // setup le plateau avec les 16 pièces blanches et les 16 pièces noires
    public void setup() {

        // rempli les cases vides avec un string "   "
        for (int r=0; r<8; r++) {
            for (int c=0; c<8; c++) {
                Board[r][c] = "   ";
            }
        }

        // white pieces PAWN line
        String[] white_pawn_id = {"WP1", "WP2", "WP3", "WP4", "WP5", "WP6", "WP7", "WP8"};
        String[] white_pawn_coordinates = {"a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2"};
        for (int i=0; i<white_pawn_coordinates.length; i++) {
            white_pieces[i] = spawnPiece(white_pawn_id[i], white_pawn_coordinates[i], "white", 'p');
        }   

        // white pieces ELITE line
        white_pieces[8] = spawnPiece("WR1", "a1", "white", 'r');
        white_pieces[9] = spawnPiece("WC1", "b1", "white", 'r');
        white_pieces[10] = spawnPiece("WB1", "c1", "white", 'b');
        white_pieces[11] = spawnPiece("WQ1", "d1", "white", 'q');
        white_pieces[12] = spawnPiece("WK1", "e1", "white", 'k');
        white_pieces[13] = spawnPiece("WB2", "f1", "white", 'b');
        white_pieces[14] = spawnPiece("WR2", "g1", "white", 'c');
        white_pieces[15] = spawnPiece("WR2", "h1", "white", 'c');


        // black pieces PAWN
        String[] black_pieces_id = {"BP1", "BP2", "BP3", "BP4", "BP5", "BP6", "BP7", "BP8"};
        String[] black_pawn_coordinates = {"a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7"};
        for (int i=0; i<black_pawn_coordinates.length; i++) {
            black_pieces[i] = spawnPiece(black_pieces_id[i], black_pawn_coordinates[i], "blacl", 'p');
        }   

        // black pieces ELITE line
        black_pieces[8] = spawnPiece("BR1", "a8", "black", 'r');
        black_pieces[9] = spawnPiece("BC1", "b8", "black", 'r');
        black_pieces[10] = spawnPiece("BB1", "c8", "black", 'b');
        black_pieces[11] = spawnPiece("BQ1", "d8", "black", 'q');
        black_pieces[12] = spawnPiece("BK1", "e8", "black", 'k');
        black_pieces[13] = spawnPiece("BB2", "f8", "black", 'b');
        black_pieces[14] = spawnPiece("BR2", "g8", "black", 'c');
        black_pieces[15] = spawnPiece("BR2", "h8", "black", 'c');
      
    }

    // rajoute une pièce à un emplacement
    public Piece spawnPiece(String id, String coordinates, String color, char piece_type) {
        char type = Character.toLowerCase(piece_type);
        Piece new_piece;

        switch (type) {
            case 'p':
                new_piece = new Pawn(id, coordinates, color);
                Board[new_piece.coordinates[0]][new_piece.coordinates[1]] = new_piece.id;
                return new_piece;

            case 'r':
                new_piece = new Rook(id, coordinates, color);
                Board[new_piece.coordinates[0]][new_piece.coordinates[1]] = new_piece.id;
                return new_piece;

            case 'c':
                new_piece = new Cavalier(id, coordinates, color);
                Board[new_piece.coordinates[0]][new_piece.coordinates[1]] = new_piece.id;
                return new_piece;

            case 'b':
                new_piece = new Bishop(id, coordinates, color);
                Board[new_piece.coordinates[0]][new_piece.coordinates[1]] = new_piece.id;
                return new_piece;

            case 'q':
                new_piece = new Queen(id, coordinates, color);
                Board[new_piece.coordinates[0]][new_piece.coordinates[1]] = new_piece.id;
                return new_piece;

            case 'k':
                new_piece = new King(id, coordinates, color);
                Board[new_piece.coordinates[0]][new_piece.coordinates[1]] = new_piece.id;
                return new_piece;

            default:
                System.out.println("error no piece created");
                return null;
        }
    }

    // met le plateau logique à 0
    public void erase() {
        for (int r=0; r<8; r++) {
            for (int c=0; c<8; c++) {
                Board[r][c] = "   ";
            }
        }
    }

    // update le plateau
    public void update() {

    }

    // print le plateau
    public void printInConsole() {
        System.out.println("  =================================================");

        for (int r=0; r<8; r++) {
                        
            System.out.println(""+(Board.length-r)+" | "+Board[r][0]+" | "+Board[r][1]+" | "+Board[r][2]+" | "+Board[r][3]+" | "+Board[r][4]+" | "+Board[r][5]+" | "+Board[r][6]+" | "+Board[r][7]+" |");
            
            if (r!=7) { 
                System.out.println("  |-----|-----|-----|-----|-----|-----|-----|-----|"); 
            }
            
        }

        System.out.println("  =================================================");
        System.out.println("     a     b     c     d     e     f     g     h  ");
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
