package domain;

import javax.persistence.*;


/**
 * Created by Daria on 26.10.2014.
 */
@Entity
@Table(name = "Excurs_Guide")
public class ExcursionGuide {

    @Id
    @Column(name = "seq_excurs_guide")
    @GeneratedValue()
    private Integer seq_excurs_guide;

    @Column(name = "excurs_id")
    private Integer excurs_id;

    @Column(name = "user_guide_id")
    private Integer user_guide_id;

    @Column(name = "date_excurs")
    private Long date_excurs;

    @Column(name = "tourist_quantity")
    private Integer tourist_quantity;

    public ExcursionGuide(Integer excurs_id, Integer user_guide_id, Long date_excurs, Integer tourist_quantity) {
        this.excurs_id = excurs_id;
        this.user_guide_id = user_guide_id;
        this.date_excurs = date_excurs;
        this.tourist_quantity = tourist_quantity;
    }

    public ExcursionGuide() {
    }

    public Integer getSeq_excurs_guide() {
        return seq_excurs_guide;
    }

    public void setSeq_excurs_guide(Integer seq_excurs_guide) {
        this.seq_excurs_guide = seq_excurs_guide;
    }

    public Integer getExcurs_id() {
        return excurs_id;
    }

    public void setExcurs_id(Integer excurs_id) {
        this.excurs_id = excurs_id;
    }

    public Long getDate_excurs() {
        return date_excurs;
    }

    public void setDate_excurs(Long date_excurs) {
        this.date_excurs = date_excurs;
    }

    public Integer getUser_guide_id() {
        return user_guide_id;
    }

    public void setUser_guide_id(Integer user_guide_id) {
        this.user_guide_id = user_guide_id;
    }

    public Integer getTourist_quantity() {
        return tourist_quantity;
    }

    public void setTourist_quantity(Integer tourist_quantity) {
        this.tourist_quantity = tourist_quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExcursionGuide that = (ExcursionGuide) o;

        if (date_excurs != null ? !date_excurs.equals(that.date_excurs) : that.date_excurs != null) return false;
        if (excurs_id != null ? !excurs_id.equals(that.excurs_id) : that.excurs_id != null) return false;
        if (seq_excurs_guide != null ? !seq_excurs_guide.equals(that.seq_excurs_guide) : that.seq_excurs_guide != null)
            return false;
        if (tourist_quantity != null ? !tourist_quantity.equals(that.tourist_quantity) : that.tourist_quantity != null)
            return false;
        if (user_guide_id != null ? !user_guide_id.equals(that.user_guide_id) : that.user_guide_id != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = seq_excurs_guide != null ? seq_excurs_guide.hashCode() : 0;
        result = 31 * result + (excurs_id != null ? excurs_id.hashCode() : 0);
        result = 31 * result + (user_guide_id != null ? user_guide_id.hashCode() : 0);
        result = 31 * result + (date_excurs != null ? date_excurs.hashCode() : 0);
        result = 31 * result + (tourist_quantity != null ? tourist_quantity.hashCode() : 0);
        return result;
    }
}
