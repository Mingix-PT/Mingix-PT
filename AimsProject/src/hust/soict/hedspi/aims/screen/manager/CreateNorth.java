//package hust.soict.hedspi.aims.screen.manager;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class CreateNorth {
//    JPanel createNorth() {
//        JPanel north = new JPanel();
//        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
//        north.add(createMenuBar());
//        north.add(createHeader());
//        return north;
//    }
//
//    JMenuBar createMenuBar() {
//        JMenu menu = new JMenu("Options");
//
//        menu.add(new JMenuItem("View Store"));
//
//        JMenu smUpdateStore = new JMenu("Update Store");
//        JMenuItem smAddBook = new JMenuItem("Add Book");
//        JMenuItem smAddDVD = new JMenuItem("Add DVD");
//        JMenuItem smAddCD = new JMenuItem("Add CD");
//        smUpdateStore.add(smAddBook);
//        smUpdateStore.add(smAddDVD);
//        smUpdateStore.add(smAddCD);
//        smAddBook.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                AddBookToStoreScreen addBookToStoreScreen = new AddBookToStoreScreen(store);
//            }
//        });
//        smAddDVD.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                AddDigitalVideoDiscToStoreScreen addDigitalVideoDiscToStoreScreen = new AddDigitalVideoDiscToStoreScreen(store);
//            }
//        });
//        smAddCD.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                AddCompactDiscToStoreScreen addCompactDiscToStoreScreen = new AddCompactDiscToStoreScreen(store);
//            }
//        });
//        menu.add(smUpdateStore);
//
//        JMenuBar menuBar = new JMenuBar();
//        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
//        menuBar.add(menu);
//
//        return menuBar;
//    }
//
//    JPanel createHeader() {
//        JPanel header = new JPanel();
//        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
//
//        JLabel title = new JLabel("AIMS");
//        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
//        title.setForeground(Color.CYAN);
//
//        header.add(Box.createRigidArea(new Dimension(10, 0)));
//        header.add(title);
//        header.add(Box.createHorizontalGlue());
//        header.add(Box.createRigidArea(new Dimension(10, 0)));
//
//        return header;
//    }
//}
