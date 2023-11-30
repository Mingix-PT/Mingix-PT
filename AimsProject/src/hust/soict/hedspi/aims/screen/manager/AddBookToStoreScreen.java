package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private Book book;
    private String authorNameTemp;
    private int numberAuthor;

    private TextField tfAuthorName = new TextField();
    private Label lbAuthorName = new Label("Author name: ");
    private Label lbNumberAuthor = new Label("Number of authors: ");
    private TextField tfNumberAuthor = new TextField();

    public AddBookToStoreScreen(Store store) {
        super(store);
        cp.add(createCenter(), BorderLayout.CENTER);
        setTitle("Add Book to Store: ");
    }

    JPanel createCenter() {
        JPanel center = super.createCenter();
        center.add(lbNumberAuthor);
        center.add(tfNumberAuthor);
        tfNumberAuthor.addActionListener(new NumberAuthorInputListener());
        for (int i = 0; i < numberAuthor; i++) {
            tfAuthorName = new TextField();
            center.add(lbAuthorName);
            center.add(tfAuthorName);
            tfAuthorName.addActionListener(new AuthorNameInputListener());
            book.addAuthor(authorNameTemp);
        }
        book = (Book) media;
        book = new Book(title, category, cost);
        store.addMedia(book);
        return center;
    }

    private class NumberAuthorInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            numberAuthor = Integer.parseInt(tfNumberAuthor.getText());
        }
    }

    private class AuthorNameInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            authorNameTemp = tfAuthorName.getText();
        }
    }
}
