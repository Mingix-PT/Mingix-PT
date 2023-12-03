package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.database.StoreMediaDatabase;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private StoreScreenManager storeScreenManager;
    private DigitalVideoDisc dvd;
    private String director;
    private int length;
    protected TextField tfDirector = new TextField();
    protected TextField tfLength = new TextField();
    protected Label lbDirector = new Label("Director: ");
    protected Label lbLength = new Label("Length: ");

    public AddDigitalVideoDiscToStoreScreen(Store store, StoreScreenManager storeScreenManager) {
        super(store);
        this.storeScreenManager = storeScreenManager;
        cp.add(createCenter(), BorderLayout.CENTER);
        cp.add(createAddDVDButton(), BorderLayout.NORTH);
        setTitle("Add DVD to Store: ");
    }

    JPanel createCenter() {
        JPanel center = super.createCenter();
        center.add(lbDirector);
        center.add(tfDirector);
        center.add(lbLength);
        center.add(tfLength);
        return center;
    }

    JButton createAddDVDButton() {
        JButton btnAddDVD = new JButton("Add DVD");
        btnAddDVD.setPreferredSize(new Dimension(50, 25));
        btnAddDVD.addActionListener(new AddDVDListener());
        return btnAddDVD;
    }

    private class AddDVDListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dvd = (DigitalVideoDisc) media;
            title = tfTitle.getText();
            category = tfCategory.getText();
            cost = Float.parseFloat(tfCost.getText());
            director = tfDirector.getText();
            length = Integer.parseInt(tfLength.getText());
            dvd = new DigitalVideoDisc(title, category, director, length, cost);
            store.addMedia(dvd);
            StoreMediaDatabase.updateStoreMediaDatabase(store);
            SuccessDialog.SuccessAddedMediaDialog(dvd);
            TurnOff.TurnOffAddMediaScreen(AddDigitalVideoDiscToStoreScreen.this, storeScreenManager);
        }
    }
}
