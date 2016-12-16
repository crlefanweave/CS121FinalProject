package bsu.edu.CS121.crlefanweave.finalproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Room{
	protected String roomName;
	public String roomDesc1;
	public String roomDesc2;
	public String roomDesc3;
	protected String roomDescCurr;
	protected String roomN;
	protected String roomE;
	protected String roomS;
	protected String roomW;
	protected ArrayList<String> itemsPresent = new ArrayList<String>();
	protected Map<String, String> dir = new HashMap<String, String>();
	protected boolean hasVisited;
	protected String[] movements = new String[4];
	public Room(String name, String desc1, String desc2, String desc3, String directions, String item){
		roomName = name;
		roomDesc1 = desc1;
		roomDesc2 = desc2;
		roomDesc3 = desc3;
		if(!item.equalsIgnoreCase("empty"))
			placeItem(item);
		dirProc(directions);
		setRoomDescCurr(roomDesc1);
		hasVisited = false;
	}
	public String getRoomName() {
		return roomName;
	}
	public void placeItem(String theItem){
		this.itemsPresent.add(theItem);
	}
	private void dirProc(String d){
		String[] dirArr = d.split(";");
		for(String s : dirArr){
			if(s.length() > 2)
				this.dir.put((s.charAt(0) + ""), (s.charAt(1) + "")+(s.charAt(2) + ""));
			else
				this.dir.put((s.charAt(0) + ""), (s.charAt(1) + ""));
			
		}
		if(this.dir.containsKey("N")){
			this.roomN = dir.get("N");
			this.movements[0] = "N";
		}else{
			this.movements[0] = "X";
		}
		if(this.dir.containsKey("E")){
			this.roomE = dir.get("E");
			this.movements[1] = "E";
		}else{
			this.movements[1] = "X";
		}
		if(this.dir.containsKey("S")){
			this.roomS = dir.get("S");
			this.movements[2] = "S";
		}else{
			this.movements[2] = "X";
		}
		if(this.dir.containsKey("W")){
			this.roomW = dir.get("W");
			this.movements[3] = "W";
		}else{
			this.movements[3] = "X";
		}
		
	}
	public void visit(){
		hasVisited = true;
	}
	public void removeItem(String theItem){
		if(!itemsPresent.isEmpty())
			this.itemsPresent.remove(theItem);
		setRoomDescCurr(roomDesc2);
	}
	public String currentDesc(){
		return roomDescCurr;
	}
	public void setRoomDescCurr(String roomDescCurr) {
		this.roomDescCurr = roomDescCurr;
	}
	public String goNorth(){
		return roomN;
	}
	public String goSouth(){
		return roomS;
	}
	public String goEast(){
		return roomE;
	}
	public String goWest(){
		return roomW;
	}
	public void movements(){
		String concat = "";
		for(String str : movements)
			concat = concat + str + ", ";
		System.out.println("You can move in these directions: " + concat);
	}
}
