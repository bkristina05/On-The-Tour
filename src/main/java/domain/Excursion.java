package domain;

import javax.persistence.*;
import java.security.Timestamp;


/**
 * Created by Daria on 26.10.2014.
 */


@Entity
@Table(name = "Excursion")
public class Excursion {
    @Id
    @Column(name = "excurs_id")
    @GeneratedValue()
    private Integer excurs_id;

    @Column(name = "place")
    private String place;

    @Column(name = "town")
    private String town;

    @Column(name = "max_tourists")
    private Integer max_tourists;

    @Column(name = "price")
    private Double price;

    @Column(name = "tour_starts")
    private Timestamp tour_starts;

    @Column(name = "tour_end")
    private Timestamp tour_end;

    public Excursion(String place, String town, Integer max_tourists, Double price, Timestamp tour_starts, Timestamp tour_end) {
        this.place = place;
        this.town = town;
        this.max_tourists = max_tourists;
        this.price = price;
        this.tour_starts = tour_starts;
        this.tour_end = tour_end;
    }

    public Excursion() {
    }

    public Integer getExcurs_id() {
        return excurs_id;
    }

    public void setExcurs_id(Integer excurs_id) {
        this.excurs_id = excurs_id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Integer getMax_tourists() {
        return max_tourists;
    }

    public void setMax_tourists(Integer max_tourists) {
        this.max_tourists = max_tourists;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Timestamp getTour_starts() {
        return tour_starts;
    }

    public void setTour_starts(Timestamp tour_starts) {
        this.tour_starts = tour_starts;
    }

    public Timestamp getTour_end() {
        return tour_end;
    }

    public void setTour_end(Timestamp tour_end) {
        this.tour_end = tour_end;
    }

    @Override
    public String toString() {
        return "Excursion{" +
                "excurs_id = " + excurs_id +
                ", place='" + place + '\'' +
                ", town='" + town + '\'' +
                ", max_tourists=" + max_tourists +
                ", price=" + price +
                ", tour_starts=" + tour_starts +
                ", tour_end=" + tour_end +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Excursion excursion = (Excursion) o;

        if (excurs_id != null ? !excurs_id.equals(excursion.excurs_id) : excursion.excurs_id != null) return false;
        if (max_tourists != null ? !max_tourists.equals(excursion.max_tourists) : excursion.max_tourists != null)
            return false;
        if (place != null ? !place.equals(excursion.place) : excursion.place != null) return false;
        if (price != null ? !price.equals(excursion.price) : excursion.price != null) return false;
        if (tour_end != null ? !tour_end.equals(excursion.tour_end) : excursion.tour_end != null) return false;
        if (tour_starts != null ? !tour_starts.equals(excursion.tour_starts) : excursion.tour_starts != null)
            return false;
        if (town != null ? !town.equals(excursion.town) : excursion.town != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = excurs_id != null ? excurs_id.hashCode() : 0;
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (town != null ? town.hashCode() : 0);
        result = 31 * result + (max_tourists != null ? max_tourists.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (tour_starts != null ? tour_starts.hashCode() : 0);
        result = 31 * result + (tour_end != null ? tour_end.hashCode() : 0);
        return result;
    }
}
