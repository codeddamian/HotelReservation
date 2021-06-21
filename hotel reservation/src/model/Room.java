package model;

public class Room implements IRoom {
    private String roomNumber;
    private Double roomPrice;
    private RoomType enumeration;

    public Room(String roomNumber, Double roomPrice, RoomType enumeration) {
        super();
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.enumeration = enumeration;
    }


    @Override
    public String getRoomNumber() {
        return  roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(Double roomPrice) {
        this.roomPrice = roomPrice;
    }


    @Override
    public RoomType getRoomType() {
        return enumeration;
    }

    public void setRoomType(RoomType enumeration) {
        this.enumeration = enumeration;
    }


    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public String toString(){
        return "Your room number is  " + roomNumber + "  it costs " + roomPrice + " and Its a  " + enumeration ;
    }
}

