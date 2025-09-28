import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Theatre {
    private int id;
    private String theatreName;
    private List<Screen> screens;
    private List<Show> shows;
    private List<Booking> bookings;
    private List<Payment> payments;

    public Theatre(int id, String theatreName, List<Screen> screens, List<Show> shows) {
        this.id = id;
        this.theatreName = theatreName;
        this.screens = screens;
        this.shows = shows;
        this.bookings = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getTheatreName() { return theatreName; }
    public List<Screen> getScreens() { return screens; }
    public List<Show> getShows() { return shows; }
    public List<Booking> getBookings() { return bookings; }
    public List<Payment> getPayments() { return payments; }

    // Find shows by movie name
    public List<Show> findShowsByMovie(String movieName) {
        return shows.stream().filter(s -> s.getMovie().getMovieName().equalsIgnoreCase(movieName)).collect(Collectors.toList());
    }

    // Book seats for a show, create booking and payment
    public Booking bookSeats(User user, int showId, List<Integer> seatIds) {
        Show show = shows.stream().filter(s -> s.getShowId() == showId).findFirst().orElse(null);
        if (show == null) return null;
        List<Seat> selectedSeats = new ArrayList<>();
        int totalAmount = 0;
        for (int seatId : seatIds) {
            Seat seat = show.getScreen().getSeats().stream().filter(seatObj -> seatObj.getSeatId() == seatId && !seatObj.isBooked()).findFirst().orElse(null);
            if (seat == null) return null; // seat not available
            selectedSeats.add(seat);
            totalAmount += seat.getPrice();
        }
        // Book all selected seats atomically and thread-safely
        List<Seat> bookedSeats = new ArrayList<>();
        for (Seat seat : selectedSeats) {
            if (!seat.tryBook()) {
                // Rollback: cancel any seats already booked in this transaction
                for (Seat booked : bookedSeats) {
                    booked.tryCancel();
                }
                return null;
            }
            bookedSeats.add(seat);
        }
        Booking booking = new Booking(bookings.size() + 1, user, show, selectedSeats);
        bookings.add(booking);
        // Create payment
        Payment payment = new Payment(payments.size() + 1, booking, totalAmount, PaymentStatus.SUCCESS);
        payments.add(payment);
        booking.setPayment(payment);
        return booking;
    }
}
