package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBER_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("The disc has been added");
        }
        else {
            System.out.println("The cart is almost full");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The disc has been removed");
        }
        else {
            System.out.println("The disc is not in the cart");
        }
    }

//    public void printDVDList() {
//        if (qtyOrdered == 0) {
//            System.out.println("The cart is empty");
//            return;
//        }
//        System.out.println("\n***********************CART***********************");
//        System.out.println("Ordered items:");
//        for (int i = 0; i < qtyOrdered; i++) {
//            System.out.println((i+1) + ". " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory() +
//                    " - " + itemsOrdered[i].getDirector() + " - " + itemsOrdered[i].getLength() + " : " +
//                    itemsOrdered[i].getCost() + "$");
//        }
//        System.out.printf("Total cost: %.2f\n", totalPrice());
//        System.out.println("**************************************************");
//    }
//
//    public void searchDVD (int id) {
//        for (int i = 0; i < qtyOrdered; i++) {
//            if (itemsOrdered[i].getId() == id) {
//                System.out.println("The disc with ID " + id + " is in the cart:");
//                System.out.println(itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory() +
//                        " - " + itemsOrdered[i].getDirector() + " - " + itemsOrdered[i].getLength() + " : " +
//                        itemsOrdered[i].getCost() + "$");
//                return;
//            }
//        }
//        System.out.println("The disc with ID " + id + " is not in the cart");
//    }
//
//    public void searchDVD(String title) {
//        for (int i = 0; i < qtyOrdered; i++) {
//            if (itemsOrdered[i].isMatch(title)) {
//                System.out.println("The disc with title \"" + title + "\":");
//                System.out.println(itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory() +
//                        " - " + itemsOrdered[i].getDirector() + " - " + itemsOrdered[i].getLength() + " : " +
//                        itemsOrdered[i].getCost() + "$");
//                return;
//            }
//        }
//        System.out.println("The disc with title \"" + title + "\" is not in the cart");
//    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i+1) + "\t" + itemsOrdered.get(i).getTitle() + "\t\t" + itemsOrdered.get(i).getCost());
            total += itemsOrdered.get(i).getCost();
        }
        return total;
    }

    public float totalPrice() {
        float total = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            total += itemsOrdered.get(i).getCost();
        }
        return total;
    }
}