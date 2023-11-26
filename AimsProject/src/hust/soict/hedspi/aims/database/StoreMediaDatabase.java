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
        String data = new String();
        List<Media> mediaList = new ArrayList<Media>();
        String fileName = "hust/soict/hedspi/aims/database/MediaDatabase.txt";
        File file = new File(fileName);
        try {
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                String temp = input.nextLine();
                switch (temp) {
                    case "Book" -> {
                        String title = input.nextLine();
                        String category = input.nextLine();
                        float cost = Float.parseFloat(input.nextLine());
                        List<String> author = new ArrayList<String>();
                        Book book = new Book(title, category, cost);
                        int authorNumber = Integer.parseInt(input.nextLine());
                        for (int i = 0; i < authorNumber; i++) {
                            author.add(input.nextLine());
                        }
                        mediaList.add(book);
                    }
                    case "DigitalVideoDisc" -> {
                        String title = input.nextLine();
                        String category = input.nextLine();
                        String director = input.nextLine();
                        int length = Integer.parseInt(input.nextLine());
                        float cost = Float.parseFloat(input.nextLine());
                        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                        mediaList.add(dvd);
                    }
                    case "CompactDisc" -> {
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

    public void updateStoreMediaDatabase(List<Media> mediaList) {
        String fileName = "hust/soict/hedspi/aims/database/MediaDatabase.txt";
        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            for (Media media : mediaList) {
                if (media instanceof Book) {
                    writer.write("Book\n");
                    writer.write(media.getTitle() + "\n");
                    writer.write(media.getCategory() + "\n");
                    writer.write(media.getCost() + "\n");
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
