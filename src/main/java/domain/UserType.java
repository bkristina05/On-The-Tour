package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Created by Daria on 26.10.2014.
 */

@Entity
@Table(name = "User_Type")
public class UserType {

    @Id
    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "type_id")
    private String type_id;


    public UserType(Integer user_id,String type_id) {
        this.user_id = user_id;
        this.type_id = type_id;
    }

    public UserType() {
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "bd.UserType{" +
                "type_id=" + type_id +
                ", user_id='" + user_id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserType userType = (UserType) o;

        if (type_id != null ? !type_id.equals(userType.type_id) : userType.type_id != null) return false;
        if (user_id != null ? !user_id.equals(userType.user_id) : userType.user_id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type_id != null ? type_id.hashCode() : 0;
        result = 31 * result + (user_id != null ? user_id.hashCode() : 0);
        return result;
    }
}

