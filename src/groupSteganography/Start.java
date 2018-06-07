package groupSteganography;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Start {

	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();

	private int width = 1000;
	private int height = 1000;

	public void formatSetup() throws IOException {
		frame.setSize(width, height);
		width = panel.getWidth();
		height = panel.getHeight();
		panel.setLayout(new GridLayout(1, 1));
		panel.setSize(width, height);
		panel.setBackground(Color.WHITE);

		JButton encode = new JButton("Encode");
		panel.add(encode);

		JButton decode = new JButton("Decode");
		panel.add(decode);

		// frame.setResizable(false);
		// frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		encode.addActionListener((ActionListener) new encodeUI());
		decode.addActionListener((ActionListener) new decodeUI());
	}

	private class encodeUI implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Encoder encoder = new Encoder();
			try {
				encoder.formatSetup();
			} catch (IOException ex) {
				Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	private class decodeUI implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Decoder decoder = new Decoder();
			try {
				decoder.formatSetup();
			} catch (IOException ex) {
				Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
