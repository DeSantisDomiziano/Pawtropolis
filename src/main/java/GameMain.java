import org.java.animals.controller.MapController;
import org.java.animals.controller.MoveController;

import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MapController mapController = MapController.getInstance();
        mapController.createMap();
        MoveController moveController = MoveController.getInstance();
        System.out.println( "the room you are in is : " + MapController.roomMap.get(MoveController.userPosition));



            do {
                System.out.println("Command: 1)go to, 2)get items 3)drop 4)look 5)bag 6)exit");
                String input = scanner.nextLine();

                switch (input) {
                    case "go to":
                        System.out.println("choose direction: go north/south/west/east");
                        String command = scanner.nextLine();
                        moveController.changeRoom(command);
                        break;
                    case "get items":
                        break;
                    case "drop":
                        break;
                    case "look":
                        break;
                    case "bag":
                        break;
                    case "exit":
                        System.out.println("Turn off");
                        System.exit(0);
                    default:
                        System.out.println("Command not found. Repeat the command");
                }
            }while (true);






    }



}
