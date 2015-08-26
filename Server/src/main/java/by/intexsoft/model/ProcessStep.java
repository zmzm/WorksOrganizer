package by.intexsoft.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ProcessStep")
public class ProcessStep {
    @Id
    @Column(name = "step_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "step_name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "process_id")
    private Process processId;
    @Column(name = "step_priority")
    private Integer priority;
    @Column(name = "step_status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
    @OneToMany
    @JoinColumn(name = "stepId")
    private List<Field> fields;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Process getProcess() {
        return processId;
    }

    public void setProcess(Process processId) {
        this.processId = processId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser(){return this.userId;}

    public void setUser(User user){
        this.userId = user;
    }
}
