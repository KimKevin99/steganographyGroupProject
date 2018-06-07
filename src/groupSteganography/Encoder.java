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

		BufferedImage myPicture = ImageIO.read(new File("src/groupSteganography/csimage.jpg"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		panel.add(picLabel);

		BufferedImage myPicture2 = ImageIO.read(new File("src/groupSteganography/csimage.jpg"));
		JLabel picLabel2 = new JLabel(new ImageIcon(myPicture2));
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
		public void actionPerformed(ActionEvent e) {
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
					ArrayList<Color> img = imageToArray(ImageIO.read(chooser.getSelectedFile()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

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

	}

}
