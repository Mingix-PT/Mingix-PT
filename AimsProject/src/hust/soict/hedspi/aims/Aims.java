package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.database.StoreMediaDatabase;
import hust.soict.hedspi.aims.menu.MenuAction;
import hust.soict.hedspi.aims.menu.MenuDisplay;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.screen.manager.StoreScreenManager;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;

import java.util.List;
import java.util.Scanner;


public class Aims {
    public static void main(String[] args) {
        Store store = StoreMediaDatabase.getStoreMediaDatabase();

//        Store store = new Store();
//        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
//        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));

        Cart cart = new Cart();
        store.printMediaList();
        StoreScreenManager storeScreenManager = new StoreScreenManager(store);
//        int choice;
//        while (true) {
//            MenuDisplay.showMenu();
//            Scanner keyboard = new Scanner(System.in);
//            choice = keyboard.nextInt();
//            switch (choice) {
//                case 0:
//                    MenuDisplay.clrscr();
//                    System.out.println("Thanks for using our application!");
//                    System.out.println("Exiting...");
//                    StoreMediaDatabase.updateStoreMediaDatabase(store);
//                    System.exit(0);
//                case 1:
//                    MenuAction.storeMenuAction(cart, store);
//                    break;
//                case 2:
//                    MenuAction.updateStore(store);
//                    break;
//                case 3:
//                    MenuAction.cartMenuAction(cart);
//                    break;
//                default:
//                    MenuDisplay.clrscr();
//                    System.out.println("Invalid choice! Please choose again!");
//                    break;
//            }
//        }
    }
}
