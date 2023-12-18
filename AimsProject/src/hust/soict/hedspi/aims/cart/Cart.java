package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.naming.LimitExceededException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) throws LimitExceededException, IllegalArgumentException {
        if (itemsOrdered.size() == MAX_NUMBER_ORDERED) {
            throw new LimitExceededException("ERROR: The number of medias has reached its limit");
        }
        if (itemsOrdered.contains(media)) {
            throw new IllegalArgumentException("ERROR: The media is already in the cart");
        }
        itemsOrdered.add(media);
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

    public void showCart() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty");
            return;
        }
        System.out.println("***********************CART***********************");
        System.out.println("Ordered items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i+1) + ". "  + itemsOrdered.get(i).toString());
        }
        System.out.printf("Total cost: %.2f\n", totalPrice());
        System.out.println("**************************************************");

    }

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

    public void sort(Comparator<Media> comparator) {
        Collections.sort(itemsOrdered, comparator);
    }

    public List<Media> getMediaList () {
        return itemsOrdered;
    }

    public ObservableList<Media> getObservableMediaList() {
        return FXCollections.observableArrayList(itemsOrdered);
    }

    public void emptyCart() {
        itemsOrdered.clear();
    }
}