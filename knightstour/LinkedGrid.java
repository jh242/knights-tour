package knightstour;

public class LinkedGrid {

	private Node northWest = null;
	private Node southEast = null;
	private String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H" };

	public LinkedGrid(int x, int y) { //constructor to create a linked grid of dimensions x*y
		northWest = new Node();
		Node temp = northWest;
		for (int marker = 1; marker < x; marker++) { //create first row
			temp.setId(letters[0] + marker);
			temp.setEast(new Node());
			temp.getEast().setWest(temp);
			temp = temp.getEast();
		}
		temp.setId(letters[0] + 8); //set the ID of the last element, because the for loop has ended

		Node rowMark = northWest;
		int markX;

		for (int markY = 1; markY < y; markY++) { //create more rows below the first and stitch the nodes
			temp = rowMark;
			temp.setSouth(new Node());
			temp.getSouth().setNorth(temp);
			temp = temp.getSouth();
			for (markX = 1; markX < x; markX++) {
				temp.setId(letters[markY] + markX);
				temp.setEast(new Node());
				temp.getEast().setWest(temp);
				temp = temp.getEast();
				temp.setNorth(temp.getWest().getNorth().getEast());
				temp.getNorth().setSouth(temp);
			}
			temp.setId(letters[markY] + markX);
			rowMark = rowMark.getSouth();
		}

	}

	public Node getNorthWest() {
		return northWest;
	}

	public void setNorthWest(Node northWest) {
		this.northWest = northWest;
	}

	public Node getSouthEast() {
		return southEast;
	}

	public void setSouthEast(Node southEast) {
		this.southEast = southEast;
	}

}
