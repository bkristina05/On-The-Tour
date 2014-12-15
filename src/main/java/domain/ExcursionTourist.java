package domain;

import javax.persistence.*;


/**
 * Created by Daria on 26.10.2014.
 */
@Entity
@Table(name = "Excurs_Tourist")
public class ExcursionTourist {
    @Id
    @Column(name = "sequence_id")
    @GeneratedValue()
    private Integer sequence_id;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "excurs_guide_seq")
    private Integer excurs_guide_seq;


    public ExcursionTourist(Integer user_id, Integer excurs_guide_seq) {
        this.user_id = user_id;
        this.excurs_guide_seq = excurs_guide_seq;
    }

    public ExcursionTourist() {
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getSequence_id() {
        return sequence_id;
    }

    public void setSequence_id(Integer sequence_id) {
        this.sequence_id = sequence_id;
    }

    public Integer getExcurs_guide_seq() {
        return excurs_guide_seq;
    }

    public void setExcurs_guide_seq(Integer excurs_guide_seq) {
        this.excurs_guide_seq = excurs_guide_seq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExcursionTourist that = (ExcursionTourist) o;

        if (excurs_guide_seq != null ? !excurs_guide_seq.equals(that.excurs_guide_seq) : that.excurs_guide_seq != null)
            return false;
        if (sequence_id != null ? !sequence_id.equals(that.sequence_id) : that.sequence_id != null) return false;
        if (user_id != null ? !user_id.equals(that.user_id) : that.user_id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sequence_id != null ? sequence_id.hashCode() : 0;
        result = 31 * result + (user_id != null ? user_id.hashCode() : 0);
        result = 31 * result + (excurs_guide_seq != null ? excurs_guide_seq.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ExcursionTourist{" +
                "sequence_id=" + sequence_id +
                ", user_id=" + user_id +
                ", excurs_guide_seq=" + excurs_guide_seq +
                '}';
    }
}
