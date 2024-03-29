package model;

import model.Customer;
import model.IRoom;

import java.util.Date;

public class Reservation {
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

 public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
     this.customer =  customer;
     this.room = room;
     this.checkInDate = checkInDate;
     this.checkOutDate = checkOutDate;
 }

    public void setCustomer(Customer customer) {

        this.customer = customer;
    }

    public Customer getCustomer() {

        return customer;
    }

    public void setIRoom(IRoom room) {

        this.room = room;
    }

    public IRoom getIRoom() {

        return room;
    }
    public void setCheckInDate (Date checkInDate) {
        this.checkInDate = checkInDate;
    }
    public Date getCheckInDate() {
        return checkInDate;
    }
    public void setCheckOutDate (Date checkOutDate) {
        this.checkOutDate = checkInDate;
    }
    public Date getCheckOutDate() {
        return checkOutDate;

    }
    @Override
    public String toString() {

        return "Customer " + customer + " Room " + room + " CheckInDate " + checkInDate + " CheckOutDate " + checkOutDate ;
    }

    }
