package hust.soict.hedspi.aims.menu;

import hust.soict.hedspi.aims.database.StoreMediaDatabase;
import hust.soict.hedspi.aims.menu.MenuDisplay;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuAction {
    public static void storeMenuAction (Cart cart, Store store) {
        MenuDisplay.clrscr();
        int choice;
        while (true) {
            MenuDisplay.storeMenu();
            Scanner keyboard = new Scanner(System.in);
            choice = keyboard.nextInt();
            switch (choice) {
                case 0:
                    MenuDisplay.clrscr();
                    return;
                case 1:
                    MenuDisplay.clrscr();
                    System.out.println("Enter the title of the media you want to see: ");
                    keyboard.nextLine();
                    String titleView = keyboard.nextLine();
                    MenuDisplay.clrscr();
                    System.out.println("Media details: ");
                    int countMatchView = 0;
                    Media itemMatchView = null;
                    for (int i = 0; i < store.getItemsInStore().size(); i++) {
                        Media item = store.getItemsInStore().get(i);
                        if (item.getTitle().equals(titleView)) {
                            System.out.println(item.toString());
                            itemMatchView = item;
                            countMatchView++;
                        }
                    }
                    if (countMatchView == 0) {
                        System.out.println("No media found!");
                    }
                    else {
                        mediaDetailsMenuAction(cart, itemMatchView);
                    }
                    break;
                case 2:
                    MenuDisplay.clrscr();
                    System.out.println("Enter the title of the media you want to add to cart: ");
                    keyboard.nextLine();
                    String titleAdd = keyboard.nextLine();
                    MenuDisplay.clrscr();
                    int countMatchAdd = 0;
                    for (int i = 0; i < store.getItemsInStore().size(); i++) {
                        Media item = store.getItemsInStore().get(i);
                        if (item.getTitle().equals(titleAdd)) {
                            cart.addMedia(item);
                            System.out.println("Adding media " + item.getTitle() + " to cart...");
                            countMatchAdd++;
                        }
                    }
                    if (countMatchAdd == 0) {
                        System.out.println("No media found!");
                    }
                    break;
                case 3:
                    MenuDisplay.clrscr();
                    System.out.println("Enter the title of the media you want to play: ");
                    keyboard.nextLine();
                    String titlePlay = keyboard.nextLine();
                    MenuDisplay.clrscr();
                    int countMatchPlay = 0;
                    for (int i = 0; i < store.getItemsInStore().size(); i++) {
                        Media item = store.getItemsInStore().get(i);
                        if (item.getTitle().equals(titlePlay) && item instanceof Playable) {
                            ((Playable) item).play();
                            countMatchPlay++;
                        }
                    }
                    if (countMatchPlay == 0) {
                        System.out.println("No media found!");
                    }
                    break;
                case 4:
                    MenuDisplay.clrscr();
                    System.out.println("Current cart: ");
                    cart.showCart();
                    break;
                default:
                    MenuDisplay.clrscr();
                    System.out.println("Invalid choice! Please choose again!");
                    break;
            }
        }
    }

    public static void mediaDetailsMenuAction (Cart cart, Media item) {
        while (true) {
            MenuDisplay.mediaDetailsMenu();
            Scanner keyboard = new Scanner(System.in);
            int choice = keyboard.nextInt();
            switch (choice) {
                case 0:
                    MenuDisplay.clrscr();
                    return;
                case 1:
                    System.out.println("Cart now has " + cart.getMediaList().size() + " items");
                    MenuDisplay.clrscr();
                    return;
                case 2:
                    if (item instanceof Playable) {
                        ((Playable) item).play();
                    }
                    else {
                        System.out.println("This media is not playable!");
                    }
                    return;
                default:
                    MenuDisplay.clrscr();
                    System.out.println("Invalid choice! Please choose again!");
                    break;
            }
        }
    }

    public static void updateStore (Store store) {
        MenuDisplay.clrscr();
        int choice;
        while (true) {
            MenuDisplay.clrscr();
            MenuDisplay.storeUpdateMenu();
            Scanner keyboard = new Scanner(System.in);
            choice = keyboard.nextInt();
            MenuDisplay.clrscr();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    updateStoreAddChoice(store);
                    break;
                case 2:
                    System.out.println("Enter the title of the media you want to remove from store: ");
                    keyboard.nextLine();
                    String titleRemove = keyboard.nextLine();
                    MenuDisplay.clrscr();
                    int countMatchRemove = 0;
                    for (int i = 0; i < store.getItemsInStore().size(); i++) {
                        Media item = store.getItemsInStore().get(i);
                        if (item.getTitle().equals(titleRemove)) {
                            store.removeMedia(item);
                            System.out.println("Removing media " + item.getTitle() + " from store...");
                            countMatchRemove++;
                            StoreMediaDatabase.updateStoreMediaDatabase(store);
                        }
                    }
                    if (countMatchRemove == 0) {
                        System.out.println("No media found!");
                    }
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again!");
                    break;
            }
        }
    }

    public static void updateStoreAddChoice(Store store) {
        MenuDisplay.clrscr();
        int choice;
        while (true) {
            MenuDisplay.storeUpdateAddMenu();
            Scanner keyboard = new Scanner(System.in);
            choice = keyboard.nextInt();
            MenuDisplay.clrscr();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    System.out.println("Enter the title of the book you want to add to store: ");
                    keyboard.nextLine();
                    String titleAddBook = keyboard.nextLine();
                    System.out.println("Enter the category of the book you want to add to store: ");
                    keyboard.nextLine();
                    String categoryAddBook = keyboard.nextLine();
                    System.out.println("Enter the cost of the book you want to add to store: ");
                    keyboard.nextLine();
                    float costAddBook = keyboard.nextFloat();
                    Book book = new Book(titleAddBook, categoryAddBook, costAddBook);
                    System.out.println("Enter the number of authors of the book you want to add to store: ");
                    keyboard.nextLine();
                    int numAuthorsAddBook = keyboard.nextInt();
                    for (int i = 0; i < numAuthorsAddBook; i++) {
                        System.out.println("Enter the name of author " + (i + 1) + ": ");
                        keyboard.nextLine();
                        String authorAddBook = keyboard.nextLine();
                        book.addAuthor(authorAddBook);
                    }
                    store.addMedia(book);
                    StoreMediaDatabase.updateStoreMediaDatabase(store);
                    System.out.println("Adding book " + book.getTitle() + " to store...");
                    break;
                case 2:
                    System.out.println("Enter the title of the dvd you want to add to store: ");
                    keyboard.nextLine();
                    String titleAddDVD = keyboard.nextLine();
                    System.out.println("Enter the category of the dvd you want to add to store: ");
                    keyboard.nextLine();
                    String categoryAddDVD = keyboard.nextLine();
                    System.out.println("Enter the cost of the dvd you want to add to store: ");
                    keyboard.nextLine();
                    float costAddDVD = keyboard.nextFloat();
                    System.out.println("Enter the director of the dvd you want to add to store: ");
                    keyboard.nextLine();
                    String directorAddDVD = keyboard.nextLine();
                    System.out.println("Enter the length of the dvd you want to add to store: ");
                    keyboard.nextLine();
                    int lengthAddDVD = keyboard.nextInt();
                    DigitalVideoDisc dvd = new DigitalVideoDisc(titleAddDVD, categoryAddDVD, directorAddDVD, lengthAddDVD, costAddDVD);
                    store.addMedia(dvd);
                    StoreMediaDatabase.updateStoreMediaDatabase(store);
                    break;
                case 3:
                    System.out.println("Enter the title of the cd you want to add to store: ");
                    keyboard.nextLine();
                    String titleAddCD = keyboard.nextLine();
                    System.out.println("Enter the category of the cd you want to add to store: ");
                    keyboard.nextLine();
                    String categoryAddCD = keyboard.nextLine();
                    System.out.println("Enter the cost of the cd you want to add to store: ");
                    keyboard.nextLine();
                    float costAddCD = keyboard.nextFloat();
                    System.out.println("Enter the artist of the cd you want to add to store: ");
                    keyboard.nextLine();
                    String artistAddCD = keyboard.nextLine();
                    System.out.println("Enter the length of the cd you want to add to store: ");
                    keyboard.nextLine();
                    int lengthAddCD = keyboard.nextInt();
                    CompactDisc cd = new CompactDisc(titleAddCD, categoryAddCD, artistAddCD, lengthAddCD, costAddCD);
                    System.out.println("Enter the number of tracks of the cd you want to add to store: ");
                    keyboard.nextLine();
                    int numTracksAddCD = keyboard.nextInt();
                    for (int i = 0; i < numTracksAddCD; i++) {
                        System.out.println("Enter the title of track " + (i + 1) + ": ");
                        keyboard.nextLine();
                        String titleAddTrack = keyboard.nextLine();
                        System.out.println("Enter the length of track " + (i + 1) + ": ");
                        keyboard.nextLine();
                        int lengthAddTrack = keyboard.nextInt();
                        Track track = new Track(titleAddTrack, lengthAddTrack);
                        cd.addTrack(track);
                    }
                    store.addMedia(cd);
                    StoreMediaDatabase.updateStoreMediaDatabase(store);
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again!");
                    break;
            }
        }
    }

    public static void cartMenuAction (Cart cart) {
        int choice;
        MenuDisplay.clrscr();
        while (true) {
            MenuDisplay.cartMenu();
            Scanner keyboard = new Scanner(System.in);
            choice = keyboard.nextInt();
            MenuDisplay.clrscr();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    cartFilter(cart);
                    break;
                case 2:
                    cartSort(cart);
                    break;
                case 3:
                    keyboard.nextLine();
                    String titleRemove = keyboard.nextLine();
                    int countMatchRemove = 0;
                    for (int i = 0; i < cart.getMediaList().size(); i++) {
                        Media item = cart.getMediaList().get(i);
                        if (item.getTitle().equals(titleRemove)) {
                            cart.removeMedia(item);
                            System.out.println("Removing media " + item.getTitle() + " from cart...");
                            countMatchRemove++;
                        }
                    }
                    if (countMatchRemove == 0) {
                        System.out.println("No media found!");
                    }
                    break;
                case 4:
                    keyboard.nextLine();
                    String titlePlay = keyboard.nextLine();
                    int countMatchPlay = 0;
                    for (int i = 0; i < cart.getMediaList().size(); i++) {
                        Media item = cart.getMediaList().get(i);
                        if (item.getTitle().equals(titlePlay) && item instanceof Playable) {
                            ((Playable) item).play();
                            countMatchPlay++;
                        }
                    }
                    if (countMatchPlay == 0) {
                        System.out.println("No media found!");
                    }
                    break;
                case 5:
                    System.out.println("An order is created. Total cost: " + cart.totalPrice());
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again!");
                    break;
            }
        }
    }

    public static void cartFilter (Cart cart) {
        MenuDisplay.clrscr();
        int choice;
        while (true) {
            MenuDisplay.cartFilterMenu();
            Scanner keyboard = new Scanner(System.in);
            choice = keyboard.nextInt();
            MenuDisplay.clrscr();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    System.out.println("Enter the title of the media you want to filter: ");
                    keyboard.nextLine();
                    int titleFilterID = keyboard.nextInt();
                    MenuDisplay.clrscr();
                    int countMatchFilterID = 0;
                    for (int i = 0; i < cart.getMediaList().size(); i++) {
                        Media item = cart.getMediaList().get(i);
                        if (item.getId()==titleFilterID) {
                            System.out.println(item.toString());
                            countMatchFilterID++;
                        }
                    }
                    if (countMatchFilterID == 0) {
                        System.out.println("No media found!");
                    }
                    break;
                case 2:
                    System.out.println("Enter the title of the media you want to filter: ");
                    keyboard.nextLine();
                    String titleFilterTitle = keyboard.nextLine();
                    MenuDisplay.clrscr();
                    int countMatchFilterTitle = 0;
                    for (int i = 0; i < cart.getMediaList().size(); i++) {
                        Media item = cart.getMediaList().get(i);
                        if (item.isMatch(titleFilterTitle)) {
                            System.out.println(item.toString());
                            countMatchFilterTitle++;
                        }
                    }
                    if (countMatchFilterTitle == 0) {
                        System.out.println("No media found!");
                    }
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again!");
                    break;
            }
        }
    }

    public static void cartSort (Cart cart) {
        MenuDisplay.clrscr();
        int choice;
        while (true) {
            MenuDisplay.cartSortMenu();
            Scanner keyboard = new Scanner(System.in);
            choice = keyboard.nextInt();
            MenuDisplay.clrscr();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    cart.sort(Media.COMPARE_BY_TITLE_COST);
                    break;
                case 2:
                    cart.sort(Media.COMPARE_BY_COST_TITLE);
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again!");
                    break;
            }
        }
    }
}
