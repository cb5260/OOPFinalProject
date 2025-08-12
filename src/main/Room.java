package main;

public class Room {
	private static int totalnumber=0;
    private int roomId;
    private String type;
    private double price;
    private boolean isAvailable;
    private String customerName;

    public Room(String type, double price) {
        this.roomId = totalnumber;
        totalnumber++;
        this.type = type;
        this.price = price;
        this.isAvailable = true;
        this.customerName = null;
    }

    public int getRoomId() { return roomId; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    @Override
    public String toString() { 
        return "Room " + roomId + " (" + type + ") - $" + price + 
               " ** " + (isAvailable ? "Available" : "Booked by: " + customerName);
    }
}