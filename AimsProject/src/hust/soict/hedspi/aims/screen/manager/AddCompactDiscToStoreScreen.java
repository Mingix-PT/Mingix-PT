package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.database.StoreMediaDatabase;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    protected StoreScreenManager storeScreenManager;
    protected CompactDisc cd;
    protected String artist;
    protected String director;
    protected JButton btnAddCDTrack;
    protected int numberTracks = 0;
    protected TextField tfArtist = new TextField();
    protected TextField tfDirector = new TextField();
    protected TextField tfNumberTracks = new TextField();
    protected Label lbArtist = new Label("Artist: ");
    protected Label lbDirector = new Label("Director: ");
    protected Label lbNumberTracks = new Label("Number of tracks: ");

    public AddCompactDiscToStoreScreen(Store store, StoreScreenManager storeScreenManager) {
        super(store);
        this.storeScreenManager = storeScreenManager;
        cp.add(createCenter(), BorderLayout.CENTER);
        cp.add(createAddCDTrackButton(), BorderLayout.NORTH);
        setTitle("Add CD to Store: ");
    }
    
    JButton createAddCDTrackButton() {
        JButton btnAddCD = new JButton("Add Tracks");
        btnAddCD.setPreferredSize(new Dimension(50, 25));
        btnAddCD.addActionListener(new AddCDTracksListener());
        this.btnAddCDTrack = btnAddCD;
        return btnAddCD;
    }

    JPanel createCenter() {
        JPanel center = super.createCenter();
        center.add(lbArtist);
        center.add(tfArtist);
        center.add(lbDirector);
        center.add(tfDirector);
        center.add(lbNumberTracks);
        center.add(tfNumberTracks);
        return center;
    }

    private class AddCDTracksListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cd = (CompactDisc) media;
            title = tfTitle.getText();
            category = tfCategory.getText();
            cost = Float.parseFloat(tfCost.getText());
            artist = tfArtist.getText();
            director = tfDirector.getText();
            cd = new CompactDisc(title, category, artist, director, cost);
            numberTracks = Integer.parseInt(tfNumberTracks.getText());
            AddTrackToCDScreen addTrackToCDScreen = new AddTrackToCDScreen(store, numberTracks, cd, AddCompactDiscToStoreScreen.this);
        }
    }
}
