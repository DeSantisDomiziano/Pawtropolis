import org.java.animals.controller.ActionController;
import org.java.animals.controller.MapController;
import org.java.animals.controller.MoveController;
import org.java.animals.entity.Item;

import java.util.Scanner;

import static org.java.animals.controller.MapController.roomMap;
import static org.java.animals.controller.MoveController.userPosition;

public class GameMain {
    public static void main(String[] args) {

        ActionController actionController = ActionController.getInstance();
        MapController mapController = MapController.getInstance();
        MoveController moveController = MoveController.getInstance();

        Scanner scanner = new Scanner(System.in);
        mapController.createMap();

        System.out.println("the room you are in is : " + MapController.roomMap.get(MoveController.userPosition));

        do {
            System.out.println("type the number to give the command:\n1)go to\n2)get items\n3)drop\n4)look\n5)bag\n6)exit");
            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    System.out.println("choose direction: go to\n1)north\n2)south\n3)west\n4)east");
                    int command = scanner.nextInt();
                    scanner.nextLine();
                    moveController.changeRoom(command);
                    break;
                case 2:
                    actionController.lookItems();
                    int indexItemToGet = scanner.nextInt();
                    scanner.nextLine();
                    actionController.addItem(roomMap.get(userPosition).getListItem().get(indexItemToGet - 1));
                    break;
                case 3:
                    actionController.lookBag();
                    int indexItemToDrop = scanner.nextInt();
                    scanner.nextLine();
                    Item itemToDrop = actionController.getItemFromBag(indexItemToDrop - 1);
                    actionController.removeItem(itemToDrop);
                    break;
                case 4:
                    actionController.lookRoom();
                    break;
                case 5:
                    actionController.lookBag();
                    break;
                case 6:
                    System.out.println("Turn off");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Command not found. Repeat the command");
            }
        } while (true);

    }
}