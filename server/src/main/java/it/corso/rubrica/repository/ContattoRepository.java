package it.corso.rubrica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.corso.rubrica.model.Contatto;

@Repository
public interface ContattoRepository extends JpaRepository<Contatto, Long>{
	List<Contatto> findAllByOrderById();
	List<Contatto> findByNomeContains(String ricerca);
	List<Contatto> findByCognomeContains(String ricerca);
	List<Contatto> findByTelefonoContains(String ricerca);
	Contatto findByTelefonoAndCognomeAndNome(String telefono, String cognome, String nome);
}
