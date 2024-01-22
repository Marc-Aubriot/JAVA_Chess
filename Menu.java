import java.util.Scanner;

public class Menu {
    
    // constructor 
    Menu() {
        Scanner menu = new Scanner(System.in);

        System.out.println("=== System Menu ===");
        menuCall(menu);
    }

    // print menu
    public static void menuCall(Scanner menu) {
        System.out.println("Play Chess(P)  Quit(Q)");
        System.out.println("------------------------");

        String answer = menu.nextLine();
        char ans = answer.charAt(0);
        ans = Character.toLowerCase(ans);

        switch (ans) {
            case 'p':
            menu.close(); // prevent memory leak
            new Chess();
                break;
        
            case 'q':
            menu.close(); // prevent memory leak
            System.exit(0);
                break;

            default:
                System.out.println("Answer invalid, options are: ");
                menuCall(menu);
                break;
        }    
    }
}
