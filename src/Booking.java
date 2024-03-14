
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;



public class Booking {

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

    public Booking() {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter name of passenger: ");
        passenger= scanner.next();
        System.out.println("Enter bus number: ");
        busNo=scanner.nextInt();
        System.out.println("Enter dd-mm-yyyy :");
        String dateInput=scanner.next();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
        try {
            date =simpleDateFormat.parse(dateInput);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }
    public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
        int capacity=0;
        for(Bus bus:buses){
            if(bus.getBusNo()==busNo)
                capacity=bus.getCapacity();
        }
        int booked=0;
        for(Booking booking:bookings){
            if(booking.busNo==busNo && booking.date.equals(date)){
                booked++;
            }
        }
        return booked<capacity?true:false;


    }
}
