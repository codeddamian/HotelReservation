package UI;
import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
https://github.com/codeddamian/HotelReservation.gitenu {

        public static void main(String[] args) throws ParseException {
            int selectedOption = selectMainMenu();
            switch (selectedOption){
                case 1:
                    addReservationMenu();
                    break;
                case 3:
                    addCustomerMenu();
                    CustomerService.getInstance().printAllCustomers();
                    break;
                case 4:
                    int selectedAdminOption = AdminMenu.selectAdminMenu();
                    AdminMenu.addLogicForAdminOptions(selectedAdminOption);
                    break;
                case 5:
                    System.exit(0);
            }
        }
        public static int selectMainMenu(){

            System.out.println("MAIN MENU");
            System.out.println("Choose option");
            System.out.println("1. Find and reserve a room");
            System.out.println("2. See my reservations");
            System.out.println("3. Create an account");
            System.out.println("4. Admin");
            System.out.println("5. Exit");
            Scanner input = new Scanner(System.in);
            int selection = input.nextInt();
            System.out.println("You selected option number " + selection + " from Main Menu.");
            return selection;
        }
        public static void addCustomerMenu(){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter email: ");
            String customerEmail = input.nextLine();
            System.out.println("Enter first name: ");
            String customerFirstName = input.nextLine();
            System.out.println("Enter last name: ");
            String customerLastName = input.nextLine();
            CustomerService.getInstance().addCustomer(customerFirstName,customerLastName,customerEmail);
        }
        public static void addReservationMenu() throws ParseException {
            IRoom reservedRoom = null;
            Scanner input = new Scanner(System.in);
            System.out.println("Enter CheckIn Date mm/dd/yyyy");
            Date checkInDate = new SimpleDateFormat("MM/dd/yyyy").parse(input.nextLine());
            System.out.println("Enter CheckOut Date mm/dd/yyyy");
            Date checkOutdate = new SimpleDateFormat("MM/dd/yyyy").parse(input.nextLine());
            System.out.println("Enter your email ");
            String reservationEmail = input.nextLine();
            System.out.println("What room would you like to reserve?");
            String roomNumber = input.nextLine();
            try{
                reservedRoom = ReservationService.getInstance().getARoom(roomNumber);
            } catch (Exception ex){
                System.out.println("Room does not exist");
            }

            Customer customer = CustomerService.getInstance().getCustomer(reservationEmail);
            ReservationService.getInstance().reserveARoom(customer,reservedRoom, checkInDate, checkOutdate);

        }
    }
}
