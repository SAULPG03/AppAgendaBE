package es.ieslosmontecillos.AppAgendaBE.dao;

import es.ieslosmontecillos.AppAgendaBE.entity.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProvinciaDao extends JpaRepository<Provincia, Long> {
}

