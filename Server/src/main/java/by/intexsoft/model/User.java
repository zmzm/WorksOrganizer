package by.intexsoft.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "User")
public class User{
    @Id
    @Column(name = "user_id")
    private Integer id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_password")
    private String userPassword;
    @OneToOne
    @JoinColumn(name = "role_id")
    private Role roleId;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "userId")
    private ProcessStep processStep;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }
}
