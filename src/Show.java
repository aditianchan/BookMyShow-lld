import java.time.LocalDateTime;

public class Show {
    private int showId;
    private Movie movie;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Screen screen;

    public Show(int showId, Movie movie, LocalDateTime startTime, LocalDateTime endTime, Screen screen) {
        this.showId = showId;
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = endTime;
        this.screen = screen;
    }

    public int getShowId() {
        return showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Screen getScreen() {
        return screen;
    }
}
