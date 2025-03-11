package es.ieslosmontecillos.AppAgendaBE.controller;

import es.ieslosmontecillos.AppAgendaBE.entity.Login;
import es.ieslosmontecillos.AppAgendaBE.entity.Provincia;
import es.ieslosmontecillos.AppAgendaBE.services.LoginService;
import es.ieslosmontecillos.AppAgendaBE.services.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/v1")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @GetMapping(value="/LOGIN")
    public ResponseEntity<Object> get(){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Login> list = loginService.findAll();
            return new ResponseEntity<Object>(list,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value="/LOGIN/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        try {
            Login data = loginService.findById(id);
            return new ResponseEntity<Object>(data,HttpStatus.OK);
        }
        catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = "/LOGIN")
    public ResponseEntity<Object> create(@RequestBody Login login) {
        Map<String, Object> map = new HashMap<>();
        try {
            Login res = loginService.save(login);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/LOGIN/{id}")
    public ResponseEntity<Object> update(@RequestBody Login login,
                                         @PathVariable Integer id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Login currentProvincia = loginService.findById(id);
            currentProvincia.setId(login.getId());
            currentProvincia.setEmail(login.getEmail());
            currentProvincia.setClave(login.getClave());
            currentProvincia.setVigencia(login.getVigencia());
            Login res = loginService.save(currentProvincia);
            return new ResponseEntity<Object>(res,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/LOGIN/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Login currentProvincia = loginService.findById(id);
            loginService.delete(currentProvincia);
            map.put("deleted", true);
            return new ResponseEntity<Object>(map,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
