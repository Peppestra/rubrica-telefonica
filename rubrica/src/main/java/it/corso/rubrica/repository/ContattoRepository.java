package it.corso.rubrica.repository;

import org.springframework.stereotype.Repository;

import it.corso.rubrica.model.Contatto;

@Repository
public interface ContattoRepository extends JpaRepository<Contatto, Long>{

}
