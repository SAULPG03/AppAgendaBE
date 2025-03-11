package es.ieslosmontecillos.AppAgendaBE.controller;

import es.ieslosmontecillos.AppAgendaBE.entity.Usuario;
import es.ieslosmontecillos.AppAgendaBE.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    // Obtener todas las personas
    @GetMapping(value = "/USUARIO")
    public ResponseEntity<Object> getAllUsuarios() {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Usuario> list = usuarioService.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener una persona por ID
    @GetMapping(value = "/USUARIO/{id}")
    public ResponseEntity<Object> getPersonaById(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            Usuario usuario = usuarioService.findById(id);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Crear una nueva persona
    @PostMapping(value = "/USUARIO")
    public ResponseEntity<Object> createPersona(@RequestBody Usuario persona) {
        Map<String, Object> map = new HashMap<>();
        try {
            Usuario res = usuarioService.save(persona);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar una persona por ID
    @PutMapping("/USUARIO/{id}")
    public ResponseEntity<Object> updatePersona(@RequestBody Usuario usuario, @PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            Usuario currentPersona = usuarioService.findById(id);
            currentPersona.setType(usuario.getType());
            currentPersona.setRpta(usuario.getRpta());
            currentPersona.setMessage(usuario.getMessage());
            currentPersona.setLogin(usuario.getLogin());

            Usuario res = usuarioService.save(currentPersona);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar una persona por ID
    @DeleteMapping("/USUARIO/{id}")
    public ResponseEntity<Object> deletePersona(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            Usuario currentPersona = usuarioService.findById(id);
            usuarioService.delete(currentPersona);
            map.put("deleted", true);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


