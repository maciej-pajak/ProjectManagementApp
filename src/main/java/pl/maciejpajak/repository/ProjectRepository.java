package pl.maciejpajak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.maciejpajak.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p LEFT JOIN FETCH p.users WHERE p.id=:id")
    public Project findOneByIdFetchUsers(@Param("id") Long id);
    
    public List<Project> findByOwnerId(Long id);
    
    public List<Project> findByUsersId(Long id);
    
}
