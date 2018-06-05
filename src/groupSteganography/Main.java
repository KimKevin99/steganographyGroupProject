package groupSteganography;

import java.awt.Color;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Main {
	ArrayList<Integer> changes = new ArrayList<Integer>();
	public static int messageLength;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Please enter a string to be encoded");
		Scanner input = new Scanner(System.in);
		String toEncode = input.nextLine();
		char[] ind = toEncode.toCharArray();
		int[] bin = new int[ind.length];
		messageLength = bin.length;
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
		imageToBinary();
		Start start = new Start(); 
		start.formatSetup();
	}

	public void addMesssage(String message) {
		for (int i = 0; i < message.length(); i++) {
			int temp = message.charAt(i);
			changes.add(temp);
		}
	}

	public void ModifyAll(ArrayList<Integer> image) {
		for (int i = 0; i < changes.size(); i++) {
			image.set(i, changes.get(i) + image.get(i));
		}
	}

	public static void imageToBinary() throws IOException {
		BufferedImage image = ImageIO.read(new File("src/groupSteganography/csimage.jpg"));
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
			/*
			System.out.println("Element: " + (i + 1));
			System.out.println("Red: " + Integer.toString(r, 2)); // converts to binary
			System.out.println("Green: " + Integer.toString(g, 2));
			System.out.println("Blue: " + Integer.toString(b, 2));
			System.out.println("");
			*/
		}
	}
}
