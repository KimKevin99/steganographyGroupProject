package groupSteganography;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Decoder {
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();

    private int width = 300;
    private int height = 300;

    public void formatSetup() throws IOException {
        frame.setSize(width, height);
        width = panel.getWidth();
        height = panel.getHeight();
        panel.setLayout(new GridLayout(2, 2));
        panel.setSize(width, height);
        panel.setBackground(Color.WHITE);

        BufferedImage myPicture = ImageIO.read(new File("H:\\12th Grade\\Computer Science\\300px-Color_icon_green.svg.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panel.add(picLabel);

        BufferedImage myPicture2 = ImageIO.read(new File("H:\\12th Grade\\Computer Science\\MMP_077_RAF_Dark_Green_large.jpg"));
        JLabel picLabel2 = new JLabel(new ImageIcon(myPicture2));
        panel.add(picLabel2);

        JTextField tf = new JTextField();
        panel.add(tf);

        JButton convert = new JButton("Convert");
        panel.add(convert);

        //frame.setResizable(false);
        //frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
