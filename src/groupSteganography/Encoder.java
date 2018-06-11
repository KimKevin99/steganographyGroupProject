package groupSteganography;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Encoder {

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JLabel picLabel;
    private JLabel picLabel2;
    private BufferedImage myPicture2;

    private int width = 1000;
    private int height = 1000;
    private JTextField tf;

    public void formatSetup() throws IOException {
        frame.setSize(width, height);
        width = panel.getWidth();
        height = panel.getHeight();
        panel.setLayout(new GridLayout(2, 2));
        panel.setSize(width, height);
        panel.setBackground(Color.WHITE);

        BufferedImage myPicture = ImageIO.read(new File("E:\\Allen\\12th Grade\\Computer Science\\csimage.jpg"));
        picLabel = new JLabel(new ImageIcon(myPicture));
        panel.add(picLabel);

        BufferedImage myPicture2 = ImageIO.read(new File("E:\\Allen\\12th Grade\\Computer Science\\csimage.jpg"));
        this.myPicture2 = myPicture2;
        picLabel2 = new JLabel(new ImageIcon());
        panel.add(picLabel2);
        tf = new JTextField();
        panel.add(tf);

        JButton convert = new JButton("Convert");
        panel.add(convert);
        convert.addActionListener((ActionListener) new onClick());

        // frame.setResizable(false);
        // frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        JButton fileChoose = new JButton("Please insert a file");
        fileChoose.addActionListener((ActionListener) new fileClick());
        panel.add(fileChoose);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    private class onClick implements ActionListener { // gets the text to encode

        @Override
        public void actionPerformed(ActionEvent e){
            String toEncode = tf.getText();
            char[] ind = toEncode.toCharArray();
            int[] bin = new int[ind.length];
            int messageLength = bin.length;
            int i = 0;
            for (char a : ind) {
                int toSave = a;
                bin[i] = toSave;
                i++;
            }
            i = 0;
            for (int b : bin) {
                bin[i] = Integer.parseInt(Integer.toBinaryString(b));
                System.out.println(bin[i]);
                i++;
            }
            picLabel2.setIcon(new ImageIcon(myPicture2));
            panel.repaint();
        }
    }

    private class fileClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                try {
                    encode;
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }

        }
        //deprecated
        public ArrayList<Color> imageToArray(BufferedImage img) {
            FastRGB imgColors = new FastRGB(img);
            ArrayList<Color> colors = new ArrayList<Color>();
            for (int i = 0; i < img.getWidth(); i++) {
                for (int j = 0; j < img.getHeight(); j++) {
                    colors.add(new Color(img.getRGB(i, j)));
                }
            }
            return colors;
        }
        //writes an image given the original and the message
        public void encode (BufferedImage img, String message){
            FastRGB imgColors = new FastRGB(img);
            ArrayList<Color> colors = new ArrayList<Color>();
             BufferedImage encodedImage = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB); 
             for (int i = 0; i < img.getWidth(); i++) {
                for (int j = 0; j < img.getHeight(); j++) {
                    int currentColor = imgColors.getRGB(i, j);
                    if (characterValue = message.charAt(i * img.getHeight() + j) != null) {        
                        int red = ((currentColor >> 16) / 8) * 8 + characterValue / 16
                        // int red = (colors.get(i * img.getHeight() + j).getRed() / 8) * 8 + characterValue / 16;
                        characterValue -= characterValue / 16;
                        int green = (((currentColor >> 8) % 256) / 4) * 4 + characterValue / 4;
                        characterValue -= characterValue / 4;
                        int blue = ((currentColor % 65536) / 4) * 4 + characterValue;
                        encodedImage.setRGB(i, j, new Color red + green + blue));
                    }else {
                        encodedImage.setRGB(i, j, currentColor);
                    }
                }
            }
            File outputFile = new File("/output.bmp");
            ImageIO.write(encodedImage, "bmp", outputFile);
        }

    }

}
