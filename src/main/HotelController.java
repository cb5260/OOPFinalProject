package main;

import java.util.Iterator;
import java.util.List;

public class HotelController {
    private RoomDB roomDB;

    public HotelController() {
        this.roomDB = new RoomDB();
        createROoms(); // a set number of rooms
    }

    private void createROoms() {
    	for (int i = 0; i < 7; i++) {
    		roomDB.addRoom(new Room("single", 60));
		}
    	for (int i = 0; i < 5; i++) {
    		roomDB.addRoom(new Room("double", 75));
		}
    	for (int i = 0; i < 3; i++) {
    		roomDB.addRoom(new Room("triple", 100));
		}
    }

    public void bookRoom() {
    	//TODO, by type only
    	
    }


    public Room getRoom(int roomId) {
        return roomDB.getRoom(roomId);
    }

    public List<Room> searchRooms(String types, boolean isAva) {
        return roomDB.search(types, isAva);
    }


    public boolean editRoom(int roomId, String type, double price, boolean isAva, String name) {
        return roomDB.editRoom(roomId, type, price, isAva, name);
    }

    public List<Room> getAllRooms() {
        return roomDB.getAllRooms();
    }
}