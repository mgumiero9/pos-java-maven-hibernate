package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mguser", schema = "public")
@NamedQueries({
        @NamedQuery(name = "MGUser.getAllIds", query = "select id from MGUser")
})
public class MGUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;

    @OneToMany(mappedBy = "mgUser")
    private List<UserPhone> userPhones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserPhone> getUserPhones() {
        return userPhones;
    }

    public void setUserPhones(List<UserPhone> userPhones) {
        this.userPhones = userPhones;
    }

    @Override
    public String toString() {
        return "MGUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
