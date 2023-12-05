//package hust.soict.hedspi.test.cart;
//
//import hust.soict.hedspi.aims.cart.Cart;
//import hust.soict.hedspi.aims.media.Book;
//import hust.soict.hedspi.aims.media.CompactDisc;
//import hust.soict.hedspi.aims.media.DigitalVideoDisc;
//import hust.soict.hedspi.aims.media.Media;
//
//public class TestSortCart {
//    public static void main (String[] args) {
//        Cart cart = new Cart();
//        CompactDisc cd = new CompactDisc("CD1", "Rock", 1.1f);
//        DigitalVideoDisc dvd = new DigitalVideoDisc("DVD1", "Horror", 2.1f);
//        Book book = new Book("Book1", "Adventure", 3.1f);
//        cart.addMedia(cd);
//        cart.addMedia(dvd);
//        cart.addMedia(book);
//
//        // Test the sort method
//        System.out.println("Before sorting:");
//        cart.showCart();
//        System.out.println("After sorting by title then cost:");
//        cart.sort(Media.COMPARE_BY_TITLE_COST);
//        cart.showCart();
//        System.out.println("After sorting by cost then title:");
//        cart.sort(Media.COMPARE_BY_COST_TITLE);
//        cart.showCart();
//    }
//}
