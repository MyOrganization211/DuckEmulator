package epam.training;

import java.io.IOException;
import java.util.List;
import epam.training.control.Controller;
import epam.training.service.MyFileReader;

public class Emulator {

	public static void main(String[] args) {
		
       if(args.length < 1) {
 	       System.out.println("Error, usage: java ClassName inputfile");
		   System.exit(1);
		}
	    
		MyFileReader reader = new MyFileReader();
		try {
			reader.readFile(args[0]);
			List <String[]> data = reader.getData();
			if (data != null && !data.isEmpty()) {
				Controller controller = new Controller();
				controller.startGame(data);
				controller.doGame();
			}
			else {
				System.out.println("File is empty");
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
}
