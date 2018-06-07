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
import javax.swing.filechooser.FileNameExtensionFilter;

public class Decoder {
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private File original = new File("src/groupSteganography/csimage.jpg");
	private File changed;
	private int width = 1000;
	private int height = 1000;
	ArrayList<Color> img = null;

	public void formatSetup() throws IOException {
		frame.setSize(width, height);
		width = panel.getWidth();
		height = panel.getHeight();
		panel.setLayout(new GridLayout(2, 2));
		panel.setSize(width, height);
		panel.setBackground(Color.WHITE);

		BufferedImage myPicture = ImageIO.read(original);
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		panel.add(picLabel);

		BufferedImage myPicture2 = ImageIO.read(new File("src/groupSteganography/csimage.jpg"));
		JLabel picLabel2 = new JLabel(new ImageIcon(myPicture2));
		panel.add(picLabel2);

		JButton fileChoose = new JButton("Please insert a file");
		fileChoose.addActionListener((ActionListener) new fileClick());
		panel.add(fileChoose);

		JButton convert = new JButton("Decode");
		convert.addActionListener((ActionListener) new onClick());
		panel.add(convert);

		// frame.setResizable(false);
		// frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	private class onClick implements ActionListener { // decodes the images

		@Override
		public void actionPerformed(ActionEvent e) {
			// Comparator comparator = new Comparator(original, changed);
		}
	}

	private class fileClick implements ActionListener { // decodes the images

		@Override
		public void actionPerformed(ActionEvent e) {

			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files Only", "jpg", "png", "tif");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				
				System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
				
				try {
					img = imageToArray(ImageIO.read(chooser.getSelectedFile()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

		// converts to image to an arraylist of colors, where first 8 bits represent
		// red, next 8 blue, final 8 green
		public ArrayList<Color> imageToArray(BufferedImage img) throws IOException {
			FastRGB imgColors = new FastRGB(img);
			ArrayList<Color> colors = new ArrayList<Color>();
			for (int i = 0; i < img.getWidth(); i++) {
				for (int j = 0; j < img.getHeight(); j++) {
					colors.add(new Color(img.getRGB(i, j)));
				}
			}
			return colors;
		}
	}
}
