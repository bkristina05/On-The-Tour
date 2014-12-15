package transferObjects;

import org.joda.time.DateTime;

/**
 * Created by Daria on 15.12.2014.
 */
public class Excursion {
    private Integer idExcursion;
    private String town;
    private String place;
    private Integer available;
    private DateTime date;
    private Integer duration;
    private Double price;

    public Excursion(String town, String place, Integer idExcursion, Integer available, DateTime date, Integer duration, Double price) {
        this.town = town;
        this.place = place;
        this.idExcursion = idExcursion;
        this.available = available;
        this.date = date;
        this.duration = duration;
        this.price = price;
    }

    public Integer getIdExcursion() {
        return idExcursion;
    }

    public void setIdExcursion(Integer idExcursion) {
        this.idExcursion = idExcursion;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Excursion excursion = (Excursion) o;

        if (available != null ? !available.equals(excursion.available) : excursion.available != null) return false;
        if (date != null ? !date.equals(excursion.date) : excursion.date != null) return false;
        if (duration != null ? !duration.equals(excursion.duration) : excursion.duration != null) return false;
        if (idExcursion != null ? !idExcursion.equals(excursion.idExcursion) : excursion.idExcursion != null)
            return false;
        if (place != null ? !place.equals(excursion.place) : excursion.place != null) return false;
        if (price != null ? !price.equals(excursion.price) : excursion.price != null) return false;
        if (town != null ? !town.equals(excursion.town) : excursion.town != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idExcursion != null ? idExcursion.hashCode() : 0;
        result = 31 * result + (town != null ? town.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (available != null ? available.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Excursion{" +
                "idExcursion=" + idExcursion +
                ", town='" + town + '\'' +
                ", place='" + place + '\'' +
                ", available=" + available +
                ", date=" + date +
                ", duration=" + duration +
                ", price=" + price +
                '}';
    }
}
