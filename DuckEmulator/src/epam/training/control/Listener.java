package epam.training.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import epam.training.model.Constants;

/**
 * According to SRP Listener has one responsibility to take the keyboard input.
 */
	public class Listener{ 
	
	public Listener() {
		super();
	}

	public String listen() { 
	     
		String command = null;
		char c; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	    try {
			c = (char) br.read();
		
			switch (c) {
			
				case('w'):
					command = Constants.GO_UP;
					break;
				case('s'):
					command = Constants.GO_DOWN;
					break;	
				case('d'):
					command = Constants.GO_RIGHT;
					break;
				case('a'):
					command = Constants.GO_LEFT;
				    break;
				default: System.out.println(Constants.KEYS);
				    break;
			}
		
		} catch (IOException e) {
			System.out.println("Reading error");
		} 
		return command;
	}
}
