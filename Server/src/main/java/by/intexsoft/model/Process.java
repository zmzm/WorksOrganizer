package by.intexsoft.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Process")
public class Process{
    @Id
    @Column(name = "process_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "process_name")
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "processId")
    private List<Report> report;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "processId")
    private List<ProcessStep> processSteps;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
