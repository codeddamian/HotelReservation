package service;

import model.*;


import java.util.*;

public class ReservationService {
    private String roomNumber;
    private String roomId;
    private Double price;
    private RoomType enumeration;

    private Collection<Reservation> allReservation = new HashSet<>();
    private Map<Date, Reservation> mapOfReservations = new HashMap<>();
     Collection<IRoom> allRooms = new HashSet<>();
    private Map<String, IRoom> mapOfRooms = new HashMap<>();

    static ReservationService reservationService = null;
//private constructor to facilitate the Singleton Pattern

    // for the "There can be only One!!!!" instance of this class
    private ReservationService() {

    }

    public static ReservationService getInstance() {

        if (null == reservationService) {

            reservationService = new ReservationService();
        }
        return reservationService;
    }

    //method to add rooms to Collection<IRoom> rooms
    public void addRoom(IRoom room) {
        Room newRoom = new Room(roomNumber, price, enumeration);
        this.allRooms.add(newRoom);
        this.mapOfRooms.put(newRoom.getRoomNumber(), newRoom);
    }

    //method that should return roomId if roomId is available and
    public IRoom getARoom(String roomId) {

        for (IRoom room : mapOfRooms.values()) {

            if ((room.getRoomNumber()).equals(roomId)) {

                return room;

            }

        }
        return null;

    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {

        Reservation reservedRooms = new Reservation(customer, room, checkInDate, checkOutDate);

        this.allReservation.add(reservedRooms);
        this.mapOfReservations.put(reservedRooms.getCheckInDate(), reservedRooms);

        return reservedRooms;

    }

    public Collection<IRoom> findARoom(Date checkInDate, Date checkOutDate) {

        for (IRoom room : allRooms) {
            if ((checkInDate.after(checkInDate) && checkOutDate.before(checkOutDate))) {

                Iterator<IRoom> iRoomIterator = allRooms.iterator();

                while (iRoomIterator.hasNext()) {

                    System.out.println(iRoomIterator.next());

                }

                return allRooms;

            }


        }
        return null;


    }

    public Collection<Reservation> getCustomersReservation(Customer customer) {
        Collection<Reservation> reservationsByCustomer = new ArrayList<>();
        for (Reservation reserved : allReservation) {
            if (reserved.getCustomer().equals(customer)) {
                reservationsByCustomer.add(reserved);
            }
            return reservationsByCustomer;
        }

        return null;

    }


    public void printAllReservations() {

        for (Reservation reservation : allReservation) {
            Iterator iterator = allReservation.iterator();
            while (iterator.hasNext()) {
                System.out.println(allReservation);

            }

        }

    }

    public Collection<IRoom> allRooms() {
        return allRooms;
    }
}

