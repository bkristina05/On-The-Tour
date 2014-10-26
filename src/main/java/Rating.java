import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Created by Daria on 26.10.2014.
 */
@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @Column(name = "excurs_id")
    private Integer excurs_id;

    @Id
    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "rating")
    private Double rating;

    public Rating(Integer excurs_id, Integer user_id, Double rating) {
        this.excurs_id = excurs_id;
        this.user_id = user_id;
        this.rating = rating;
    }

    public Rating() {
    }

    public Integer getExcurs_id() {
        return excurs_id;
    }

    public void setExcurs_id(Integer excurs_id) {
        this.excurs_id = excurs_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "excurs_id=" + excurs_id +
                ", user_id=" + user_id +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rating rating1 = (Rating) o;

        if (excurs_id != null ? !excurs_id.equals(rating1.excurs_id) : rating1.excurs_id != null) return false;
        if (rating != null ? !rating.equals(rating1.rating) : rating1.rating != null) return false;
        if (user_id != null ? !user_id.equals(rating1.user_id) : rating1.user_id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = excurs_id != null ? excurs_id.hashCode() : 0;
        result = 31 * result + (user_id != null ? user_id.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }
}
