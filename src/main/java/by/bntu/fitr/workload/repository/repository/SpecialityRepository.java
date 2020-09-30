package by.bntu.fitr.workload.repository.repository;

import by.bntu.fitr.workload.repository.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
}
