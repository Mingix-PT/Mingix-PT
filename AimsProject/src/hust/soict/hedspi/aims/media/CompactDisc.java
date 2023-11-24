package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc{
    private String artist;
    private List<Track> trackList = new ArrayList<Track>();

    private static int nbCompactDiscs = 0;

    public CompactDisc(String title) {
        super(title);
    }

    public CompactDisc(String title, String category) {
        super(title, category);
    }

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public CompactDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }

    public CompactDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (nbCompactDiscs < 100) {
            if (!trackList.contains(track)) {
                trackList.add(track);
                nbCompactDiscs++;
            }
            else {
                System.out.println("The track " + track.getTitle() + " is already in the list");
            }
        } else {
            System.out.println("The track list is full");
        }
    }

    public void removeTrack(Track track) {
        if (trackList.contains(track)) {
            trackList.remove(track);
            nbCompactDiscs--;
        }
        else {
            System.out.println("The track " + track.getTitle() + " is not in the list");
        }
    }

    public int getLength() {
        int length = 0;
        for (Track track : trackList) {
            length += track.getLength();
        }
        return length;
    }
}
