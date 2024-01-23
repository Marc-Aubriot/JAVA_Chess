public class Cavalier extends Piece{
    
    Cavalier(String piece_id, String piece_coordinates, String color) {
        super(piece_id, piece_coordinates, color);
        
    }
 
    public void move(int step) {
        System.out.println("test move");
    }
}