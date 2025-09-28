import java.util.List;

public class City {
    private String name;
    private List<Theatre> theatres;

    public City(String name, List<Theatre> theatres) {
        this.name = name;
        this.theatres = theatres;
    }

    public String getName() {
        return name;
    }

    public List<Theatre> getTheatres() {
        return theatres;
    }
}
