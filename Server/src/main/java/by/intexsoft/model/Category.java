package by.intexsoft.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Category")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Category{
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "parent_id")
    private Integer parentId;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryId")
    private List<Report> reportList;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}