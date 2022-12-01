/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliocdc.cdc.Controller;
import com.portfoliocdc.cdc.Dto.dtoProyectos;
import com.portfoliocdc.cdc.Entity.proyectos;
import com.portfoliocdc.cdc.Security.Controller.Mensaje;
import com.portfoliocdc.cdc.Service.Sproyectos;
import java.util.List;  
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://frontendcdc-cb428.web.app")
@RequestMapping("/proyectos")
public class Cproyectos {
    @Autowired
    Sproyectos sproyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<proyectos>> list() {
        List<proyectos> list = sproyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<proyectos> getById(@PathVariable("id") int id) {
        if (!sproyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        proyectos Proyectos = sproyectos.getOne(id).get();
        return new ResponseEntity(Proyectos, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sproyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        sproyectos.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproyectos) {
        if (StringUtils.isBlank(dtoproyectos.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sproyectos.existsByNombre(dtoproyectos.getNombre())) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }

        proyectos Proyectos = new proyectos(dtoproyectos.getNombre(), dtoproyectos.getImg());
        sproyectos.save(Proyectos);

        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproyectos) {
        //Validamos si existe el ID
        if (!sproyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de proyectos
        if (sproyectos.existsByNombre(dtoproyectos.getNombre()) && sproyectos.getByNombre(dtoproyectos.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoproyectos.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        proyectos Proyectos = sproyectos.getOne(id).get();
        Proyectos.setNombre(dtoproyectos.getNombre());
        Proyectos.setImg(dtoproyectos.getImg());

        sproyectos.save(Proyectos);
        return new ResponseEntity(new Mensaje("Poyecto actualizado"), HttpStatus.OK);
     }
}
