package GameMechanics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class represents the overall map that
 * clients will race on
 * 
 * @author Joseph Ryan
 */
public class Map {

	public String[][] map;	//The actual map
	private int width, height;
	
	/**
	 * Default constructor (not in use)
	 */
	public Map(){}
	
	/**
	 * Constructor: Builds an empty map with given dimensions
	 * 
	 * @param width
	 * 			The width of the map
	 * @param height
	 * 			The height of the map
	 */
	public Map(int width, int height){
		this.width= width;
		this.height = height;

		//Build the map
		map = new String[width][height];
		
		for(int w = 0; w < width; w++){
			for(int h = 0; h < height ; h++){
				map[w][h] = "0";
			}
		}
		
	}
	
	/**
	 * Constructor:  Builds a map based on a given text file <br />
	 * <b>Format:</b><br />
	 * width height <br />
	 * map data...<br /><br />
	 * <b>Example:</b><br />
	 * 4 5<br />
	 * w w w w<br />
	 * 0 0 0 0<br />
	 * 0 0 0 0<br />
	 * w w 0 w
	 * @param f
	 * 			The file to read from
	 */
	public Map(File f){
		
		try {
			Scanner s = new Scanner(f);
			
			width = s.nextInt();
			height = s.nextInt();
			map = new String[width][height];
			
			for(int h = 0; h < height ; h++){
				for(int w = 0; w < width; w++){
				
					map[w][h] = s.next();
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("The given file ("+f.getName()+") is not found.");
		}
	}
	
	/**
	 * Returns the game's map
	 * @return
	 * 			The game's map
	 */
	public String[][] getMap(){
		return this.map;
	}
	
	/**
	 * Returns the height of the map
	 * @return
	 * 			The height of the map
	 */
	public int getHeight(){
		return this.height;
	}
	
	/**
	 * Returns the width of the map
	 * @return
	 * 			the width of the map
	 */
	public int getWidth(){
		return this.width;
	}
	
	/**
	 * Determines if the given coordinate is a valid location to go to
	 * @param x
	 * 			The x coordinate
	 * @param y
	 * 			The y coordinate
	 * @return
	 * 			If the give coordinate is a valid coordinate
	 */
	public boolean validLocation(int x, int y){
		if(x >= map.length || y >= map[0].length)
			return false;
		if(x < 0 || y < 0)
			return false;
		if(!map[x][y].equals("W"))
			return true;
		return false;
	}
	
	public boolean checkForMine(int x, int y){
		if(map[x][y].equals("-1"))
			return true;
		return false;
	}
}
