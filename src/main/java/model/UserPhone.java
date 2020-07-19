package model;

import javax.persistence.*;

@Entity
@Table(name = "userphone", schema = "public")
public class UserPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String number;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MGUser mgUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public MGUser getMgUser() {
        return mgUser;
    }

    public void setMgUser(MGUser mgUser) {
        this.mgUser = mgUser;
    }

    @Override
    public String toString() {
        return "UserPhone{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", mgUser=" + mgUser +
                '}';
    }
}
