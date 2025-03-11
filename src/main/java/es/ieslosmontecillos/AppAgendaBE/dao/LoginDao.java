package es.ieslosmontecillos.AppAgendaBE.dao;

import es.ieslosmontecillos.AppAgendaBE.entity.Login;
import es.ieslosmontecillos.AppAgendaBE.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginDao extends JpaRepository<Login, Integer> {
}
