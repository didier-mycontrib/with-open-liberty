package com.demo.dao;

import java.util.List;

import com.demo.entity.Devise;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@RequestScoped
@Transactional
public class DeviseDao {
	@PersistenceContext(name = "jpa-unit")
    private EntityManager em;

    public void createDevise(Devise devise) {
        em.persist(devise);
    }

    public Devise readDevise(String deviseCode) {
        return em.find(Devise.class, deviseCode);
    }

    public void updateDevise(Devise devise) {
        em.merge(devise);
    }

    public void deleteDeviseByCode(Devise deviseCode) {
    	Devise devise = em.find(Devise.class, deviseCode);
        em.remove(devise);
    }
    
    public void deleteAllDevise() {
        em.createNamedQuery("Devise.deleteAll").executeUpdate();
    }

    public List<Devise> readAllDevises() {
        return em.createNamedQuery("Devise.findAll", Devise.class).getResultList();
    }
}
