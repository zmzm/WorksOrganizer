package by.intexsoft.repository;

import by.intexsoft.model.MetaField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaFieldRepository extends JpaRepository<MetaField, Integer> {
}
