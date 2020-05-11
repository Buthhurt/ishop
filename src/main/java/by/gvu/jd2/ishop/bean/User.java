package by.gvu.jd2.ishop.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable {
    static final long serialVersionUID = 86L;

    private Long id;
    private String login;
    private String pswSh3;
    private String pswMd5;
    private String email;
    private Integer roleId;
    private String firstName;
    private String secondName;
    private String nikName;
    private Integer sexId;
    private Timestamp birthday;

    public User() {
        //Empty constructor
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPswSh3() {
        return pswSh3;
    }

    public void setPswSh3(String pswSh3) {
        this.pswSh3 = pswSh3;
    }

    public String getPswMd5() {
        return pswMd5;
    }

    public void setPswMd5(String pswMd5) {
        this.pswMd5 = pswMd5;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getNikName() {
        return nikName;
    }

    public void setNikName(String nikName) {
        this.nikName = nikName;
    }

    public Integer getSexId() {
        return sexId;
    }

    public void setSexId(Integer sexId) {
        this.sexId = sexId;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (pswSh3 != null ? !pswSh3.equals(user.pswSh3) : user.pswSh3 != null) return false;
        if (pswMd5 != null ? !pswMd5.equals(user.pswMd5) : user.pswMd5 != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (roleId != null ? !roleId.equals(user.roleId) : user.roleId != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (secondName != null ? !secondName.equals(user.secondName) : user.secondName != null) return false;
        if (nikName != null ? !nikName.equals(user.nikName) : user.nikName != null) return false;
        if (sexId != null ? !sexId.equals(user.sexId) : user.sexId != null) return false;
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (pswSh3 != null ? pswSh3.hashCode() : 0);
        result = 31 * result + (pswMd5 != null ? pswMd5.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (nikName != null ? nikName.hashCode() : 0);
        result = 31 * result + (sexId != null ? sexId.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pswSh3='" + pswSh3 + '\'' +
                ", pswMd5='" + pswMd5 + '\'' +
                ", email='" + email + '\'' +
                ", roleId=" + roleId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", nikName='" + nikName + '\'' +
                ", sexId='" + sexId + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
