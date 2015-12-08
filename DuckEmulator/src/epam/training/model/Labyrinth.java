package epam.training.model;

import java.util.ArrayList;
import java.util.List;

public class Labyrinth {
	
	public final static String symbolWall = "|";
	public final static String symbolPassage = " ";
	public final static String entry = "I";
	public final static String exit= "X";
	public final static String wall = "1";
	public final static String passage = "0";
	private List <String[]> m_cells = new ArrayList <String[]>();
	private Position entryPosition;
    private Position exitPosition;
    private int maxX;
    private int maxY;
	
    public Labyrinth() {
		super();
	}

    public Labyrinth(List <String[]> cells) {
	    this.m_cells = cells;
		this.maxX = m_cells.get(0).length - 1;
		this.maxY = m_cells.size()-1;
		setCoordinatePoints();
	}
	
	private void setCoordinatePoints(){
		for(String[] cell: m_cells)
	    {
			for (int i = 0; i < cell.length; i++)
	        {
	          if (cell[i].equals(entry)) {
                  this.entryPosition = new Position(i, m_cells.indexOf(cell));
              }
	          else if (cell[i].equals(exit)) {
	        	  this.exitPosition = new Position(i, m_cells.indexOf(cell));
	          }
	        }
	    }
	}
	
   public List<String[]> getCells() {
		return m_cells;
	}

	public void setCells(List<String[]> m_cells) {
		this.m_cells = m_cells;
	}

    public int getMaxX() {
		return maxX;
	}
    
    public int getMaxY() {
		return maxY;
	}

    public Position getEntryPosition() {
		return entryPosition;
	}
    
    public void setEntryPosition(Position entryPosition) {
		this.entryPosition = entryPosition;
	}

    public Position getExitPosition() {
		return exitPosition;
	}

    public void setExitPosition(Position exitPosition) {
		this.exitPosition = exitPosition;
	}
}
	

