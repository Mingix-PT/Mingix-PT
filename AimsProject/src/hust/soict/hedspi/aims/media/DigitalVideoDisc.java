package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }


    public void setTitle(String title) {
        this.title = title;
    }

//    public DigitalVideoDisc(String title) {
//        super(title);
//        nbDigitalVideoDiscs++;
//        id = nbDigitalVideoDiscs;
//    }
//
//    public DigitalVideoDisc(String title, String category, float cost) {
//        super(title, category, cost);
//        nbDigitalVideoDiscs++;
//        id = nbDigitalVideoDiscs;
//    }
//
//    public DigitalVideoDisc(String title, String category, String director, float cost) {
//        super(title, category, director, cost);
//        nbDigitalVideoDiscs++;
//        id = nbDigitalVideoDiscs;
//    }

//    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
//        super(title, category, director, length, cost);
//        nbDigitalVideoDiscs++;
//        id = nbDigitalVideoDiscs;
//    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " +
                super.getDirector() + " - " + super.getLength() + " : " + this.getCost() + "$";
    }
}