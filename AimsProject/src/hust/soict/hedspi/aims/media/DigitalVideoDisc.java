package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

import javax.swing.*;

public class DigitalVideoDisc extends Disc implements Playable {
    public void setTitle(String title) {
        this.title = title;
    }

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        }
        else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }

    @Override
    public String playMessage() throws PlayerException {
        if (this.getLength() > 0) {
            return "Playing DVD: " + this.getTitle() + "\nDVD length: " + this.getLength();
        }
        else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }

    @Override
    public void playOptionPane() throws PlayerException {
        if (this.getLength() > 0) {
            JOptionPane.showMessageDialog(null, this.playMessage());
        }
        else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }


    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " +
                super.getDirector() + " - " + super.getLength() + " : " + this.getCost() + "$";
    }
}