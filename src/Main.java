import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create seats for Bronze screen
        List<Seat> seatListBronze = new ArrayList<>();
        seatListBronze.add(new Seat(1, 100));
        seatListBronze.add(new Seat(2, 100));
        // Create seats for Gold screen
        List<Seat> seatListGold = new ArrayList<>();
        seatListGold.add(new Seat(3, 500));
        seatListGold.add(new Seat(4, 500));
        // Create screens
        Screen bronzeScreen = new Screen(1, ScreenType.BRONZE, seatListBronze);
        Screen goldScreen = new Screen(2, ScreenType.GOLD, seatListGold);
        List<Screen> screens = new ArrayList<>();
        screens.add(bronzeScreen);
        screens.add(goldScreen);
        // Create shows, each on a specific screen
        List<Show> showList = new ArrayList<>();
        Show show1 = new Show(1, new Movie(1, "Conjuring"), LocalDateTime.of(2025, 9, 28, 18, 0), LocalDateTime.of(2025, 9, 28, 20, 0), bronzeScreen);
        Show show2 = new Show(2, new Movie(2, "Conjuring 2"), LocalDateTime.of(2025, 9, 28, 21, 0), LocalDateTime.of(2025, 9, 28, 23, 0), goldScreen);
        showList.add(show1);
        showList.add(show2);
        // Create theatre
        Theatre theatre1 = new Theatre(1, "INOX", screens, showList);
        List<Theatre> theatreList = new ArrayList<>();
        theatreList.add(theatre1);
        // Create city
        City city = new City("Bangalore", theatreList);
        // Create user
        User user = new User(1, "Alice", "alice@example.com");
        // Book multiple seats for user for show1
        List<Integer> seatIdsToBook = new ArrayList<>();
        seatIdsToBook.add(1);
        seatIdsToBook.add(2);
        Booking booking = theatre1.bookSeats(user, 1, seatIdsToBook);
        if (booking != null) {
            System.out.println("Booking successful!\nBooking ID: " + booking.getBookingId() +
                    "\nUser: " + booking.getUser().getName() +
                    "\nMovie: " + booking.getShow().getMovie().getMovieName() +
                    "\nSeats: " + booking.getSeats().stream().map(Seat::getSeatId).toList() +
                    "\nTotal Amount: " + booking.getPayment().getAmount() +
                    "\nPayment Status: " + booking.getPayment().getStatus());
        } else {
            System.out.println("Booking failed.");
        }

    }
}