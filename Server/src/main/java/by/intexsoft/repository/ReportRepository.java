package by.intexsoft.repository;

import by.intexsoft.model.Category;
import by.intexsoft.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
    @Query("SELECT r FROM Report r where r.categoryId = :category")
    Report findReportByCategory(@Param("category") Category category);
}
