package hust.soict.hedspi.aims.media;

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
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public String playMessage() {
        return "Playing DVD: " + this.getTitle() + "\nDVD length: " + this.getLength();
    }

    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " +
                super.getDirector() + " - " + super.getLength() + " : " + this.getCost() + "$";
    }
}