package br.com.fiap.fluvu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.fiap.fluvu.model.SensorBoeiro;

@Repository
public interface SensorRepository extends JpaRepository<SensorBoeiro, Long> {
}
