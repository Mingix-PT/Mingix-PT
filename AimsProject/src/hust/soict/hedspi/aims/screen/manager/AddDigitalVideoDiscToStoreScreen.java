package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private DigitalVideoDisc dvd;
    private String director;
    private int length;
    protected TextField tfDirector = new TextField();
    protected TextField tfLength = new TextField();
    protected Label lbDirector = new Label("Director: ");
    protected Label lbLength = new Label("Length: ");

    protected void setMediaDirector(String director) {
        this.director = director;
    }

    protected void setMediaLength(int length) {
        this.length = length;
    }

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        cp.add(createCenter(), BorderLayout.CENTER);
        setTitle("Add DVD to Store: ");
    }

    JPanel createCenter() {
        JPanel center = super.createCenter();
        center.add(lbDirector);
        center.add(tfDirector);
        center.add(lbLength);
        center.add(tfLength);
        tfDirector.addActionListener(new DirectorInputListener());
        tfLength.addActionListener(new LengthInputListener());
        dvd = (DigitalVideoDisc) media;
        dvd = new DigitalVideoDisc(title, category, director, length, cost);
        store.addMedia(dvd);
        return center;
    }

    private class DirectorInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setMediaDirector(tfDirector.getText());
        }
    }

    private class LengthInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setMediaLength(Integer.parseInt(tfLength.getText()));
        }
    }
}
