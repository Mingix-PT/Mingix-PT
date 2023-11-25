package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private String director;
    private int length;

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

    public DigitalVideoDisc(String title) {
        super(title);
        nbDigitalVideoDiscs++;
        id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
        nbDigitalVideoDiscs++;
        id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, cost);
        nbDigitalVideoDiscs++;
        id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        nbDigitalVideoDiscs++;
        id = nbDigitalVideoDiscs;
    }

    public boolean isMatch(String keyword) {
        String keywordLowerCase = keyword.toLowerCase();
        String titleLowerCase = title.toLowerCase();
        String[] words = keywordLowerCase.split(" ");
        for (String word : words) {
            if (!titleLowerCase.contains(word)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}