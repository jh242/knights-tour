package knightstour;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class KnightsTour {

	static LinkedList<String> solution = new LinkedList<String>();
	static PrintWriter out;
	static long solutions;

	public static void main(String[] args) throws FileNotFoundException {

		LinkedGrid board = new LinkedGrid(8, 8); //create a new 8*8 linked grid to act as a chessboard
		out = new PrintWriter("solutions.txt"); //create a file to record found solutions
		tour(board.getNorthWest()); //Tour starting from the board's northwest corner

		}

	public static void print() { //method to print solution to a file, and list number of solutions found in console
		for (String move : solution){
			out.print(move + ", ");
		}
		out.println();
		System.out.println(solutions);
	}

	public static void tour(Node knight) {

		solution.add(knight.getId());
		knight.setData(true);

		Node path1 = null, path2 = null, path3 = null, path4 = null, path5 = null, path6 = null, path7 = null,
				path8 = null;
		
		//The following try-catch blocks are to set paths from the knight's current position
		try {
			path1 = knight.getNorth().getNorth().getEast();
		} catch (Exception e) {
		}
		try {
			path2 = knight.getNorth().getEast().getEast();
		} catch (Exception f) {
		}
		try {
			path3 = knight.getSouth().getEast().getEast();
		} catch (Exception g) {
		}
		try {
			path4 = knight.getSouth().getSouth().getEast();
		} catch (Exception h) {
		}
		try {
			path5 = knight.getSouth().getSouth().getWest();
		} catch (Exception i) {
		}
		try {
			path6 = knight.getSouth().getWest().getWest();
		} catch (Exception j) {
		}
		try {
			path7 = knight.getNorth().getWest().getWest();
		} catch (Exception k) {
		}
		try {
			path8 = knight.getNorth().getNorth().getWest();
		} catch (Exception l) {
		}
		if (path1 != null && !path1.getData())//tour path 1 if it exists and it hasn't been visited before
			tour(path1);
		if (path2 != null && !path2.getData())//tour path 2, etc.
			tour(path2);
		if (path3 != null && !path3.getData())
			tour(path3);
		if (path4 != null && !path4.getData()) 
			tour(path4);
		if (path5 != null && !path5.getData())
			tour(path5);
		if (path6 != null && !path6.getData())
			tour(path6);
		if (path7 != null && !path7.getData()) 
			tour(path7);
		if (path8 != null && !path8.getData()) 
			tour(path8);

		if (solution.size() == 64) {
			solutions++;
			print();
		}
		knight.setData(false); //send the knight back to the last visited square to tour alternate paths
		solution.removeLast();
	}
}
