package es.ieslosmontecillos.AppAgendaBE.services;

import es.ieslosmontecillos.AppAgendaBE.dao.UsuarioDao;
import es.ieslosmontecillos.AppAgendaBE.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UsuarioServiceImplement implements UsuarioService{
    @Autowired
    private UsuarioDao usuarioDao;
    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }
    @Override
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }
    @Override
    public Usuario findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }
    @Override
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }
}
