package model;

public class Tester {
    public static void main(String[] args) {

        Customer  damian = new Customer("Damian", "Odoh", "email");
        try {
            System.out.println(damian) ;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getLocalizedMessage());
        }

    }

}
