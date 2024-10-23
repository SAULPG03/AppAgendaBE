package es.ieslosmontecillos.AppAgendaBE.controller;

import es.ieslosmontecillos.AppAgendaBE.entity.Persona;
import es.ieslosmontecillos.AppAgendaBE.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    // Obtener todas las personas
    @GetMapping(value = "/PERSONA")
    public ResponseEntity<Object> getAllPersonas() {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Persona> list = personaService.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener una persona por ID
    @GetMapping(value = "/PERSONA/{id}")
    public ResponseEntity<Object> getPersonaById(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            Persona persona = personaService.findById(id);
            return new ResponseEntity<>(persona, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Crear una nueva persona
    @PostMapping(value = "/PERSONA")
    public ResponseEntity<Object> createPersona(@RequestBody Persona persona) {
        Map<String, Object> map = new HashMap<>();
        try {
            Persona res = personaService.save(persona);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar una persona por ID
    @PutMapping("/PERSONA/{id}")
    public ResponseEntity<Object> updatePersona(@RequestBody Persona persona, @PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            Persona currentPersona = personaService.findById(id);
            currentPersona.setNombre(persona.getNombre());
            currentPersona.setApellidos(persona.getApellidos());
            currentPersona.setTelefono(persona.getTelefono());
            currentPersona.setEmail(persona.getEmail());
            currentPersona.setProvincia(persona.getProvincia());
            currentPersona.setFechaNacimiento(persona.getFechaNacimiento());
            currentPersona.setNumHijos(persona.getNumHijos());
            currentPersona.setEstadoCivil(persona.getEstadoCivil());
            currentPersona.setSalario(persona.getSalario());
            currentPersona.setJubilado(persona.getJubilado());
            currentPersona.setFoto(persona.getFoto());

            Persona res = personaService.save(currentPersona);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar una persona por ID
    @DeleteMapping("/PERSONA/{id}")
    public ResponseEntity<Object> deletePersona(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            Persona currentPersona = personaService.findById(id);
            personaService.delete(currentPersona);
            map.put("deleted", true);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

