package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

import javax.naming.LimitExceededException;
import java.util.ArrayList;
import java.util.List;

public class Store {
    static final int MAX_ITEMS = 100;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia (Media media) throws LimitExceededException, IllegalArgumentException {
        if (itemsInStore.size() == MAX_ITEMS) {
            System.out.println("The store is full");
            throw new LimitExceededException("ERROR: The number of medias has reached its limit");
        }
        if (itemsInStore.contains(media)) {
            throw new IllegalArgumentException("ERROR: The media is already in the store");
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

    public void printMediaList() {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty");
            return;
        }
        System.out.println("\n***********************STORE***********************");
        System.out.println("Items in store:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i+1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("**************************************************");
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
