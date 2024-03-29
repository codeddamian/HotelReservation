package api;

import model.*;
import service.CustomerService;
import service.ReservationService;


import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class HotelResource {

    private static HotelResource hotelResource;
    public static CustomerService customerService = CustomerService.getInstance();
    public static ReservationService reservationService = ReservationService.getInstance();

    private HotelResource() {
    }


    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName){
            customerService.addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom(String roomNumber){
       return reservationService.getARoom(roomNumber);
    }


    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate,  Date checkOutDate)
    {
        Customer customer = CustomerService.getInstance().getCustomer(customerEmail);
        if (customer == null) return null;
        return reservationService.reserveARoom(customer,room,checkInDate,checkOutDate);

    }
    public Collection<Reservation> getCustomerReservations(String customerEmail){

        Customer customer = CustomerService.getInstance().getCustomer(customerEmail);

        if (customer == null) return null;

        return reservationService.getCustomersReservation(customer);

    }

    public Collection<IRoom> findARoom(Date checkInDate, Date checkOutDate){

        return reservationService.findARoom(checkInDate, checkOutDate);

    }

    }


