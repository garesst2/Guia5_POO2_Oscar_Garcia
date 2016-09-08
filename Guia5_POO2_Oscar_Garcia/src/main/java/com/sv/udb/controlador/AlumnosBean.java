/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Alumnos;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author root
 */
@Named(value = "alumnosBean")
@Dependent
public class AlumnosBean {

    private Alumnos objeAlum;
    private boolean guard;

    /**
     * Creates a new instance of AlumnoBean
     */
    public AlumnosBean() {
    }

    @PostConstruct //Despues de iniciar la vista
    public void init() {
        this.objeAlum = new Alumnos();
        this.guard = true;
    }

    public Alumnos getObjeAlum() {
        return objeAlum;
    }

    public void setObjeAlum(Alumnos objeAlum) {
        this.objeAlum = objeAlum;
    }

    public boolean isGuard() {
        return guard;
    }

    public void setGuard(boolean guard) {
        this.guard = guard;
    }

    public void guard() {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            em.persist(this.objeAlum);
            tx.commit();
            resp = true;
        } catch (Exception ex) {
            tx.rollback();
        }
        em.close();
        emf.close();
    }

}
