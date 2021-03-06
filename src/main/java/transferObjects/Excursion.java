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
    private String description;
    private String name;
    private String phone;
    private String email;


    public Excursion(Integer idExcursion, String town, String place, Integer available, DateTime date, Integer duration, Double price, String description) {
        this.idExcursion = idExcursion;
        this.town = town;
        this.place = place;
        this.available = available;
        this.date = date;
        this.duration = duration;
        this.price = price;
        this.description = description;
    }

    public Excursion(Double price, String town, String place, DateTime date, Integer duration, String name, String phone, String email, Integer available,Integer idExcursion) {
        this.price = price;
        this.town = town;
        this.place = place;
        this.date = date;
        this.duration = duration;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.available = available;
        this.idExcursion = idExcursion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Excursion excursion = (Excursion) o;

        if (available != null ? !available.equals(excursion.available) : excursion.available != null) return false;
        if (date != null ? !date.equals(excursion.date) : excursion.date != null) return false;
        if (description != null ? !description.equals(excursion.description) : excursion.description != null)
            return false;
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
        result = 31 * result + (description != null ? description.hashCode() : 0);
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
                ", description='" + description + '\'' +
                '}';
    }
}
