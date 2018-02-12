package pl.maciejpajak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.maciejpajak.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
