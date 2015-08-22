package by.intexsoft.model;

import javax.persistence.*;

@Entity
@Table(name = "Role")
public class Role{
    @Id
    @Column(name = "role_id")
    private Integer id;
    @Column(name = "role_name")
    private String roleName;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "roleId")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
