package domain;

import javax.persistence.*;


/**
 * Created by Daria on 26.10.2014.
 */


@Entity
@Table(name = "excursion")
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

    @Column(name = "duration_tour")
    private Integer duration_tour;

    @Column(name = "description")
    private String description;

    public Excursion() {
    }

    public Excursion(String place, String town, Integer max_tourists, Double price, Integer duration_tour, String description) {
        this.place = place;
        this.town = town;
        this.max_tourists = max_tourists;
        this.price = price;
        this.duration_tour = duration_tour;
        this.description = description;
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

    public Integer getMax_tourists() {
        return max_tourists;
    }

    public void setMax_tourists(Integer max_tourists) {
        this.max_tourists = max_tourists;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDuration_tour() {
        return duration_tour;
    }

    public void setDuration_tour(Integer duration_tour) {
        this.duration_tour = duration_tour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Excursion excursion = (Excursion) o;

        if (description != null ? !description.equals(excursion.description) : excursion.description != null)
            return false;
        if (duration_tour != null ? !duration_tour.equals(excursion.duration_tour) : excursion.duration_tour != null)
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
        result = 31 * result + (duration_tour != null ? duration_tour.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
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
                ", duration_tour=" + duration_tour +
                ", description='" + description + '\'' +
                '}';
    }
}
