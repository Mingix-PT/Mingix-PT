package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.cart.Cart;

import java.util.Objects;

public class Store {
    static final int MAX_ITEMS = 100;
    static int currentItem = 0;
    DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEMS];
    public void addDVD (DigitalVideoDisc disc) {
        if (currentItem == MAX_ITEMS) {
            System.out.println("The store is full");
            return;
        }
        for (int i = 0; i < itemsInStore.length; i++) {
            if (itemsInStore[i] == null) {
                itemsInStore[i] = disc;
                System.out.println("The disc has been added");
                currentItem++;
                return;
            }
        }
    }

    public void removeDVD (DigitalVideoDisc disc) {
        for (int i = 0; i < itemsInStore.length; i++) {
            if (itemsInStore[i].getTitle().equals(disc.getTitle())) {
                itemsInStore[i] = null;
                System.out.println("The disc has been removed");
                currentItem--;
                return;
            }
        }
        System.out.println("The disc is not in the store");
    }

    public void printDVDList() {
        if (currentItem == 0) {
            System.out.println("The store is empty");
            return;
        }
        System.out.println("\n***********************STORE***********************");
        System.out.println("Items in store:");
        for (int i = 0; i < itemsInStore.length; i++) {
            if (itemsInStore[i] != null) {
                System.out.println((i+1) + ". " + itemsInStore[i].getTitle() + " - " + itemsInStore[i].getCategory() +
                        " - " + itemsInStore[i].getDirector() + " - " + itemsInStore[i].getLength() + " : " +
                        itemsInStore[i].getCost() + "$");
            }
        }
        System.out.println("**************************************************");
    }
}
