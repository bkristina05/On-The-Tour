package domain;

import javax.persistence.*;


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

    @Column(name = "duration_tour_minutes")
    private Integer duration_tour_minutes;

    public Excursion(String place, String town, Integer max_tourists, Double price, Integer duration_tour_minutes) {
        this.place = place;
        this.town = town;
        this.max_tourists = max_tourists;
        this.price = price;
        this.duration_tour_minutes = duration_tour_minutes;
    }

    public Excursion(){}

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

    public Integer getDuration_tour_minutes() {
        return duration_tour_minutes;
    }

    public void setDuration_tour_minutes(Integer duration_tour_minutes) {
        this.duration_tour_minutes = duration_tour_minutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Excursion excursion = (Excursion) o;

        if (duration_tour_minutes != null ? !duration_tour_minutes.equals(excursion.duration_tour_minutes) : excursion.duration_tour_minutes != null)
            return false;
        if (excurs_id != null ? !excurs_id.equals(excursion.excurs_id) : excursion.excurs_id != null) return false;
        if (max_tourists != null ? !max_tourists.equals(excursion.max_tourists) : excursion.max_tourists != null)
            return false;
        if (place != null ? !place.equals(excursion.place) : excursion.place != null) return false;
        if (price != null ? !price.equals(excursion.price) : excursion.price != null) return false;
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
        result = 31 * result + (duration_tour_minutes != null ? duration_tour_minutes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Excursion{" +
                "excurs_id=" + excurs_id +
                ", place='" + place + '\'' +
                ", town='" + town + '\'' +
                ", max_tourists=" + max_tourists +
                ", price=" + price +
                ", duration_tour_minutes=" + duration_tour_minutes +
                '}';
    }
}
