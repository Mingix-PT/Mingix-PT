package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public interface Playable {
    public void play() throws PlayerException;
    public String playMessage() throws PlayerException;
    public void playOptionPane() throws PlayerException;
}
