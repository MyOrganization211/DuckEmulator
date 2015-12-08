package epam.training.control;

import java.util.List;
import epam.training.model.Constants;
import epam.training.model.Duck;
import epam.training.model.Labyrinth;
import epam.training.model.Position;
import epam.training.view.FrameBuffer;

public class Controller {
     private Labyrinth labyrinth;
     private Duck duck;
     private FrameBuffer buffer;
	
	 public void startGame(List <String[]> data) {
		labyrinth = new Labyrinth(data);
		duck = new Duck(labyrinth.getEntryPosition());
		buffer = new FrameBuffer(); 
		buffer.setLabyrinth(labyrinth);
	    buffer.setDuck(duck);
		
	}
	
	public void doGame() {
		buffer.display();
		System.out.println(Constants.KEYS); 
		
		Listener listener = new Listener();
		do {
			String command = listener.listen();
		    if (command != null && isAction(command))
		    {  
		    	buffer.clear();
		    	buffer.setDuck(duck);
			    buffer.display();  
		    }
		}
		while (!duck.getPosition().equals(labyrinth.getExitPosition()));
	    System.out.println(Constants.CONGRATULATIONS);
	}
	
	
	private boolean isAction(String command) {
		boolean isAction= false;
		Position position = new Position(duck.getPosition().getX(),duck.getPosition().getY());
		Duck testDuck = new Duck(position);
	
        switch (command) {
		
			case(Constants.GO_UP): 
				testDuck.goUp();             
			    if (isAvailableAction(testDuck.getPosition())) {
			 		duck.goUp();
			 		isAction = true;
			 	}
			 	break;
			case(Constants.GO_DOWN):;
				testDuck.goDown();             
		        if (isAvailableAction(testDuck.getPosition())) {
					duck.goDown(); 
					isAction = true;
				}
		
				break;
			case(Constants.GO_RIGHT):;
				testDuck.goRight();             
				if (isAvailableAction(testDuck.getPosition())) {
					duck.goRight(); 
					isAction = true;
				}
				break;
			case(Constants.GO_LEFT):;
				testDuck.goLeft();             
				if (isAvailableAction(testDuck.getPosition())) {
					duck.goLeft();
					isAction = true;
				}
				break;
		}
		if (!isAvailableAction(testDuck.getPosition())) {
			 System.out.println(Constants.WALL);
		}
		return isAction;
	}
	
		
	 private boolean isAvailableAction(Position position){
			
		int newX = position.getX();
		int newY = position.getY();
		
		if (newX >= 0 && newY >= 0 && newX <= labyrinth.getMaxX() &&
				newY <= labyrinth.getMaxY() &&
			    !labyrinth.getCells().get(newY)[newX].equals(labyrinth.wall))
		{
			return true;
		}
		else
		{
		    return false;
	    }
	}

	public Labyrinth getLabyrinth() {
		return labyrinth;
	}

	public void setLabyrinth(Labyrinth labyrinth) {
		this.labyrinth = labyrinth;
	}

	public Duck getDuck() {
		return duck;
	}

	public void setDuck(Duck duck) {
		this.duck = duck;
	}

	public FrameBuffer getBuffer() {
		return buffer;
	}

	public void setBuffer(FrameBuffer buffer) {
		this.buffer = buffer;
	}
}
