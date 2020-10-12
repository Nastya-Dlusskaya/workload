package by.bntu.fitr.workload.repository.dataaccess;

import by.bntu.fitr.workload.repository.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long>, FindByNameRepository<Lecturer, Long> {

    Lecturer findByEmail(String email);

}
