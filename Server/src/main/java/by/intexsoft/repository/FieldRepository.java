package by.intexsoft.repository;

import by.intexsoft.model.Field;
import by.intexsoft.model.ProcessStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldRepository extends JpaRepository<Field, Integer> {
    @Query("SELECT f FROM Field f where f.stepId = :step")
    public List<Field> getStepByStep(@Param("step") ProcessStep step);
}
