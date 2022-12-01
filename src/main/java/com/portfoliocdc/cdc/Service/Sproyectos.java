/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliocdc.cdc.Service;
import com.portfoliocdc.cdc.Entity.proyectos;
import com.portfoliocdc.cdc.Repository.Rproyectos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class Sproyectos {
    @Autowired
    Rproyectos rproyectos;
    
    public List<proyectos> list(){
        return rproyectos.findAll();
    }
    
    public Optional<proyectos> getOne(int id){
        return rproyectos.findById(id);
    }
    
    public Optional<proyectos> getByNombre(String nombre){
        return rproyectos.findByNombre(nombre);
    }
    
    public void save(proyectos skill){
        rproyectos.save(skill);
    }
    
    public void delete(int id){
        rproyectos.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rproyectos.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rproyectos.existsByNombre(nombre);
    }
    
    
}
