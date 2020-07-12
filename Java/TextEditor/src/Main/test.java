package Main;

import java.io.*;

public class test {
	public static void main(String[] args) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader input = new BufferedReader(isr);
			System.out.println("Enter your name : ");
			String i = input.readLine();			
			System.out.println("Hi, " + i);
		} catch (IOException e) {
			
		}
	}
}
