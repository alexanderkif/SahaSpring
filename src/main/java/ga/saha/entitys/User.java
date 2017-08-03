package ga.saha.entitys;

import javax.persistence.*;

/**
 * Created by ya on 30.07.2017.
 */
@Entity
@Table(name = "users", schema = "public", catalog = "db5g9j38hag412")
public class User {
    private int idUser;
    private String firstname;
    private String password;
    private String email;
    private Boolean checked;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user", updatable = false, nullable = false)
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "firstname", nullable = true, length = 15)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 15)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "checked", nullable = true)
    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", firstname='" + firstname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", checked=" + checked +
                '}';
    }
}
