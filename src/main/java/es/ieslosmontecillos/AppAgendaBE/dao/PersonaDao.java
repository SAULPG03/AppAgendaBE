package es.ieslosmontecillos.AppAgendaBE.dao;

import es.ieslosmontecillos.AppAgendaBE.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaDao extends JpaRepository<Persona, Integer> {
}

