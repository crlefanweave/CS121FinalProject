package bsu.edu.CS121.crlefanweave.finalproject;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends WorldBuilder{
	public Scanner kb = new Scanner(System.in);
	protected ArrayList<String> inv = new ArrayList<String>();
	private int playerPos;
	private String[] inputSplit;
	public Player() {
		setPos(1);
		System.out.println(rooms.get(playerPos-1).roomName + "\n" + rooms.get(playerPos-1).currentDesc());
		rooms.get(playerPos-1).setRoomDescCurr(rooms.get(playerPos-1).roomDesc2);
		rooms.get(playerPos-1).movements();
		while(!winner()){
			System.out.println("What will you do now?");
			String input = kb.nextLine();
			inputSplit = input.split(" ");
			if(inputSplit[0].equalsIgnoreCase("take")){
				addItem(inputSplit[1]);
			}
			if(inputSplit[0].equalsIgnoreCase("drop")){	
				dropItem(inputSplit[1]);
			}
			if(inputSplit[0].equalsIgnoreCase("move") || inputSplit[0].equalsIgnoreCase("go")){
				moveTo(inputSplit[1]);
			}
			if(inputSplit[0].equalsIgnoreCase("score")){
				score();
			}
			if(inputSplit[0].equalsIgnoreCase("look")){
				System.out.println(rooms.get(playerPos-1).roomName + "\n" + rooms.get(playerPos-1).currentDesc());
			}
			if(inputSplit[0].equalsIgnoreCase("quit")){
				System.out.println("Good bye!");
				break;
			}
			if(inputSplit[0].equalsIgnoreCase("inventory") || inputSplit[0].equalsIgnoreCase("inv")){
				String things = "";
				for(String x : inv){
					things = things + x + ", ";
				}
				System.out.println("You rummage through your things and find you have: " + things);
			}
		}
		if(winner())
			System.out.println(rooms.get(0).roomDesc3);
	}
	public void addItem(String item){
		String realItem;
		if(rooms.get(getPos()-1).itemsPresent.isEmpty()){
			System.out.println("What are you trying to take?");
		}
		else if(item.equalsIgnoreCase("eye") || item.equalsIgnoreCase("newt")){
			realItem = "eye of newt";
			inv.add(realItem);
			rooms.get(getPos()-1).removeItem(realItem);
			System.out.println("You have taken the " + realItem + ".");
		}
		else if(item.equalsIgnoreCase("hair") || item.equalsIgnoreCase("cat")){
			realItem = "cat hair";
			inv.add(realItem);
			rooms.get(getPos()-1).removeItem(realItem);
			System.out.println("You have taken the " + realItem + ".");
		}
		else if (item.equalsIgnoreCase("toe") || item.equalsIgnoreCase("frog")){
			realItem = "toe of frog";
			inv.add(realItem);
			rooms.get(getPos()-1).removeItem(realItem);
			System.out.println("You have taken the " + realItem + ".");
		}
		else if (item.equalsIgnoreCase("leg") || item.equalsIgnoreCase("lizard")){
			realItem = "lizard's leg";
			inv.add(realItem);
			rooms.get(getPos()-1).removeItem(realItem);
			System.out.println("You have taken the " + realItem + ".");
		}
		else if (item.equalsIgnoreCase("wing") || item.equalsIgnoreCase("owlet")){
			realItem = "owlet's wing";
			inv.add(realItem);
			rooms.get(getPos()-1).removeItem(realItem);
			System.out.println("You have taken the " + realItem + ".");
		}else{
			System.out.println("What are you trying to take?");
		}
	}
	public void dropItem(String item){
		String realItem = "dust";
		if(item.equalsIgnoreCase("eye") || item.equalsIgnoreCase("newt")){
			realItem = "eye of newt";
		}
		if(item.equalsIgnoreCase("hair") || item.equalsIgnoreCase("cat")){
			realItem = "cat hair";
		}
		if (item.equalsIgnoreCase("toe") || item.equalsIgnoreCase("frog")){
			realItem = "toe of frog";
		}
		if (item.equalsIgnoreCase("leg") || item.equalsIgnoreCase("lizard")){
			realItem = "lizard's leg";
		}
		if (item.equalsIgnoreCase("wing") || item.equalsIgnoreCase("owlet")){
			realItem = "owlet's wing";
		}
		if(inv.contains(realItem)){
			inv.remove(realItem);
			rooms.get(getPos()-1).placeItem(realItem);
			System.out.println("You have dropped the " + realItem + ".");
		}
		else{
			System.out.println("Are you sure you have that?");
		}
	}
	private void score(){
		int counter = 0;
		for(Room room : rooms){
			if (room.hasVisited == true)
				counter+=1;
		}
		counter+=inv.size();
		System.out.println("Your score is: " + counter);
	}
	private void setPos(int x){
		playerPos = x;
	}
	private int getPos(){
		return playerPos;
	}
	private boolean winner(){
		if((getPos() == 1) && (rooms.get(getPos()-1).itemsPresent.size() == 5)){
			return true;
		}
		return false;
	}
	public void moveTo(String way){
		try{
		if(way.equalsIgnoreCase("north") || way.equalsIgnoreCase("n")){
			setPos(Integer.parseInt(rooms.get(getPos()-1).goNorth()));
			System.out.println(rooms.get(getPos()-1).roomName + "\n" + rooms.get(getPos()-1).currentDesc());
		}
		else if(way.equalsIgnoreCase("south") || way.equalsIgnoreCase("s")){
			setPos(Integer.parseInt(rooms.get(getPos()-1).goSouth()));
			System.out.println(rooms.get(getPos()-1).roomName + "\n" + rooms.get(getPos()-1).currentDesc());
		}
		else if(way.equalsIgnoreCase("east") || way.equalsIgnoreCase("e")){
			setPos(Integer.parseInt(rooms.get(getPos()-1).goEast()));
			System.out.println(rooms.get(getPos()-1).roomName + "\n" + rooms.get(getPos()-1).currentDesc());
		}
		else if(way.equalsIgnoreCase("west") || way.equalsIgnoreCase("w")){
			setPos(Integer.parseInt(rooms.get(getPos()-1).goWest()));
			System.out.println(rooms.get(getPos()-1).roomName + "\n" + rooms.get(getPos()-1).currentDesc());
		}
		else{
			System.out.println("Where are you trying to go?");
		}
		rooms.get(getPos()-1).visit();
		rooms.get(getPos()-1).movements();
		}catch(Exception e){
			System.out.println("Are you sure you can go that way?");
		}
	}
}
