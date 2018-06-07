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

	
}
