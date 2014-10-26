import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Created by Daria on 26.10.2014.
 */

@Entity
@Table(name = "Type_Name")
public class TypeName {
    @Id
    @Column(name = "type_id")
    private Integer type_id;

    @Column(name = "type_name")
    private String type_name;

    public TypeName(Integer type_id, String type_name) {
        this.type_id = type_id;
        this.type_name = type_name;
    }

    public TypeName() {
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    @Override
    public String toString() {
        return "TypeName{" +
                "type_id=" + type_id +
                ", type_name='" + type_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeName typeName = (TypeName) o;

        if (type_id != null ? !type_id.equals(typeName.type_id) : typeName.type_id != null) return false;
        if (type_name != null ? !type_name.equals(typeName.type_name) : typeName.type_name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type_id != null ? type_id.hashCode() : 0;
        result = 31 * result + (type_name != null ? type_name.hashCode() : 0);
        return result;
    }
}
