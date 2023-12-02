package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

import javax.swing.*;

public class SuccessDialog {
    public static void SuccessAddedMediaDialog(Media media) {
        String type;
        if (media instanceof Book) {
            type = "Book";
        }
        else if (media instanceof DigitalVideoDisc) {
            type = "DVD";
        }
        else {
            type = "CD";
        }
        JOptionPane.showMessageDialog(null, "The "+ type + " " +  media.getTitle() + " has been added to the store", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
