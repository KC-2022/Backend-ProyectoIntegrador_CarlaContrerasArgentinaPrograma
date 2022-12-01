/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliocdc.cdc.Dto;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Administrador
 */
public class dtoProyectos {
    @NotBlank
    private String nombre;
    @NotBlank
    private String img;

    public dtoProyectos() {
    }

    public dtoProyectos(String nombre, String img) {
        this.nombre = nombre;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
}
