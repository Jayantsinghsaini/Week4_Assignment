/***
 * this is our Main class for number system
 * Name - Jayant Singh
 * Date - 26/09/24
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constant.CHOICES);
        System.out.println(Constant.ENTER_CHOICE);
        String choice = scanner.nextLine();
        switch (choice){
            case "1":
                Methods.conversion();
                break;
            case "2":
                Methods.operation();
                break;
            default:
                System.out.println(Constant.INVALID_CHOICE);
                break;
        }
    }
}

