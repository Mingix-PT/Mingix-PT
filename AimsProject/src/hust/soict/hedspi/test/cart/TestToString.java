package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class TestToString {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();
        CompactDisc cd = new CompactDisc("CD1", "Rock", 1.1f);
        DigitalVideoDisc dvd = new DigitalVideoDisc("DVD1", "Horror", 1.1f);
        Book book = new Book("Book1", "Adventure", 1.1f);
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);
        for (Media media : mediae) {
            System.out.println(media.toString());
        }
    }
}
