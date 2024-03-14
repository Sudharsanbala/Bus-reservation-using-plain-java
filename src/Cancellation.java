import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Cancellation {

    private String passenger;
    private int busNo;
    private Date date;

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Cancellation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter passenger name: ");
        passenger = scanner.next();
        System.out.println("Enter Bus number: ");
        busNo = scanner.nextInt();
        System.out.println("Enter date you booked (format: dd-MM-yyyy): ");
        String dateInput = scanner.next();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date = simpleDateFormat.parse(dateInput);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd-MM-yyyy format.");
        }
    }

    public void cancelTicket(ArrayList<Booking> bookings) {


        boolean cancelled = false;

        for (Booking booking : bookings) {
            if (booking.getPassenger().equals(passenger) &&
                    booking.getDate().equals(date) &&
                    booking.getBusNo() == busNo) {
                // Cancel the booking
                bookings.remove(booking);
                System.out.println("Booking for " + passenger + " on " + date + " for bus number " + busNo + " has been cancelled.");
                cancelled = true;
                break; // Once booking is found and cancelled, exit the loop
            }
        }

        if (!cancelled) {
            System.out.println("Booking not found for the provided details.");
        }
    }
}
