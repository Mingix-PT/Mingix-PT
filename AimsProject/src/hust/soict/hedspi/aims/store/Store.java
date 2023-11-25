package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {
    static final int MAX_ITEMS = 100;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia (Media media) {
        if (itemsInStore.size() == MAX_ITEMS) {
            System.out.println("The store is full");
            return;
        }
        if (itemsInStore.contains(media)) {
            System.out.println("The disc is already in the store");
            return;
        }
        itemsInStore.add(media);
    }

    public void removeMedia (Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The disc has been removed");
        }
        else {
            System.out.println("The disc is not in the store");
        }
    }

//    public void printDVDList() {
//        if (currentItem == 0) {
//            System.out.println("The store is empty");
//            return;
//        }
//        System.out.println("\n***********************STORE***********************");
//        System.out.println("Items in store:");
//        for (int i = 0; i < itemsInStore.length; i++) {
//            if (itemsInStore[i] != null) {
//                System.out.println((i+1) + ". " + itemsInStore[i].getTitle() + " - " + itemsInStore[i].getCategory() +
//                        " - " + itemsInStore[i].getDirector() + " - " + itemsInStore[i].getLength() + " : " +
//                        itemsInStore[i].getCost() + "$");
//            }
//        }
//        System.out.println("**************************************************");
//    }
}