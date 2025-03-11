package es.ieslosmontecillos.AppAgendaBE.dao;

import es.ieslosmontecillos.AppAgendaBE.entity.Persona;
import es.ieslosmontecillos.AppAgendaBE.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Integer> {
}
