package pl.maciejpajak.repository;

import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.maciejpajak.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p LEFT JOIN FETCH p.users WHERE p.id=:id AND p.active=true")
    public Optional<Project> findOneByIdAndActiveFetchUsers(@Param("id") Long id);

    public List<Project> findByOwnerIdAndActive(Long id, boolean isActive);

    public List<Project> findByUsersIdAndActive(Long id, boolean isActive);

    @Query("SELECT new pl.maciejpajak.util.Pair(p.id, p.identifier) FROM Project p WHERE p.owner.id=:id AND p.active=true")
    public List<Entry<Long, String>> findActiveNamesAndIdsByOwnerAndActive(@Param("id") Long id);
    
    @Query("SELECT p.name FROM Project p WHERE p.id=:id")
    public String findProjectIdentifier(@Param("id") Long id);
    
}
