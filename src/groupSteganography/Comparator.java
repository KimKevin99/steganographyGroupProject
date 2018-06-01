package groupSteganography;

public class Comparator { // to compare and eventually decode
	private int[][] original;
	private int[][] after; 
	private String toReturn; 
	
	
	public Comparator(int[][] original, int[][] after) { //assume that the images are the same size
		this.original = original;
		this.after = after; 
		compare();
	}
	private void compare() { //assumes that the message was encoded in order
		StringBuilder sb = new StringBuilder();
		char a; 
		for(int i = 0; i<original.length; i++) {
			for(int j = 0; j<original[i].length; j++) {
				if(original[i][j] != after[i][j]) {
					a = (char) after[i][j];
					sb.append(Character.toString(a));
				}
			}
		}
		toReturn = sb.toString();
	}
	
	public String returnMessage() {
		return toReturn; 
	}
	

}
 