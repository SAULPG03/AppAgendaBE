package es.ieslosmontecillos.AppAgendaBE.services;

import es.ieslosmontecillos.AppAgendaBE.entity.Usuario;
import java.util.List;

public interface UsuarioService {
    public List<Usuario> findAll();
    public Usuario save(Usuario usuario);
    public Usuario findById(Integer id);
    public void delete(Usuario usuario);
}
