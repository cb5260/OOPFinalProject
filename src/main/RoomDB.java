package main;

import java.util.ArrayList;
import java.util.List;

// an list of room
public class RoomDB {
    private List<Room> rooms;

    public RoomDB() {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    // get room from ID
    public Room getRoom(int roomId) {
        for (Room room : rooms) {
            if (room.getRoomId() == roomId) {
                return room;
            }
        }
        return null;
    }
    
    public List<Room> search(String type, boolean isAva) {

        List<Room> result = new ArrayList<>();
        
        for (Room room : rooms) {
            boolean t1 = (type == null) || room.getType().equalsIgnoreCase(type);
            
            if (t1 && (room.isAvailable()==isAva)) result.add(room);
        }
        
        return result;

    }
    

    public boolean editRoom(int roomId, String type, double price, boolean isAvailable, String customerName) {
        Room roomToEdit = getRoom(roomId);
        
        if (roomToEdit != null) {
                roomToEdit.setType(type); 
                roomToEdit.setPrice(price);
                roomToEdit.setAvailable(isAvailable);
                roomToEdit.setCustomerName(customerName);
                return true;
        }
        return false;
    }


    public List<Room> getAllRooms() {
        return new ArrayList<>(rooms);
    }
}