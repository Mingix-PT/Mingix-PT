package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.database.StoreMediaDatabase;
import hust.soict.hedspi.aims.menu.MenuAction;
import hust.soict.hedspi.aims.menu.MenuDisplay;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.screen.manager.StoreScreenManager;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;

import javax.naming.LimitExceededException;
import java.util.List;
import java.util.Scanner;


public class Aims {
    public static void main(String[] args) throws LimitExceededException {
        Store store = StoreMediaDatabase.getStoreMediaDatabase();
        Cart cart = new Cart();
        store.printMediaList();
        StoreScreenManager storeScreenManager = new StoreScreenManager(store);
    }
}
