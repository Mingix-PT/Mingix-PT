package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.database.StoreMediaDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private StoreScreenManager storeScreenManager;
    private Book book;
    private String authorNameTemp;

    private TextField tfAuthorName = new TextField();
    private Label lbAuthorName = new Label("Authors' name: ");

    public AddBookToStoreScreen(Store store, StoreScreenManager storeScreenManager) {
        super(store);
        this.storeScreenManager = storeScreenManager;
        cp.add(createCenter(), BorderLayout.CENTER);
        setTitle("Add Book to Store: ");
    }

    JPanel createCenter() {
        JPanel center = super.createCenter();
        center.add(lbAuthorName);
        center.add(tfAuthorName);
        JButton btnAddAuthor = new JButton("Add Book");
        center.add(btnAddAuthor);
        btnAddAuthor.addActionListener(new AddBookBtnListener());
        return center;
    }

    private class AddBookBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            book = (Book) media;
            title = tfTitle.getText();
            category = tfCategory.getText();
            cost = Float.parseFloat(tfCost.getText());
            book = new Book(title, category, cost);
            authorNameTemp = tfAuthorName.getText();
            String[] authorsName = authorNameTemp.split(",");
            for (String authorName : authorsName) {
                book.addAuthor(authorName);
            }
            store.addMedia(book);
            StoreMediaDatabase.updateStoreMediaDatabase(store);
            SuccessDialog.SuccessAddedMediaDialog(book);
            TurnOff.TurnOffAddMediaScreen(AddBookToStoreScreen.this, storeScreenManager);
        }
    }
}
