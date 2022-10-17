package br.com.fiap.fluvu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.fluvu.model.Central;

@Repository
public interface CentralRepository extends JpaRepository<Central, Long> {
}
