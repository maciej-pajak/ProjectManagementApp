package pl.maciejpajak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.maciejpajak.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
