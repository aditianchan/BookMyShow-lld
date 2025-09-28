import java.util.List;

public class Screen {
    private int screenId;
    private ScreenType screenType;
    private List<Seat> seats;

    public Screen(int screenId, ScreenType screenType, List<Seat> seats) {
        this.screenId = screenId;
        this.screenType = screenType;
        this.seats = seats;
    }

    public int getScreenId() {
        return screenId;
    }

    public ScreenType getScreenType() {
        return screenType;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
