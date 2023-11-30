package hust.soict.hedspi.aims.screen.manager;

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
    private CompactDisc cd;
    private String artist;
    private String trackNameTemp;

    private int trackLenthTemp;
    private int length;

    private int numberTracks = 0;
    protected TextField tfArtist = new TextField();
    protected TextField tfNumberTracks = new TextField();
    protected TextField tfLength = new TextField();

    protected TextField tfTrack = new TextField();

    protected TextField tfTrackLength = new TextField();

    protected Label lbArtist = new Label("Artist: ");
    protected Label lbNumberTracks = new Label("Number of tracks: ");
    protected Label lbTracks = new Label("Tracks: ");
    protected Label lbLength = new Label("Length: ");

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        cp.add(createCenter(), BorderLayout.CENTER);
        setTitle("Add CD to Store: ");
    }

    protected void setMediaArtist(String artist) {
        this.artist = artist;
    }

//    protected void setMediaTracks(String track) {
//        this.tracks.add(track);
//    }

    protected void setMediaLength(int length) {
        this.length = length;
    }

    JPanel createCenter() {
        JPanel center = super.createCenter();
        center.add(lbArtist);
        center.add(tfArtist);
        center.add(lbNumberTracks);
        center.add(tfNumberTracks);
        for (int i = 0; i < numberTracks; i++) {
            tfTrack = new TextField();
            center.add(lbTracks);
            center.add(tfTrack);
            tfTrack.addActionListener(new TrackNameInputListener());
            center.add(lbLength);
            center.add(tfTrackLength);
            tfTrackLength.addActionListener(new TrackLengthInputListener());
            Track track = new Track(trackNameTemp, trackLenthTemp);
            cd.addTrack(track);
            length += trackLenthTemp;
        }
        tfArtist.addActionListener(new ArtistInputListener());
        tfNumberTracks.addActionListener(new NumberTracksInputListener());
        cd = (CompactDisc) media;
        cd = new CompactDisc(title, category, artist, length, cost);
        store.addMedia(cd);
        return center;
    }

    private class ArtistInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setMediaArtist(tfArtist.getText());
        }
    }

    private class NumberTracksInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            numberTracks = Integer.parseInt(tfNumberTracks.getText());
        }
    }

    private class TrackNameInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            trackNameTemp = tfTrack.getText();
        }
    }

        private class TrackLengthInputListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                trackLenthTemp = Integer.parseInt(tfTrackLength.getText());
            }
        }
    }
