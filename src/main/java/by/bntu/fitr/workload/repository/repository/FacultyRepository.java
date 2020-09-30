package by.bntu.fitr.workload.repository.repository;

import by.bntu.fitr.workload.repository.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
