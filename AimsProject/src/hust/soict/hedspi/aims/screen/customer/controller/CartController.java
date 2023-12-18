package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class CartController {
    private Cart cart;
    private Store store;
    private StringProperty totalCost;

    public CartController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        totalCost = new SimpleStringProperty(cart.totalCost() + "$");
    }

    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        if (cart.getMediaList() != null) {
            tblMedia.setItems(cart.getObservableMediaList());
        }

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        costLabel.textProperty().bind(totalCost);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observableValue, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String filterText) {
                if (filterText == null || filterText.isEmpty()) {
                    tblMedia.setItems(cart.getObservableMediaList());
                } else {
                    ObservableList<Media> filteredList = cart.getObservableMediaList().filtered(media -> {
                        if (radioBtnFilterId.isSelected()) {
                            return media.getId() == Integer.parseInt(filterText);
                        } else {
                            return media.getTitle().toLowerCase().contains(filterText.toLowerCase());
                        }
                    });
                    tblMedia.setItems(filteredList);
                }
            }
        });
    }

    void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            btnPlay.setVisible(media instanceof Playable);
        }
    }

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        String message = ((Playable) media).playMessage();
        JOptionPane.showMessageDialog(null, message, "Play", JOptionPane.INFORMATION_MESSAGE);
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(selectedMedia);
        tblMedia.setItems(cart.getObservableMediaList());
        totalCost.setValue(cart.totalCost() + "$");
    }

    @FXML
    void placeOrder(ActionEvent event) {
        String confirmMessage = "Do you want to place your order?";
        String yesMessage = "Your order is placed!";
        int select = JOptionPane.showConfirmDialog(null, confirmMessage, "Place order", JOptionPane.YES_NO_OPTION);
        if (select == JOptionPane.YES_OPTION) {
            cart.emptyCart();
            totalCost.setValue(cart.totalCost() + "$");
            tblMedia.setItems(cart.getObservableMediaList());
            JOptionPane.showMessageDialog(null, yesMessage, "Place order", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        final String VIEW_STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(VIEW_STORE_FXML_FILE_PATH));
            ViewStoreController viewStoreController = new ViewStoreController(store, cart);
            fxmlLoader.setController(viewStoreController);
            Parent root = fxmlLoader.load();
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}