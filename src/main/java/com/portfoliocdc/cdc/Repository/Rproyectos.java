/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfoliocdc.cdc.Repository;
import com.portfoliocdc.cdc.Entity.proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Rproyectos extends JpaRepository<proyectos, Integer>{
    Optional<proyectos> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
