import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Busdemo {

    public static void main(String[] args) {

        ArrayList<Bus> buses = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

        buses.add(new Bus(1, true, 1));
        for (Bus b : buses) {
            b.displayInfo();
        }

        int userOpt = 1;
        Scanner scanner = new Scanner(System.in);
        while (userOpt == 1) {
            System.out.println("Enter 1 to book tickets, 2 to cancel tickets, and 3 to exit");
            userOpt = scanner.nextInt();

            if (userOpt == 1) {
                Booking booking = new Booking();
                if (booking.isAvailable(bookings, buses)) {
                    bookings.add(booking);
                    System.out.println("Booking is successfully confirmed.");
                } else {
                    System.out.println("Sorry, bus is full!");
                }
            } else if (userOpt == 2) {

                Cancellation cancellation=new Cancellation();

                cancellation.cancelTicket(bookings);


                }
            else{
                System.out.println("You have chose to exit the booking .......");
            }
            }
        }
    }

