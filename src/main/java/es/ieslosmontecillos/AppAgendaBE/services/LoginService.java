package es.ieslosmontecillos.AppAgendaBE.services;

import es.ieslosmontecillos.AppAgendaBE.entity.Login;
import es.ieslosmontecillos.AppAgendaBE.entity.Provincia;

import java.util.List;

public interface LoginService {
    public List<Login> findAll();
    public Login save(Login login);
    public Login findById(Integer id);
    public void delete(Login login);
}
