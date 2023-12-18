package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.database.StoreMediaDatabase;
import hust.soict.hedspi.aims.menu.MenuAction;
import hust.soict.hedspi.aims.menu.MenuDisplay;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.screen.manager.StoreScreenManager;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.naming.LimitExceededException;
import java.util.List;
import java.util.Scanner;

    // Customer view
public class Aims extends Application {
    private static Cart cart;
    private static Store store;
    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);
        Parent parent = fxmlLoader.load();

        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Store");
        primaryStage.show();
    }

    public static void main(String[] args) throws LimitExceededException {
        store = StoreMediaDatabase.getStoreMediaDatabase();
        cart = new Cart();
        launch(args);
    }
}

    // Manager view
//public class Aims {
//    public static void main(String[] args) throws LimitExceededException {
//        Store store = StoreMediaDatabase.getStoreMediaDatabase();
//        Cart cart = new Cart();
//        store.printMediaList();
//        StoreScreenManager storeScreenManager = new StoreScreenManager(store);
//    }
//}
