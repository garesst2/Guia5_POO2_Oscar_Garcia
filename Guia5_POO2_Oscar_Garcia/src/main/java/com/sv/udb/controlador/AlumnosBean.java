/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sv.udb.controlador;

import com.sv.udb.modelo.Alumno;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Laboratorio
 */
@ManagedBean
@RequestScoped
public class AlumnosBean {
    private Alumno objeAlum;
    private boolean guard;

    /**
     * Creates a new instance of AlumnosBean
     */
    public AlumnosBean() {        
        
    }
    
    @PostConstruct //Despues de iniciar la vista
    public void init(){
        this.objeAlum = new Alumno();
        this.guard = true;
    }

    public Alumno getObjeAlum() {
        return objeAlum;
    }

    public void setObjeAlum(Alumno objeAlum) {
        this.objeAlum = objeAlum;
    }
    
}
