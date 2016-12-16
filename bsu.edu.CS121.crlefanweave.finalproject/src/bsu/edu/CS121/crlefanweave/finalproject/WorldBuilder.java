package bsu.edu.CS121.crlefanweave.finalproject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WorldBuilder {
	protected File file = new File("finalproject.txt");
	protected ArrayList<String> everyLine = new ArrayList<String>();
	protected ArrayList<Room> rooms = new ArrayList<Room>();
	public WorldBuilder() {
		try{
			Scanner input = new Scanner(file);
			while(input.hasNextLine()){
				String line = input.nextLine();
				everyLine.add(line);
			}
			makeRooms(everyLine);
		}catch (IOException e){
			System.out.println("Error: " + e);
		}
	}
	private void makeRooms(ArrayList<String> array){
		while(!array.isEmpty()){
			Room newRoom = new Room(strRecon(array.get(0)), strRecon(array.get(1)), strRecon(array.get(2)), strRecon(array.get(3)), array.get(4), array.get(5));
			rooms.add(newRoom);
			array.subList(0, 6).clear();
		}
	}
	private String strRecon(String s){
		String[] strings = s.split("@");
		String newString = "";
		for(int x = 0; x < strings.length; x++){
			newString = newString + strings[x] + "\n";
		}
		return newString;
	}
}
