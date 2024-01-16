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
            System.out.println("Command: 1)go to, 2)get items 3)drop 4)look 5)bag");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    System.out.println("1 = north, 2 = south, 3 = west, 4 = east");
                    int inputPosition = scanner.nextInt();
                    moveController.changeRoom(inputPosition);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("command not found");
            }





    }


}
