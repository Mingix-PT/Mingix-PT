package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title) {
        this.title = title;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }

    @Override
    public String playMessage() throws PlayerException {
        if (this.getLength() > 0) {
            return "Playing track: " + this.getTitle() + "\nTrack length: " + this.getLength();
        } else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }

    @Override
    public void playOptionPane() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println(this.playMessage());
        } else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof Track track) {
            return track.getTitle().equals(this.getTitle()) && track.getLength() == this.getLength();
        }
        return false;
    }
}
