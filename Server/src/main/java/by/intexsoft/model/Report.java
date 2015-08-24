package by.intexsoft.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "Report")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Report{
    @Id
    @Column(name = "report_id")
    private Integer id;
    @Column(name = "report_name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "process_id")
    private Process processId;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoryId;

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

    public Category getCategory() {
        return categoryId;
    }

    public void setCategory(Category categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
