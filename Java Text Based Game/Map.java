import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Map {
	private static Map instance = null;
	private char[][] map;
	private boolean[][] revealed;

	/**
	 * Constructor - builds two arrays of 5x5: one of characters and other of
	 * boolean.
	 */
	private Map() {
		map = new char[5][5];
		revealed = new boolean[5][5];
	}
	
  /**
   * creates an instance of Map() if one does not already exist.
   * @return instance - instance of Map
   */
	public static Map getInstance() {
		if(instance == null) {
			instance = new Map();
		}
		return instance;
	}

	/**
	 * loadMap - Read the map from the map text documents and load the map according
	 * to the different levels.
	 * 
	 * @param mapNum - Number of the map to be load.
	 */
	public void loadMap(int mapNum) {
		try { // Reading and loading Map1
			if (mapNum == 1) {
				Scanner read = new Scanner(new File("Map1.txt"));
				while (read.hasNext()) {
					for (int i = 0; i < map.length; i++) {
						for (int j = 0; j < map.length; j++) {
							char line = read.next().charAt(0);
							map[i][j] = line;
							revealed[i][j] = false;
						}
					}
				}
			} else if (mapNum == 2) { // Reading and loading Map2
				Scanner read = new Scanner(new File("Map2.txt"));
				while (read.hasNext()) {
					for (int i = 0; i < map.length; i++) {
						for (int j = 0; j < map.length; j++) {
							char line = read.next().charAt(0);
							map[i][j] = line;
							revealed[i][j] = false;
						}
					}
				}
			} else { // Reading and loading Map3
				Scanner read = new Scanner(new File("Map3.txt"));
				while (read.hasNext()) {
					for (int i = 0; i < map.length; i++) {
						for (int j = 0; j < map.length; j++) {
							char line = read.next().charAt(0);
							map[i][j] = line;
							revealed[i][j] = false;
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist");
		}
	}

	/**
	 * getCharAtLoc - getting the character at the given location.
	 * 
	 * @param p - point of which character should be get.
	 * @return - the charater at the point p
	 */
	public char getCharAtLoc(Point p) {
		return map[p.x][p.y];
	}

	/**
	 * mapToString - Display the map as the string
	 * 
	 * @param p - Point p on the map
	 * @return - Display of the map as 5x5 '*' or 'x'
	 */
	public String mapToString(Point p) {
		String[][] completeMap = new String[5][5];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++)
				// insert hero location
				if (i == p.x && j == p.y) {
					completeMap[i][j] = "*";
				}
				// insert revealed location
				else if (revealed[i][j] == true) {
					completeMap[i][j] = String.valueOf(map[i][j]);
				} else {
					completeMap[i][j] = "x";
				}
		}
		int index = 0;
		String[] newMap = new String[25];
		for (int k = 0; k < completeMap.length; k++) {
			for (int l = 0; l < completeMap.length; l++) {
				if (l == 4) {
					newMap[index] = completeMap[k][l];
				} else {
					newMap[index] = completeMap[k][l];
				}
				index++;
			}
		}
		for (int b = 0; b < newMap.length; b++) {
			if (b % 5 == 0) {
				newMap[b] = "\n" + newMap[b];
			}
		}
		return Arrays.toString(newMap).replace(",", " ").replace("[", "").replace("]", "");
	}

	/**
	 * findStart - finding the start on the map
	 * 
	 * @return - the location of the start point
	 */
	public Point findStart() {
		Point start = new Point(0, 0);
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 's') {
					revealed[i][j] = true;
					Point found = new Point(i, j);
					start = found;
				}
			}
		}
		return start;
	}

	/**
	 * reveal - revealing the point p
	 * 
	 * @param p - point p
	 */
	public void reveal(Point p) {
		revealed[p.x][p.y] = true;
	}

	/**
	 * removing the character at point p
	 * 
	 * @param p - point p
	 */
	public void removeCharAtLoc(Point p) {
		if (map[p.x][p.y] != 's') {
			map[p.x][p.y] = 'n';
		}

	}
}