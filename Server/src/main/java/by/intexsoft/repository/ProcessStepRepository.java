package by.intexsoft.repository;

import by.intexsoft.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import by.intexsoft.model.Process;

import java.util.List;

@Repository
public interface ProcessStepRepository extends JpaRepository<ProcessStep, Integer> {
    @Query("SELECT s FROM ProcessStep s where s.processId = :process")
    public List<ProcessStep> getStepByProcess(@Param("process") Process process);
}
