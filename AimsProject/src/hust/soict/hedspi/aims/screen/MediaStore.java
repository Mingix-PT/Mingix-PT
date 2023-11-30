package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.Media;

import javax.swing.*;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(createImage());
        add(createTitle());
        add(createCost());
    }

    JPanel createImage() {
        JPanel image = new JPanel();
        image.setLayout(new BoxLayout(image, BoxLayout.X_AXIS));
        image.add(Box.createHorizontalGlue());
        image.add(new JLabel(new ImageIcon("hust/soict/hedspi/aims/media/images/" + media.getTitle() + ".jpg")));
        image.add(Box.createHorizontalGlue());
        return image;
    }

    JPanel createTitle() {
        JPanel title = new JPanel();
        title.setLayout(new BoxLayout(title, BoxLayout.X_AXIS));
        title.add(Box.createHorizontalGlue());
        title.add(new JLabel(media.getTitle()));
        title.add(Box.createHorizontalGlue());
        return title;
    }

    JPanel createCost() {
        JPanel cost = new JPanel();
        cost.setLayout(new BoxLayout(cost, BoxLayout.X_AXIS));
        cost.add(Box.createHorizontalGlue());
        cost.add(new JLabel("$" + media.getCost()));
        cost.add(Box.createHorizontalGlue());
        return cost;
    }
}
