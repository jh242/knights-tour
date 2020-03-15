package knightstour;

public class Node {
	
	private Node north = null;
	private Node south = null;
	private Node east = null;
	private Node west = null;
	private boolean data = false;
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean getData() {
		return data;
	}
	public void setData(boolean data) {
		this.data = data;
	}
	public Node getNorth() {
		return north;
	}
	public void setNorth(Node north) {
		this.north = north;
	}
	public Node getSouth() {
		return south;
	}
	public void setSouth(Node south) {
		this.south = south;
	}
	public Node getEast() {
		return east;
	}
	public void setEast(Node east) {
		this.east = east;
	}
	public Node getWest() {
		return west;
	}
	public void setWest(Node west) {
		this.west = west;
	}

}
