package es.ieslosmontecillos.AppAgendaBE.services;

import es.ieslosmontecillos.AppAgendaBE.entity.Persona;
import java.util.List;

public interface PersonaService {
    public List<Persona> findAll();
    public Persona save(Persona persona);
    public Persona findById(Integer id);
    public void delete(Persona persona);
}
