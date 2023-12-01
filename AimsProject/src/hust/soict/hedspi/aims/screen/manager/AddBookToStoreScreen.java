package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.database.StoreMediaDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private Book book;
    private String authorNameTemp;
    private int numberAuthor;

    private TextField tfAuthorName = new TextField();
    private Label lbAuthorName = new Label("Authors' name: ");
    private Label lbNumberAuthor = new Label("Number of authors: ");
    private TextField tfNumberAuthor = new TextField();

    public AddBookToStoreScreen(Store store) {
        super(store);
        cp.add(createCenter(), BorderLayout.CENTER);
        setTitle("Add Book to Store: ");
    }

    JPanel createCenter() {
        JPanel center = super.createCenter();
        center.add(lbAuthorName);
        center.add(tfAuthorName);
        JButton btnAddAuthor = new JButton("Add Book");
        center.add(btnAddAuthor);
        btnAddAuthor.addActionListener(new AddAuthorBtnListener());
        return center;
    }

    private class AddAuthorBtnListener implements ActionListener {
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
        }
    }
}
