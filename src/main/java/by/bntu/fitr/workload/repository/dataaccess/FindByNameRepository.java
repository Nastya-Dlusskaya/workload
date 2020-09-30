package by.bntu.fitr.workload.repository.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface FindByNameRepository<ENTITY, ID> extends JpaRepository<ENTITY, ID> {

    ENTITY findByName(String name);
}
