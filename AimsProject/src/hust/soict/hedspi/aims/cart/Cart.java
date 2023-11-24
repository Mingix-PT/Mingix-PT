package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBER_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        if (qtyOrdered + dvdList.length <= MAX_NUMBER_ORDERED) {
            for (DigitalVideoDisc digitalVideoDisc : dvdList) {
                itemsOrdered[qtyOrdered] = digitalVideoDisc;
                qtyOrdered++;
            }
            System.out.println("The discs have been added");
        }
        else {
            System.out.println("The cart is almost full");
        }
    }

    public void printDVDList() {
        if (qtyOrdered == 0) {
            System.out.println("The cart is empty");
            return;
        }
        System.out.println("\n***********************CART***********************");
        System.out.println("Ordered items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i+1) + ". " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory() +
                    " - " + itemsOrdered[i].getDirector() + " - " + itemsOrdered[i].getLength() + " : " +
                    itemsOrdered[i].getCost() + "$");
        }
        System.out.printf("Total cost: %.2f\n", totalPrice());
        System.out.println("**************************************************");
    }

    public void searchDVD (int id) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("The disc with ID " + id + " is in the cart:");
                System.out.println(itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory() +
                        " - " + itemsOrdered[i].getDirector() + " - " + itemsOrdered[i].getLength() + " : " +
                        itemsOrdered[i].getCost() + "$");
                return;
            }
        }
        System.out.println("The disc with ID " + id + " is not in the cart");
    }

    public void searchDVD(String title) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("The disc with title \"" + title + "\":");
                System.out.println(itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory() +
                        " - " + itemsOrdered[i].getDirector() + " - " + itemsOrdered[i].getLength() + " : " +
                        itemsOrdered[i].getCost() + "$");
                return;
            }
        }
        System.out.println("The disc with title \"" + title + "\" is not in the cart");
    }

//    public void addDigitalVideoDisc(DigitalVideoDisc... dvd) {
//        if (qtyOrdered + dvd.length <= MAX_NUMBER_ORDERED) {
//            for (DigitalVideoDisc digitalVideoDisc : dvd) {
//                itemsOrdered[qtyOrdered] = digitalVideoDisc;
//                qtyOrdered++;
//            }
//            System.out.println("The discs have been added");
//        }
//        else {
//        System.out.println("The cart is almost full");
//    }
//    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 2 <= MAX_NUMBER_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
            itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered > 0) {
            for (int i = 0; i < qtyOrdered; i++) {
                if (itemsOrdered[i].equals(disc)) {
                    for (int j = i; j < qtyOrdered - 1; j++) {
                        itemsOrdered[j] = itemsOrdered[j + 1];
                    }
                    qtyOrdered--;
                    System.out.println("The disc has been removed");
                    return;
                }
            }
            System.out.println("The disc is not in the cart");
        } else {
            System.out.println("The cart is empty");
        }
    }


    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i+1) + "\t" + itemsOrdered[i].getTitle() + "\t\t" + itemsOrdered[i].getCost());
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public float totalPrice() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}