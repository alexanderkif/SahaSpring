package ga.saha.entitys;

import javax.persistence.*;

@Entity
@Table(name = "saves", schema = "public", catalog = "db5g9j38hag412")
public class Save {
    private int idSafe;
    private int user;
    private String name;
    private String in;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_save", updatable = false, nullable = false)
    public int getIdSafe() {
        return idSafe;
    }

    public void setIdSafe(int idSafe) {
        this.idSafe = idSafe;
    }

    @Basic
    @Column(name = "user", nullable = true)
    public int getUser() {
        return user;
    }

    public void setUser(int user) {
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



}
