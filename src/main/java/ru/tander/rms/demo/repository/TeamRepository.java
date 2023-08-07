package ru.tander.rms.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tander.rms.demo.entity.TeamEntity;

public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
}
