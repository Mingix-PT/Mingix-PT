package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.screen.customer.controller.CartController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewCartScreen extends Application {
    private static Cart cart;
    final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";

//    public static void setCart(Cart cart) {
//        TestViewCartScreen.cart = cart;
//    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(CART_FXML_FILE_PATH));
        CartController cartController = new CartController(cart);
        fxmlLoader.setController(cartController);
        Parent parent = fxmlLoader.load();

        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cart");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Cart newCart = new Cart();
        newCart.addMedia(new Book( "The Lion King", "Animation", 19.95f));
        newCart.addMedia(new Book( "Star Wars", "Science Fiction", 24.95f));
        newCart.addMedia(new Book( "Aladdin", "Animation", 18.99f));
        cart = newCart;
        launch(args);
    }
}
