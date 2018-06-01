package steganography;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class Steganography {

    public static void main(String[] args) throws IOException {
        Start s = new Start();
        s.formatSetup();
    }
    
    /*public void imageToBinary() throws IOException {
        BufferedImage image = ImageIO.read(new File("H:\\12th Grade\\Computer Science\\300px-Color_icon_green.svg.png"));
        int r = 0, g = 0, b = 0;
        int w = image.getWidth();
        int h = image.getHeight();
        System.out.println("Image Dimension: Height-" + h + ", Width-" + w);
        int totalPixels = (h * w);
        ArrayList<Color> Colors = new ArrayList<Color>();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                Colors.add(new Color(image.getRGB(i, j)));
            }
        }
        for (int i = 0; i < Colors.size(); i++) {
            Color c = Colors.get(i);
            r = c.getRed();
            g = c.getGreen();
            b = c.getBlue();
            System.out.println("Element: " + (i + 1));
            System.out.println("Red: " + Integer.toString(r, 2)); //converts to binary
            System.out.println("Green: " + Integer.toString(g, 2));
            System.out.println("Blue: " + Integer.toString(b, 2));
            System.out.println("");
        }
    } */
}
