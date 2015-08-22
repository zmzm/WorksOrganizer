package by.intexsoft.repository;

import by.intexsoft.model.ProcessStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessStepRepository extends JpaRepository<ProcessStep, Integer> {
}
