import java.util.List;

public class Booking {
    private int bookingId;
    private User user;
    private Show show;
    private List<Seat> seats;
    private BookingStatus status;
    private Payment payment;

    public Booking(int bookingId, User user, Show show, List<Seat> seats) {
        this.bookingId = bookingId;
        this.user = user;
        this.show = show;
        this.seats = seats;
        this.status = BookingStatus.CONFIRMED;
    }

    public int getBookingId() { return bookingId; }
    public User getUser() { return user; }
    public Show getShow() { return show; }
    public List<Seat> getSeats() { return seats; }
    public BookingStatus getStatus() { return status; }
    public void setStatus(BookingStatus status) { this.status = status; }
    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment) { this.payment = payment; }
}
