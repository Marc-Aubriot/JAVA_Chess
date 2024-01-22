import java.util.Scanner;

public class Chess {
    
    String a8="  ", b8="  ", c8="  ", d8="  ", e8="  ", f8="  ", g8="  ", h8="  ";
    String a7="  ", b7="  ", c7="  ", d7="  ", e7="  ", f7="  ", g7="  ", h7="  ";
    String a6="  ", b6="  ", c6="  ", d6="  ", e6="  ", f6="  ", g6="  ", h6="  ";
    String a5="  ", b5="  ", c5="  ", d5="  ", e5="  ", f5="  ", g5="  ", h5="  ";
    String a4="  ", b4="  ", c4="  ", d4="  ", e4="  ", f4="  ", g4="  ", h4="  ";
    String a3="  ", b3="  ", c3="  ", d3="  ", e3="  ", f3="  ", g3="  ", h3="  ";
    String a2="  ", b2="  ", c2="  ", d2="  ", e2="  ", f2="  ", g2="  ", h2="  ";
    String a1="  ", b1="  ", c1="  ", d1="  ", e1="  ", f1="  ", g1="  ", h1="  ";


    Chess() {
        System.out.println(("=== JAVA Chess ==="));
        System.out.println(("Hello Chess"));

        Scanner userInterface = new Scanner(System.in);
        //String userInput = userInterface.nextLine();
        //userInterface.close(); // prevent memory leak

        printBoard();
        getUserInput(userInterface);
    }

    public void printBoard() {
        System.out.println("  =========================================");
        System.out.println("8 | "+a8+" | "+b8+" | "+c8+" | "+d8+" | "+e8+" | "+f8+" | "+g8+" | "+h8+" |");
        System.out.println("  |----|----|----|----|----|----|----|----|");
        System.out.println("7 | "+a7+" | "+b7+" | "+c7+" | "+d7+" | "+e7+" | "+f7+" | "+g7+" | "+h7+" |");
        System.out.println("  |----|----|----|----|----|----|----|----|");
        System.out.println("6 | "+a6+" | "+b6+" | "+c6+" | "+d6+" | "+e6+" | "+f6+" | "+g6+" | "+h6+" |");
        System.out.println("  |----|----|----|----|----|----|----|----|");
        System.out.println("5 | "+a5+" | "+b5+" | "+c5+" | "+d5+" | "+e5+" | "+f5+" | "+g5+" | "+h5+" |");
        System.out.println("  |----|----|----|----|----|----|----|----|");
        System.out.println("4 | "+a4+" | "+b4+" | "+c4+" | "+d4+" | "+e4+" | "+f4+" | "+g4+" | "+h4+" |");
        System.out.println("  |----|----|----|----|----|----|----|----|");
        System.out.println("3 | "+a3+" | "+b3+" | "+c3+" | "+d3+" | "+e3+" | "+f3+" | "+g3+" | "+h3+" |");
        System.out.println("  |----|----|----|----|----|----|----|----|");
        System.out.println("2 | "+a2+" | "+b2+" | "+c2+" | "+d2+" | "+e2+" | "+f2+" | "+g2+" | "+h2+" |");
        System.out.println("  |----|----|----|----|----|----|----|----|");
        System.out.println("1 | "+a1+" | "+b1+" | "+c1+" | "+d1+" | "+e1+" | "+f1+" | "+g1+" | "+h1+" |");
        System.out.println("  =========================================");
        System.out.println("    a    b    c    d    e    f    g    h  ");
    } 

    public static void getUserInput(Scanner userInterface) {

    }
}
