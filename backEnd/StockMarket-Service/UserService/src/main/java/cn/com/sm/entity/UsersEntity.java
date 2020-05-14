package cn.com.sm.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "mydb", catalog = "")
public class UsersEntity {
    private int id;
    private String username;
    private String password;
    private String userType;
    private String email;
    private String mobileNumber;
    private String confirmed;
    private Timestamp lastChgTsp;
    private Timestamp createTsp;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "user_type")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "mobile_number")
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Basic
    @Column(name = "confirmed")
    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    @Basic
    @Column(name = "last_chg_tsp")
    public Timestamp getLastChgTsp() {
        return lastChgTsp;
    }

    public void setLastChgTsp(Timestamp lastChgTsp) {
        this.lastChgTsp = lastChgTsp;
    }

    @Basic
    @Column(name = "create_tsp")
    public Timestamp getCreateTsp() {
        return createTsp;
    }

    public void setCreateTsp(Timestamp createTsp) {
        this.createTsp = createTsp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return id == that.id &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(userType, that.userType) &&
                Objects.equals(email, that.email) &&
                Objects.equals(mobileNumber, that.mobileNumber) &&
                Objects.equals(confirmed, that.confirmed) &&
                Objects.equals(lastChgTsp, that.lastChgTsp) &&
                Objects.equals(createTsp, that.createTsp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, userType, email, mobileNumber, confirmed, lastChgTsp, createTsp);
    }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", confirmed='" + confirmed + '\'' +
                ", lastChgTsp=" + lastChgTsp +
                ", createTsp=" + createTsp +
                '}';
    }
}
