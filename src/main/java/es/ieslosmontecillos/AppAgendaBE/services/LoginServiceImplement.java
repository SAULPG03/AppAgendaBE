package es.ieslosmontecillos.AppAgendaBE.services;

import es.ieslosmontecillos.AppAgendaBE.dao.LoginDao;
import es.ieslosmontecillos.AppAgendaBE.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoginServiceImplement implements LoginService {

    // Aquí debe inyectarse el repositorio LoginDao (o el repositorio correspondiente)
    @Autowired
    private LoginDao loginDao;

    @Override
    public Login save(Login login) {
        return loginDao.save(login);
    }

    @Override
    public Login findById(Integer id) {
        return loginDao.findById(id).orElseThrow(() -> new RuntimeException("Login no encontrado"));
    }

    @Override
    public List<Login> findAll() {
        return loginDao.findAll();
    }

    @Override
    public void delete(Login login) {
        loginDao.delete(login);
    }
}


