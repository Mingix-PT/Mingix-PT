package hust.soict.hedspi.aims.database;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoreMediaDatabase {
    public static Store getStoreMediaDatabase() {
        List<Media> mediaList = new ArrayList<Media>();
        String fileName = "C:\\Users\\DELL\\IdeaProjects\\OOLT.VN.20231-20215088.LeQuangMinh\\AimsProject\\src\\hust\\soict\\hedspi\\aims\\database\\MediaDatabase.txt";
        File file = new File(fileName);
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String temp = input.nextLine();
                if (temp.equals("Book")) {
                    String title = input.nextLine();
                    String category = input.nextLine();
                    float cost = Float.parseFloat(input.nextLine());
                    Book book = new Book(title, category, cost);
                    int authorNumber = Integer.parseInt(input.nextLine());
                    for (int i = 0; i < authorNumber; i++) {
                        String author = input.nextLine();
                        book.addAuthor(author);
                    }
                    mediaList.add(book);
                }
                else if (temp.equals("CompactDisc")) {
                    String title = input.nextLine();
                    String category = input.nextLine();
                    String artist = input.nextLine();
                    String director = input.nextLine();
                    int length = Integer.parseInt(input.nextLine());
                    float cost = Float.parseFloat(input.nextLine());
                    CompactDisc cd = new CompactDisc(title, category, artist, director, length, cost);
                    int numberTracks = Integer.parseInt(input.nextLine());
                    for (int i = 0; i < numberTracks; i++) {
                        String trackTitle = input.nextLine();
                        int trackLength = Integer.parseInt(input.nextLine());
                        Track track = new Track(trackTitle, trackLength);
                        cd.addTrack(track);
                    }
                    mediaList.add(cd);
                }
                else if (temp.equals("DigitalVideoDisc")) {
                    String title = input.nextLine();
                    String category = input.nextLine();
                    String director = input.nextLine();
                    int length = Integer.parseInt(input.nextLine());
                    float cost = Float.parseFloat(input.nextLine());
                    DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                    mediaList.add(dvd);
                }
                else {
                    break;
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        Store store = new Store();
        for (Media media : mediaList) {
            store.addMedia(media);
        }
        return store;
    }

    public static void updateStoreMediaDatabase(Store store) {
        String fileName = "hust/soict/hedspi/aims/database/MediaDatabase.txt";
        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            List<Media> mediaList = store.getItemsInStore();
            for (Media media : mediaList) {
                if (media instanceof Book) {
                    writer.write("Book\n");
                    writer.write(media.getTitle() + "\n");
                    writer.write(media.getCategory() + "\n");
                    writer.write(media.getCost() + "\n");
                    writer.write(((Book) media).getAuthors().size() + "\n");
                    for (String author : ((Book) media).getAuthors()) {
                        writer.write(author + "\n");
                    }
                }
                else if (media instanceof DigitalVideoDisc) {
                    writer.write("DigitalVideoDisc\n");
                    writer.write(media.getTitle() + "\n");
                    writer.write(media.getCategory() + "\n");
                    writer.write(((DigitalVideoDisc) media).getDirector() + "\n");
                    writer.write(((DigitalVideoDisc) media).getLength() + "\n");
                    writer.write(media.getCost() + "\n");
                }
                else if (media instanceof CompactDisc) {
                    writer.write("CompactDisc\n");
                    writer.write(media.getTitle() + "\n");
                    writer.write(media.getCategory() + "\n");
                    writer.write(((CompactDisc) media).getArtist() + "\n");
                    writer.write(((CompactDisc) media).getDirector() + "\n");
                    writer.write(((CompactDisc) media).getLength() + "\n");
                    writer.write(media.getCost() + "\n");
                    writer.write(((CompactDisc) media).getTrackNumber() + "\n");
                    for (Track track : ((CompactDisc) media).getTrackList()) {
                        writer.write(track.getTitle() + "\n");
                        writer.write(track.getLength() + "\n");
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
