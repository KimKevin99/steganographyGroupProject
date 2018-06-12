package groupSteganography;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
	ArrayList<Color> changedImage = null; // color array for changed image
	ArrayList<Color> originalImage = null; // color array for original image


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
			//prompts to choose changed image
			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				changed = chooser.getSelectedFile(); 
				try {
					changedImage = imageToArray(ImageIO.read(changed));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			//prompts to choose original image
			/*int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				changed = chooser.getSelectedFile(); 
				try {
					originalImage = imageToArray(ImageIO.read(changed));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}*/
			BufferedImage myPicture2 = null;
			try {
				myPicture2 = ImageIO.read(changed);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JLabel picLabel2 = new JLabel(new ImageIcon(myPicture2));
			panel.add(picLabel2);
			frame.add(panel);
			PrintWriter out;
			try {
				out = new PrintWriter(new File("test.txt"));
				out.println(read(changedImage));
				out.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			

		}

		// converts to image to an arraylist of colors, where first 8 bits represent
		// red, next 8 blue, final 8 green
		public ArrayList<Color> imageToArray(BufferedImage img) throws IOException {
			FastRGB imgColors = new FastRGB(img);
			ArrayList<Color> colors = new ArrayList<Color>();
			for (int i = 0; i < img.getWidth(); i++) {
				for (int j = 0; j < img.getHeight(); j++) {
					if (imgColors.getRGB(i, j)==4){
						break;
					} else{
						colors.add(new Color(img.getRGB(i, j)));
					}
				}
			}
			return colors;
		}
		//converts the array to a message
		public String read(ArrayList<Color> originalColor) {
		StringBuilder message = new StringBuilder();
		for (int i = 0; i < 1000; i++) {
			message.append((char) (originalColor.get(i).getRed() % 8 * 16 + originalColor.get(i).getGreen() % 4 * 4
					+ originalColor.get(i).getBlue() % 4));
			System.out.println(originalColor.get(i).getRed() % 8 * 16 + originalColor.get(i).getGreen() % 4 * 4
					+ originalColor.get(i).getBlue() % 4);
		}
		return message.toString();
		}
	}
}
