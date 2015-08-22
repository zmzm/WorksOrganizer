package by.intexsoft.model;

import javax.persistence.*;

@Entity
@Table(name = "Field")
public class Field{
    @Id
    @Column(name = "field_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "field_name")
    private String name;
    @Column(name = "field_value")
    private String value;
    @ManyToOne
    @JoinColumn(name = "meta_id")
    private MetaField metaId;
    @ManyToOne
    @JoinColumn(name = "step_id")
    private ProcessStep stepId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public MetaField getMeta() {
        return metaId;
    }

    public void setMeta(MetaField meta_id) {
        this.metaId = meta_id;
    }

    public ProcessStep getStep() {
        return stepId;
    }

    public void setStep(ProcessStep step_id) {
        this.stepId = step_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
