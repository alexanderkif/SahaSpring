package ga.saha.entitys;

import javax.persistence.*;

/**
 * Created by ya on 30.07.2017.
 */
@Entity
@Table(name = "safes", schema = "public", catalog = "db5g9j38hag412")
public class SafeEntity {
    private int idSafe;
    private Long user;
    private String name;
    private String in;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_safe", updatable = false, nullable = false)
    public int getIdSafe() {
        return idSafe;
    }

    public void setIdSafe(int idSafe) {
        this.idSafe = idSafe;
    }

    @Basic
    @Column(name = "user", nullable = true)
    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "in", nullable = true, length = 300)
    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SafeEntity that = (SafeEntity) o;

        if (idSafe != that.idSafe) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (in != null ? !in.equals(that.in) : that.in != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSafe;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (in != null ? in.hashCode() : 0);
        return result;
    }
}
