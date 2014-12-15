package transferObjects;

import org.joda.time.DateTime;

/**
 * Created by Daria on 15.12.2014.
 */
public class Excursion {
    private String place;
    private Integer available;
    private DateTime date;

    @Override
    public String toString() {
        return "Excursion{" +
                "place='" + place + '\'' +
                ", available=" + available +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Excursion excursion = (Excursion) o;

        if (available != null ? !available.equals(excursion.available) : excursion.available != null) return false;
        if (date != null ? !date.equals(excursion.date) : excursion.date != null) return false;
        if (place != null ? !place.equals(excursion.place) : excursion.place != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = place != null ? place.hashCode() : 0;
        result = 31 * result + (available != null ? available.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
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

    public Excursion(String place, Integer available, DateTime date) {
        this.place = place;
        this.available = available;
        this.date = date;
    }
}
