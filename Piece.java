public class Piece {
    
    String id;
    String spot;
    String color;
    int[] coordinates = new int[2];

    Piece(String piece_id, String piece_coordinates, String color_string) {
        id = piece_id;
        spot = piece_coordinates;
        color = color_string;
        coordinates = getCoordinates(piece_coordinates);
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
    
}
