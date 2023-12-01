package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.database.StoreMediaDatabase;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTrackToCDScreen extends AddCompactDiscToStoreScreen {
    private CompactDisc cd;
    private int numberTracks;
    private List<Track> tracks = new ArrayList<>();
    private List<TextField> tfTracksName = new ArrayList<>();
    private List<TextField> tfTracksLength = new ArrayList<>();

    public AddTrackToCDScreen(Store store, int numberTracks, CompactDisc cd) {
        super(store);
        this.numberTracks = numberTracks;
        this.cd = cd;
        cp.add(createCenter(), BorderLayout.CENTER);
        setTitle("Add Tracks to CD: ");
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(8, 2));
        for (int i = 0; i < numberTracks; i++) {
            TextField tfTrackName = new TextField();
            TextField tfTrackLength = new TextField();
            Label lbTrackName = new Label("Track " + (i + 1) + " name: ");
            Label lbTrackLength = new Label("Track " + (i + 1) + " length: ");
            tfTracksName.add(tfTrackName);
            tfTracksLength.add(tfTrackLength);
            center.add(lbTrackName);
            center.add(tfTrackName);
            center.add(lbTrackLength);
            center.add(tfTrackLength);
        }
        JButton btnAddCD = new JButton("Add CD");
        center.add(btnAddCD);
        btnAddCD.addActionListener(new AddCDListener());
        return center;
    }

    private class AddCDListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String trackNameTemp;
            int trackLengthTemp;
            int totalLength = 0;
            for (int i = 0; i < numberTracks; i++) {
                trackNameTemp = tfTracksName.get(i).getText();
                trackLengthTemp = Integer.parseInt(tfTracksLength.get(i).getText());
                Track trackTemp = new Track(trackNameTemp, trackLengthTemp);
                tracks.add(trackTemp);
                totalLength += trackLengthTemp;
            }
            cd.setLength(totalLength);
            cd.addTracks(tracks);
            store.addMedia(cd);
            StoreMediaDatabase.updateStoreMediaDatabase(store);
        }
    }
}
