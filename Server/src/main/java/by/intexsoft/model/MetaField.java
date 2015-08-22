package by.intexsoft.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MetaField")
public class MetaField {
    @Id
    @Column(name = "meta_id")
    private Integer id;
    @Column(name = "meta_type")
    private String type;
    @Column(name = "validator")
    private String validator;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "metaId")
    private List<Field> fields;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValidator() {
        return validator;
    }

    public void setValidator(String validator) {
        this.validator = validator;
    }
}
