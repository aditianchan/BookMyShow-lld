import java.util.concurrent.atomic.AtomicBoolean;

public class Seat {
    private int seatId;
    private int price;
    private final AtomicBoolean isBooked = new AtomicBoolean(false);

    public Seat(int seatId, int price) {
        this.seatId = seatId;
        this.price = price;
    }

    public int getSeatId() {
        return seatId;
    }

    public int getPrice() {
        return price;
    }

    public boolean isBooked() {
        return isBooked.get();
    }

    /**
     * Atomically tries to book the seat. Returns true if booking succeeded, false if already booked.
     */
    public boolean tryBook() {
        return isBooked.compareAndSet(false, true);
    }

    /**
     * Atomically cancels the booking. Returns true if cancellation succeeded, false if not booked.
     */
    public boolean tryCancel() {
        return isBooked.compareAndSet(true, false);
    }
}
