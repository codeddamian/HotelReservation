package api;
import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.*;

public class AdminResource {
    private static HotelResource hotelResource;
    public static CustomerService customerService = CustomerService.getInstance();
    public static ReservationService reservationService = ReservationService.getInstance();

        public static AdminResource adminResource = new AdminResource();
    // Static Reference
        private AdminResource() {

        }

        public Customer getCustomer(String email) {
            return customerService.getCustomer(email);
        }

        public void addRoom(List<IRoom> room) {
            for (IRoom rum : room) {
                reservationService.addRoom(rum);
            }
        }

        public  Collection<IRoom> getAllRooms(){

        return reservationService.allRooms();

    }

    public  Collection<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    public void displayAllReservations(){
      reservationService.printAllReservations();
    }

}
