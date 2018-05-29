package groupSteganography;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	ArrayList<Integer> changes= new ArrayList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter a string to be encoded");
		Scanner input = new Scanner(System.in);
		String toEncode = input.next(); 
		char[] ind = toEncode.toCharArray();
		int[] bin = new int[ind.length];
		int i = 0; 
		for(char a: ind) {
			int toSave = a; 
			bin[i] = toSave; 
			i++;
		}
		System.out.println("success!");
		

	}
	
	public void addMesssage (String message) {
		for (int i=0; i<message.length(); i++) {
			int temp=message.charAt(i);
			changes.add(temp);
		}
	}
	public void ModifyAll(ArrayList<Integer> image) {
		for (int i=0; i<changes.size(); i++) {
			image.set(i, changes.get(i)+image.get(i));
		}
	}

}
